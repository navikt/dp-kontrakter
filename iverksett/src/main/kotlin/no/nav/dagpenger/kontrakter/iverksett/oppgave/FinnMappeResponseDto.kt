package no.nav.dagpenger.kontrakter.iverksett.oppgave

data class FinnMappeResponseDto(
    val antallTreffTotalt: Int,
    val mapper: List<MappeDto>,
)

data class MappeDto(
    val id: Int,
    val navn: String,
    val enhetsnr: String,
    val tema: String? = null,
)
