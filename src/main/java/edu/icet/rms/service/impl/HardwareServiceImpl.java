package edu.icet.rms.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.icet.rms.entity.HardwareItemEntity;
import edu.icet.rms.model.HardwareItem;
import edu.icet.rms.repository.HardwareItemRepository;
import edu.icet.rms.service.HardwareItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class HardwareServiceImpl implements HardwareItemService {

    private final HardwareItemRepository hardwareItemRepository;

    private final ObjectMapper mapper;
    @Override
    public HardwareItem persist(HardwareItemEntity hardwareItemEntity) {
        return mapper.convertValue(
                hardwareItemRepository.save(hardwareItemEntity), HardwareItem.class);
    }

    @Override
    public List<HardwareItem> retrieveAll() {
        List<HardwareItem> hardwareItemList = new ArrayList<>();

        Iterable<HardwareItemEntity> entities = hardwareItemRepository.findAll();
        entities.forEach(hardwareItemEntity ->
                hardwareItemList.add(mapper.convertValue(hardwareItemEntity, HardwareItem.class)));
        return hardwareItemList;
    }

    @Override
    public HardwareItem update(HardwareItemEntity hardwareItemEntity) {
        if (hardwareItemRepository.existsById(hardwareItemEntity.getItemId())) {
            return mapper.convertValue(
                    hardwareItemRepository.save(hardwareItemEntity), HardwareItem.class);
        }
        return null;
    }

    @Override
    public String deleteById(Long id) {
        if (hardwareItemRepository.existsById(id)) {
            hardwareItemRepository.deleteById(id);
            return "SUCCESS";
        }
        return "FAILED";
    }

    @Override
    public HardwareItem searchById(Long id) {
        Optional<HardwareItemEntity> hardwareItemEntity = hardwareItemRepository.findById(id);
        if (hardwareItemEntity.isPresent()) {
            return mapper.convertValue(hardwareItemEntity.get(), HardwareItem.class);
        }
        return null;
    }
}
