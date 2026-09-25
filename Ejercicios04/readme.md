
# Ejercicio 4. Cajero Automático Básico

## 1. Descripción del problema

Desarrollar un programa en Java que simule el funcionamiento de un cajero automático básico. El usuario comenzará con un saldo inicial de $100 y podrá realizar diferentes operaciones mediante un menú.

El programa debe permitir:

- Consultar saldo.
- Realizar depósitos.
- Realizar retiros.
- Mostrar movimientos.
- Salir del sistema.

El menú debe repetirse utilizando la estructura `do-while` hasta que el usuario seleccione la opción 5 (Salir).

Se deben implementar validaciones para evitar depósitos y retiros negativos, así como retiros superiores al saldo disponible. Además, se utilizarán contadores para registrar la cantidad de operaciones y acumuladores para calcular los valores totales de depósitos y retiros.

### Ejemplo

**Saldo inicial:** $100

```text
===== CAJERO ACADEMICO =====

1. Consultar saldo
2. Depositar
3. Retirar
4. Mostrar movimientos
5. Salir

Seleccione una opcion: 2
Ingrese el monto a depositar: 50

Deposito realizado correctamente.
Saldo actual: $150
```

---

## 2. Análisis del problema

### 2.1 Entradas

| Variable | Tipo | Descripción |
|---|---|---|
| `opcion` | `int` | Opción seleccionada en el menú. |
| `monto` | `double` | Cantidad de dinero para depositar o retirar. |

### 2.2 Procesos

1. Inicializar el saldo en $100.
2. Inicializar los contadores de depósitos y retiros en cero.
3. Inicializar los acumuladores de depósitos y retiros en cero.
4. Mostrar el menú principal y leer la opción del usuario.
5. Utilizar `switch` para procesar la opción seleccionada.
6. Si se selecciona depositar:
   - Leer el monto.
   - Verificar que no sea negativo.
   - Aumentar el saldo si el monto es válido.
   - Incrementar el contador y acumulador de depósitos.
7. Si se selecciona retirar:
   - Leer el monto.
   - Verificar que no sea negativo.
   - Comprobar que el monto no supere el saldo disponible.
   - Disminuir el saldo si el retiro es válido.
   - Incrementar el contador y acumulador de retiros.
8. Si se selecciona mostrar movimientos, presentar los totales y contadores.
9. Si se selecciona salir, mostrar el resumen final.
10. Repetir el menú hasta que la opción sea 5.

### 2.3 Salidas

| Salida | Descripción |
|---|---|
| Saldo actual | Dinero disponible en la cuenta. |
| Mensajes de confirmación | Informan si un depósito o retiro fue realizado. |
| Mensajes de error | Informan sobre montos negativos, saldo insuficiente u opciones inexistentes. |
| Depósitos realizados | Cantidad de depósitos válidos. |
| Retiros realizados | Cantidad de retiros válidos. |
| Total depositado | Suma de los depósitos válidos. |
| Total retirado | Suma de los retiros válidos. |
| Saldo final | Dinero disponible al finalizar el programa. |

### 2.4 Regla de negocio

- El saldo inicial es de $100.
- No se permiten depósitos negativos.
- No se permiten retiros negativos.
- No se permiten retiros superiores al saldo disponible.
- Las operaciones válidas actualizan los contadores y acumuladores.
- Las operaciones rechazadas no modifican el saldo ni los registros.
- El programa finaliza cuando se selecciona la opción 5.

---

## 3. Diccionario de datos

| Variable | Tipo | Descripción |
|---|---|---|
| `opcion` | `int` | Opción seleccionada en el menú. |
| `monto` | `double` | Cantidad de dinero para depositar o retirar. |
| `saldo` | `double` | Dinero disponible en la cuenta. |
| `totalDepositado` | `double` | Acumulador del dinero depositado. |
| `totalRetirado` | `double` | Acumulador del dinero retirado. |
| `contadorDepositos` | `int` | Cantidad de depósitos válidos. |
| `contadorRetiros` | `int` | Cantidad de retiros válidos. |

---

## 4. Estructura del programa

### 4.1 Algoritmo

```text
INICIO

    Inicializar saldo = 100
    Inicializar totalDepositado = 0
    Inicializar totalRetirado = 0
    Inicializar contadorDepositos = 0
    Inicializar contadorRetiros = 0

    REPETIR

        Mostrar menú
        Leer opcion

        SEGÚN opcion HACER

            CASO 1:
                Mostrar saldo actual

            CASO 2:
                Leer monto

                SI monto < 0 ENTONCES
                    Mostrar error
                SINO
                    Aumentar saldo
                    Acumular depósito
                    Incrementar contador de depósitos
                FIN SI

            CASO 3:
                Leer monto

                SI monto < 0 ENTONCES
                    Mostrar error
                SINO SI monto > saldo ENTONCES
                    Mostrar saldo insuficiente
                SINO
                    Disminuir saldo
                    Acumular retiro
                    Incrementar contador de retiros
                FIN SI

            CASO 4:
                Mostrar movimientos y totales

            CASO 5:
                Mostrar resumen final

            OTRO CASO:
                Mostrar opción inexistente

        FIN SEGÚN

    HASTA QUE opcion = 5

FIN
```

### 4.2 Estructuras utilizadas

| Estructura | Función |
|---|---|
| `do-while` | Repetir el menú hasta salir. |
| `switch` | Procesar las opciones del menú. |
| `if-else` | Validar los depósitos y retiros. |
| Contadores | Contabilizar depósitos y retiros. |
| Acumuladores | Sumar los valores depositados y retirados. |

