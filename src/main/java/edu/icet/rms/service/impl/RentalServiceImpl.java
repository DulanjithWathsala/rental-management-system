package edu.icet.rms.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.icet.rms.entity.RentalEntity;
import edu.icet.rms.exception.ObjectNotFoundException;
import edu.icet.rms.model.Rental;
import edu.icet.rms.repository.RentalRepository;
import edu.icet.rms.service.RentalService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RentalServiceImpl implements RentalService {

    private final RentalRepository rentalRepository;

    private final ObjectMapper mapper;

    @Override
    public Rental persist(Rental rental) {
        return mapper.convertValue(rentalRepository.save(
                        mapper.convertValue(rental, RentalEntity.class)),
                Rental.class);
    }

    @Override
    public List<Rental> retrieveAll() {
        List<Rental> rentalList = new ArrayList<>();

        Iterable<RentalEntity> entities = rentalRepository.findAll();
        entities.forEach(rentalEntity ->
                rentalList.add(mapper.convertValue(rentalEntity, Rental.class)));
        return rentalList;
    }

    @Override
    public Rental update(Rental rental) {
        if (!rentalRepository.existsById(rental.getRentalId())) {
            throw new ObjectNotFoundException("Rental not found");
        }
        return mapper.convertValue(rentalRepository.save(
                        mapper.convertValue(rental, RentalEntity.class)),
                Rental.class);
    }

    @Override
    public String deleteById(Long id) {
        if (rentalRepository.existsById(id)) {
            rentalRepository.deleteById(id);
            return "SUCCESS";
        }
        return "FAILED";
    }

    @Override
    public Rental searchById(Long id) {
        Optional<RentalEntity> rentalEntity = rentalRepository.findById(id);
        if (rentalEntity.isEmpty()) {
            throw new ObjectNotFoundException("Rental not found");
        }
        return mapper.convertValue(rentalEntity.get(), Rental.class);
    }
}
