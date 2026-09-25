Algoritmo EstadisticasEstudiantes
    Definir n, sumaEdad, sumaHoras, maxHoras, indiceMax, contMenos2 Como Entero
    Definir edadProm, horasProm Como Real
    Definir edad, semestre, horas Como Entero

    Escribir "¿Cuántos estudiantes participarán?"
    Leer n

    Dimension edad[n]
    Dimension semestre[n]
    Dimension horas[n]

    sumaEdad <- 0
    sumaHoras <- 0
    maxHoras <- -1
    indiceMax <- 0
    contMenos2 <- 0

    Para i <- 1 Hasta n Con Paso 1 Hacer
        // Validar edad
        Repetir
            Escribir "Ingrese edad del estudiante ", i, ": "
            Leer edad[i]
            Si edad[i] < 16 O edad[i] > 80 Entonces
                Escribir "Error: edad fuera de rango"
            FinSi
        Hasta Que edad[i] >= 16 Y edad[i] <= 80

        // Validar semestre
        Repetir
            Escribir "Ingrese semestre del estudiante ", i, ": "
            Leer semestre[i]
            Si semestre[i] < 1 O semestre[i] > 10 Entonces
                Escribir "Error: semestre fuera de rango"
            FinSi
        Hasta Que semestre[i] >= 1 Y semestre[i] <= 10

        // Validar horas
        Repetir
            Escribir "Ingrese horas de estudio del estudiante ", i, ": "
            Leer horas[i]
            Si horas[i] < 0 O horas[i] > 24 Entonces
                Escribir "Error: horas fuera de rango"
            FinSi
        Hasta Que horas[i] >= 0 Y horas[i] <= 24

        // Acumuladores
        sumaEdad <- sumaEdad + edad[i]
        sumaHoras <- sumaHoras + horas[i]

        // Máximo de horas
        Si horas[i] > maxHoras Entonces
            maxHoras <- horas[i]
            indiceMax <- i
        FinSi

        // Contar estudiantes con menos de 2 horas
        Si horas[i] < 2 Entonces
            contMenos2 <- contMenos2 + 1
        FinSi
    FinPara

    edadProm <- sumaEdad / n
    horasProm <- sumaHoras / n

    Escribir "===== ESTADÍSTICAS ====="
    Escribir "Edad promedio: ", edadProm
    Escribir "Horas promedio: ", horasProm
    Escribir "Estudiante con más horas: ", indiceMax, " (", maxHoras, " horas)"
    Escribir "Cantidad con menos de 2 horas: ", contMenos2

    // Conteo por semestre
    Para s <- 1 Hasta 10 Con Paso 1 Hacer
        contSemestre <- 0
        Para i <- 1 Hasta n Con Paso 1 Hacer
            Si semestre[i] = s Entonces
                contSemestre <- contSemestre + 1
            FinSi
        FinPara

        Si contSemestre > 0 Entonces
            Escribir "Semestre ", s, ": ", contSemestre, " estudiantes"
        FinSi
    FinPara
FinAlgoritmo
