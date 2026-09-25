# Ejercicio 1. Control de Calificaciones

## 1. Descripción del problema

Desarrollar un programa que permita ingresar las calificaciones de **N estudiantes**, donde:

- El número de estudiantes debe ser **mayor que cero**.
- Cada calificación debe estar en el rango **[0, 10]**.

El programa debe determinar:

- Número de estudiantes.
- Suma de calificaciones.
- Promedio general.
- Cantidad de aprobados.
- Cantidad de reprobados.
- Nota más alta.
- Nota más baja.

**Estructuras esperadas:** `while` para validación de entradas y `for` para el procesamiento de las N notas.

**Casos límite obligatorios:** probar notas `0`, `7` y `10`.

---

## 2. Análisis del problema

### 2.1 Entradas
- `n`: número de estudiantes (entero, > 0).
- `nota`: calificación de cada estudiante (decimal, entre 0 y 10 inclusive).

### 2.2 Procesos
1. Validar con un bucle `while` que `n` sea mayor que cero (si no, repetir la solicitud).
2. Repetir `n` veces (`for`) la lectura de cada nota:
   - Validar con un `while` que la nota esté en el rango `[0, 10]`.
   - Acumular la suma.
   - Actualizar la nota más alta (`mayor`) y la más baja (`menor`).
   - Clasificar como aprobado (`nota >= 7.0`) o reprobado (`nota < 7.0`).
3. Calcular el promedio general (`suma / n`).

### 2.3 Salidas
- Número de estudiantes, suma, promedio, cantidad de aprobados, cantidad de reprobados, nota más alta y nota más baja.

### 2.4 Regla de negocio
- Nota de aprobación: `NOTA_APROBACION = 7.0` → aprobado si `nota >= 7.0`, reprobado si `nota < 7.0`.

---

## 3. Diccionario de datos (según el código)

| Variable          | Tipo     | Descripción                                              |
|--------------------|----------|------------------------------------------------------------|
| `n`                | `int`    | Cantidad de estudiantes a registrar (> 0)                  |
| `nota`             | `double` | Calificación ingresada de cada estudiante (0 a 10)          |
| `suma`             | `double` | Acumulador de la suma de todas las calificaciones           |
| `mayor`            | `double` | Nota más alta registrada (inicia en `-1.0` como centinela)  |
| `menor`            | `double` | Nota más baja registrada (inicia en `11.0` como centinela)  |
| `aprobados`        | `int`    | Contador de estudiantes con `nota >= 7.0`                   |
| `reprobados`       | `int`    | Contador de estudiantes con `nota < 7.0`                    |
| `NOTA_APROBACION`  | `double` (final) | Constante de nota mínima de aprobación = `7.0`         |
| `promedio`         | `double` | Resultado de `suma / n`                                    |
| `i`                | `int`    | Contador del bucle `for` (índice del estudiante)             |

---

## 4. Estructura del programa (según el código)

```
INICIO
  Leer n
  MIENTRAS n <= 0:
      Mostrar error
      Leer n de nuevo
  FIN MIENTRAS

  suma = 0
  mayor = -1.0
  menor = 11.0
  aprobados = 0
  reprobados = 0
  NOTA_APROBACION = 7.0

  PARA i = 0 HASTA n-1:
      MIENTRAS nota < 0 O nota > 10:
          Mostrar error
          Leer nota de nuevo
      FIN MIENTRAS

      suma = suma + nota
      SI nota > mayor ENTONCES mayor = nota
      SI nota < menor ENTONCES menor = nota
      SI nota >= NOTA_APROBACION ENTONCES aprobados++
      SINO reprobados++
  FIN PARA

  promedio = suma / n
  Mostrar n, suma, promedio, aprobados, reprobados, mayor, menor
FIN
```

---

## 5. Casos de prueba

