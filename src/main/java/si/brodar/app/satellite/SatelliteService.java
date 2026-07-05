package si.brodar.app.satellite;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tools.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class SatelliteService {

    @Autowired
    private SatelliteRepository satelliteRepository;

    @Autowired
    private CelestrakRestClient celestrakRestClient;

    public Satellite createSatellite(Satellite satellite) {
        return satelliteRepository.save(satellite);
    }

    public List<Satellite> getAllSatellites() {
        return satelliteRepository.findAll();
    }

    public Satellite getSatelliteById(Long id) {
        return satelliteRepository.findById(id).orElse(null);
    }

    public Satellite updateSatellite(Satellite satellite, Long id) {
        satellite.setNoradCatId(id);
        return satelliteRepository.save(satellite);
    }

    public void deleteSatelliteById(Long id) {
        satelliteRepository.deleteById(id);
    }

    public boolean syncFromCelesTrak() {
        List<Satellite> gp_data = celestrakRestClient.getCelesTrak();
        if (gp_data.isEmpty()) {
            return false;
        }
        for (Satellite satellite : gp_data) {
            System.out.println(satellite);
        }
        ObjectMapper om = new ObjectMapper();
        File file = new File("../../../../../resources/gp_data_starlink.json");
        om.writeValue(file, gp_data);
        System.out.println("File saved to: " + file.getAbsolutePath());
        return true;
    }
}
