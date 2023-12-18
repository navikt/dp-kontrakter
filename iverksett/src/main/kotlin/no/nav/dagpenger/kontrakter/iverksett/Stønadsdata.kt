package no.nav.dagpenger.kontrakter.iverksett

import no.nav.dagpenger.kontrakter.felles.StønadTypeDagpenger
import no.nav.dagpenger.kontrakter.felles.StønadTypeTiltakspenger

enum class Ferietillegg {
    ORDINAER,
    AVDOD
}

sealed interface Stønadsdata

data class StønadsdataDagpenger(val stønadstype: StønadTypeDagpenger, val ferietillegg: Ferietillegg? = null) :
    Stønadsdata

data class StønadsdataTiltakspenger(val stønadType: StønadTypeTiltakspenger, val barnetillegg: Boolean = false) :
    Stønadsdata