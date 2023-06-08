package no.nav.dagpenger.kontrakter.iverksett

import no.nav.dagpenger.kontrakter.felles.Brevmottakere
import no.nav.dagpenger.kontrakter.felles.Datoperiode
import no.nav.dagpenger.kontrakter.felles.Tilbakekrevingsvalg
import java.math.BigDecimal
import java.time.LocalDateTime
import java.util.*


data class IverksettDto(
    val sakId: UUID,
    val behandlingId: UUID,
    val personIdent: String,
    val vedtak: VedtaksdetaljerDagpenger,
    @Deprecated("Bruk forrigeIverksetting") val utbetalingerPaaForrigeVedtak: List<UtbetalingDto> = emptyList(),
    val forrigeIverksetting: ForrigeIverksettingDto? = null
)

data class VedtaksdetaljerDagpenger(
    val vedtakstype: VedtakType = VedtakType.RAMMEVEDTAK,
    val vedtaksresultat: Vedtaksresultat,
    val vedtakstidspunkt: LocalDateTime,
    val opphørÅrsak: OpphørÅrsak?,
    val saksbehandlerId: String,
    val beslutterId: String,
    val tilkjentYtelse: TilkjentYtelse?,
    val tilbakekreving: Tilbakekrevingsdetaljer? = null,
    val brevmottakere: Brevmottakere? = null,
    val vedtaksperioder: List<VedtaksperiodeDagpenger> = listOf(),
    val avslagÅrsak: AvslagÅrsak? = null,
)

sealed class Vedtaksperiode

data class VedtaksperiodeDagpenger(
    val periode: Datoperiode,
    val periodeType: VedtaksperiodeType,
) : Vedtaksperiode()

data class Tilbakekrevingsdetaljer(
    val tilbakekrevingsvalg: Tilbakekrevingsvalg,
    val tilbakekrevingMedVarsel: TilbakekrevingMedVarsel?,
)

data class TilbakekrevingMedVarsel(
    val varseltekst: String,
    val sumFeilutbetaling: BigDecimal?,
    val perioder: List<Datoperiode>?,
)

enum class IverksettStatus {
    SENDT_TIL_OPPDRAG,
    FEILET_MOT_OPPDRAG,
    OK_MOT_OPPDRAG,
    JOURNALFORT,
    OK,
    IKKE_PAABEGYNT,
}

enum class VedtaksperiodeType {
    MIGRERING,
    FORLENGELSE,
    HOVEDPERIODE,
    UTVIDELSE,
    SANKSJON
}

data class ForrigeIverksettingDto(
    val behandlingId: UUID,
    val utbetalinger: List<UtbetalingDto> = emptyList()
)
