package no.nav.dagpenger.kontrakter.iverksett

import no.nav.dagpenger.kontrakter.felles.Datoperiode
import no.nav.dagpenger.kontrakter.felles.StønadType

data class AndelTilkjentYtelse(
    val beløp: Int,
    val periode: Datoperiode,
    val stønadstype: StønadType,
    val ferietillegg: Ferietillegg?,
    val periodeId: Long? = null,
    val forrigePeriodeId: Long? = null,
) {

    private fun erTilsvarendeForUtbetaling(other: AndelTilkjentYtelse): Boolean {
        return (
                this.periode == other.periode &&
                        this.beløp == other.beløp
                )
    }

    fun erNull() = this.beløp == 0

    companion object {

        /**
         * Merk at det søkes snitt på visse attributter (erTilsvarendeForUtbetaling)
         * og man kun returnerer objekter fra receiver (ikke other)
         */
        fun Set<AndelTilkjentYtelse>.snittAndeler(other: Set<AndelTilkjentYtelse>): Set<AndelTilkjentYtelse> {
            val andelerKunIDenne = this.subtractAndeler(other)
            return this.subtractAndeler(andelerKunIDenne)
        }

        fun Set<AndelTilkjentYtelse>.disjunkteAndeler(other: Set<AndelTilkjentYtelse>): Set<AndelTilkjentYtelse> {
            val andelerKunIDenne = this.subtractAndeler(other)
            val andelerKunIAnnen = other.subtractAndeler(this)
            return andelerKunIDenne.union(andelerKunIAnnen)
        }

        private fun Set<AndelTilkjentYtelse>.subtractAndeler(other: Set<AndelTilkjentYtelse>): Set<AndelTilkjentYtelse> {
            return this.filter { a ->
                other.none { b -> a.erTilsvarendeForUtbetaling(b) }
            }.toSet()
        }
    }
}

fun AndelTilkjentYtelse.tilKlassifisering() = when (this.stønadstype) {
    StønadType.DAGPENGER_ARBEIDSSOKER_ORDINAER -> when (ferietillegg) {
        Ferietillegg.ORDINAER -> "DPORASFE"
        Ferietillegg.AVDOD -> "DPORASFE-IOP"
        null -> "DPORAS"
    }

    StønadType.DAGPENGER_PERMITTERING_ORDINAER -> when (ferietillegg) {
        Ferietillegg.ORDINAER -> "DPPEASFE1"
        Ferietillegg.AVDOD -> "DPPEASFE1-IOP"
        null -> "DPPEAS"
    }

    StønadType.DAGPENGER_PERMITTERING_FISKEINDUSTRI -> when (ferietillegg) {
        Ferietillegg.ORDINAER -> "DPPEFIFE1"
        Ferietillegg.AVDOD -> "DPPEFIFE1-IOP"
        null -> "DPPEFI"
    }

    StønadType.DAGPENGER_EOS -> when (ferietillegg) {
        Ferietillegg.ORDINAER -> "DPFEASISP"
        Ferietillegg.AVDOD -> throw IllegalArgumentException("Eksport-gruppen har ingen egen kode for ferietillegg til avdød")
        null -> "DPDPASISP1"
    }
}
