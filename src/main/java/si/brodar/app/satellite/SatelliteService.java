package si.brodar.app.satellite;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SatelliteService {

    @Autowired
    private SatelliteRepository satelliteRepository;

    public Satellite createSatellite(Satellite satellite) {
        return satelliteRepository.save(satellite);
    }

    public List<Satellite> getAllSatellites() {
        return satelliteRepository.findAll();
    }

    public Satellite getSatelliteById(String id) {
        return satelliteRepository.findById(id).orElse(null);
    }

    public Satellite updateSatellite(Satellite satellite, String id) {
        //satellite.setNoradCatId(); etc..
        return satelliteRepository.save(satellite);
    }

    public void deleteSatelliteById(String id) {
        satelliteRepository.deleteById(id);
    }
}
