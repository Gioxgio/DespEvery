package com.gagioga.DespEvery.service;

import com.gagioga.DespEvery.model.Place;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class PlaceService {

    public Place getByName(String name) {
        return new Place(UUID.randomUUID(), name, 12, 12);
    }
}
