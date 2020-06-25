package com.udacity.boogle.maps;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/maps")
public class MapsController {
    /**
     *
     * @param lat
     * @param lon
     * @return
     */
    public Address get(@RequestParam double lat,
                       @RequestParam double lon) {
        return MockAddressRepository.getRandom();
    }
}
