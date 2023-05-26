package no.nav.dagpenger.kontrakter.iverksett.journalføring.dokarkiv

import no.nav.dagpenger.iverksett.kontrakter.felles.BrukerIdType

data class AvsenderMottaker(
    val id: String?,
    val idType: BrukerIdType?,
    val navn: String
)
