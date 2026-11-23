package co.sqasa.tasks;

import co.sqasa.interactions.CambiarAlIframe;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Open;

import static co.sqasa.userinterfaces.DatepickerPage.ENLACE_RANGO_RESTRINGIDO;
import static co.sqasa.userinterfaces.DatepickerPage.IFRAME_DEMO_RANGO_RESTRINGIDO;
import static co.sqasa.utils.Constantes.URL_DATEPICKER;
import static net.serenitybdd.screenplay.Tasks.instrumented;

/** Abre el demo "Restrict date range" (minDate: -20, maxDate: "+1M +10D") desde el menú lateral. */
public class AbrirDemoRangoRestringido implements Task {

    public static AbrirDemoRangoRestringido desdeElMenu() {
        return instrumented(AbrirDemoRangoRestringido.class);
    }

    @Override
    @Step("{0} abre el demo de rango de fechas restringido")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Open.url(URL_DATEPICKER),
                Click.on(ENLACE_RANGO_RESTRINGIDO),
                CambiarAlIframe.delDemo(IFRAME_DEMO_RANGO_RESTRINGIDO)
        );
    }
}
