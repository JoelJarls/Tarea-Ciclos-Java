# 🔁 Tarea Ciclos Java — Estructuras de Repetición y Control

Repositorio con la resolución de 10 ejercicios prácticos en Java aplicando estructuras de repetición (`for`, `while`, `do-while`), estructuras de selección (`if-else`, `switch`), validación de datos, contadores, acumuladores y trazabilidad mediante pruebas de escritorio.

<p align="center">
  <a href="./Pseudocodigos"><strong>📄 Ir a Pseudocódigos</strong></a>
  &nbsp;|&nbsp;
  <a href="./evidencias"><strong>📸 Ir a Evidencias</strong></a>
</p>

---

## 📑 Contenido

- [Integrantes](#-integrantes)
- [Objetivo](#-objetivo)
- [Descripción de los ejercicios](#-descripción-de-los-ejercicios)
- [Estructuras utilizadas](#-estructuras-utilizadas)
- [Instrucciones de ejecución](#-instrucciones-de-ejecución)
- [Casos de prueba](#-casos-de-prueba)
- [Capturas / Evidencias](#-capturas--evidencias)
- [Conclusiones](#-conclusiones)

---

## 👥 Integrantes

- Matías Pico
- Andres Castro
- Marlon Yaguana
- Leyber Peñafiel
- Joel Pacha
- Steeve Ortiz

---

## 🎯 Objetivo

Implementar algoritmos de lógica de programación en Java aplicando estructuras de repetición (`for`, `while`, `do-while`) y de selección (`if-else`, `switch`), incorporando validación de datos de entrada, manejo de contadores y acumuladores, y trazabilidad mediante pruebas de escritorio (tablas de traza), con el fin de reforzar el pensamiento algorítmico y la depuración de errores en ciclos.

---

## 📚 Descripción de los ejercicios

Cada ejercicio se encuentra en su propia carpeta (`EjerciciosXX`), con su código fuente `.java` y un `README.md` propio que detalla análisis, diccionario de datos, pseudocódigo, casos de prueba y trazas de ejecución.

| N° | Ejercicio | Descripción | Estructura clave | Detalle |
|----|-----------|-------------|--------------------|---------|
| 1 | **Control de calificaciones** | Ingresa las notas de N estudiantes (0–10) y calcula suma, promedio, aprobados, reprobados, nota más alta y más baja. Caso límite: notas 0, 7 y 10. | `while` (validación) + `for` (procesamiento) | [Ver carpeta](./Ejercicios01) |
| 2 | **Tabla de multiplicar configurable** | Genera las tablas de multiplicar entre una tabla inicial y una final, validando que la inicial no sea mayor que la final. Desafío: multiplicador máximo configurable por el usuario. | `for` anidados | [Ver carpeta](./Ejercicios02) |
| 3 | **Serie y suma de números pares** | Genera la serie de pares entre 2 y N, junto con cantidad, suma y promedio. Casos límite: N=1, N=2 y valores negativos. | Contador + acumulador + validación + `for` | [Ver carpeta](./Ejercicios03) |
| 4 | **Cajero automático básico** | Menú de cajero (consultar saldo, depositar, retirar, mostrar movimientos, salir) con saldo inicial de $100 y validaciones de montos negativos o insuficientes. | `do-while` + `switch` + contadores/acumuladores | [Ver carpeta](./Ejercicios04) |
| 5 | **Estacionamiento universitario** | Registra vehículos (moto, automóvil, camioneta) por horas, calcula tarifas y genera un reporte final por tipo de vehículo, total recaudado y promedio pagado. | `do-while` + `switch` + contadores/acumuladores | [Ver carpeta](./Ejercicios05) |
| 6 | **Triángulo y patrones** | Genera patrones de asteriscos (triángulo, triángulo invertido, pirámide numérica) según un número entre 2 y 10, explicando la traza del ciclo externo e interno. | `for` anidados | [Ver carpeta](./Ejercicios06) |
| 7 | **Control de ventas de cafetería** | Menú de ventas (registrar venta, estadísticas, tabla de productos, salir) con 4 productos, calculando número de ventas, total recaudado, promedio y producto más vendido. | `do-while` + `switch` + contadores/acumuladores/condicionales | [Ver carpeta](./Ejercicios07) |
| 8 | **Detector y depurador de errores** | Analiza un fragmento de código con un ciclo `while` defectuoso (bucle infinito), identifica la causa, lo corrige, elabora su tabla de trazas y crea un ejemplo propio de error en ciclos. | `while` (depuración) | [Ver carpeta](./Ejercicios08) |
| 9 | **Estadísticas de una encuesta universitaria** | Encuesta a N estudiantes (edad, semestre, horas de estudio) validando rangos, y calcula edad promedio, mayor cantidad de horas de estudio, estudiantes que estudian menos de 2 horas y cantidad por semestre. | `for` con ciclos anidados / estrategia equivalente | [Ver carpeta](./Ejercicios09) |
| 10 | **Sistema integrador de parqueadero** | Aplicación completa de parqueadero universitario (registrar vehículo, mostrar registrados, estadísticas, recaudación, salir) con tarifas diferenciadas por tipo, rol, día y boleto perdido. | `for` + `while` + `do-while` + `switch` + ciclos anidados + contadores + acumuladores + validaciones + casos límite | [Ver carpeta](./Ejercicios10) |

---

## 🧩 Estructuras utilizadas

- **Estructuras de repetición:**
  - `for`: procesamiento de N elementos, ciclos anidados (tablas de multiplicar, patrones, parqueadero).
  - `while`: validación de entradas (rangos, tipos de dato), detección/corrección de bucles infinitos.
  - `do-while`: menús interactivos que deben ejecutarse al menos una vez (cajero, estacionamiento, cafetería, parqueadero).
- **Estructuras de selección:**
  - `switch-case`: navegación de menús y selección de productos/opciones.
  - `if-else`: validaciones, clasificación de estados (aprobado/reprobado) y actualización de máximos/mínimos.
- **Variables de control interno:**
  - **Contadores:** número de ventas, número de vehículos, aprobados, reprobados, etc.
  - **Acumuladores:** suma de calificaciones, total recaudado, total de horas, total de productos, etc.
- **Validación de datos de entrada:** rangos numéricos, tipos de dato (`Scanner.hasNextInt()`), valores mayores a cero, opciones válidas de menú.
- **Trazabilidad:** pruebas de escritorio (tablas de traza) documentadas en el `README.md` de cada ejercicio.

---

## ▶️ Instrucciones de ejecución

1. **Clonar el repositorio:**
   ```bash
   git clone https://github.com/JoelJarls/Tarea-Ciclos-Java.git
   cd Tarea-Ciclos-Java
   ```

2. **Ingresar a la carpeta del ejercicio deseado:**
   ```bash
   cd Ejercicios01
   ```

3. **Compilar el archivo `.java`:**
   ```bash
   javac NombreDelArchivo.java
   ```

4. **Ejecutar el programa:**
   ```bash
   java NombreDeLaClase
   ```

5. **Seguir las instrucciones por consola** (menús, ingreso de datos, validaciones).

> 💡 También se puede abrir cada ejercicio directamente en un IDE (IntelliJ IDEA, Eclipse, NetBeans o VS Code con el extension pack de Java) y ejecutar la clase `main` correspondiente.

---

## 🧪 Casos de prueba

Cada ejercicio incluye, en su propio `README.md`, una tabla completa de **casos de prueba** (flujo normal, validaciones, casos límite y casos de error) junto con sus **trazas de ejecución** paso a paso. A modo de resumen general:

| Ejercicio | Casos límite / especiales cubiertos |
|-----------|----------------------------------------|
| 1. Calificaciones | Notas 0, 7 (aprobación exacta) y 10 |
| 2. Tabla configurable | Tabla inicial > tabla final (inválido), multiplicador máximo distinto de 10 |
| 3. Serie de pares | N = 1, N = 2 y valores negativos |
| 4. Cajero automático | Depósitos/retiros negativos, retiro mayor al saldo disponible, opción inexistente |
| 5. Estacionamiento | Horas iguales a cero, tipo de vehículo inválido |
| 6. Triángulo y patrones | N = 2 y N = 10 (límites del rango permitido) |
| 7. Ventas de cafetería | Entradas no numéricas, cantidad ≤ 0, empate en producto más vendido |
| 8. Depurador de errores | Bucle infinito por condición mal formulada (`numero <= 50`) |
| 9. Encuesta universitaria | Edad y semestre fuera de rango, horas de estudio fuera de rango |
| 10. Parqueadero integrador | Boleto perdido, fin de semana, horas = 0, lista vacía al consultar recaudación |

📎 Para el detalle completo (tablas de casos de prueba y trazas), ver el `README.md` dentro de cada carpeta `EjerciciosXX`.

---

## 📸 Capturas / Evidencias

Las capturas de pantalla de la ejecución de cada programa (entradas, validaciones y resultados por consola) se encuentran en la carpeta:

### 👉 [`/evidencias`](./evidencias)

Cada evidencia está organizada y nombrada según el número de ejercicio al que corresponde.

---

## 🧮 Pseudocódigos

Los pseudocódigos y diagramas de análisis previos a la implementación en Java de cada ejercicio se encuentran en la carpeta:

### 👉 [`/Pseudocodigos`](./Pseudocodigos)

---

## ✅ Conclusiones

- Se reforzó el uso correcto de las tres estructuras de repetición de Java (`for`, `while`, `do-while`), identificando en qué escenario conviene aplicar cada una (procesamiento de N elementos, validación de entradas, menús interactivos).
- La validación exhaustiva de datos de entrada (rangos, tipos de dato, opciones de menú) evitó comportamientos inesperados y mejoró la robustez de cada programa.
- El uso sistemático de contadores y acumuladores permitió generar reportes estadísticos confiables (promedios, totales, máximos y mínimos) en todos los ejercicios.
- La elaboración de tablas de traza y casos límite (Ejercicios 1, 3, 6, 8 y 10) permitió detectar y corregir errores lógicos antes de considerarse terminado cada ejercicio, en particular en el Ejercicio 8, enfocado explícitamente en la depuración de ciclos.
- El Ejercicio 10 integró todos los conceptos trabajados durante la tarea (ciclos anidados, `switch`, `do-while`, contadores, acumuladores, validaciones y casos límite) en una sola aplicación completa, consolidando el aprendizaje del grupo.
