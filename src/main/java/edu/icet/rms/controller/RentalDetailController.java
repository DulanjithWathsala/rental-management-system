package edu.icet.rms.controller;

import edu.icet.rms.model.RentalDetail;
import edu.icet.rms.service.RentalDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@Service
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("/rental-detail")
public class RentalDetailController {

    private final RentalDetailService rentalDetailService;

    @PostMapping()
    public RentalDetail persist(@RequestBody RentalDetail rentalDetail) {
        return rentalDetailService.persist(rentalDetail);
    }

    @GetMapping("/retrieve-all")
    public List<RentalDetail> retrieveAll() {
        return rentalDetailService.retrieveAll();
    }

    @PutMapping("/update")
    public RentalDetail update(@RequestBody RentalDetail rentalDetail) {
        return rentalDetailService.update(rentalDetail);
    }

    @DeleteMapping("/delete/{id}")
    public Map<String, String> deleteById(@PathVariable Long id) {
        return Collections.singletonMap("DELETE", rentalDetailService.deleteById(id));
    }
}
