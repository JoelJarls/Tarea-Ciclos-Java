Proceso TablaMultiplicarConfigurable
	
	Definir tablaInicial, tablaFinal, maxMultiplicador, i, j Como Entero
	
	Escribir "Ingrese la tabla inicial: " Sin Saltar
	Leer tablaInicial
	
	Escribir "Ingrese la tabla final: " Sin Saltar
	Leer tablaFinal
	
	Escribir "Ingrese el multiplicador maximo (por defecto es 10): " Sin Saltar
	Leer maxMultiplicador
	
	Escribir ""
	
	Si tablaInicial > tablaFinal Entonces
		Escribir "Error: La tabla inicial no puede ser mayor que la tabla final."
	Sino
		Para i <- tablaInicial Hasta tablaFinal Hacer
			Escribir "TABLA DEL ", i
			
			Para j <- 1 Hasta maxMultiplicador Hacer
				Escribir i, " x ", j, " = ", (i * j)
			FinPara
			
			Escribir ""
		FinPara
	FinSi
	
FinProceso
