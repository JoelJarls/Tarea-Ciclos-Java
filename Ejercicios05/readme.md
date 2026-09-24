# Ejercicio 05: Estacionamiento Universitario

## Descripción del Problema
Programa para el control de cobro de un estacionamiento universitario. Permite registrar secuencialmente distintos tipos de vehículos (Motocicleta, Automóvil y Camioneta) solicitando la cantidad de horas estacionadas. Valida estrictamente que las horas ingresadas sean mayores que cero ($horas > 0$) y procesa las tarifas por hora específicas para cada categoría.

Al finalizar la captura de datos, genera un reporte consolidado con:
- Total de vehículos ingresados por categoría.
- Total general de vehículos atendidos.
- Recaudación monetaria total.
- Promedio monetario cobrado por vehículo.

---

## Análisis del Algoritmo

### Entradas
- `tipoVehiculo` (entero): Opción del menú ($1 = \text{Motocicleta}$, $2 = \text{Automóvil}$, $3 = \text{Camioneta}$).
- `horas` (decimal): Tiempo estacionado en horas.
- `continuar` (entero): Bandera de repetición del menú ($1 = \text{Sí}$, $0 = \text{Terminar}$).

### Proceso
1. **Control del ciclo principal:** Un bucle `do-while` ejecuta la lectura mientras `continuar != 0`.
2. **Validación de categoría:** Comprueba con un condicional `if (tipoVehiculo >= 1 && tipoVehiculo <= 3)` si la categoría elegida es válida.
3. **Validación de horas:** Utiliza un ciclo interno `do-while` que exige al usuario ingresar un valor estrictamente mayor que cero ($horas > 0$).
4. **Cálculo de tarifas (`switch`):**
   - Caso 1 (Moto): $pago = horas \times 0.50$, incrementa `contMoto`.
   - Caso 2 (Auto): $pago = horas \times 1.00$, incrementa `contAuto`.
   - Caso 3 (Camioneta): $pago = horas \times 1.50$, incrementa `contCamioneta`.
5. **Acumulación:** Suma el pago parcial a `totalRecaudado`.
6. **Consolidado final:** Suma el número de vehículos y calcula el promedio general previniendo la división por cero (`if (totalVehiculos > 0)`).

### Salidas
- Reporte formateado con conteos individuales, suma de vehículos, total acumulado y promedio.

---

## Estructuras Utilizadas
- **`do-while`:** Controla la repetición del registro de vehículos y la validación obligatoria de horas ($horas > 0$).
- **`switch-case`:** Aplica la tarifa correspondiente según el tipo de vehículo.
- **`if-else`:** Verifica que el menú de vehículo ingresado sea válido e impide divisiones por cero al calcular el promedio.
- **Contadores y Acumuladores:**
  - Contadores: `contMoto`, `contAuto`, `contCamioneta`, `totalVehiculos`.
  - Acumulador: `totalRecaudado`.

---

## Casos de Prueba y Límites

| Caso Evaluado | Entradas de Prueba | Resultado Esperado |
| :--- | :--- | :--- |
| **Opción de vehículo inválida** | Opción: `5` $\rightarrow$ Opción: `2` | Muestra "Opción de vehículo no válida." y vuelve a consultar si desea continuar. |
| **Horas inválidas ($\le 0$)** | Horas: `-2` $\rightarrow$ Horas: `0` $\rightarrow$ Horas: `3` | Rechaza `-2` y `0` mostrando mensaje de error; acepta `3`. |
| **Finalizar sin registros** | Opción: `4` $\rightarrow$ Continuar: `0` | Procesa `totalVehiculos = 0` y `promedioPagado = 0.00` sin errores. |
| **Proceso completo** | Moto: `2` hrs, Auto: `1.5` hrs | Moto: `$1.00`, Auto: `$1.50`, Total: `$2.50`, Promedio: `$1.25`. |
