# Ejercicio 2. Tabla de Multiplicar Configurable

## 1. Descripción del problema

Solicitar al usuario dos números:

- **Tabla inicial**
- **Tabla final**

El programa debe generar, para cada tabla desde la inicial hasta la final, la tabla de multiplicar correspondiente (por defecto del 1 al 10).

**Ejemplo:**
```
Tabla inicial: 3
Tabla final: 5
```

**Salida esperada:**
```
TABLA DEL 3
3 x 1 = 3
...
3 x 10 = 30

TABLA DEL 4
...

TABLA DEL 5
...
```

Se debe **validar que la tabla inicial no sea mayor que la tabla final**.

**Estructura obligatoria:** ciclos `for` anidados.

**Desafío implementado:** el usuario también determina hasta qué multiplicador desea generar las tablas (`maxMultiplicador`), en lugar de dejarlo fijo en 10.

---

## 2. Análisis del problema

### 2.1 Entradas
- `tablaInicial`: número entero desde el cual empieza el rango de tablas a generar.
- `tablaFinal`: número entero hasta el cual llega el rango de tablas a generar.
- `maxMultiplicador`: número entero hasta el cual se multiplica cada tabla (reemplaza el valor fijo de 10, cumpliendo el desafío propuesto).

### 2.2 Procesos
1. Leer `tablaInicial`, `tablaFinal` y `maxMultiplicador`.
2. Validar que `tablaInicial <= tablaFinal`; si no se cumple, mostrar un mensaje de error y no generar ninguna tabla.
3. Si la validación es correcta, usar un ciclo `for` externo que recorra cada tabla `i` desde `tablaInicial` hasta `tablaFinal`.
4. Por cada tabla `i`, usar un ciclo `for` interno (anidado) que recorra el multiplicador `j` desde `1` hasta `maxMultiplicador`, calculando e imprimiendo `i x j = i*j`.

### 2.3 Salidas
- Mensaje de error si `tablaInicial > tablaFinal`.
- Listado de tablas de multiplicar, cada una encabezada por `TABLA DEL i`, con sus resultados `i x j = producto` desde `j = 1` hasta `j = maxMultiplicador`.

### 2.4 Regla de negocio
- Condición de validación: si `tablaInicial > tablaFinal` → error, no se procesa ninguna tabla.
- El programa **no valida** que `maxMultiplicador` sea mayor que cero (posible mejora, ver sección de conclusiones).

---

## 3. Diccionario de datos (según el código)

| Variable            | Tipo  | Descripción                                                        |
|----------------------|-------|-----------------------------------------------------------------------|
| `tablaInicial`       | `int` | Primer número de tabla a generar                                     |
| `tablaFinal`         | `int` | Último número de tabla a generar                                     |
| `maxMultiplicador`   | `int` | Multiplicador máximo hasta el cual se genera cada tabla (desafío)     |
| `i`                  | `int` | Contador del ciclo `for` externo — recorre cada tabla                 |
| `j`                  | `int` | Contador del ciclo `for` interno — recorre cada multiplicador          |
| `(i * j)`            | `int` | Resultado de la multiplicación mostrado en cada línea                 |

---

## 4. Estructura del programa (según el código)

```
INICIO
  Leer tablaInicial
  Leer tablaFinal
  Leer maxMultiplicador

  SI tablaInicial > tablaFinal ENTONCES
      Mostrar "Error: La tabla inicial no puede ser mayor que la tabla final."
  SINO
      PARA i = tablaInicial HASTA tablaFinal:
          Mostrar "TABLA DEL " + i
          PARA j = 1 HASTA maxMultiplicador:
              Mostrar i + " x " + j + " = " + (i * j)
          FIN PARA
          Mostrar línea en blanco
      FIN PARA
  FIN SI
FIN
```

---

## 5. Casos de prueba

| N° | Escenario | Entrada (tablaInicial, tablaFinal, maxMultiplicador) | Resultado esperado |
|----|-----------|--------------------------------------------------------|----------------------|
| CP01 | Rango válido básico | 3, 5, 10 | Genera tablas del 3, 4 y 5, cada una de `x1` hasta `x10` |
| CP02 | Tabla inicial mayor que la final (inválido) | 7, 4, 10 | Mensaje: "Error: La tabla inicial no puede ser mayor que la tabla final." |
| CP03 | Tabla inicial igual a la final | 6, 6, 10 | Genera únicamente "TABLA DEL 6" de `x1` a `x10` |
| CP04 | Multiplicador máximo reducido (desafío) | 2, 3, 5 | Genera tablas del 2 y 3, solo hasta `x5` |
| CP05 | Multiplicador máximo mayor a 10 (desafío) | 1, 1, 12 | Genera "TABLA DEL 1" de `x1` hasta `x12` |
| CP06 | Tabla del 0 | 0, 1, 10 | Genera "TABLA DEL 0" (todos los resultados = 0) y "TABLA DEL 1" |
| CP07 | Números negativos | -2, 0, 3 | Genera tablas del -2, -1 y 0, con productos negativos y ceros |
| CP08 | Multiplicador máximo = 1 | 4, 5, 1 | Genera cada tabla mostrando únicamente `i x 1 = i` |
| CP09 | Multiplicador máximo = 0 (caso límite no validado) | 3, 4, 0 | El ciclo interno no se ejecuta: solo se imprime "TABLA DEL i" sin líneas de multiplicación |
| CP10 | Rango amplio | 1, 10, 10 | Genera las 10 tablas completas, de la del 1 a la del 10, cada una de `x1` a `x10` |

