package edu.icet.rms.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.icet.rms.entity.HardwareItemEntity;
import edu.icet.rms.entity.RentalDetailEntity;
import edu.icet.rms.model.HardwareItem;
import edu.icet.rms.model.RentalDetail;
import edu.icet.rms.repository.RentalDetailRepository;
import edu.icet.rms.service.RentalDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RentalDetailServiceImpl implements RentalDetailService {

    private final RentalDetailRepository rentalDetailRepository;

    private final ObjectMapper mapper;

    @Override
    public RentalDetail persist(RentalDetail rentalDetail) {
        return mapper.convertValue(rentalDetailRepository.save(
                        mapper.convertValue(rentalDetail, RentalDetailEntity.class)),
                RentalDetail.class);
    }

    @Override
    public List<RentalDetail> retrieveAll() {
        List<RentalDetail> rentalDetailList = new ArrayList<>();

        Iterable<RentalDetailEntity> entities = rentalDetailRepository.findAll();
        entities.forEach(rentalDetailEntity ->
                rentalDetailList.add(mapper.convertValue(rentalDetailEntity, RentalDetail.class)));
        return rentalDetailList;
    }

    @Override
    public RentalDetail update(RentalDetail rentalDetail) {
        if (rentalDetailRepository.existsById(rentalDetail.getRentalDetailId())) {
            return mapper.convertValue(rentalDetailRepository.save(
                            mapper.convertValue(rentalDetail, RentalDetailEntity.class)),
                    RentalDetail.class);
        }
        return null;
    }

    @Override
    public String deleteById(Long id) {
        if (rentalDetailRepository.existsById(id)) {
            rentalDetailRepository.deleteById(id);
            return "SUCCESS";
        }
        return "FAILED";
    }

    @Override
    public RentalDetail searchById(Long id) {
        Optional<RentalDetailEntity> rentalDetailEntity = rentalDetailRepository.findById(id);
        if (rentalDetailEntity.isPresent()) {
            return mapper.convertValue(rentalDetailEntity.get(), RentalDetail.class);
        }
        return null;
    }
}
