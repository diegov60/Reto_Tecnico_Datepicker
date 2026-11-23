package co.sqasa.tasks;

import co.sqasa.interactions.CambiarAlIframe;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

import static co.sqasa.userinterfaces.DatepickerPage.IFRAME_DEMO;
import static co.sqasa.utils.Constantes.URL_DATEPICKER;
import static net.serenitybdd.screenplay.Tasks.instrumented;

/** Abre https://jqueryui.com/datepicker/ y deja el foco en el demo por defecto. */
public class AbrirDatepicker implements Task {

    public static AbrirDatepicker porDefecto() {
        return instrumented(AbrirDatepicker.class);
    }

    @Override
    @Step("{0} abre el selector de fecha de jQuery UI")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Open.url(URL_DATEPICKER),
                CambiarAlIframe.delDemo(IFRAME_DEMO)
        );
    }
}
