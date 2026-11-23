package co.sqasa.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public final class DatepickerPage {

    public static final Target IFRAME_DEMO = Target.the("iframe del demo por defecto")
            .locatedBy("css:iframe.demo-frame");

    public static final Target IFRAME_DEMO_RANGO_RESTRINGIDO = Target.the("iframe del demo de rango restringido")
            .locatedBy("xpath://iframe[contains(@src,'min-max')]");

    public static final Target ENLACE_RANGO_RESTRINGIDO = Target.the("enlace al demo 'Restrict date range'")
            .locatedBy("xpath://a[normalize-space()='Restrict date range']");

    public static final Target CAMPO_FECHA = Target.the("campo de fecha")
            .locatedBy("css:#datepicker");

    public static final Target CALENDARIO_EMERGENTE = Target.the("calendario emergente")
            .locatedBy("css:#ui-datepicker-div");

    public static final Target MES_VISIBLE = Target.the("mes visible en el calendario")
            .locatedBy("css:#ui-datepicker-div .ui-datepicker-month");

    public static final Target ANIO_VISIBLE = Target.the("año visible en el calendario")
            .locatedBy("css:#ui-datepicker-div .ui-datepicker-year");

    public static final Target BOTON_MES_SIGUIENTE = Target.the("botón mes siguiente")
            .locatedBy("css:#ui-datepicker-div .ui-datepicker-next");

    public static final Target BOTON_MES_ANTERIOR = Target.the("botón mes anterior")
            .locatedBy("css:#ui-datepicker-div .ui-datepicker-prev");

    public static final Target DIA_SELECCIONABLE = Target.the("día {0} seleccionable")
            .locatedBy("xpath://div[@id='ui-datepicker-div']//td[@data-handler='selectDay']/a[normalize-space()='{0}']");

    private DatepickerPage() {
    }
}
