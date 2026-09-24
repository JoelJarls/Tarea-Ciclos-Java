
# Ejercicio 3: Serie y Suma de Números Pares

## 1. Descripción del Problema
El objetivo de este programa es solicitar al usuario un número entero positivo $N$ y generar la secuencia de todos los números pares en el intervalo $[2, N]$. A partir de esta serie, el programa debe calcular y mostrar:
- La serie de números pares.
- La cantidad total de números pares mostrados (Contador).
- La suma total de los números pares (Acumulador).
- El promedio de los números pares.

---

## 2. Análisis del Problema

### Definición de Variables
- **Entradas:**
  - `N` (`entero`): Número entero positivo que establece el límite superior del rango.
- **Salidas:**
  - **Serie:** Lista impresa de números pares desde 2 hasta $N$.
  - `contador` (`entero`): Cuenta cuántos números pares se han procesado.
  - `acumulador` (`entero`): Suma de todos los números pares procesados.
  - `promedio` (`real / flotante`): Promedio aritmético ($\frac{\text{acumulador}}{\text{contador}}$).
- **Variables de Control:**
  - `i` (`entero`): Variable de control para el ciclo `for`.

### Lógica y Estructuras de Control
1. **Validación de Entrada (`do-while`):** Se valida que el valor ingresado sea estrictamente positivo ($N > 0$). De lo contrario, se solicita nuevamente.
2. **Ciclo Iterativo (`for`):** Itera desde `i = 2` hasta `N` con incrementos de 2 (`i += 2`).
3. **Manejo de Casos Especiales:** Para evitar errores de división por cero ($\text{división por } 0$), el promedio solo se calcula si `contador > 0`.

---

## 3. Pruebas de Escritorio

| Caso de Prueba | Entrada ($N$) | Serie Impresa | Cantidad (`contador`) | Suma (`acumulador`) | Promedio (`promedio`) | Notas / Comportamiento |
| :--- | :---: | :---: | :---: | :---: | :---: | :--- |
| **Caso Estándar** | `12` | `2 4 6 8 10 12` | `6` | `42` | `7.0` | Flujo normal con múltiples pares. |
| **Caso Límite Sin Pares** | `1` | *(Vacía)* | `0` | `0` | N/A | El ciclo no ingresa; evita división por cero. |
| **Caso Límite Mínimo Par** | `2` | `2` | `1` | `2` | `2.0` | El ciclo ejecuta exactamente 1 iteración. |
| **Entrada Impar** | `5` | `2 4` | `2` | `6` | `3.0` | Detiene el ciclo en el último par $\le N$. |
| **Entrada Inválida** | `-4` $\to$ `6` | `2 4 6` | `3` | `12` | `4.0` | Valida la entrada negativa y vuelve a pedir $N$. |

---

## 4. Trazas de Ejecución (Paso a Paso)

### Traza 1: Entrada $N = 12$ (Caso de uso estándar)

* **Validación:** $12 > 0$ $\rightarrow$ Entrada Válida.
* **Inicialización:** `contador = 0`, `acumulador = 0`

| Paso | Variable `i` | Condición (`i <= 12`) | Impresión | `contador` (`contador + 1`) | `acumulador` (`acumulador + i`) |
| :---: | :---: | :---: | :---: | :---: | :---: |
| **Inicio** | - | - | - | 0 | 0 |
| **1** | 2 | $2 \le 12$ (Verdadero) | `2` | 1 | 2 |
| **2** | 4 | $4 \le 12$ (Verdadero) | `4` | 2 | 6 |
| **3** | 6 | $6 \le 12$ (Verdadero) | `6` | 3 | 12 |
| **4** | 8 | $8 \le 12$ (Verdadero) | `8` | 4 | 20 |
| **5** | 10 | $10 \le 12$ (Verdadero) | `10` | 5 | 30 |
| **6** | 12 | $12 \le 12$ (Verdadero) | `12` | 6 | 42 |
| **Fin** | 14 | $14 \le 12$ (Falso) | - | **6** | **42** |

* **Cálculo Final:**
  - $\text{Promedio} = \frac{\text{acumulador}}{\text{contador}} = \frac{42}{6} = 7.0$

---

### Traza 2: Entrada $N = 1$ (Caso límite)

* **Validación:** $1 > 0$ $\rightarrow$ Entrada Válida.
* **Inicialización:** `contador = 0`, `acumulador = 0`

| Paso | Variable `i` | Condición (`i <= 1`) | Impresión | `contador` | `acumulador` |
| :---: | :---: | :---: | :---: | :---: | :---: |
| **Inicio** | - | - | - | 0 | 0 |
| **1** | 2 | $2 \le 1$ (Falso) | *(Ninguna)* | **0** | **0** |

* **Cálculo Final:**
  - Como `contador == 0`, se omite el cálculo del promedio para prevenir la división por cero y se muestra un mensaje indicando que no se encontraron números pares.

---

### Traza 3: Entrada $N = -3$ seguido de $N = 4$ (Validación)

1. **Iteración 1 (Validación):** 
   - $N = -3$
   - Evalúa $N \le 0$ (Verdadero) $\rightarrow$ Muestra mensaje de error y solicita reingresar.
2. **Iteración 2 (Validación):** 
   - $N = 4$
   - Evalúa $N \le 0$ (Falso) $\rightarrow$ Sale del ciclo de validación.

| Paso | Variable `i` | Condición (`i <= 4`) | Impresión | `contador` | `acumulador` |
| :---: | :---: | :---: | :---: | :---: | :---: |
| **Inicio** | - | - | - | 0 | 0 |
| **1** | 2 | $2 \le 4$ (Verdadero) | `2` | 1 | 2 |
| **2** | 4 | $4 \le 4$ (Verdadero) | `4` | 2 | 6 |
| **Fin** | 6 | $6 \le 4$ (Falso) | - | **2** | **6** |

* **Cálculo Final:**
  - $\text{Promedio} = \frac{6}{2} = 3.0$
