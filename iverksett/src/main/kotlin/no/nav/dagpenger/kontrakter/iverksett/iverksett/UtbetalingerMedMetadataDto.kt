package no.nav.dagpenger.kontrakter.iverksett.iverksett

import no.nav.dagpenger.kontrakter.utbetaling.StønadType
import java.time.LocalDate
import java.util.UUID

data class UtbetalingerMedMetadataDto(
    val utbetalinger: List<UtbetalingDto>,
    val saksbehandlerId: String,
    val stønadstype: StønadType,
    val sakId: UUID,
    val personIdent: String,
    val behandlingId: UUID,
    val vedtaksdato: LocalDate,
)