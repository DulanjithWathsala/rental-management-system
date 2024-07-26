package edu.icet.rms.repository;

import edu.icet.rms.entity.RentalEntity;
import org.springframework.data.repository.CrudRepository;

public interface RentalRepository extends CrudRepository<RentalEntity, Long> {
}
