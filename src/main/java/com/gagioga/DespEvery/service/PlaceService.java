package com.gagioga.DespEvery.service;

import com.gagioga.DespEvery.geonames.Geonames;
import com.gagioga.DespEvery.model.Place;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class PlaceService {

    private final Geonames geonames;

    public List<Place> getByName(String name) {
        return geonames.getByName(name);
    }
}
