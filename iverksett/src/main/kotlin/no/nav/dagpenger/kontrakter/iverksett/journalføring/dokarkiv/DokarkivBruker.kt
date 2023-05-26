package no.nav.dagpenger.kontrakter.iverksett.journalføring.dokarkiv

import no.nav.dagpenger.kontrakter.iverksett.felles.BrukerIdType

data class DokarkivBruker(
    val idType: BrukerIdType,
    val id: String
)
