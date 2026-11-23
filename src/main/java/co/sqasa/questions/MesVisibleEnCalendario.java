package co.sqasa.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import java.time.Month;
import java.time.YearMonth;
import java.util.Locale;

import static co.sqasa.userinterfaces.DatepickerPage.ANIO_VISIBLE;
import static co.sqasa.userinterfaces.DatepickerPage.MES_VISIBLE;

/** Devuelve el mes y año que el calendario emergente está mostrando. */
public class MesVisibleEnCalendario implements Question<YearMonth> {

    public static MesVisibleEnCalendario actual() {
        return new MesVisibleEnCalendario();
    }

    @Override
    public YearMonth answeredBy(Actor actor) {
        String mes = MES_VISIBLE.resolveFor(actor).getText().trim();
        String anio = ANIO_VISIBLE.resolveFor(actor).getText().trim();
        return YearMonth.of(Integer.parseInt(anio), Month.valueOf(mes.toUpperCase(Locale.ENGLISH)));
    }
}