---

## 6. Trazas de ejecución

### Traza 1 — CP01: tablaInicial = 3, tablaFinal = 5, maxMultiplicador = 10 (recortada)

| i | Encabezado | j | i × j | Salida |
|---|------------|---|-------|--------|
| 3 | TABLA DEL 3 | 1 | 3  | 3 x 1 = 3 |
| 3 | | 2 | 6  | 3 x 2 = 6 |
| 3 | | ... | ... | ... |
| 3 | | 10 | 30 | 3 x 10 = 30 |
| 4 | TABLA DEL 4 | 1 | 4  | 4 x 1 = 4 |
| 4 | | ... | ... | ... |
| 4 | | 10 | 40 | 4 x 10 = 40 |
| 5 | TABLA DEL 5 | 1 | 5  | 5 x 1 = 5 |
| 5 | | ... | ... | ... |
| 5 | | 10 | 50 | 5 x 10 = 50 |

**Validación:** `tablaInicial (3) <= tablaFinal (5)` → verdadero, se ejecutan ambos ciclos `for`.

### Traza 2 — CP04: tablaInicial = 2, tablaFinal = 3, maxMultiplicador = 5

| i | j | i × j | Salida |
|---|---|-------|--------|
| 2 | 1 | 2  | 2 x 1 = 2 |
| 2 | 2 | 4  | 2 x 2 = 4 |
| 2 | 3 | 6  | 2 x 3 = 6 |
| 2 | 4 | 8  | 2 x 4 = 8 |
| 2 | 5 | 10 | 2 x 5 = 10 |
| 3 | 1 | 3  | 3 x 1 = 3 |
| 3 | 2 | 6  | 3 x 2 = 6 |
| 3 | 3 | 9  | 3 x 3 = 9 |
| 3 | 4 | 12 | 3 x 4 = 12 |
| 3 | 5 | 15 | 3 x 5 = 15 |

**Resultado final:** el ciclo externo se ejecuta 2 veces (`i = 2, 3`) y el interno 5 veces por cada `i` (`j = 1..5`), generando 10 líneas de resultados en total.

### Traza 3 — CP02: tablaInicial = 7, tablaFinal = 4, maxMultiplicador = 10 (caso inválido)

| Paso | Variable | Valor |
|------|-----------|-------|
| 1 | tablaInicial | 7 |
| 2 | tablaFinal | 4 |
| 3 | maxMultiplicador | 10 |
| 4 | Evaluación `tablaInicial > tablaFinal` | 7 > 4 → verdadero |
| 5 | Salida | "Error: La tabla inicial no puede ser mayor que la tabla final." |
| 6 | Ciclos `for` | No se ejecutan |

### Traza 4 — CP09: tablaInicial = 3, tablaFinal = 4, maxMultiplicador = 0 (caso límite no validado)

| i | Encabezado | Ciclo interno (j = 1 hasta 0) |
|---|------------|-------------------------------|
| 3 | TABLA DEL 3 | No se ejecuta (condición `j <= 0` es falsa desde el inicio) |
| 4 | TABLA DEL 4 | No se ejecuta |

**Resultado final:** se imprimen los encabezados "TABLA DEL 3" y "TABLA DEL 4", pero ninguna línea de multiplicación, ya que el `for` interno nunca cumple `j <= maxMultiplicador` con `maxMultiplicador = 0`.

---

## 7. Conclusiones

- El programa cumple con la estructura obligatoria de **ciclos `for` anidados**: el externo recorre las tablas (`tablaInicial` a `tablaFinal`) y el interno recorre los multiplicadores (`1` a `maxMultiplicador`).
- Se cumple el **desafío** propuesto en el enunciado: el usuario define `maxMultiplicador`, en lugar de que el límite quede fijo en 10.
- La validación `tablaInicial > tablaFinal` evita generar tablas en un rango inválido (CP02).
- **Punto de mejora detectado:** el código no valida que `maxMultiplicador` sea mayor que cero. Con `maxMultiplicador = 0` o negativo (CP09), el programa no genera error, simplemente imprime los encabezados sin líneas de multiplicación, lo cual podría no ser el comportamiento esperado por el usuario.
- El programa admite correctamente valores límite como tablas iguales (`tablaInicial = tablaFinal`), tabla del 0 y números negativos, ya que Java no restringe el rango de estas variables más allá de la validación explícita del código.
