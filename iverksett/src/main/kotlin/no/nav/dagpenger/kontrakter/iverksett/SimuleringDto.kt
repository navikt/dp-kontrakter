package no.nav.dagpenger.kontrakter.iverksett

import no.nav.dagpenger.kontrakter.felles.StønadType
import java.time.LocalDate
import java.util.UUID

data class SimuleringDto(
    val utbetalinger: List<UtbetalingDto> = emptyList(),
    val saksbehandlerId: String,
    val eksternBehandlingId: Long,
    val stønadstype: StønadType,
    val sakId: UUID,
    val personIdent: String,
    val behandlingId: UUID,
    val vedtaksdato: LocalDate,
    val forrigeBehandlingId: UUID?,
)

