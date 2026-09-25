# Ejercicio 10. Sistema Integrador de Parqueadero Universitario

## 1. Descripción del problema

Se requiere construir una aplicación completa que simule un **sistema de gestión de parqueadero universitario**, mediante un menú con las siguientes opciones:

```
================================
   PARQUEADERO UNIVERSITARIO
================================
1. Registrar vehículo
2. Mostrar vehículos registrados
3. Mostrar estadísticas
4. Mostrar recaudación
5. Salir
================================
```

Por cada vehículo se debe capturar:

| Dato               | Tipo             | Valores posibles                          |
|--------------------|------------------|--------------------------------------------|
| Tipo de vehículo    | Cadena / opción   | Carro, Moto, Bicicleta                    |
| Rol                | Cadena / opción   | Estudiante, Docente, Visitante            |
| Número de horas     | Numérico entero   | > 0                                       |
| Día de la semana    | Cadena / opción   | Lunes … Domingo                           |
| Boleto perdido      | Booleano          | Sí / No                                   |

El sistema debe aplicar **tarifas diferenciadas** definidas por el equipo y generar al finalizar un **reporte estadístico y de recaudación**.

---

## 2. Análisis del problema

### 2.1 Entradas
- Tipo de vehículo, rol, número de horas, día de la semana y si perdió el boleto (por cada registro).
- Opción del menú seleccionada por el usuario.

### 2.2 Procesos
1. Registrar un vehículo (agregarlo a una estructura de almacenamiento, p. ej. lista de objetos/diccionarios).
2. Calcular el valor a pagar por cada vehículo según tarifa base, tipo, rol, horas, día y boleto perdido.
3. Acumular estadísticas: cantidad por tipo, cantidad por rol, total de horas, promedio de permanencia, total recaudado, mayor y menor valor pagado.
4. Mostrar los reportes solicitados.

### 2.3 Salidas
- Listado de vehículos registrados.
- Estadísticas (cantidades, totales, promedios).
- Recaudación total, valor máximo y mínimo pagado.

### 2.4 Reglas de negocio (tarifas propuestas por el equipo)

> Estas tarifas son un ejemplo razonable; deben ajustarse según lo que defina el equipo real.

| Tipo de vehículo | Tarifa base / hora |
|-------------------|--------------------|
| Carro              | $1.00              |
| Moto                | $0.60              |
| Bicicleta           | $0.25              |

**Descuentos por rol** (sobre el subtotal):
- Estudiante: 20% de descuento
- Docente: 10% de descuento
- Visitante: sin descuento (0%)

**Recargos adicionales:**
- Fin de semana (Sábado o Domingo): recargo del 15% sobre el subtotal.
- Boleto perdido: recargo fijo de **$2.00** adicional.

**Fórmula general:**

```
subtotal = horas * tarifa_base(tipo)
subtotal = subtotal - (subtotal * descuento_rol)
subtotal = subtotal + (subtotal * recargo_fin_de_semana)  [si aplica]
total    = subtotal + recargo_boleto_perdido               [si aplica]
```

---

## 3. Diseño del algoritmo (pseudocódigo)

```
INICIO
  Definir lista vehiculos = []
  Repetir
    Mostrar menú
    Leer opción
    Según opción:
      Caso 1: // Registrar vehículo
        Leer tipo, rol, horas, dia, boleto_perdido
        valor_pagado = calcularTarifa(tipo, rol, horas, dia, boleto_perdido)
        Agregar {tipo, rol, horas, dia, boleto_perdido, valor_pagado} a vehiculos
      Caso 2: // Mostrar vehículos
        Para cada v en vehiculos: Mostrar v
      Caso 3: // Estadísticas
        cantidad_por_tipo = agrupar(vehiculos, "tipo")
        cantidad_por_rol  = agrupar(vehiculos, "rol")
        total_horas       = sumar(vehiculos.horas)
        promedio_horas    = total_horas / cantidad(vehiculos)
        Mostrar cantidad_por_tipo, cantidad_por_rol, total_horas, promedio_horas
      Caso 4: // Recaudación
        total_recaudado = sumar(vehiculos.valor_pagado)
        mayor_pagado    = max(vehiculos.valor_pagado)
        menor_pagado    = min(vehiculos.valor_pagado)
        Mostrar total_recaudado, mayor_pagado, menor_pagado
      Caso 5:
        Salir del bucle
  Hasta opción = 5
FIN
```

---

## 4. Diccionario de datos

| Variable         | Tipo    | Descripción                                  |
|-------------------|---------|-----------------------------------------------|
| `tipo`            | string  | "Carro", "Moto" o "Bicicleta"                 |
| `rol`             | string  | "Estudiante", "Docente" o "Visitante"         |
| `horas`           | int     | Número de horas de permanencia (> 0)          |
| `dia`             | string  | Día de la semana                              |
| `boleto_perdido`  | bool    | true / false                                  |
| `valor_pagado`    | float   | Valor calculado a pagar por el vehículo       |
| `vehiculos`       | list    | Estructura donde se almacenan todos los registros |

---

## 5. Casos de prueba

