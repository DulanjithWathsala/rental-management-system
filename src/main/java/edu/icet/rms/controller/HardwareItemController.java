package edu.icet.rms.controller;

import edu.icet.rms.model.HardwareItem;
import edu.icet.rms.service.HardwareItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("/hardware-item")
public class HardwareItemController {

    private final HardwareItemService hardwareItemService;

    @PostMapping()
    public HardwareItem persist(@RequestBody HardwareItem hardwareItem) {
        return hardwareItemService.persist(hardwareItem);
    }

    @GetMapping("/retrieve-all")
    public List<HardwareItem> retrieveAll() {
        return hardwareItemService.retrieveAll();
    }

    @PutMapping("/update")
    public HardwareItem update(@RequestBody HardwareItem hardwareItem) {
        return hardwareItemService.update(hardwareItem);
    }

    @DeleteMapping("/delete/{id}")
    public Map<String, String> deleteById(@PathVariable Long id) {
        return Collections.singletonMap("DELETE", hardwareItemService.deleteById(id));
    }

}
