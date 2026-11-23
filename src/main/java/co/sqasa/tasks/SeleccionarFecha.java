package co.sqasa.tasks;

import co.sqasa.interactions.NavegarAlMes;
import co.sqasa.questions.MesVisibleEnCalendario;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.List;

import static co.sqasa.userinterfaces.DatepickerPage.CALENDARIO_EMERGENTE;
import static co.sqasa.userinterfaces.DatepickerPage.CAMPO_FECHA;
import static co.sqasa.userinterfaces.DatepickerPage.DIA_SELECCIONABLE;
import static co.sqasa.utils.Constantes.MEMORIA_FECHA_SELECCIONADA;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

/**
 * Abre el calendario emergente, navega al mes de la fecha y hace clic en el día.
 * Si la fecha no es seleccionable (fuera de rango), no hace clic: el resultado se valida con las Questions.
 */
public class SeleccionarFecha implements Task {

    private static final int SEGUNDOS_ESPERA_CALENDARIO = 10;

    private final LocalDate fecha;

    public SeleccionarFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public static SeleccionarFecha delCalendario(LocalDate fecha) {
        return instrumented(SeleccionarFecha.class, fecha);
    }

    @Override
    @Step("{0} selecciona la fecha #fecha en el calendario emergente")
    public <T extends Actor> void performAs(T actor) {
        YearMonth mesDeLaFecha = YearMonth.from(fecha);
        actor.remember(MEMORIA_FECHA_SELECCIONADA, fecha);
        actor.attemptsTo(
                Click.on(CAMPO_FECHA),
                WaitUntil.the(CALENDARIO_EMERGENTE, isVisible()).forNoMoreThan(SEGUNDOS_ESPERA_CALENDARIO).seconds(),
                NavegarAlMes.de(mesDeLaFecha)
        );

        if (!MesVisibleEnCalendario.actual().answeredBy(actor).equals(mesDeLaFecha)) {
            return;
        }
        List<WebElementFacade> dia = DIA_SELECCIONABLE.of(String.valueOf(fecha.getDayOfMonth())).resolveAllFor(actor);
        if (!dia.isEmpty()) {
            actor.attemptsTo(Click.on(dia.get(0)));
        }
    }
}
