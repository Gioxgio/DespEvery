package com.gagioga.DespEvery.model;

public record Place(int id, String name, double lat, double lng) {
    public Place() {
        this(0, null, 0, 0);
    }
}
