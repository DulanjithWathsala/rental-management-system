package edu.icet.rms.service;

import edu.icet.rms.entity.RentalDetailEntity;
import edu.icet.rms.model.RentalDetail;

import java.util.List;

public interface RentalDetailService {

    RentalDetail persist(RentalDetailEntity rentalDetailEntity);

    List<RentalDetail> retrieveAll();

    RentalDetail update(RentalDetailEntity rentalDetailEntity);

    String deleteById(Long id);

    RentalDetail searchById(Long id);
}
