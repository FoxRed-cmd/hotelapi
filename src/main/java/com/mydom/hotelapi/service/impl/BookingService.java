package com.mydom.hotelapi.service.impl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.mydom.hotelapi.dto.BookingCreateDto;
import com.mydom.hotelapi.dto.BookingDetailsDto;
import com.mydom.hotelapi.exception.ApiException;
import com.mydom.hotelapi.mapper.BookingDetailsMapper;
import com.mydom.hotelapi.mapper.ClientMapper;
import com.mydom.hotelapi.model.Booking;
import com.mydom.hotelapi.model.Client;
import com.mydom.hotelapi.model.Employee;
import com.mydom.hotelapi.model.Room;
import com.mydom.hotelapi.model.ServiceOrder;
import com.mydom.hotelapi.repository.BookingRepository;
import com.mydom.hotelapi.repository.ClientRepository;
import com.mydom.hotelapi.repository.EmployeeRepository;
import com.mydom.hotelapi.repository.RoomRepository;
import com.mydom.hotelapi.repository.ServiceRepository;
import com.mydom.hotelapi.service.IBookingService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BookingService implements IBookingService {
    private final BookingRepository bookingRepository;
    private final BookingDetailsMapper bookingDetailsMapper;
    private final EmployeeRepository employeeRepository;
    private final ClientRepository clientRepository;
    private final RoomRepository roomRepository;
    private final ServiceRepository serviceRepository;
    private final ClientMapper clientMapper;

    @Override
    public List<BookingDetailsDto> getAll() {
        return bookingRepository.findAll().stream().map(bookingDetailsMapper::toDto).toList();
    }

    @Override
    @Transactional
    public BookingDetailsDto create(BookingCreateDto bookingCreateDto) {
        Room room = roomRepository.findByNumber(bookingCreateDto.getRoomNumber())
                .orElseThrow(() -> new ApiException(HttpStatus.NOT_FOUND, ("Room not found")));
        room.setStatus("Забронирован");
        roomRepository.save(room);

        Client client = null;
        var foundClient = clientRepository
                .findByPassportNumber(bookingCreateDto.getClient().getPassportNumber());
        if (foundClient.isEmpty()) {
            client = clientMapper.toEntity(bookingCreateDto.getClient());
            client.setCreatedAt(LocalDateTime.now());
            client = clientRepository.save(client);
        } else {
            client = foundClient.get();
        }

        // TODO: get employee from client application
        Employee employee = employeeRepository.findById(1L)
                .orElseThrow(() -> new ApiException(HttpStatus.NOT_FOUND, ("Employee not found")));;

        Booking newBooking = Booking.builder().room(room)
                .checkInDate(LocalDate.parse(bookingCreateDto.getCheckInDate(),
                        DateTimeFormatter.ofPattern("dd.MM.yyyy")))
                .checkOutDate(LocalDate.parse(bookingCreateDto.getCheckOutDate(),
                        DateTimeFormatter.ofPattern("dd.MM.yyyy")))
                .totalPrice(bookingCreateDto.getTotalPrice()).status("Ожидание оплаты").build();

        newBooking.setClients(List.of(client));
        newBooking.setEmployees(List.of(employee));

        Long totalPrice = bookingCreateDto.getServices().stream()
                .mapToLong(service -> service.getPrice().longValue()).sum();

        newBooking.setServiceOrders(bookingCreateDto.getServices().stream()
                .map(service -> ServiceOrder.builder()
                        .service(serviceRepository.findById(service.getId())
                                .orElseThrow(() -> new ApiException(HttpStatus.NOT_FOUND,
                                        ("Service not found"))))
                        .booking(newBooking).orderDate(LocalDate.now()).quantity(1)
                        .totalPrice(BigDecimal.valueOf(totalPrice)).build())
                .toList());

        return bookingDetailsMapper.toDto(bookingRepository.save(newBooking));
    }

}
