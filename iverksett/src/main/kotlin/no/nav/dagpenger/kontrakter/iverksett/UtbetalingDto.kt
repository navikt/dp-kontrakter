package no.nav.dagpenger.kontrakter.iverksett

import no.nav.dagpenger.kontrakter.utbetaling.Ferietillegg
import no.nav.dagpenger.kontrakter.utbetaling.StønadType
import java.time.LocalDate
import java.util.UUID

data class UtbetalingDto(
    val beløp: Int,
    val fraOgMedDato: LocalDate? = null,
    val tilOgMedDato: LocalDate? = null,
    val stønadstype: StønadType = StønadType.DAGPENGER_ARBEIDSSOKER_ORDINAER,
    val ferietillegg: Ferietillegg? = null,
    @Deprecated("Bruk fraOgMedDato og tilOgMedDato")
    val periode: DatoperiodeDto? = null,
    val inntekt: Int? = null,
    val inntektsreduksjon: Int? = null,
    val samordningsfradrag: Int? = null,
    val kildeBehandlingId: UUID? = null,
)
