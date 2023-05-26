package no.nav.dagpenger.kontrakter.felles

enum class RegelId(val beskrivelse: String) {

    // Medlemskap
    SØKER_MEDLEM_I_FOLKETRYGDEN("Har søker vært medlem i folketrygden i de siste 5 årene?"),
    MEDLEMSKAP_UNNTAK("Er unntak fra hovedreglen oppfylt?"),

    // Opphold
    BOR_OG_OPPHOLDER_SEG_I_NORGE("Bor og oppholder bruker og barna seg i Norge?"),
    OPPHOLD_UNNTAK("Er unntak fra hovedregelen oppfylt?"),

    // Aleneomsorg
    SKRIFTLIG_AVTALE_OM_DELT_BOSTED(""),
    NÆRE_BOFORHOLD(""),
    MER_AV_DAGLIG_OMSORG(""),

    // Mor eller far
    OMSORG_FOR_EGNE_ELLER_ADOPTERTE_BARN("Har bruker omsorgen for egne/adopterte barn?"),

    // Sivilstand
    KRAV_SIVILSTAND_UTEN_PÅKREVD_BEGRUNNELSE("Er krav til sivilstand oppfylt?"),

    // Aktivitet
    FYLLER_BRUKER_AKTIVITETSPLIKT("Fyller bruker aktivitetsplikt, unntak for aktivitetsplikt eller har barn under 1 år?"),

    // Sagt opp arbeidsforhold
    SAGT_OPP_ELLER_REDUSERT("Har søker sagt opp jobben, tatt frivillig permisjon eller redusert arbeidstiden de siste 6 månedene før søknadstidspunktet?"),
    RIMELIG_GRUNN_SAGT_OPP("Hadde søker rimelig grunn til å si opp jobben eller redusere arbeidstiden?"),

    // Tidligere Stønadsperioder
    HAR_TIDLIGERE_MOTTATT_DAGPENGER("Har søker tidligere mottatt dagpenger?"),
    HAR_TIDLIGERE_ANDRE_STØNADER_SOM_HAR_BETYDNING("Har søker tidligere mottatt andre stønader som har betydning for stønadstiden i §15-8 første og andre ledd?"),

    // Inntekt
    INNTEKT_LAVERE_ENN_INNTEKTSGRENSE("Har brukeren inntekt under 6 ganger grunnbeløpet?"),
    INNTEKT_SAMSVARER_MED_OS("Er inntekten i samsvar med den inntekten som er lagt til grunn ved beregning av dagpenger?"),

    // Aktivitet - arbeid
    ER_I_ARBEID_ELLER_FORBIGÅENDE_SYKDOM("Er brukeren i arbeid eller har forbigående sykdom?"),
}
