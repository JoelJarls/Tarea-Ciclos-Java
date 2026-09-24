### Ejercicio 06: Triangulo y Patrones

#### Descripcion
Programa que solicita un numero entero $N$ dentro del rango de $[2, 10]$ y genera tres patrones graficos distintos utilizando estructuras de ciclos `for` anidados. Los patrones generados son:
1. Triangulo creciente de asteriscos ($1$ a $N$).
2. Triangulo decreciente de asteriscos ($N$ a $1$).
3. Triangulo creciente numerico con secuencias de $1$ hasta la fila actual.

#### Estructuras Utilizadas
- **`while`:** Valida que el valor de $N$ ingresado por el usuario este estrictamente dentro del rango $[2, 10]$.
- **`for` Anidados:**
  - **Ciclo Exterior (`i`):** Gobierna las filas impresas en pantalla.
  - **Ciclo Interior (`j`):** Gobierna la cantidad de caracteres o numeros que se imprimen por cada fila.

#### Casos de Prueba y Limites

| Caso Evaluado | Entradas de Prueba | Resultado Esperado |
| :--- | :--- | :--- |
| **Limite inferior invalido** | `N = 1` $\rightarrow$ `N = 3` | Rechaza `1` por estar fuera de rango, acepta `3`. |
| **Limite superior invalido** | `N = 11` $\rightarrow$ `N = 5` | Rechaza `11`, acepta `5` e imprime los patrones de 5 filas. |
| **Casos limite exactos (2 y 10)** | `N = 2` / `N = 10` | Acepta `2` (patron minimo) y `10` (patron maximo) sin errores de formateo. |
