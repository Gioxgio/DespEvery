package com.gagioga.DespEvery.geonames;

import java.util.List;

public record GeonamesResponse(List<GeonamesPlace> geonames) {
    public record GeonamesPlace(int geonameId, String name, double lat, double lng) {
    }
}
