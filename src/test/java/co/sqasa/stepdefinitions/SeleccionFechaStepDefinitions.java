package co.sqasa.stepdefinitions;

import co.sqasa.questions.ValorDelCampoFecha;
import co.sqasa.tasks.AbrirDatepicker;
import co.sqasa.tasks.AbrirDemoRangoRestringido;
import co.sqasa.tasks.SeleccionarFecha;
import co.sqasa.utils.RangoRestringido;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;

import java.time.LocalDate;

import static co.sqasa.utils.Constantes.FORMATO_FECHA_ENTRADA;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.emptyOrNullString;
import static org.hamcrest.Matchers.equalTo;

public class SeleccionFechaStepDefinitions {

    private static final String ACTOR = "Usuario";

    @Dado("que el usuario abre el selector de fecha de jQuery UI")
    public void abreElSelectorDeFecha() {
        theActorCalled(ACTOR).attemptsTo(AbrirDatepicker.porDefecto());
    }

    @Dado("que el usuario abre el demo de rango de fechas restringido")
    public void abreElDemoDeRangoRestringido() {
        theActorCalled(ACTOR).attemptsTo(AbrirDemoRangoRestringido.desdeElMenu());
    }

    @Cuando("selecciona la fecha {string} desde el calendario emergente")
    public void seleccionaLaFecha(String fecha) {
        theActorInTheSpotlight().attemptsTo(
                SeleccionarFecha.delCalendario(LocalDate.parse(fecha, FORMATO_FECHA_ENTRADA)));
    }

    @Cuando("intenta seleccionar una fecha posterior a la máxima permitida")
    public void intentaSeleccionarFechaPosteriorAlMaximo() {
        theActorInTheSpotlight().attemptsTo(
                SeleccionarFecha.delCalendario(RangoRestringido.primeraFechaPosteriorAlMaximo()));
    }

    @Cuando("intenta seleccionar una fecha anterior a la mínima permitida")
    public void intentaSeleccionarFechaAnteriorAlMinimo() {
        theActorInTheSpotlight().attemptsTo(
                SeleccionarFecha.delCalendario(RangoRestringido.ultimaFechaAnteriorAlMinimo()));
    }

    @Entonces("el campo de fecha muestra {string}")
    public void elCampoDeFechaMuestra(String fechaEsperada) {
        theActorInTheSpotlight().should(seeThat(ValorDelCampoFecha.mostrado(), equalTo(fechaEsperada)));
    }

    @Entonces("el campo de fecha permanece vacío")
    public void elCampoDeFechaPermaneceVacio() {
        theActorInTheSpotlight().should(seeThat(ValorDelCampoFecha.mostrado(), emptyOrNullString()));
    }
}
