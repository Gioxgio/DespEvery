package com.gagioga.DespEvery.geonames;

import com.gagioga.DespEvery.model.Place;
import org.springframework.stereotype.Component;

@Component
public class GeonamesMapper {

    protected final Place toPlace(final GeonamesResponse.GeonamesPlace geonamesPlace) {

        return new Place(geonamesPlace.geonameId(), geonamesPlace.name(), geonamesPlace.lat(), geonamesPlace.lng());
    }
}
