package com.mydom.hotelapi.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Booking {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "booking_id")
        private Long id;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "room_id", nullable = false)
        private Room room;

        @Column(name = "check_in_date", nullable = false)
        private LocalDate checkInDate;

        @Column(name = "check_out_date", nullable = false)
        private LocalDate checkOutDate;

        @Column(name = "total_price", nullable = false, precision = 10, scale = 2)
        private BigDecimal totalPrice;

        @Column(name = "status", nullable = false, length = 20)
        private String status;

        @ManyToMany
        @JoinTable(name = "clientbooking", joinColumns = @JoinColumn(name = "booking_id"),
                        inverseJoinColumns = @JoinColumn(name = "client_id"))
        private List<Client> clients;

        // Прямая связь ManyToMany с сотрудниками
        @ManyToMany
        @JoinTable(name = "employeebooking", joinColumns = @JoinColumn(name = "booking_id"),
                        inverseJoinColumns = @JoinColumn(name = "employee_id"))
        private List<Employee> employees;

        @OneToMany(mappedBy = "booking", cascade = CascadeType.ALL, orphanRemoval = true)
        private List<ServiceOrder> serviceOrders;
}