| N° | Escenario | Entrada | Resultado esperado |
|----|-----------|---------|----------------------|
| CP01 | Número de estudiantes inválido (0) | n = 0 | Mensaje: "Error: el número de estudiantes debe ser mayor que cero." y vuelve a pedir `n` |
| CP02 | Número de estudiantes inválido (negativo) | n = -3 | Mensaje de error y vuelve a pedir `n` |
| CP03 | Número de estudiantes válido | n = 1 | Continúa pidiendo la nota del estudiante 1 |
| CP04 | Nota fuera de rango (mayor a 10) | nota = 15 | Mensaje: "Error: la nota debe estar entre 0 y 10." y vuelve a pedir la nota |
| CP05 | Nota fuera de rango (negativa) | nota = -1 | Mensaje de error y vuelve a pedir la nota |
| CP06 | **Caso límite: nota = 0** | n = 1, nota = 0 | suma = 0.0, promedio = 0.0, aprobados = 0, reprobados = 1, mayor = 0.0, menor = 0.0 |
| CP07 | **Caso límite: nota = 7 (aprobación exacta)** | n = 1, nota = 7 | suma = 7.0, promedio = 7.0, aprobados = 1, reprobados = 0, mayor = 7.0, menor = 7.0 |
| CP08 | **Caso límite: nota = 10** | n = 1, nota = 10 | suma = 10.0, promedio = 10.0, aprobados = 1, reprobados = 0, mayor = 10.0, menor = 10.0 |
| CP09 | Conjunto mixto de notas | n = 5, notas = 0, 7, 10, 5, 8 | suma = 30.0, promedio = 6.0, aprobados = 3, reprobados = 2, mayor = 10.0, menor = 0.0 |
| CP10 | Todas las notas iguales | n = 3, notas = 7, 7, 7 | suma = 21.0, promedio = 7.0, aprobados = 3, reprobados = 0, mayor = 7.0, menor = 7.0 |

---

## 6. Trazas de ejecución

### Traza 1 — CP09: n = 5, notas = 0, 7, 10, 5, 8

| i | nota | suma | mayor | menor | aprobados | reprobados |
|---|------|------|-------|-------|-----------|------------|
| — | (inicio) | 0.0 | -1.0 | 11.0 | 0 | 0 |
| 0 | 0  | 0.0  | 0.0  | 0.0  | 0 | 1 |
| 1 | 7  | 7.0  | 7.0  | 0.0  | 1 | 1 |
| 2 | 10 | 17.0 | 10.0 | 0.0  | 2 | 1 |
| 3 | 5  | 22.0 | 10.0 | 0.0  | 2 | 2 |
| 4 | 8  | 30.0 | 10.0 | 0.0  | 3 | 2 |

**Resultado final:**
`promedio = 30.0 / 5 = 6.0`
`suma = 30.0`, `aprobados = 3`, `reprobados = 2`, `mayor = 10.0`, `menor = 0.0`

### Traza 2 — CP06/CP07/CP08 combinados: n = 3, notas = 0, 7, 10

| i | nota | suma | mayor | menor | aprobados | reprobados |
|---|------|------|-------|-------|-----------|------------|
| — | (inicio) | 0.0 | -1.0 | 11.0 | 0 | 0 |
| 0 | 0  | 0.0  | 0.0  | 0.0  | 0 | 1 |
| 1 | 7  | 7.0  | 7.0  | 0.0  | 1 | 1 |
| 2 | 10 | 17.0 | 10.0 | 0.0  | 2 | 1 |

**Resultado final:**
`promedio = 17.0 / 3 = 5.666...`
`suma = 17.0`, `aprobados = 2`, `reprobados = 1`, `mayor = 10.0`, `menor = 0.0`

> Esta traza cubre explícitamente los tres casos límite exigidos: nota `0` (reprueba), nota `7` (aprueba justo en el límite) y nota `10` (aprueba con la nota máxima).

### Traza 3 — CP01: validación de entrada inválida

| Paso | Acción | Valor de `n` | Resultado |
|------|--------|----------------|-----------|
| 1 | Ingresa n | 0 | `n > 0` es falso → se muestra error, el `while` no rompe |
| 2 | Ingresa n nuevamente | -2 | `n > 0` es falso → se muestra error |
| 3 | Ingresa n nuevamente | 4 | `n > 0` es verdadero → `break`, continúa el programa |

---

## 7. Conclusiones

- El programa cumple con las estructuras solicitadas: `while` para validar entradas (número de estudiantes y rango de notas) y `for` para procesar las N calificaciones.
- Los valores centinela (`mayor = -1.0`, `menor = 11.0`) garantizan que la primera nota ingresada siempre actualice correctamente el máximo y el mínimo, sin necesidad de inicializarlos con la primera nota.
- Los casos límite obligatorios (0, 7 y 10) están cubiertos: 0 siempre reprueba, 7 es el punto exacto de aprobación (`>= 7.0`) y 10 es el valor máximo permitido.
- Las validaciones evitan que se ingresen números de estudiantes ≤ 0 o notas fuera del rango [0, 10], asegurando la integridad de los cálculos.
