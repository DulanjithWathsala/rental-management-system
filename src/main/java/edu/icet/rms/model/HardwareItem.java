package edu.icet.rms.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HardwareItem {

    private Long itemId;
    private boolean availability;
    private String name;
    private Double rentalPerDay;
    private Double finePerDay;
}
