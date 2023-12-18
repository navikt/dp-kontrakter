package no.nav.dagpenger.kontrakter.iverksett

import io.swagger.v3.oas.annotations.media.Schema
import java.time.LocalDate

data class UtbetalingDto(
    @Schema(description = "Må være et positivt heltall")
    val belopPerDag: Int,
    val fraOgMedDato: LocalDate,
    val tilOgMedDato: LocalDate,
    @Schema(oneOf = [StønadsdataDagpenger::class, StønadsdataTiltakspenger::class])
    val stønadsdata: Stønadsdata,
)
