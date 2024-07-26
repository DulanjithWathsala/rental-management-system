package edu.icet.rms.repository;

import edu.icet.rms.entity.HardwareItemEntity;
import org.springframework.data.repository.CrudRepository;

public interface HardwareItemRepository extends CrudRepository<HardwareItemEntity, Long> {
}
