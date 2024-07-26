package edu.icet.rms.service;


import edu.icet.rms.entity.RentalEntity;
import edu.icet.rms.model.Rental;

import java.util.List;

public interface RentalService {

    Rental persist(Rental rental);

    List<Rental> retrieveAll();

    Rental update(Rental rental);

    String deleteById(Long id);

    Rental searchById(Long id);
}
