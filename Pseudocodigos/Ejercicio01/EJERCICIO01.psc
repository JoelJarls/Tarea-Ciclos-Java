Algoritmo ControlCalificaciones
    Definir n, aprobados, reprobados, i Como Entero
    Definir nota, suma, promedio, notaAlta, notaBaja Como Real
    
    // 1. Validacion del numero de estudiantes con WHILE
    Escribir "Ingrese el numero de estudiantes:"
    Leer n
    Mientras n <= 0 Hacer
        Escribir "Error: El numero de estudiantes debe ser mayor que cero. Ingrese nuevamente:"
        Leer n
    FinMientras
    
    // Inicializaciones
    suma <- 0.0
    aprobados <- 0
    reprobados <- 0
    notaAlta <- 0.0
    notaBaja <- 10.0
    
    // 2. Procesamiento de notas con FOR
    Para i <- 1 Hasta n Con Paso 1 Hacer
        Escribir "Ingrese la calificacion del estudiante ", i, " (0 a 10):"
        Leer nota
        
        // Validacion de rango de nota con WHILE
        Mientras nota < 0 O nota > 10 Hacer
            Escribir "Error: La calificacion debe estar entre 0 y 10. Ingrese nuevamente:"
            Leer nota
        FinMientras
        
        // Acumular
        suma <- suma + nota
        
        // Contar aprobados y reprobados (Criterio: >= 7 aprueba)
        Si nota >= 7 Entonces
            aprobados <- aprobados + 1
        Sino
            reprobados <- reprobados + 1
        FinSi
        
        // Evaluar nota mas alta y mas baja
        Si i = 1 Entonces
            notaAlta <- nota
            notaBaja <- nota
        Sino
            Si nota > notaAlta Entonces
                notaAlta <- nota
            FinSi
            Si nota < notaBaja Entonces
                notaBaja <- nota
            FinSi
        FinSi
    FinPara
    
    // 3. Calculos finales y Salida
    promedio <- suma / n
    
    Escribir "----------------- RESULTADOS -----------------"
    Escribir "Numero de estudiantes: ", n
    Escribir "Suma de calificaciones: ", suma
    Escribir "Promedio general: ", promedio
    Escribir "Cantidad de aprobados: ", aprobados
    Escribir "Cantidad de reprobados: ", reprobados
    Escribir "Nota mas alta: ", notaAlta
    Escribir "Nota mas baja: ", notaBaja
    Escribir "----------------------------------------------"
FinAlgoritmo
