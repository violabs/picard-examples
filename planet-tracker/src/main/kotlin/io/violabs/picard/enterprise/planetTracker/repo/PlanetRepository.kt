package io.violabs.picard.enterprise.planetTracker.repo

import io.violabs.picard.enterprise.planetTracker.domain.Planet
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.PagingAndSortingRepository

interface PlanetRepository : CrudRepository<Planet, String>, PagingAndSortingRepository<Planet, String>