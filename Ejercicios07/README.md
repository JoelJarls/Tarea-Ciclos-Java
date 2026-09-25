# Ejercicio 7. Control de Ventas de Cafetería

## 1. Descripción del problema

Construir un sistema con el siguiente menú:

```
===================================
      CAFETERÍA UNIVERSITARIA
===================================
1. Registrar venta
2. Mostrar estadísticas
3. Mostrar tabla de productos
4. Salir
===================================
```

**Productos disponibles:**

| N° | Producto  | Precio |
|----|-----------|--------|
| 1  | Café       | $1.00 |
| 2  | Sándwich   | $2.50 |
| 3  | Jugo        | $1.50 |
| 4  | Empanada    | $1.25 |

Al registrar una venta se debe solicitar **producto** y **cantidad**.

El reporte de estadísticas debe indicar:

- Número de ventas.
- Cantidad total de productos.
- Total recaudado.
- Promedio por venta.
- Producto con mayor cantidad vendida.

Se deben **validar todas las entradas**.

**Estructuras esperadas:** `do-while`, `switch`, contadores, acumuladores y condicionales.

---

## 2. Análisis del problema

### 2.1 Entradas
- `opcionMenu`: opción del menú principal (1 a 4).
- `opcionProducto`: producto seleccionado dentro del registro de venta (1 a 4).
- `cantidad`: cantidad de unidades vendidas del producto (entero > 0).

### 2.2 Procesos
1. Mostrar el menú principal en un ciclo `do-while` que se repite mientras `opcionMenu != 4`.
2. Validar que la opción ingresada sea un número entero (`scanner.hasNextInt()`), reingresando si no lo es.
3. Según la opción (`switch`):
   - **Opción 1 — Registrar venta:**
     - Mostrar submenú de productos en un `do-while` hasta que `opcionProducto` esté entre 1 y 4.
     - Solicitar la cantidad en un `do-while` hasta que sea un entero mayor a 0.
     - Según el producto (`switch` anidado), asignar el `precio` correspondiente y acumular la cantidad en el contador específico del producto (`cantCafe`, `cantSandwich`, `cantJugo`, `cantEmpanada`).
     - Incrementar `totalVentas`, acumular `totalProductos` y `totalRecaudado`.
   - **Opción 2 — Mostrar estadísticas:**
     - Si `totalVentas > 0`, calcular `promedioVenta = totalRecaudado / totalVentas`.
     - Determinar el mayor valor entre los 4 contadores de producto con `Math.max` anidado.
     - Mostrar todos los productos que igualen ese máximo (permite empates).
     - Si no hay ventas, mostrar mensaje informativo.
   - **Opción 3 — Mostrar tabla de productos:** imprimir el listado fijo de productos y precios.
   - **Opción 4 — Salir:** termina el ciclo `do-while` principal.
   - **Default:** mensaje de opción inválida.

### 2.3 Salidas
- Confirmación de venta registrada.
- Reporte de estadísticas (ventas, productos, recaudación, promedio, producto más vendido).
- Tabla de productos y precios.
- Mensajes de validación ante entradas inválidas.

### 2.4 Reglas de negocio
- Precios fijos: Café $1.00, Sándwich $2.50, Jugo $1.50, Empanada $1.25.
- `cantidad` debe ser un entero mayor que 0.
- `opcionProducto` debe estar entre 1 y 4.
- El producto con mayor cantidad vendida se calcula comparando los 4 contadores; si hay empate, se muestran todos los productos empatados en el máximo.

---

## 3. Diccionario de datos (según el código)

| Variable          | Tipo     | Descripción                                                      |
|--------------------|----------|----------------------------------------------------------------------|
| `opcionMenu`       | `int`    | Opción seleccionada del menú principal (1–4)                        |
| `opcionProducto`   | `int`    | Producto seleccionado al registrar una venta (1–4)                  |
| `cantidad`         | `int`    | Unidades vendidas del producto en el registro actual (> 0)          |
| `precio`           | `double` | Precio unitario del producto seleccionado                           |
| `totalVentas`      | `int`    | Contador: número total de ventas registradas                        |
| `totalProductos`   | `int`    | Acumulador: cantidad total de productos vendidos (todas las ventas) |
| `totalRecaudado`   | `double` | Acumulador: dinero total recaudado                                  |
| `cantCafe`         | `int`    | Acumulador: unidades vendidas de Café                               |
| `cantSandwich`     | `int`    | Acumulador: unidades vendidas de Sándwich                           |
| `cantJugo`         | `int`    | Acumulador: unidades vendidas de Jugo                                |
| `cantEmpanada`     | `int`    | Acumulador: unidades vendidas de Empanada                           |
| `promedioVenta`    | `double` | `totalRecaudado / totalVentas`, calculado solo en la opción 2       |
| `mayorCantidad`    | `int`    | Máximo entre `cantCafe`, `cantSandwich`, `cantJugo`, `cantEmpanada`  |

