package com.gagioga.DespEvery.geonames;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("geonames")
public record GeonamesConfig(String username) {
}
