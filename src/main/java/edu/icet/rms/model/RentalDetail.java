package edu.icet.rms.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RentalDetail {

    private Long rentalDetailId;
    private Long rentalId;
    private Long itemId;
    private Double totalItemCost;
    private String city;
}