---

## 4. Estructura del programa (según el código)

```
INICIO
  totalVentas = 0, totalProductos = 0, totalRecaudado = 0.0
  cantCafe = cantSandwich = cantJugo = cantEmpanada = 0

  HACER
    Mostrar menú principal
    MIENTRAS entrada no sea entero: pedir de nuevo
    Leer opcionMenu

    SEGÚN opcionMenu:
      CASO 1: // Registrar venta
        HACER
          Mostrar submenú de productos
          MIENTRAS entrada no sea entero: pedir de nuevo
          Leer opcionProducto
        MIENTRAS (opcionProducto < 1 O opcionProducto > 4)

        HACER
          MIENTRAS entrada no sea entero: pedir de nuevo
          Leer cantidad
        MIENTRAS (cantidad <= 0)

        SEGÚN opcionProducto:
          1: precio = 1.00, cantCafe += cantidad
          2: precio = 2.50, cantSandwich += cantidad
          3: precio = 1.50, cantJugo += cantidad
          4: precio = 1.25, cantEmpanada += cantidad

        totalVentas++
        totalProductos += cantidad
        totalRecaudado += precio * cantidad
        Mostrar "Venta registrada con éxito"

      CASO 2: // Estadísticas
        SI totalVentas > 0 ENTONCES
          promedioVenta = totalRecaudado / totalVentas
          Mostrar totalVentas, totalProductos, totalRecaudado, promedioVenta
          mayorCantidad = max(cantCafe, cantSandwich, cantJugo, cantEmpanada)
          Mostrar producto(s) cuyo contador == mayorCantidad
        SINO
          Mostrar "No se han registrado ventas."

      CASO 3: // Tabla de productos
        Mostrar tabla fija de productos y precios

      CASO 4: // Salir
        Mostrar "Saliendo del sistema..."

      DEFECTO:
        Mostrar "Opción inválida."

  MIENTRAS (opcionMenu != 4)
FIN
```

---

## 5. Casos de prueba

| N° | Escenario | Entrada | Resultado esperado |
|----|-----------|---------|----------------------|
| CP01 | Registrar una venta válida (Café) | Menú=1, producto=1, cantidad=3 | `totalVentas=1`, `totalProductos=3`, `totalRecaudado=$3.00`, `cantCafe=3` |
| CP02 | Opción de menú no numérica | Menú="abc" | Mensaje: "Entrada inválida. Ingrese un número entre 1 y 4:" y vuelve a pedir |
| CP03 | Opción de menú fuera de rango | Menú=9 | Mensaje del `default`: "Opción inválida. Intente de nuevo." |
| CP04 | Producto fuera de rango dentro del registro | Menú=1, producto=7 → luego producto=2 | Repite el submenú hasta ingresar un producto entre 1 y 4 |
| CP05 | Cantidad inválida (0 o negativa) | Menú=1, producto=3, cantidad=0 → luego cantidad=4 | Repite la solicitud hasta ingresar cantidad > 0 |
| CP06 | Cantidad no numérica | cantidad="dos" | Mensaje: "Entrada inválida. Ingrese una cantidad entera positiva:" y vuelve a pedir |
| CP07 | Ver estadísticas sin ventas registradas | Menú=2 (sin ventas previas) | Mensaje: "No se han registrado ventas." |
| CP08 | Ver estadísticas con varias ventas | 3 ventas: 2 Café, 1 Sándwich, 4 Jugo | `totalVentas=3`, producto con mayor cantidad = Jugo (4 unidades) |
| CP09 | Empate en producto más vendido | cantCafe=5, cantJugo=5 (resto en 0) | Se muestran ambos: "- Café" y "- Jugo" |
| CP10 | Mostrar tabla de productos | Menú=3 | Se imprime el listado fijo de los 4 productos con sus precios |
| CP11 | Salir del sistema | Menú=4 | Mensaje: "Saliendo del sistema..." y el `do-while` principal termina |

---

## 6. Trazas de ejecución

### Traza 1 — CP01: Registrar venta de 3 cafés

| Paso | Variable | Valor |
|------|-----------|-------|
| 1 | opcionMenu | 1 |
| 2 | opcionProducto | 1 (Café) |
| 3 | cantidad | 3 |
| 4 | precio (switch interno, caso 1) | 1.00 |
| 5 | cantCafe = 0 + 3 | 3 |
| 6 | totalVentas = 0 + 1 | 1 |
| 7 | totalProductos = 0 + 3 | 3 |
| 8 | totalRecaudado = 0.0 + (1.00 × 3) | 3.00 |
| 9 | Salida | "¡Venta registrada con éxito!" |

