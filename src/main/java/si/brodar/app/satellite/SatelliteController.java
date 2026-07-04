package si.brodar.app.satellite;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
@RequestMapping("/api/satellites")
public class SatelliteController {

    @Autowired
    private SatelliteService satelliteService;

    @PostMapping
    public Satellite save(@RequestBody Satellite satellite) {
        re
    }
}
