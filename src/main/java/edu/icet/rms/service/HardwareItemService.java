package edu.icet.rms.service;

import edu.icet.rms.entity.CustomerEntity;
import edu.icet.rms.entity.HardwareItemEntity;
import edu.icet.rms.model.Customer;
import edu.icet.rms.model.HardwareItem;

import java.util.List;

public interface HardwareItemService {

    HardwareItem persist(HardwareItemEntity hardwareItemEntity);

    List<HardwareItem> retrieveAll();

    HardwareItem update(HardwareItemEntity hardwareItemEntity);

    void deleteById(Long id);

    HardwareItem searchById(Long id);
}
