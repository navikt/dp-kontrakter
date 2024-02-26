package no.nav.dagpenger.kontrakter.oppdrag

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import no.nav.dagpenger.kontrakter.felles.Fagsystem
import no.nav.dagpenger.kontrakter.felles.GeneriskId
import no.nav.dagpenger.kontrakter.felles.Satstype
import java.math.BigDecimal
import java.time.LocalDate
import java.time.LocalDateTime

@Suppress("unused")
data class Utbetalingsoppdrag(
    val erFørsteUtbetalingPåSak: Boolean,
    val fagsystem: Fagsystem,
    val saksnummer: GeneriskId,
    val iverksettingId: String?,
    val aktør: String,
    val saksbehandlerId: String,
    val avstemmingstidspunkt: LocalDateTime = LocalDateTime.now(),
    val utbetalingsperiode: List<Utbetalingsperiode>,
    val brukersNavKontor: String? = null,
)

@JsonIgnoreProperties(ignoreUnknown = true)
data class Utbetalingsperiode(
    val erEndringPåEksisterendePeriode: Boolean,
    val opphør: Opphør? = null,
    val periodeId: Long,
    val forrigePeriodeId: Long? = null,
    val vedtaksdato: LocalDate,
    val klassifisering: String,
    val fom: LocalDate,
    val tom: LocalDate,
    val sats: BigDecimal,
    val satstype: Satstype,
    val utbetalesTil: String,
    val behandlingId: GeneriskId,
    val utbetalingsgrad: Int? = null,
)

data class Opphør(val fom: LocalDate)