### Traza 2 — CP08: Tres ventas seguidas y consulta de estadísticas

Ventas registradas en orden:
1. Café, cantidad = 2 → precio 1.00
2. Sándwich, cantidad = 1 → precio 2.50
3. Jugo, cantidad = 4 → precio 1.50

| Venta | Producto | cantidad | precio | totalVentas | totalProductos | totalRecaudado | cantCafe | cantSandwich | cantJugo | cantEmpanada |
|-------|----------|----------|--------|--------------|------------------|------------------|----------|----------------|----------|----------------|
| — | (inicio) | — | — | 0 | 0 | 0.00 | 0 | 0 | 0 | 0 |
| 1 | Café | 2 | 1.00 | 1 | 2 | 2.00 | 2 | 0 | 0 | 0 |
| 2 | Sándwich | 1 | 2.50 | 2 | 3 | 4.50 | 2 | 1 | 0 | 0 |
| 3 | Jugo | 4 | 1.50 | 3 | 7 | 10.50 | 2 | 1 | 4 | 0 |

**Al elegir opción 2 (estadísticas):**
- `promedioVenta = 10.50 / 3 = 3.50`
- `mayorCantidad = max(2, 1, 4, 0) = 4`
- Producto(s) con mayor cantidad vendida: **Jugo** (único con contador = 4)

**Salida esperada:**
```
Número de ventas: 3
Cantidad total de productos: 7
Total recaudado: $10.50
Promedio por venta: $3.50
Producto(s) con mayor cantidad vendida (4 unidades):
- Jugo
```

### Traza 3 — CP09: Empate entre Café y Jugo

Estado acumulado: `cantCafe = 5`, `cantSandwich = 0`, `cantJugo = 5`, `cantEmpanada = 0`

| Paso | Cálculo | Resultado |
|------|----------|-----------|
| 1 | `Math.max(cantCafe, cantSandwich)` = `Math.max(5, 0)` | 5 |
| 2 | `Math.max(cantJugo, cantEmpanada)` = `Math.max(5, 0)` | 5 |
| 3 | `mayorCantidad = Math.max(5, 5)` | 5 |
| 4 | ¿cantCafe (5) == mayorCantidad (5)? | Sí → se imprime "- Café" |
| 5 | ¿cantSandwich (0) == mayorCantidad (5)? | No |
| 6 | ¿cantJugo (5) == mayorCantidad (5)? | Sí → se imprime "- Jugo" |
| 7 | ¿cantEmpanada (0) == mayorCantidad (5)? | No |

**Salida esperada:** se listan ambos productos empatados, "Café" y "Jugo".

### Traza 4 — CP03/CP04/CP05/CP06: validaciones encadenadas

| Paso | Entrada ingresada | Validación | Resultado |
|------|---------------------|--------------|-----------|
| 1 | opcionMenu = "x" | `!scanner.hasNextInt()` → true | Mensaje de error, se descarta el token y se vuelve a pedir |
| 2 | opcionMenu = 1 | Entero válido | Continúa al registro de venta |
| 3 | opcionProducto = 9 | `9 < 1 \|\| 9 > 4` → true | Repite el `do-while` del submenú |
| 4 | opcionProducto = 2 | Válido (1–4) | Sale del `do-while`, continúa |
| 5 | cantidad = -1 | `-1 <= 0` → true | Repite el `do-while` de cantidad |
| 6 | cantidad = 5 | `5 > 0` → válido | Sale del `do-while`, se procesa la venta |

---

## 7. Conclusiones

- El programa cumple con todas las estructuras exigidas: `do-while` (menú principal, submenú de producto y validación de cantidad), `switch` (opción de menú y selección de producto), contadores (`totalVentas`, `cantCafe`, etc.) y acumuladores (`totalProductos`, `totalRecaudado`).
- Todas las entradas numéricas están validadas con `scanner.hasNextInt()`, evitando que el programa se rompa ante texto no numérico, y con condiciones de rango (`opcionProducto` entre 1 y 4, `cantidad > 0`).
- El cálculo del producto más vendido usando `Math.max` anidado maneja correctamente los **empates**, mostrando todos los productos que alcanzan el valor máximo (CP09).
- La opción de estadísticas está protegida contra división por cero: solo calcula el promedio si `totalVentas > 0` (CP07).
- El ciclo principal `do-while (opcionMenu != 4)` garantiza que el menú se muestre al menos una vez y continúe hasta que el usuario decida salir explícitamente.
