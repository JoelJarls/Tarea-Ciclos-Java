Algoritmo SerieYSumaPares
    Definir N, contador, acumulador, i Como Entero
    Definir promedio Como Real
    
    // Validación de entrada
    Repetir
        Escribir "Ingrese N:"
        Leer N
        Si N <= 0 Entonces
            Escribir "Por favor, ingrese un número entero positivo mayor a 0."
        FinSi
    Hasta Que N > 0
    
    // Inicialización de variables de control
    contador <- 0
    acumulador <- 0
    
    Escribir "Serie:"
    // Ciclo para generar y procesar números pares
    Para i <- 2 Hasta N Con Paso 2 Hacer
        Escribir i, " " Sin Bajar
        contador <- contador + 1
        acumulador <- acumulador + i
    FinPara
    Escribir "" // Salto de línea al finalizar la serie
    
    // Mostrar resultados
    Escribir "Cantidad de pares: ", contador
    Escribir "Suma: ", acumulador
    
    // Validación para evitar división por cero
    Si contador > 0 Entonces
        promedio <- acumulador / contador
        Escribir "Promedio: ", promedio
    Sino
        Escribir "No se encontraron números pares en el rango."
    FinSi
FinAlgoritmo
