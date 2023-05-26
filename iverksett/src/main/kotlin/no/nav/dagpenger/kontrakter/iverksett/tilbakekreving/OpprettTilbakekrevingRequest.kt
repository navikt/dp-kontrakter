package no.nav.dagpenger.kontrakter.iverksett.tilbakekreving

import no.nav.dagpenger.kontrakter.iverksett.felles.Regelverk
import no.nav.dagpenger.kontrakter.iverksett.felles.Språkkode
import no.nav.dagpenger.kontrakter.utbetaling.Fagsystem
import java.time.LocalDate

data class OpprettTilbakekrevingRequest(
    val fagsystem: Fagsystem,
    val regelverk: Regelverk? = null,
    val ytelsestype: Ytelsestype,
    val eksternFagsakId: String,
    val personIdent: String,
    // Fagsystemreferanse til behandlingen, må være samme id som brukes mot datavarehus og økonomi
    val eksternId: String,
    val behandlingstype: Behandlingstype? = Behandlingstype.TILBAKEKREVING,
    val manueltOpprettet: Boolean,
    val språkkode: Språkkode = Språkkode.NB,
    val enhetId: String,
    val enhetsnavn: String,
    val saksbehandlerIdent: String,
    val varsel: Varsel?,
    val revurderingsvedtaksdato: LocalDate,
    val verge: Verge? = null,
    val faktainfo: Faktainfo,
    val institusjon: Institusjon? = null,
) {

    init {
        if (manueltOpprettet) {
            require(varsel == null) { "Kan ikke opprette manuelt behandling med varsel" }
        }
    }
}
