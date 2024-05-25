package com.gagioga.DespEvery.model;

import java.util.UUID;

public record Place(UUID id, String name, double lat, double lng) {
    public Place() {
        this(null, null, 0, 0);
    }
}
