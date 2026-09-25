# 🅿️ Ejercicio 5 — Estacionamiento Universitario

Programa para registrar los vehículos que utilizan un estacionamiento, calcular el cobro según el tipo de vehículo y las horas estacionadas, y generar un reporte final con contadores y acumuladores.

## 📑 Contenido

- [Descripción del problema](#-descripción-del-problema)
- [Análisis](#-análisis)
- [Estructuras de control utilizadas](#-estructuras-de-control-utilizadas)
- [Pseudocódigo](#-pseudocódigo)
- [Casos de prueba](#-casos-de-prueba)
- [Trazas de ejecución](#-trazas-de-ejecución)

---

## 📋 Descripción del problema

Se debe desarrollar un programa que registre varios vehículos que ingresan a un estacionamiento. Por cada vehículo se solicita el **tipo** (Motocicleta, Automóvil o Camioneta) y las **horas estacionado**, y se calcula el valor a pagar según la siguiente tarifa:

| Tipo de vehículo | Tarifa por hora |
|---|---|
| 🏍️ Motocicleta | $0.50 |
| 🚗 Automóvil | $1.00 |
| 🚚 Camioneta | $1.50 |

El programa debe repetir el registro **hasta que el usuario decida terminar**, y al finalizar debe imprimir un reporte con el número de vehículos por tipo, el total de vehículos, el total recaudado y el promedio pagado por vehículo.

**Regla de validación:** las horas ingresadas deben ser mayores que cero; si no lo son, el programa debe volver a solicitarlas.

---

## 🔍 Análisis

### Entradas

| Variable | Tipo de dato | Descripción |
|---|---|---|
| `tipo` | Entero | Tipo de vehículo (1 = Motocicleta, 2 = Automóvil, 3 = Camioneta) |
| `horas` | Entero / Real | Número de horas que el vehículo permanece estacionado (> 0) |
| `continuar` | Carácter | Respuesta del usuario (`s`/`n`) para seguir registrando vehículos |

### Proceso (contadores, acumuladores y variables auxiliares)

| Variable | Tipo de dato | Rol | Valor inicial |
|---|---|---|---|
| `contMoto` | Entero | Contador de motocicletas | 0 |
| `contAuto` | Entero | Contador de automóviles | 0 |
| `contCamioneta` | Entero | Contador de camionetas | 0 |
| `totalVehiculos` | Entero | Contador general de vehículos registrados | 0 |
| `tarifa` | Real | Tarifa por hora según el tipo (definida en el `switch`) | — |
| `pago` | Real | Valor a pagar por el vehículo actual (`tarifa * horas`) | — |
| `totalRecaudado` | Real | Acumulador del dinero recaudado | 0.00 |
| `promedio` | Real | Promedio pagado por vehículo (`totalRecaudado / totalVehiculos`) | — |

### Salidas

| Salida | Descripción |
|---|---|
| Mensajes de validación | Se muestran cuando las horas ingresadas son ≤ 0 |
| Reporte final | Cantidad de motocicletas, automóviles y camionetas; total de vehículos; total recaudado; promedio pagado |

### Reglas de validación

- `horas` debe ser **estrictamente mayor que cero**; si no lo es, se vuelve a pedir el dato (ciclo de validación anidado).
- El registro de vehículos continúa **mientras** el usuario responda afirmativamente (`s`); se detiene con cualquier otra respuesta (`n`).

---

## ⚙️ Estructuras de control utilizadas

| Estructura | Uso en el programa |
|---|---|
| `do-while` | Ciclo principal de registro de vehículos (se ejecuta al menos una vez) y ciclo de validación de horas |
| `switch` | Selección de la tarifa según el tipo de vehículo ingresado |
| Contadores | `contMoto`, `contAuto`, `contCamioneta`, `totalVehiculos` |
| Acumuladores | `totalRecaudado` |

---

## 🧮 Pseudocódigo

```
Inicio
 1.  contMoto        ← 0
 2.  contAuto        ← 0
 3.  contCamioneta   ← 0
 4.  totalVehiculos  ← 0
 5.  totalRecaudado  ← 0
 6.  hacer
 7.      Escribir "Tipo (1.Moto  2.Auto  3.Camioneta): "
 8.      Leer tipo
 9.      hacer
10.          Escribir "Horas estacionado: "
11.          Leer horas
12.          si (horas <= 0) entonces
13.              Escribir "Error: las horas deben ser mayores que cero"
14.          fin si
15.      mientras (horas <= 0)
16.      segun tipo hacer
17.          caso 1: tarifa ← 0.50
18.                   contMoto ← contMoto + 1
19.          caso 2: tarifa ← 1.00
20.                   contAuto ← contAuto + 1
21.          caso 3: tarifa ← 1.50
22.                   contCamioneta ← contCamioneta + 1
23.          defecto: Escribir "Tipo de vehículo inválido"
24.                   tarifa ← 0
25.      fin segun
26.      pago ← tarifa * horas
27.      totalVehiculos ← totalVehiculos + 1
28.      totalRecaudado ← totalRecaudado + pago
29.      Escribir "¿Desea registrar otro vehículo? (s/n): "
30.      Leer continuar
31.  mientras (continuar = 's')
32.  promedio ← totalRecaudado / totalVehiculos
33.  Escribir "===== REPORTE ====="
34.  Escribir "Motocicletas: ", contMoto
35.  Escribir "Automóviles: ", contAuto
36.  Escribir "Camionetas: ", contCamioneta
37.  Escribir "Total vehículos: ", totalVehiculos
38.  Escribir "Total recaudado: $", totalRecaudado
39.  Escribir "Promedio pagado: $", promedio
40.  Escribir "===================="
Fin
```

---

## 🧪 Casos de prueba

| # | Nombre del caso | Objetivo | Datos de entrada (tipo, horas) | Resultado esperado |
|---|---|---|---|---|
| 1 | Flujo normal con los 3 tipos | Verificar el `switch`, los 3 contadores y el acumulador con datos válidos desde el inicio | (1, 3) → s · (2, 5) → s · (3, 2) → n | Total: 3 · Recaudado: $9.50 · Promedio: $3.17 |
| 2 | Validación de horas ≤ 0 | Verificar que el ciclo `do-while` interno rechace horas inválidas (negativas y cero) | (2, -2) inválido → (2, 0) inválido → (2, 4) válido → n | Total: 1 · Recaudado: $4.00 · Promedio: $4.00 |
| 3 | Un solo vehículo | Verificar que el ciclo principal se ejecute al menos una vez y termine al primer "n" | (3, 1) → n | Total: 1 · Recaudado: $1.50 · Promedio: $1.50 |
| 4 | Varios vehículos del mismo tipo | Verificar que el contador de un solo tipo se acumule correctamente en varias iteraciones | (1, 1) → s · (1, 2) → s · (1, 3) → n | Total: 3 · Motos: 3 · Recaudado: $3.00 · Promedio: $1.00 |

---

## 🔬 Trazas de ejecución

### Traza — Caso de prueba 1 (flujo normal)

| Iteración | tipo | horas | tarifa | pago | contMoto | contAuto | contCamioneta | totalVehiculos | totalRecaudado | continuar |
|---|---|---|---|---|---|---|---|---|---|---|
| Inicial | — | — | — | — | 0 | 0 | 0 | 0 | 0.00 | — |
| 1 | 1 | 3 | 0.50 | 1.50 | 1 | 0 | 0 | 1 | 1.50 | s |
| 2 | 2 | 5 | 1.00 | 5.00 | 1 | 1 | 0 | 2 | 6.50 | s |
| 3 | 3 | 2 | 1.50 | 3.00 | 1 | 1 | 1 | 3 | 9.50 | n |

`promedio = 9.50 / 3 = 3.1667 ≈ 3.17`

```
===== REPORTE =====
Motocicletas: 1
Automóviles: 1
Camionetas: 1
Total vehículos: 3
Total recaudado: $9.50
Promedio pagado: $3.17
====================
```

### Traza — Caso de prueba 2 (validación de horas)

Sub-traza del ciclo de validación de `horas` (líneas 9-15):

| Intento | horas ingresadas | ¿horas ≤ 0? | Acción |
|---|---|---|---|
| 1 | -2 | Sí | Muestra error, repite el ciclo |
| 2 | 0 | Sí | Muestra error, repite el ciclo |
| 3 | 4 | No | Sale del ciclo con `horas = 4` |

Traza del ciclo principal:

| Iteración | tipo | horas | tarifa | pago | contMoto | contAuto | contCamioneta | totalVehiculos | totalRecaudado | continuar |
|---|---|---|---|---|---|---|---|---|---|---|
| Inicial | — | — | — | — | 0 | 0 | 0 | 0 | 0.00 | — |
| 1 | 2 | 4 | 1.00 | 4.00 | 0 | 1 | 0 | 1 | 4.00 | n |

`promedio = 4.00 / 1 = 4.00`

```
===== REPORTE =====
Motocicletas: 0
Automóviles: 1
Camionetas: 0
Total vehículos: 1
Total recaudado: $4.00
Promedio pagado: $4.00
====================
```

### Traza — Caso de prueba 3 (un solo vehículo)

| Iteración | tipo | horas | tarifa | pago | contMoto | contAuto | contCamioneta | totalVehiculos | totalRecaudado | continuar |
|---|---|---|---|---|---|---|---|---|---|---|
| Inicial | — | — | — | — | 0 | 0 | 0 | 0 | 0.00 | — |
| 1 | 3 | 1 | 1.50 | 1.50 | 0 | 0 | 1 | 1 | 1.50 | n |

`promedio = 1.50 / 1 = 1.50`

```
===== REPORTE =====
Motocicletas: 0
Automóviles: 0
Camionetas: 1
Total vehículos: 1
Total recaudado: $1.50
Promedio pagado: $1.50
====================
```

### Traza — Caso de prueba 4 (mismo tipo repetido)

| Iteración | tipo | horas | tarifa | pago | contMoto | contAuto | contCamioneta | totalVehiculos | totalRecaudado | continuar |
|---|---|---|---|---|---|---|---|---|---|---|
| Inicial | — | — | — | — | 0 | 0 | 0 | 0 | 0.00 | — |
| 1 | 1 | 1 | 0.50 | 0.50 | 1 | 0 | 0 | 1 | 0.50 | s |
| 2 | 1 | 2 | 0.50 | 1.00 | 2 | 0 | 0 | 2 | 1.50 | s |
| 3 | 1 | 3 | 0.50 | 1.50 | 3 | 0 | 0 | 3 | 3.00 | n |

`promedio = 3.00 / 3 = 1.00`

```
===== REPORTE =====
Motocicletas: 3
Automóviles: 0
Camionetas: 0
Total vehículos: 3
Total recaudado: $3.00
Promedio pagado: $1.00
====================
```

---

## ✅ Cumplimiento de requisitos

- [x] Solicita tipo de vehículo (1. Motocicleta, 2. Automóvil, 3. Camioneta)
- [x] Solicita horas estacionado y valida que sean mayores que cero
- [x] Calcula el pago según la tarifa por hora de cada tipo
- [x] Permite registrar varios vehículos hasta que el usuario decida terminar
- [x] Genera el reporte final con contadores por tipo, total de vehículos, total recaudado y promedio pagado
- [x] Usa `do-while`, `switch`, contadores y acumuladores