---

## 5. Casos de prueba

| N.º | Escenario | Entrada | Resultado esperado |
|---|---|---|---|
| CP01 | Consultar saldo inicial | Opción 1 | Muestra saldo de $100. |
| CP02 | Depósito válido | Opción 2, monto = 50 | Saldo = $150. Contador de depósitos = 1. |
| CP03 | Retiro válido | Opción 3, monto = 30 | Saldo = $70. Contador de retiros = 1. |
| CP04 | Depósito negativo | Opción 2, monto = -20 | Muestra error. Saldo sin cambios. |
| CP05 | Retiro negativo | Opción 3, monto = -10 | Muestra error. Saldo sin cambios. |
| CP06 | Retiro superior al saldo | Opción 3, monto = 150 | Muestra saldo insuficiente. |
| CP07 | Opción inexistente | Opción 8 | Muestra error de opción. |
| CP08 | Mostrar movimientos | Opción 4 | Muestra contadores, acumuladores y saldo. |
| CP09 | Salir | Opción 5 | Muestra el resumen final y finaliza. |
| CP10 | Depósito y retiro consecutivos | 2 → $100, 3 → $50 | Saldo = $150, depósito = $100 y retiro = $50. |

---

## 6. Trazas de ejecución

### Traza 1 — CP02: Depósito válido

**Estado inicial:** saldo = $100.

| Paso | Variable / Acción | Valor | Resultado |
|---|---|---|---|
| 1 | `saldo` | 100 | Saldo inicial |
| 2 | `opcion` | 2 | Selecciona depositar |
| 3 | `monto` | 50 | Monto ingresado |
| 4 | Validación | `50 < 0` → Falso | Depósito válido |
| 5 | `saldo` | 150 | Se suma el depósito |
| 6 | `totalDepositado` | 50 | Se acumula el valor |
| 7 | `contadorDepositos` | 1 | Se incrementa el contador |

**Resultado final:** saldo = $150.

---

### Traza 2 — CP03: Retiro válido

**Estado inicial:** saldo = $100.

| Paso | Variable / Acción | Valor | Resultado |
|---|---|---|---|
| 1 | `saldo` | 100 | Saldo inicial |
| 2 | `opcion` | 3 | Selecciona retirar |
| 3 | `monto` | 30 | Monto ingresado |
| 4 | Validación negativa | `30 < 0` → Falso | El monto no es negativo |
| 5 | Validación de saldo | `30 > 100` → Falso | Hay saldo suficiente |
| 6 | `saldo` | 70 | Se resta el retiro |
| 7 | `totalRetirado` | 30 | Se acumula el valor |
| 8 | `contadorRetiros` | 1 | Se incrementa el contador |

**Resultado final:** saldo = $70.

---

### Traza 3 — CP04: Depósito negativo

**Estado inicial:** saldo = $100.

| Paso | Variable / Acción | Valor | Resultado |
|---|---|---|---|
| 1 | `saldo` | 100 | Saldo inicial |
| 2 | `opcion` | 2 | Selecciona depositar |
| 3 | `monto` | -20 | Monto negativo |
| 4 | Validación | `-20 < 0` → Verdadero | Se rechaza el depósito |
| 5 | `saldo` | 100 | No cambia |
| 6 | `contadorDepositos` | 0 | No aumenta |
| 7 | `totalDepositado` | 0 | No cambia |

**Resultado final:** se muestra el mensaje de error y el saldo permanece en $100.

---

### Traza 4 — CP06: Retiro superior al saldo

**Estado inicial:** saldo = $100.

| Paso | Variable / Acción | Valor | Resultado |
|---|---|---|---|
| 1 | `saldo` | 100 | Saldo inicial |
| 2 | `opcion` | 3 | Selecciona retirar |
| 3 | `monto` | 150 | Monto ingresado |
| 4 | Validación negativa | `150 < 0` → Falso | El monto no es negativo |
| 5 | Validación de saldo | `150 > 100` → Verdadero | Se rechaza el retiro |
| 6 | `saldo` | 100 | No cambia |
| 7 | `contadorRetiros` | 0 | No aumenta |
| 8 | `totalRetirado` | 0 | No cambia |

**Resultado final:** se muestra el mensaje de saldo insuficiente y el saldo permanece en $100.

---

### Traza 5 — CP10: Operaciones consecutivas

**Entradas:**

- Saldo inicial: $100.
- Depósito: $100.
- Retiro: $50.

| Paso | Acción | Monto | Saldo | Cont. dep. | Cont. ret. | Total dep. | Total ret. |
|---|---|---:|---:|---:|---:|---:|---:|
| 1 | Inicio | — | $100 | 0 | 0 | $0 | $0 |
| 2 | Depositar | $100 | $200 | 1 | 0 | $100 | $0 |
| 3 | Retirar | $50 | $150 | 1 | 1 | $100 | $50 |
| 4 | Mostrar movimientos | — | $150 | 1 | 1 | $100 | $50 |
| 5 | Salir | — | $150 | 1 | 1 | $100 | $50 |

**Resultado final:**

- Depósitos realizados: 1.
- Retiros realizados: 1.
- Total depositado: $100.
- Total retirado: $50.
- Saldo final: $150.

---

## 7. Conclusiones

1. El programa permite gestionar operaciones básicas de un cajero automático mediante un menú repetitivo con `do-while` y `switch`.
2. Las validaciones implementadas evitan depósitos y retiros negativos, además de retiros superiores al saldo disponible.
3. El uso de contadores y acumuladores permite registrar los movimientos realizados y mostrar un resumen final del estado de la cuenta.
