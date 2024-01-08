package no.nav.dagpenger.kontrakter.iverksett

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.databind.JsonNode
import no.nav.dagpenger.kontrakter.felles.StønadType
import no.nav.dagpenger.kontrakter.felles.StønadTypeDagpenger
import no.nav.dagpenger.kontrakter.felles.StønadTypeTiltakspenger

enum class Ferietillegg {
    ORDINAER,
    AVDOD
}

sealed class Stønadsdata(open val stønadstype: StønadType) {
    companion object {
        @JsonCreator
        @JvmStatic
        fun deserialize(json: JsonNode): Stønadsdata {
            val stønadstype = json.findValue("stønadstype").asText()
            return Result.runCatching { StønadTypeDagpenger.valueOf(stønadstype) }.fold(
                    onSuccess = {
                        val ferietillegg = json.findValue("ferietillegg")?.asText()
                        if (ferietillegg != null) {
                            StønadsdataDagpenger(it, Ferietillegg.valueOf(ferietillegg))
                        } else {
                            StønadsdataDagpenger(it)
                        }
                    },
                    onFailure = {
                        val stønadstype = StønadTypeTiltakspenger.valueOf(stønadstype)
                        val barnetillegg = json.findValue("barnetillegg")?.asBoolean()
                        StønadsdataTiltakspenger(stønadstype, barnetillegg ?: false)
                    }
            )
        }
    }
}

data class StønadsdataDagpenger(override val stønadstype: StønadTypeDagpenger, val ferietillegg: Ferietillegg? = null) :
    Stønadsdata(stønadstype)

data class StønadsdataTiltakspenger(
    override val stønadstype: StønadTypeTiltakspenger,
    val barnetillegg: Boolean = false
) :
    Stønadsdata(stønadstype)