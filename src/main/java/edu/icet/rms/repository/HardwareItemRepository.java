package edu.icet.rms.repository;

import edu.icet.rms.entity.HardwareItemEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HardwareItemRepository extends CrudRepository<HardwareItemEntity, Long> {
}
