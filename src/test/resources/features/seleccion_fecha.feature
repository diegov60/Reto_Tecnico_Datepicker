# language: es
@HU-001
Característica: Selección de fecha en un campo de formulario
  Como usuario de la aplicación
  Quiero poder seleccionar una fecha desde un calendario emergente en el campo de entrada
  Para evitar errores al ingresar fechas manualmente

  @SeleccionMesDiferente
  Esquema del escenario: Selección de una fecha específica en un mes diferente al actual
    Dado que el usuario abre el selector de fecha de jQuery UI
    Cuando selecciona la fecha "<fecha>" desde el calendario emergente
    Entonces el campo de fecha muestra "<fechaEsperada>"

    Ejemplos:
      | fecha      | fechaEsperada |
      | 15/03/2027 | 03/15/2027    |
      | 24/12/2025 | 12/24/2025    |
      | 29/02/2028 | 02/29/2028    |

  @RangoRestringido
  Escenario: Las fechas posteriores a la máxima permitida no son seleccionables
    Dado que el usuario abre el demo de rango de fechas restringido
    Cuando intenta seleccionar una fecha posterior a la máxima permitida
    Entonces el campo de fecha permanece vacío

  @RangoRestringido
  Escenario: Las fechas anteriores a la mínima permitida no son seleccionables
    Dado que el usuario abre el demo de rango de fechas restringido
    Cuando intenta seleccionar una fecha anterior a la mínima permitida
    Entonces el campo de fecha permanece vacío
