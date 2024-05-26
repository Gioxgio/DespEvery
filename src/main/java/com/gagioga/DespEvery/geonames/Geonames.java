package com.gagioga.DespEvery.geonames;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gagioga.DespEvery.model.Place;
import lombok.RequiredArgsConstructor;
import lombok.val;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class Geonames {

    private static final String BASE_URL = "http://api.geonames.org/searchJSON";

    private final GeonamesConfig geonamesConfig;
    private final GeonamesMapper geonamesMapper;

    public List<Place> getByName(final String name) {

        val geonamesResponse = getGeonamesPlaces(name);

        return geonamesResponse.map((response) -> response.geonames().stream().map(geonamesMapper::toPlace).toList()).orElseGet(List::of);
    }

    private Optional<GeonamesResponse> getGeonamesPlaces(final String name) {

        val client = new OkHttpClient();
        val urlBuilder = Objects.requireNonNull(HttpUrl.parse(BASE_URL)).newBuilder();
        urlBuilder.addQueryParameter("name", name);
        urlBuilder.addQueryParameter("style", "short");
        urlBuilder.addQueryParameter("username", geonamesConfig.username());
        val request = new Request.Builder()
                .url(urlBuilder.build())
                .build();

        try (val responseBody = client.newCall(request).execute().body()) {
            val objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            return Optional.of(objectMapper.readValue(responseBody.string(), GeonamesResponse.class));
        } catch (Exception e) {
            return Optional.empty();
        }
    }
}
