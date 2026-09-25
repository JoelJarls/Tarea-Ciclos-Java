# Reporte de Corrección de Errores en Ciclos

## EJERCICIO PRINCIPAL

* **ERROR ENCONTRADO:** Bucle infinito en la estructura de control `while`.
* **CAUSA:** Falta de incremento en la variable de control (`numero`). Al no actualizarse su valor dentro del cuerpo del ciclo, la condición `numero <= 10` se mantiene indefinidamente como `true`.
* **SOLUCIÓN:** Se agregó la instrucción `numero++;` (o `numero <- numero + 1`) dentro del ciclo para que la variable cambie de estado hasta romper la condición de parada.
* **RESULTADO:** El programa imprime de manera secuencial los números del 1 al 10 y finaliza su ejecución correctamente al llegar a 11.

### Tabla de Traza (Prueba de Escritorio)

| Iteración | Condición (`numero <= 10`) | Salida por Pantalla | Cambio de Variable (`numero++`) |
| :---: | :---: | :---: | :---: |
| **Inicio** | — | — | `numero = 1` |
| **1** | 1 <= 10 (Verdadero) | 1 | `numero` pasa a 2 |
| **2** | 2 <= 10 (Verdadero) | 2 | `numero` pasa a 3 |
| **3** | 3 <= 10 (Verdadero) | 3 | `numero` pasa a 4 |
| **4** | 4 <= 10 (Verdadero) | 4 | `numero` pasa a 5 |
| **5** | 5 <= 10 (Verdadero) | 5 | `numero` pasa a 6 |
| **6** | 6 <= 10 (Verdadero) | 6 | `numero` pasa a 7 |
| **7** | 7 <= 10 (Verdadero) | 7 | `numero` pasa a 8 |
| **8** | 8 <= 10 (Verdadero) | 8 | `numero` pasa a 9 |
| **9** | 9 <= 10 (Verdadero) | 9 | `numero` pasa a 10 |
| **10** | 10 <= 10 (Verdadero) | 10 | `numero` pasa a 11 |
| **11** | 11 <= 10 (Falso) | **Fin del ciclo** | Permanece en 11 |
