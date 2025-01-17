package edu.icet.rms.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "hardware_item")
@NoArgsConstructor
@AllArgsConstructor
public class HardwareItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long itemId;
    private boolean availability;
    private String name;
    private Double rentalPerDay;
    private Double finePerDay;
}
