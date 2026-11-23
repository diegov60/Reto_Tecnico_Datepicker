package co.sqasa.questions;

import net.serenitybdd.screenplay.annotations.Subject;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static co.sqasa.userinterfaces.DatepickerPage.CAMPO_FECHA;

/** Devuelve el texto que quedó escrito en el campo de fecha. */
@Subject("el valor del campo de fecha")
public class ValorDelCampoFecha implements Question<String> {

    public static ValorDelCampoFecha mostrado() {
        return new ValorDelCampoFecha();
    }

    @Override
    public String answeredBy(Actor actor) {
        return CAMPO_FECHA.resolveFor(actor).getValue();
    }
}
