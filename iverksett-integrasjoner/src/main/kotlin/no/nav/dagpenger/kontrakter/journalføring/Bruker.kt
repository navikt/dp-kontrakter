package no.nav.dagpenger.kontrakter.iverksett.journalføring

import no.nav.dagpenger.kontrakter.felles.BrukerIdType


data class Bruker(
    val id: String,
    val type: BrukerIdType
)
