package no.nav.dagpenger.kontrakter.oppdrag.simulering

data class SimuleringMottaker(
    val simulertPostering: List<SimulertPostering>, // perioder
    val mottakerNummer: String? = null,
    val mottakerType: MottakerType
) {

    override fun toString(): String {
        return (
            javaClass.simpleName +
                "< mottakerType=" + mottakerType +
                ">"
            )
    }
}
