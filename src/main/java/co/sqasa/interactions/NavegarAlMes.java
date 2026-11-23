package co.sqasa.interactions;

import co.sqasa.exceptions.NavegacionCalendarioException;
import co.sqasa.questions.MesVisibleEnCalendario;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;

import java.time.YearMonth;

import static co.sqasa.userinterfaces.DatepickerPage.BOTON_MES_ANTERIOR;
import static co.sqasa.userinterfaces.DatepickerPage.BOTON_MES_SIGUIENTE;
import static co.sqasa.utils.Constantes.MAXIMO_SALTOS_DE_MES;
import static net.serenitybdd.screenplay.Tasks.instrumented;

/**
 * Avanza o retrocede en el calendario hasta el mes objetivo.
 * Si el botón de navegación está deshabilitado (rango restringido), se detiene en el último mes permitido.
 */
public class NavegarAlMes implements Interaction {

    private static final String CLASE_DESHABILITADO = "ui-state-disabled";

    private final YearMonth mesObjetivo;

    public NavegarAlMes(YearMonth mesObjetivo) {
        this.mesObjetivo = mesObjetivo;
    }

    public static NavegarAlMes de(YearMonth mesObjetivo) {
        return instrumented(NavegarAlMes.class, mesObjetivo);
    }

    @Override
    @Step("{0} navega en el calendario hasta #mesObjetivo")
    public <T extends Actor> void performAs(T actor) {
        for (int salto = 0; salto < MAXIMO_SALTOS_DE_MES; salto++) {
            YearMonth mesActual = MesVisibleEnCalendario.actual().answeredBy(actor);
            if (mesActual.equals(mesObjetivo)) {
                return;
            }
            Target boton = mesActual.isBefore(mesObjetivo) ? BOTON_MES_SIGUIENTE : BOTON_MES_ANTERIOR;
            if (estaDeshabilitado(boton, actor)) {
                return;
            }
            actor.attemptsTo(Click.on(boton));
        }
        throw new NavegacionCalendarioException(
                "No se alcanzó el mes " + mesObjetivo + " después de " + MAXIMO_SALTOS_DE_MES + " saltos");
    }

    private static boolean estaDeshabilitado(Target boton, Actor actor) {
        String clases = boton.resolveFor(actor).getAttribute("class");
        return clases != null && clases.contains(CLASE_DESHABILITADO);
    }
}
