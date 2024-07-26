package edu.icet.rms.service;

import edu.icet.rms.entity.HardwareItemEntity;
import edu.icet.rms.model.HardwareItem;

import java.util.List;

public interface HardwareItemService {

    HardwareItem persist(HardwareItem hardwareItem);

    List<HardwareItem> retrieveAll();

    HardwareItem update(HardwareItem hardwareItem);

    String deleteById(Long id);

    HardwareItem searchById(Long id);

    List<Long> retrieveAllIds();
}
