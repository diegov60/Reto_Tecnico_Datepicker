package co.sqasa.utils;

import java.time.LocalDate;

import static co.sqasa.utils.Constantes.DIAS_ADELANTE_FECHA_MAXIMA;
import static co.sqasa.utils.Constantes.DIAS_ATRAS_FECHA_MINIMA;
import static co.sqasa.utils.Constantes.MESES_ADELANTE_FECHA_MAXIMA;

/** Calcula los límites del demo "Restrict date range" a partir de la fecha actual. */
public final class RangoRestringido {

    private RangoRestringido() {
    }

    public static LocalDate fechaMinima() {
        return LocalDate.now().minusDays(DIAS_ATRAS_FECHA_MINIMA);
    }

    public static LocalDate fechaMaxima() {
        return LocalDate.now().plusMonths(MESES_ADELANTE_FECHA_MAXIMA).plusDays(DIAS_ADELANTE_FECHA_MAXIMA);
    }

    public static LocalDate primeraFechaPosteriorAlMaximo() {
        return fechaMaxima().plusDays(1);
    }

    public static LocalDate ultimaFechaAnteriorAlMinimo() {
        return fechaMinima().minusDays(1);
    }
}
