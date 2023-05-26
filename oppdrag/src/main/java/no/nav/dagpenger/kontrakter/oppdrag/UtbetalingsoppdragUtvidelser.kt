package no.nav.dagpenger.kontrakter.iverksett.oppdrag

import no.nav.dagpenger.kontrakter.utbetaling.Utbetalingsoppdrag

fun Utbetalingsoppdrag.behandlingsIdForFørsteUtbetalingsperiode(): String {

    return utbetalingsperiode[0].behandlingId.toString()
}

