package no.nav.dagpenger.kontrakter.iverksett.journalføring

import no.nav.dagpenger.iverksett.kontrakter.felles.BrukerIdType

data class Bruker(
    val id: String,
    val type: BrukerIdType
)
