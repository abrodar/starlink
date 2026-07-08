package si.brodar.app.satellite;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

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
        // System.out.println(System.getProperty("user.dir"));
        if (gp_data.isEmpty()) {
            return false;
        }
        satelliteRepository.saveAll(gp_data);
        System.out.println("Satellite GP data successfully inserted into the database.");
        /*
        ObjectMapper om = new ObjectMapper();
        File file = new File(System.getProperty("user.dir"), "resources/gp_data_starlink.json"); // user.dir - user current working directory !
        om.writeValue(file, gp_data);
        System.out.println("File saved to: " + file.getAbsolutePath());*/
        return true;
    }

    public Page<Satellite> getAllSatellitesC(Pageable pageable) {
        return satelliteRepository.findAll(pageable);
    }
}
