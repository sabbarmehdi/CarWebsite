package com.udacity.vehicles.client.prices;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.logging.Logger;

/**
 * Implements a class to interface with the Pricing Client for Price data.
 */
//@Component
public class PriceClient {

    private static final Logger log = LoggerFactory.getLogger(PriceClient.class);

    private final WebClient client;

    public PriceClient(WebClient pricing) {
        this.client = pricing;
    }

    public String getPrice(Long vehicleId) {
        try {
            Price price = client
                    .get()
                    .uri(uriBuilder -> uriBuilder
                            .path("services/price/")
                            .queryParam("vehicleId", vehicleId)
                            .build()
                    )
                    .retrieve().bodyToMono(Price.class).block();
            return String.format("%s %s", price.getCurrency(), price.getPrice());
        } catch (Exception exception) {
            log.error("Unexpected error retrieving price for vehicle {}", vehicleId, exception);
        }
        return "(consult price)";
    }
}
