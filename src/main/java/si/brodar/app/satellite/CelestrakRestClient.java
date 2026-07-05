package si.brodar.app.satellite;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import java.util.List;

@Component
public class CelestrakRestClient {

    private final RestClient restClient;

    CelestrakRestClient() {
        restClient = RestClient.builder()
                .baseUrl("https://celestrak.org/NORAD/elements/gp.php")
                .build();
    }

    List<Satellite> getCelesTrak() {
        return restClient.get()
                .uri("?GROUP=starlink&FORMAT=json")
                .retrieve()
                .body(new ParameterizedTypeReference<List<Satellite>>() {
                });
    }
}
