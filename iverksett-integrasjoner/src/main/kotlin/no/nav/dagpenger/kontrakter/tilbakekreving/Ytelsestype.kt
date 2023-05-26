package no.nav.dagpenger.kontrakter.iverksett.tilbakekreving

import no.nav.dagpenger.kontrakter.felles.Språkkode

enum class Ytelsestype(val kode: String, val navn: Map<Språkkode, String>) {
    DAGPENGER_ARBEIDSSOKER_ORDINAER(
        "DPORAS",
        mapOf(
            Språkkode.NB to "Dagpenger",
            Språkkode.NN to "Dagpengar",
        ),
    )
}