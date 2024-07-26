package edu.icet.rms.repository;

import edu.icet.rms.entity.RentalDetailEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RentalDetailRepository extends CrudRepository<RentalDetailEntity, Long> {
}