| N° | Escenario | Entrada (tipo, rol, horas, día, boleto perdido) | Resultado esperado | Cálculo |
|----|-----------|--------------------------------------------------|---------------------|---------|
| CP01 | Carro, estudiante, día entre semana, sin boleto perdido | Carro, Estudiante, 3h, Martes, No | $2.40 | 3×1.00=3.00 − 20%=2.40 |
| CP02 | Moto, docente, fin de semana, sin boleto perdido | Moto, Docente, 4h, Sábado, No | $2.48 | 4×0.60=2.40 −10%=2.16 +15%=2.484 ≈ 2.48 |
| CP03 | Bicicleta, visitante, día entre semana | Bicicleta, Visitante, 2h, Lunes, No | $0.50 | 2×0.25=0.50 (sin descuento/recargo) |
| CP04 | Carro, visitante, boleto perdido | Carro, Visitante, 1h, Miércoles, Sí | $3.00 | 1×1.00=1.00 +2.00(boleto)=3.00 |
| CP05 | Moto, estudiante, fin de semana, boleto perdido | Moto, Estudiante, 5h, Domingo, Sí | $4.76 | 5×0.60=3.00 −20%=2.40 +15%=2.76 +2.00=4.76 |
| CP06 | Horas = 0 (entrada inválida) | Carro, Docente, 0h, Jueves, No | Mensaje de error: "Las horas deben ser mayores a 0" | Validación |
| CP07 | Tipo de vehículo no válido | "Camión", Estudiante, 2h, Viernes, No | Mensaje de error: "Tipo de vehículo no válido" | Validación |
| CP08 | Registrar varios vehículos y consultar estadísticas | 3 registros distintos | Cantidad por tipo, por rol, total y promedio de horas correctos | Suma / conteo / promedio |
| CP09 | Consultar recaudación con lista vacía | Sin registros previos | Mensaje: "No hay vehículos registrados" | Validación |
| CP10 | Consultar mayor y menor valor pagado con varios registros | Valores: 2.40, 0.50, 4.76 | Mayor = 4.76, Menor = 0.50 | max() / min() |

---

## 6. Trazas de ejecución

### Traza 1 — CP01: Carro, Estudiante, 3h, Martes, sin boleto perdido

| Paso | Variable | Valor |
|------|-----------|-------|
| 1 | tipo | "Carro" |
| 2 | rol | "Estudiante" |
| 3 | horas | 3 |
| 4 | dia | "Martes" |
| 5 | boleto_perdido | false |
| 6 | tarifa_base(Carro) | 1.00 |
| 7 | subtotal = 3 × 1.00 | 3.00 |
| 8 | descuento (Estudiante 20%) | 3.00 − 0.60 = 2.40 |
| 9 | ¿Es fin de semana? | No → sin recargo |
| 10 | ¿Boleto perdido? | No → sin recargo |
| 11 | **valor_pagado final** | **2.40** |

### Traza 2 — CP05: Moto, Estudiante, 5h, Domingo, con boleto perdido

| Paso | Variable | Valor |
|------|-----------|-------|
| 1 | tipo | "Moto" |
| 2 | rol | "Estudiante" |
| 3 | horas | 5 |
| 4 | dia | "Domingo" |
| 5 | boleto_perdido | true |
| 6 | tarifa_base(Moto) | 0.60 |
| 7 | subtotal = 5 × 0.60 | 3.00 |
| 8 | descuento (Estudiante 20%) | 3.00 − 0.60 = 2.40 |
| 9 | ¿Es fin de semana? | Sí → 2.40 + (2.40 × 0.15) = 2.76 |
| 10 | ¿Boleto perdido? | Sí → 2.76 + 2.00 = 4.76 |
| 11 | **valor_pagado final** | **4.76** |

### Traza 3 — CP08: Estadísticas con 3 vehículos registrados

Registros:
1. Carro, Estudiante, 3h → 2.40
2. Moto, Docente, 4h → 2.48
3. Bicicleta, Visitante, 2h → 0.50

| Paso | Cálculo | Resultado |
|------|----------|-----------|
| 1 | cantidad_por_tipo | Carro: 1, Moto: 1, Bicicleta: 1 |
| 2 | cantidad_por_rol | Estudiante: 1, Docente: 1, Visitante: 1 |
| 3 | total_horas = 3 + 4 + 2 | 9 |
| 4 | promedio_horas = 9 / 3 | 3.0 |
| 5 | total_recaudado = 2.40 + 2.48 + 0.50 | 5.38 |
| 6 | mayor_pagado = max(2.40, 2.48, 0.50) | 2.48 |
| 7 | menor_pagado = min(2.40, 2.48, 0.50) | 0.50 |

---

## 7. Conclusiones

- El sistema cumple con los cinco puntos del menú solicitado: registro, listado, estadísticas, recaudación y salida.
- Las validaciones (horas > 0, tipo/rol/día válidos) evitan datos inconsistentes en los cálculos.
- Las tarifas combinan un valor base por tipo de vehículo, un descuento por rol y recargos por fin de semana y boleto perdido, cumpliendo con el requerimiento de "tarifas diferenciadas".
- Los casos de prueba cubren flujos normales, casos límite (0 horas) y casos de error (tipo inválido, lista vacía), lo que valida la robustez del programa.
