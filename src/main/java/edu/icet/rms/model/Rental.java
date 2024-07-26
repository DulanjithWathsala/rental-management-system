package edu.icet.rms.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Rental {

    private Long rentalId;
    private Date rentalDate;
    private Date returnDate;
    private Date expectedReturnDate;
    private Date dueDate;
    private Double totalCost;
    private Double fine;

}
