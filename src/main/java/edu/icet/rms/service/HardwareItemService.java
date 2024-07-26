package edu.icet.rms.service;

import edu.icet.rms.entity.HardwareItemEntity;
import edu.icet.rms.model.HardwareItem;

import java.util.List;

public interface HardwareItemService {

    HardwareItem persist(HardwareItemEntity hardwareItemEntity);

    List<HardwareItem> retrieveAll();

    HardwareItem update(HardwareItemEntity hardwareItemEntity);

    String deleteById(Long id);

    HardwareItem searchById(Long id);
}
