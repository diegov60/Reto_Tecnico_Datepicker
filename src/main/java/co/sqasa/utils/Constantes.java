package co.sqasa.utils;

import java.time.format.DateTimeFormatter;

public final class Constantes {

    public static final String URL_DATEPICKER = "https://jqueryui.com/datepicker/";

    /** Formato en el que se escriben las fechas en los features (dd/MM/yyyy). */
    public static final DateTimeFormatter FORMATO_FECHA_ENTRADA = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    /** Formato por defecto con el que jQuery UI escribe la fecha en el campo (mm/dd/yy). */
    public static final DateTimeFormatter FORMATO_FECHA_CAMPO = DateTimeFormatter.ofPattern("MM/dd/yyyy");

    /** Límite de clics de navegación entre meses para evitar ciclos infinitos (50 años). */
    public static final int MAXIMO_SALTOS_DE_MES = 600;

    /** Configuración del demo "Restrict date range": minDate: -20, maxDate: "+1M +10D". */
    public static final int DIAS_ATRAS_FECHA_MINIMA = 20;
    public static final int MESES_ADELANTE_FECHA_MAXIMA = 1;
    public static final int DIAS_ADELANTE_FECHA_MAXIMA = 10;

    public static final String MEMORIA_FECHA_SELECCIONADA = "fechaSeleccionada";

    private Constantes() {
    }
}
