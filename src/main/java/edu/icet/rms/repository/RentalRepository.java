package edu.icet.rms.repository;

import edu.icet.rms.entity.RentalEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RentalRepository extends CrudRepository<RentalEntity, Long> {
}
