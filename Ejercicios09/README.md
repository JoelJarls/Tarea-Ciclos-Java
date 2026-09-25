# 📊 Ejercicio 9 — Estadísticas de una Encuesta Universitaria

Programa para registrar los datos de varios estudiantes (edad, semestre y horas de estudio por día), validar cada dato y calcular estadísticas de la encuesta: promedios, el estudiante que más estudia, cuántos estudian poco y cuántos hay por cada semestre.

## 📑 Contenido

- [Descripción del problema](#-descripción-del-problema)
- [Análisis](#-análisis)
- [Estructuras de control utilizadas](#-estructuras-de-control-utilizadas)
- [Pseudocódigo](#-pseudocódigo)
- [Casos de prueba](#-casos-de-prueba)
- [Trazas de ejecución](#-trazas-de-ejecución)

---

## 📋 Descripción del problema

El programa pregunta primero **cuántos estudiantes** van a participar en la encuesta. Luego, por cada estudiante solicita:

| Dato | Rango válido |
|---|---|
| Edad | 16 – 80 |
| Semestre | 1 – 10 |
| Horas de estudio por día | 0 – 24 |

Con esa información, al final debe determinar:

- 📈 Edad promedio
- 📚 Horas promedio de estudio
- 🏆 Estudiante con mayor cantidad de horas de estudio
- ⏱️ Cantidad de estudiantes que estudian menos de 2 horas
- 🎓 Cantidad de estudiantes por semestre (usando **ciclos anidados**, ya que hay que recorrer los 10 semestres posibles y, por cada uno, contar cuántos estudiantes lo tienen)

---

## 🔍 Análisis

### Entradas

| Variable | Tipo de dato | Descripción |
|---|---|---|
| `n` | Entero | Número de estudiantes que participarán en la encuesta |
| `edad[i]` | Entero (arreglo de tamaño `n`) | Edad del estudiante `i` (16–80) |
| `semestre[i]` | Entero (arreglo de tamaño `n`) | Semestre del estudiante `i` (1–10) |
| `horas[i]` | Real (arreglo de tamaño `n`) | Horas de estudio por día del estudiante `i` (0–24) |

### Proceso (contadores, acumuladores y variables auxiliares)

| Variable | Tipo de dato | Rol | Valor inicial |
|---|---|---|---|
| `sumaEdad` | Real | Acumulador de edades | 0 |
| `sumaHoras` | Real | Acumulador de horas de estudio | 0 |
| `maxHoras` | Real | Guarda la mayor cantidad de horas encontrada | -1 |
| `indiceMax` | Entero | Guarda el estudiante con más horas de estudio | 0 |
| `contMenos2` | Entero | Contador de estudiantes con horas < 2 | 0 |
| `contSemestre` | Entero | Contador temporal de estudiantes por semestre (ciclo anidado) | 0 (se reinicia por cada semestre) |
| `edadProm` | Real | Edad promedio (`sumaEdad / n`) | — |
| `horasProm` | Real | Horas promedio de estudio (`sumaHoras / n`) | — |

### Salidas

| Salida | Descripción |
|---|---|
| Mensajes de validación | Se muestran cuando un dato está fuera de rango |
| Edad promedio | `sumaEdad / n` |
| Horas promedio de estudio | `sumaHoras / n` |
| Estudiante con más horas | Índice/número y horas del estudiante con `maxHoras` |
| Estudiantes con menos de 2 horas | Valor de `contMenos2` |
| Estudiantes por semestre | Lista de los semestres (1 a 10) con al menos un estudiante, y cuántos tiene cada uno |

### Reglas de validación

- `edad` debe estar en el rango **16–80** (inclusive).
- `semestre` debe estar en el rango **1–10** (inclusive).
- `horas` debe estar en el rango **0–24** (inclusive).
- Cada dato inválido se vuelve a solicitar antes de continuar con el siguiente.

---

## ⚙️ Estructuras de control utilizadas

| Estructura | Uso en el programa |
|---|---|
| `para` (ciclo definido) | Ciclo principal de registro, ya que `n` se conoce de antemano |
| `do-while` | Validación de cada dato (edad, semestre, horas) hasta que sea válido |
| **Ciclos anidados** | Conteo de estudiantes por semestre: ciclo externo recorre los semestres 1–10, ciclo interno recorre los `n` estudiantes |
| Arreglos | `edad[]`, `semestre[]`, `horas[]` para conservar los datos de todos los estudiantes |
| Acumuladores | `sumaEdad`, `sumaHoras` |
| Contadores | `contMenos2`, `contSemestre` |

---

## 🧮 Pseudocódigo

```
Inicio
 1.  Escribir "¿Cuántos estudiantes participarán?"
 2.  Leer n
 3.  sumaEdad   ← 0
 4.  sumaHoras  ← 0
 5.  maxHoras   ← -1
 6.  indiceMax  ← 0
 7.  contMenos2 ← 0
 8.  para i ← 1 hasta n hacer
 9.      hacer
10.          Escribir "Edad del estudiante ", i, ": "
11.          Leer edad[i]
12.          si (edad[i] < 16 o edad[i] > 80) entonces
13.              Escribir "Error: la edad debe estar entre 16 y 80"
14.          fin si
15.      mientras (edad[i] < 16 o edad[i] > 80)
16.      hacer
17.          Escribir "Semestre del estudiante ", i, ": "
18.          Leer semestre[i]
19.          si (semestre[i] < 1 o semestre[i] > 10) entonces
20.              Escribir "Error: el semestre debe estar entre 1 y 10"
21.          fin si
22.      mientras (semestre[i] < 1 o semestre[i] > 10)
23.      hacer
24.          Escribir "Horas de estudio del estudiante ", i, ": "
25.          Leer horas[i]
26.          si (horas[i] < 0 o horas[i] > 24) entonces
27.              Escribir "Error: las horas deben estar entre 0 y 24"
28.          fin si
29.      mientras (horas[i] < 0 o horas[i] > 24)
30.      sumaEdad  ← sumaEdad + edad[i]
31.      sumaHoras ← sumaHoras + horas[i]
32.      si (horas[i] > maxHoras) entonces
33.          maxHoras  ← horas[i]
34.          indiceMax ← i
35.      fin si
36.      si (horas[i] < 2) entonces
37.          contMenos2 ← contMenos2 + 1
38.      fin si
39.  fin para
40.  edadProm  ← sumaEdad / n
41.  horasProm ← sumaHoras / n
42.  Escribir "===== ESTADÍSTICAS ====="
43.  Escribir "Edad promedio: ", edadProm
44.  Escribir "Horas promedio de estudio: ", horasProm
45.  Escribir "Estudiante con más horas de estudio: #", indiceMax, " (", maxHoras, " horas)"
46.  Escribir "Estudiantes que estudian menos de 2 horas: ", contMenos2
47.  Escribir "Estudiantes por semestre:"
48.  para s ← 1 hasta 10 hacer               // ciclo externo: cada semestre posible
49.      contSemestre ← 0
50.      para i ← 1 hasta n hacer             // ciclo interno: recorre todos los estudiantes
51.          si (semestre[i] = s) entonces
52.              contSemestre ← contSemestre + 1
53.          fin si
54.      fin para
55.      si (contSemestre > 0) entonces
56.          Escribir "  Semestre ", s, ": ", contSemestre, " estudiante(s)"
57.      fin si
58.  fin para
Fin
```

---

## 🧪 Casos de prueba

| # | Nombre del caso | Objetivo | n | Datos (edad, semestre, horas) por estudiante | Resultado esperado |
|---|---|---|---|---|---|
| 1 | Flujo normal, varios semestres | Verificar promedios, máximo, conteo <2h y agrupación por semestre con datos variados | 5 | (20,3,2.5)·(22,5,1.0)·(19,3,4.0)·(25,7,0.5)·(21,5,3.0) | Edad prom: 21.40 · Horas prom: 2.20 · Máx: est#3 (4.0h) · <2h: 2 · Sem3:2, Sem5:2, Sem7:1 |
| 2 | Validación de rangos (límites) | Verificar que se rechacen valores fuera de rango y se acepten los valores límite (16, 1, 0) | 1 | edad: 10✗,90✗,16✓ · semestre: 0✗,11✗,1✓ · horas: -1✗,25✗,0✓ | Edad prom: 16.00 · Horas prom: 0.00 · Máx: est#1 (0h) · <2h: 1 · Sem1:1 |
| 3 | Todos en el mismo semestre | Verificar el ciclo anidado cuando todos los estudiantes comparten semestre | 3 | (18,4,3.0)·(20,4,1.5)·(23,4,6.0) | Edad prom: 20.33 · Horas prom: 3.50 · Máx: est#3 (6.0h) · <2h: 1 · Sem4:3 |
| 4 | Un solo estudiante (n=1) | Verificar el caso mínimo del ciclo principal y del ciclo anidado | 1 | (30,8,5.0) | Edad prom: 30.00 · Horas prom: 5.00 · Máx: est#1 (5.0h) · <2h: 0 · Sem8:1 |

---

## 🔬 Trazas de ejecución

### Traza — Caso de prueba 1 (flujo normal, 5 estudiantes)

**Ciclo principal (líneas 8-39):**

| i | edad[i] | semestre[i] | horas[i] | sumaEdad | sumaHoras | maxHoras | indiceMax | contMenos2 |
|---|---|---|---|---|---|---|---|---|
| inicial | — | — | — | 0 | 0.0 | -1 | 0 | 0 |
| 1 | 20 | 3 | 2.5 | 20 | 2.5 | 2.5 | 1 | 0 |
| 2 | 22 | 5 | 1.0 | 42 | 3.5 | 2.5 | 1 | 1 |
| 3 | 19 | 3 | 4.0 | 61 | 7.5 | 4.0 | 3 | 1 |
| 4 | 25 | 7 | 0.5 | 86 | 8.0 | 4.0 | 3 | 2 |
| 5 | 21 | 5 | 3.0 | 107 | 11.0 | 4.0 | 3 | 2 |

`edadProm = 107 / 5 = 21.40`  ·  `horasProm = 11.0 / 5 = 2.20`

**Ciclo anidado — conteo por semestre (líneas 48-58):**

| s (externo) | Comparaciones del ciclo interno (i = 1..5) | contSemestre | ¿Se imprime? |
|---|---|---|---|
| 1 | ningún `semestre[i]=1` | 0 | No |
| 2 | ningún `semestre[i]=2` | 0 | No |
| 3 | i=1 ✓, i=3 ✓ | 2 | **Sí → Semestre 3: 2** |
| 4 | ninguno | 0 | No |
| 5 | i=2 ✓, i=5 ✓ | 2 | **Sí → Semestre 5: 2** |
| 6 | ninguno | 0 | No |
| 7 | i=4 ✓ | 1 | **Sí → Semestre 7: 1** |
| 8–10 | ninguno | 0 | No |

**Salida final:**

```
===== ESTADÍSTICAS =====
Edad promedio: 21.40
Horas promedio de estudio: 2.20
Estudiante con más horas de estudio: #3 (4.0 horas)
Estudiantes que estudian menos de 2 horas: 2
Estudiantes por semestre:
  Semestre 3: 2 estudiante(s)
  Semestre 5: 2 estudiante(s)
  Semestre 7: 1 estudiante(s)
```

---

### Traza — Caso de prueba 2 (validación de rangos)

**Sub-traza de validación del estudiante 1 (líneas 9-29):**

| Dato | Intento 1 | Intento 2 | Intento 3 (válido) |
|---|---|---|---|
| edad | 10 (✗ < 16) | 90 (✗ > 80) | 16 (✓) |
| semestre | 0 (✗ < 1) | 11 (✗ > 10) | 1 (✓) |
| horas | -1 (✗ < 0) | 25 (✗ > 24) | 0 (✓) |

**Ciclo principal:**

| i | edad[i] | semestre[i] | horas[i] | sumaEdad | sumaHoras | maxHoras | indiceMax | contMenos2 |
|---|---|---|---|---|---|---|---|---|
| inicial | — | — | — | 0 | 0.0 | -1 | 0 | 0 |
| 1 | 16 | 1 | 0 | 16 | 0.0 | 0 | 1 | 1 |

`edadProm = 16 / 1 = 16.00`  ·  `horasProm = 0.0 / 1 = 0.00`

**Ciclo anidado:** solo `s = 1` encuentra coincidencia (i=1) → `contSemestre = 1`; el resto de semestres (2 a 10) quedan en 0 y no se imprimen.

**Salida final:**

```
===== ESTADÍSTICAS =====
Edad promedio: 16.00
Horas promedio de estudio: 0.00
Estudiante con más horas de estudio: #1 (0.0 horas)
Estudiantes que estudian menos de 2 horas: 1
Estudiantes por semestre:
  Semestre 1: 1 estudiante(s)
```

---

### Traza — Caso de prueba 3 (mismo semestre)

**Ciclo principal:**

| i | edad[i] | semestre[i] | horas[i] | sumaEdad | sumaHoras | maxHoras | indiceMax | contMenos2 |
|---|---|---|---|---|---|---|---|---|
| inicial | — | — | — | 0 | 0.0 | -1 | 0 | 0 |
| 1 | 18 | 4 | 3.0 | 18 | 3.0 | 3.0 | 1 | 0 |
| 2 | 20 | 4 | 1.5 | 38 | 4.5 | 3.0 | 1 | 1 |
| 3 | 23 | 4 | 6.0 | 61 | 10.5 | 6.0 | 3 | 1 |

`edadProm = 61 / 3 = 20.33`  ·  `horasProm = 10.5 / 3 = 3.50`

**Ciclo anidado:** solo `s = 4` acumula coincidencias, una por cada pasada del ciclo interno (i=1 ✓, i=2 ✓, i=3 ✓) → `contSemestre = 3`.

**Salida final:**

```
===== ESTADÍSTICAS =====
Edad promedio: 20.33
Horas promedio de estudio: 3.50
Estudiante con más horas de estudio: #3 (6.0 horas)
Estudiantes que estudian menos de 2 horas: 1
Estudiantes por semestre:
  Semestre 4: 3 estudiante(s)
```

---

### Traza — Caso de prueba 4 (un solo estudiante)

**Ciclo principal:**

| i | edad[i] | semestre[i] | horas[i] | sumaEdad | sumaHoras | maxHoras | indiceMax | contMenos2 |
|---|---|---|---|---|---|---|---|---|
| inicial | — | — | — | 0 | 0.0 | -1 | 0 | 0 |
| 1 | 30 | 8 | 5.0 | 30 | 5.0 | 5.0 | 1 | 0 |

`edadProm = 30 / 1 = 30.00`  ·  `horasProm = 5.0 / 1 = 5.00`

**Ciclo anidado:** solo `s = 8` encuentra coincidencia (i=1) → `contSemestre = 1`.

**Salida final:**

```
===== ESTADÍSTICAS =====
Edad promedio: 30.00
Horas promedio de estudio: 5.00
Estudiante con más horas de estudio: #1 (5.0 horas)
Estudiantes que estudian menos de 2 horas: 0
Estudiantes por semestre:
  Semestre 8: 1 estudiante(s)
```

---

## ✅ Cumplimiento de requisitos

- [x] Pregunta inicialmente cuántos estudiantes participarán
- [x] Solicita edad, semestre y horas de estudio por cada estudiante
- [x] Valida edad (16–80), semestre (1–10) y horas de estudio (0–24)
- [x] Calcula edad promedio y horas promedio de estudio
- [x] Determina el estudiante con mayor cantidad de horas de estudio
- [x] Cuenta los estudiantes que estudian menos de 2 horas
- [x] Cuenta los estudiantes por semestre usando **ciclos anidados**
