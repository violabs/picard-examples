package io.violabs.picard.enterprise.planetTracker

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class PlanetTrackerApplication

fun main(args: Array<String>) {
    runApplication<PlanetTrackerApplication>(*args)
}
