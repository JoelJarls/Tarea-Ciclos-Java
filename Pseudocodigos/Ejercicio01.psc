Algoritmo ControlCalificaciones
    Definir nEstudiantes, aprobados, reprobados, i Como Entero
    Definir nota, sumaNotas, promedio, notaAlta, notaBaja Como Real
    
    // Validación del número de estudiantes (debe ser mayor que 0)
    Escribir "Ingrese la cantidad de estudiantes:"
    Leer nEstudiantes
    Mientras nEstudiantes <= 0 Hacer
        Escribir "Error: El número de estudiantes debe ser mayor a 0. Intente de nuevo:"
        Leer nEstudiantes
    FinMientras
    
    // Inicialización de variables
    sumaNotas <- 0
    aprobados <- 0
    reprobados <- 0
    notaAlta <- -1    // Valor menor al rango posible (0 a 10)
    notaBaja <- 11    // Valor mayor al rango posible (0 a 10)
    
    // Procesamiento con ciclo PARA
    Para i <- 1 Hasta nEstudiantes Con Paso 1 Hacer
        Escribir "Ingrese la calificación del estudiante ", i, " (0 a 10):"
        Leer nota
        
        // Validación de la calificación (debe estar entre 0 y 10)
        Mientras nota < 0 O nota > 10 Hacer
            Escribir "Error: La calificación debe estar entre 0 y 10. Intente de nuevo:"
            Leer nota
        FinMientras
        
        // Acumulación de suma
        sumaNotas <- sumaNotas + nota
        
        // Conteo de aprobados y reprobados (se aprueba con nota >= 7)
        Si nota >= 7 Entonces
            aprobados <- aprobados + 1
        Sino
            reprobados <- reprobados + 1
        FinSi
        
        // Determinación de nota más alta y más baja
        Si nota > notaAlta Entonces
            notaAlta <- nota
        FinSi
        
        Si nota < notaBaja Entonces
            notaBaja <- nota
        FinSi
    FinPara
    
    // Cálculo del promedio general
    promedio <- sumaNotas / nEstudiantes
    
    // Mostrar resultados
    Escribir "--------------------------------------------"
    Escribir "          RESULTADOS DEL CONTROL            "
    Escribir "--------------------------------------------"
    Escribir "Número de estudiantes: ", nEstudiantes
    Escribir "Suma de calificaciones: ", sumaNotas
    Escribir "Promedio general: ", promedio
    Escribir "Cantidad de aprobados: ", aprobados
    Escribir "Cantidad de reprobados: ", reprobados
    Escribir "Nota más alta: ", notaAlta
    Escribir "Nota más baja: ", notaBaja
    
FinAlgoritmo
