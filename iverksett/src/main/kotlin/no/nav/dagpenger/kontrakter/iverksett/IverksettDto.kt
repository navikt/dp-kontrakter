package no.nav.dagpenger.kontrakter.iverksett

import no.nav.dagpenger.kontrakter.felles.AvslagÅrsak
import no.nav.dagpenger.kontrakter.felles.BehandlingType
import no.nav.dagpenger.kontrakter.felles.BehandlingÅrsak
import no.nav.dagpenger.kontrakter.felles.Brevmottaker
import no.nav.dagpenger.kontrakter.felles.Datoperiode
import no.nav.dagpenger.kontrakter.felles.OpphørÅrsak
import no.nav.dagpenger.kontrakter.felles.RegelId
import no.nav.dagpenger.kontrakter.felles.SvarId
import no.nav.dagpenger.kontrakter.felles.Tilbakekrevingsvalg
import no.nav.dagpenger.kontrakter.felles.VedtakType
import no.nav.dagpenger.kontrakter.felles.Vedtaksresultat
import no.nav.dagpenger.kontrakter.felles.VilkårType
import no.nav.dagpenger.kontrakter.felles.Vilkårsresultat
import no.nav.dagpenger.kontrakter.utbetaling.StønadType
import java.math.BigDecimal
import java.time.LocalDate
import java.time.LocalDateTime
import java.util.UUID

data class IverksettDagpengerdDto(
    val sakId: UUID? = null,
    @Deprecated("Bruk sakId")
    val sak: SakDto? = null,
    @Deprecated("Bruk sakId")
    val fagsak: FagsakdetaljerDto? = null,
    val behandlingId: UUID? = null,
    val behandling: BehandlingsdetaljerDto? = null,
    val personIdent: String? = null,
    @Deprecated("Bruk personIdent")
    val søker: SøkerDto?=null,
    val vedtak: VedtaksdetaljerDagpengerDto,
    val forrigeVedtak: VedtaksdetaljerDagpengerDto? = null
)

data class SøkerDto(
    val personIdent: String,
    val barn: List<BarnDto> = emptyList(),
    val tilhørendeEnhet: String = "",
    val adressebeskyttelse: AdressebeskyttelseGradering? = null,
)

@Deprecated("Bruk SakDto")
data class FagsakdetaljerDto(
    val fagsakId: UUID,
    val eksternId: Long? = null, // Ikke i bruk, bær fjernes
    val stønadstype: StønadType = StønadType.DAGPENGER_ARBEIDSSOKER_ORDINAER,
)

@Deprecated("Bruk SakId")
data class SakDto(
    val sakId: UUID,
    val stønadstype: StønadType = StønadType.DAGPENGER_ARBEIDSSOKER_ORDINAER,
)

data class BehandlingsdetaljerDto(
    val behandlingId: UUID,
    val forrigeBehandlingId: UUID? = null,
    val eksternId: Long? = null, // Ikke i bruk, bær fjernes
    val behandlingType: BehandlingType,
    val behandlingÅrsak: BehandlingÅrsak,
    val vilkårsvurderinger: List<VilkårsvurderingDto> = emptyList(),
    val aktivitetspliktInntrefferDato: LocalDate? = null,
    val kravMottatt: LocalDate? = null,
    val årsakRevurdering: ÅrsakRevurderingDto? = null,
)

data class VedtaksdetaljerDagpengerDto(
    val vedtakstype: VedtakType = VedtakType.RAMMEVEDTAK,
    val vedtakstidspunkt: LocalDateTime,
    val resultat: Vedtaksresultat,
    val saksbehandlerId: String,
    val beslutterId: String,
    val opphørÅrsak: OpphørÅrsak? = null,
    val avslagÅrsak: AvslagÅrsak? = null,
    val utbetalinger: List<UtbetalingDto> = emptyList(),
    val vedtaksperioder: List<VedtaksperiodeDagpengerDto> = emptyList(),
    val tilbakekreving: TilbakekrevingDto? = null,
    val brevmottakere: List<Brevmottaker> = emptyList(),
)

data class VilkårsvurderingDto(
    val vilkårType: VilkårType,
    val resultat: Vilkårsresultat,
    val delvilkårsvurderinger: List<DelvilkårsvurderingDto> = emptyList(),
)

data class DelvilkårsvurderingDto(
    val resultat: Vilkårsresultat,
    val vurderinger: List<VurderingDto> = emptyList(),
)

data class VurderingDto(
    val regelId: RegelId,
    val svar: SvarId? = null,
    val begrunnelse: String? = null
)
data class VedtaksperiodeDagpengerDto(
    val fraOgMedDato: LocalDate? = null,
    val tilOgMedDato: LocalDate? = null,
    @Deprecated("Bruk fraOgMedDato og tilOgMedDato")
    val periode: DatoperiodeDto? = null,
    val aktivitet: AktivitetType? = null,
    val periodeType: VedtaksperiodeType = VedtaksperiodeType.HOVEDPERIODE,
)

data class TilbakekrevingDto(
    val tilbakekrevingsvalg: Tilbakekrevingsvalg,
    val tilbakekrevingMedVarsel: TilbakekrevingMedVarselDto?,
)

data class TilbakekrevingMedVarselDto(
    val varseltekst: String,
    val sumFeilutbetaling: BigDecimal? = null, // Hentes fra simulering hvis det mangler
    val fellesperioder: List<Datoperiode> = emptyList()
) // Hentes fra simulering hvis det mangler

enum class AdressebeskyttelseGradering {
    STRENGT_FORTROLIG,
    STRENGT_FORTROLIG_UTLAND,
    FORTROLIG,
    UGRADERT,
}

enum class IverksettStatus {
    SENDT_TIL_OPPDRAG,
    FEILET_MOT_OPPDRAG,
    OK_MOT_OPPDRAG,
    JOURNALFØRT,
    OK,
    IKKE_PÅBEGYNT,
}

enum class VedtaksperiodeType {
    MIGRERING,
    FORLENGELSE,
    HOVEDPERIODE,
    UTVIDELSE,
    SANKSJON
}

enum class AktivitetType {
    MIGRERING,
    IKKE_AKTIVITETSPLIKT,
    BARN_UNDER_ETT_ÅR,
    FORSØRGER_I_ARBEID,
    FORSØRGER_I_UTDANNING,
    FORSØRGER_REELL_ARBEIDSSØKER,
    FORSØRGER_ETABLERER_VIRKSOMHET,
    BARNET_SÆRLIG_TILSYNSKREVENDE,
    FORSØRGER_MANGLER_TILSYNSORDNING,
    FORSØRGER_ER_SYK,
    BARNET_ER_SYKT,
    UTVIDELSE_FORSØRGER_I_UTDANNING,
    UTVIDELSE_BARNET_SÆRLIG_TILSYNSKREVENDE,
    FORLENGELSE_MIDLERTIDIG_SYKDOM,
    FORLENGELSE_STØNAD_PÅVENTE_ARBEID,
    FORLENGELSE_STØNAD_PÅVENTE_ARBEID_REELL_ARBEIDSSØKER,
    FORLENGELSE_STØNAD_PÅVENTE_OPPSTART_KVALIFISERINGSPROGRAM,
    FORLENGELSE_STØNAD_PÅVENTE_TILSYNSORDNING,
    FORLENGELSE_STØNAD_PÅVENTE_UTDANNING,
    FORLENGELSE_STØNAD_UT_SKOLEÅRET,
}

data class DatoperiodeDto(
    val fom: LocalDate,
    val tom: LocalDate? = null
)
