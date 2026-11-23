# Reto Técnico SQA – HU-001 Selección de fecha (jQuery UI Datepicker)

Automatización web con **Serenity BDD + Screenplay + Cucumber (Gherkin en español)** sobre
<https://jqueryui.com/datepicker/>. Proyecto creado a partir de la plantilla
[Proyecto-SQA/Reto_Tecnico](https://github.com/Proyecto-SQA/Reto_Tecnico), actualizada a Serenity 4 / Gradle 8.

## Escenarios automatizados

| Tag | Escenario | Criterio de aceptación |
|---|---|---|
| `@SeleccionMesDiferente` | Selección de una fecha específica en un mes diferente al actual (3 ejemplos: mes futuro, año anterior, 29 de febrero bisiesto) | CA1, CA2, CA3, CA4 |
| `@RangoRestringido` | Fechas posteriores a la máxima permitida no son seleccionables | CA6 |
| `@RangoRestringido` | Fechas anteriores a la mínima permitida no son seleccionables | CA6 |

## Requisitos

- JDK 17 o superior
- Google Chrome actualizado (el driver lo descarga Selenium Manager)
- Conexión a internet (Gradle 8.10.2 se descarga con el wrapper)

## Ejecución

```bash
./gradlew clean test                                   # todos los escenarios
./gradlew clean test -Dcucumber.filter.tags="@SeleccionMesDiferente"
./gradlew clean test -Dheadless.mode=true              # sin interfaz gráfica
```

Informe de Serenity: `target/site/serenity/index.html`

## Estructura (Screenplay)

```
src/main/java/co/sqasa
├── userinterfaces   DatepickerPage            → Targets (localizadores)
├── tasks            AbrirDatepicker, AbrirDemoRangoRestringido, SeleccionarFecha
├── interactions     CambiarAlIframe, NavegarAlMes
├── questions        ValorDelCampoFecha, MesVisibleEnCalendario
├── exceptions       NavegacionCalendarioException
└── utils            Constantes, RangoRestringido
src/test/java/co/sqasa
├── runners          SeleccionFechaRunner      → JUnit 5 Suite + Cucumber
└── stepdefinitions  SeleccionFechaStepDefinitions, Hooks
src/test/resources/features/seleccion_fecha.feature
```

Decisiones técnicas:
- Los demos de jqueryui.com se cargan en un `iframe`; `CambiarAlIframe` mueve el foco antes de interactuar.
- `NavegarAlMes` avanza o retrocede comparando el mes y año visibles con el objetivo, así funciona hacia el pasado y hacia el futuro, y se detiene si el botón está deshabilitado (rango restringido).
- Los días se localizan por `td[@data-handler='selectDay']`: jQuery UI solo pone ese atributo en días seleccionables.
- Las fechas del feature se escriben en `dd/MM/yyyy`; el campo muestra el formato por defecto de jQuery UI, `MM/dd/yyyy`.

## Análisis estático con SonarQube

```bash
docker run -d --name sonarqube -p 9000:9000 sonarqube:lts-community
# Crear token en http://localhost:9000 (My Account > Security)
./gradlew sonar -Dsonar.token=<TOKEN>
```

El informe exportado queda en `docs/sonarqube/`.
