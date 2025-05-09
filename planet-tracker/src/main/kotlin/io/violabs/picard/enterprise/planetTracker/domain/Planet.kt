package io.violabs.picard.enterprise.planetTracker.domain

import jakarta.persistence.Entity
import jakarta.persistence.Id


@Entity
data class Planet(
    @Id val name: String,
    val hasKnownIntelligentLife: Boolean,
    val stardate: String
)