package co.sqasa.interactions;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.WebDriver;

import static net.serenitybdd.screenplay.Tasks.instrumented;

/** Los demos de jqueryui.com se cargan dentro de un iframe: esta interacción mueve el foco a él. */
public class CambiarAlIframe implements Interaction {

    private final Target iframe;

    public CambiarAlIframe(Target iframe) {
        this.iframe = iframe;
    }

    public static CambiarAlIframe delDemo(Target iframe) {
        return instrumented(CambiarAlIframe.class, iframe);
    }

    @Override
    @Step("{0} cambia el foco al #iframe")
    public <T extends Actor> void performAs(T actor) {
        WebDriver driver = BrowseTheWeb.as(actor).getDriver();
        driver.switchTo().defaultContent();
        WebElementFacade elementoIframe = iframe.resolveFor(actor);
        elementoIframe.waitUntilVisible();
        driver.switchTo().frame(elementoIframe.getWrappedElement());
    }
}
