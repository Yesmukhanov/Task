package TestTask.api;

import TestTask.entity.Load;
import TestTask.service.LoadService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/load")
public class LoadRestController {

    private final LoadService loadService;

    @PostMapping
    public ResponseEntity<String> addLoad(@RequestBody Load load) {
        Load addLoad = loadService.addLoad(load);

        if (addLoad != null) {
            return new ResponseEntity<>("Loads details added successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Failed to add load details", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    public ResponseEntity<List<Load>> getLoadsByShipperId(@RequestParam String shipperId) {
        List<Load> loads = loadService.getLoadsByShipperId(shipperId);

        if (loads != null && !loads.isEmpty()) {
            return new ResponseEntity<>(loads, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "{loadId}")
    public ResponseEntity<Load> getById(@PathVariable(name = "loadId") Long id) {
        Load getLoad = loadService.getById(id);

        if (getLoad != null) {
            return new ResponseEntity<>(getLoad, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping(value = "{loadId}")
    public ResponseEntity<Load> updateLoad(@PathVariable(name = "loadId") Long id, @RequestBody Load load) {
        Load updatedLoad = loadService.updateLoad(id, load);

        if (updatedLoad != null) {
            return new ResponseEntity<>(updatedLoad, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(value = "{loadId}")
    public ResponseEntity<String> deleteLoad(@PathVariable(name = "loadId") Long id) {
        loadService.deleteLoad(id);

        return new ResponseEntity<>("Load deleted successfully", HttpStatus.OK);
    }


}
