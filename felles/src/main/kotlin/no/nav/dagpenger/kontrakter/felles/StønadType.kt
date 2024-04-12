package no.nav.dagpenger.kontrakter.felles

import com.fasterxml.jackson.annotation.JsonCreator

sealed interface StønadType {
    companion object {
        @JsonCreator
        @JvmStatic
        fun deserialize(json: String): StønadType? {
            return StønadTypeDagpenger.values().find { it.name == json }
        }
    }
}

enum class StønadTypeDagpenger : StønadType {
    DAGPENGER_ARBEIDSSOKER_ORDINAER,
    DAGPENGER_PERMITTERING_ORDINAER,
    DAGPENGER_PERMITTERING_FISKEINDUSTRI,
    DAGPENGER_EOS,
}
