package edu.icet.rms.controller;

import edu.icet.rms.model.Rental;
import edu.icet.rms.service.RentalService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@Service
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("/rental")
public class RentalController {

    private final RentalService rentalService;

    @PostMapping()
    public Rental persist(@RequestBody Rental rental) {
        return rentalService.persist(rental);
    }

    @GetMapping("/retrieve-all")
    public List<Rental> retrieveAll() {
        return rentalService.retrieveAll();
    }

    @PutMapping("/update")
    public Rental update(@RequestBody Rental rental) {
        return rentalService.update(rental);
    }

    @DeleteMapping("/delete/{id}")
    public Map<String, String> deleteById(@PathVariable Long id) {
        return Collections.singletonMap("DELETE", rentalService.deleteById(id));
    }
}
