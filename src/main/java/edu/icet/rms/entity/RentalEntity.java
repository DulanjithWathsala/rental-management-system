package edu.icet.rms.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "rental")
public class RentalEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rentalId;
    private Date rentalDate;
    private Date returnDate;
    private Date expectedReturnDate;
    private Date dueDate;
    private Double totalCost;
    private Double fine;

}
