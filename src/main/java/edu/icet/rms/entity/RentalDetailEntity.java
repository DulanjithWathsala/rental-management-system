package edu.icet.rms.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "rental_detail")
@NoArgsConstructor
@AllArgsConstructor
public class RentalDetailEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rentalDetailId;
    private Long rentalId;
    private Long itemId;
    private Double totalItemCost;
    private String city;
}
