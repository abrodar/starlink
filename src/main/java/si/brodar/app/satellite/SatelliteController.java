package si.brodar.app.satellite;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api/satellites")
public class SatelliteController {

    @Autowired
    private SatelliteService satelliteService;

    @PostMapping
    public Satellite save(@RequestBody Satellite satellite) {
        return satelliteService.createSatellite(satellite);
    }

    @GetMapping
    public List<Satellite> getAllSatellites() {
        return satelliteService.getAllSatellites();
    }

    @GetMapping("/{id}")
    public Satellite getSatelliteById(@PathVariable("id") Long id) {
        return satelliteService.getSatelliteById(id);
    }

    @PutMapping("/{id}")
    public Satellite updateSatelliteById(@PathVariable("id") Long id, @RequestBody Satellite satellite) {
        return satelliteService.updateSatellite(satellite, id);
    }

    @PutMapping
    public void syncFromCelesTrak() throws SyncException {
        if (!satelliteService.syncFromCelesTrak()) {
            throw new SyncException("Cannot sync from CelesTrak. Error while calling an API endpoint.");
        }
    }

}
