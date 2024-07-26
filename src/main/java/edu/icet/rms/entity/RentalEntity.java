package edu.icet.rms.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Entity
@Table(name = "rental")
@NoArgsConstructor
@AllArgsConstructor
public class RentalEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rentalId;
    private Date rentalDate;
    private Date expectedReturnDate;
    private Date dueDate;
    private Double totalCost;
    private Double fine;

}
