package no.nav.dagpenger.kontrakter.felles

data class FrittståendeBrevDto(
    val personIdent: String,
    val eksternFagsakId: Long,
    val stønadType: StønadType,
    val brevtype: FrittståendeBrevType,
    val fil: ByteArray,
    val journalførendeEnhet: String,
    val saksbehandlerIdent: String,
    val mottakere: List<BrevmottakerDto>? = null,
)

enum class FrittståendeBrevType(val tittel: String) {
    INFORMASJONSBREV("Informasjonsbrev"),
    INNHENTING_AV_OPPLYSNINGER("Innhenting av opplysninger"),
    VARSEL_OM_AKTIVITETSPLIKT("Varsel om aktivitetsplikt"),
    VARSEL_OM_SANKSJON("Varsel om sanksjon"),
    INNHENTING_AV_KARAKTERUTSKRIFT_HOVEDPERIODE("Innhenting av karakterutskrift (hovedperiode)"),
    INNHENTING_AV_KARAKTERUTSKRIFT_UTVIDET_PERIODE("Innhenting av karakterutskrift (utvidet periode)"),
    BREV_OM_SVARTID_KLAGE("Brev om svartid - klage"),
    BREV_OM_FORLENGET_SVARTID("Brev om forlenget svartid"),
    BREV_OM_FORLENGET_SVARTID_KLAGE("Brev om forlenget svartid - klage"),
    INFORMASJONSBREV_TRUKKET_SØKNAD("Informasjonsbrev - bruker har trukket søknad"),
    VARSEL_UTESTENGELSE("Varsel om utestengelse"),
    VEDTAK_UTESTENGELSE("Vedtak om utestengelse"),
}
