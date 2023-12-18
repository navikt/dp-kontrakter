package no.nav.dagpenger.kontrakter.iverksett

import no.nav.dagpenger.kontrakter.felles.StønadType
import no.nav.dagpenger.kontrakter.felles.StønadTypeDagpenger
import no.nav.dagpenger.kontrakter.felles.StønadTypeTiltakspenger

enum class Ferietillegg {
    ORDINAER,
    AVDOD
}

sealed class Stønadsdata(open val stønadstype: StønadType)

data class StønadsdataDagpenger(override val stønadstype: StønadTypeDagpenger, val ferietillegg: Ferietillegg? = null) :
    Stønadsdata(stønadstype)

data class StønadsdataTiltakspenger(
    override val stønadstype: StønadTypeTiltakspenger,
    val barnetillegg: Boolean = false
) :
    Stønadsdata(stønadstype)