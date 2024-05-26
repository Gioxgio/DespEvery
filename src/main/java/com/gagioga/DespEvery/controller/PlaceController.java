package com.gagioga.DespEvery.controller;

import com.gagioga.DespEvery.model.Place;
import com.gagioga.DespEvery.service.PlaceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RequestMapping("/place")
@RequiredArgsConstructor
@RestController
public class PlaceController {

    private final PlaceService placeService;

    @GetMapping
    public List<Place> getByName(@RequestParam(value = "name") final String name) {
        return Optional.ofNullable(name).map(placeService::getByName).orElseGet(() -> List.of(new Place()));
    }
}
