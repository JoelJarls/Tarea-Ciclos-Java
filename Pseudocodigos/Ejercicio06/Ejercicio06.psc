Algoritmo TrianguloYPatrones
	Definir n, i, j Como Entero
	Escribir 'Ingrese un numero entre 2 y 10:'
	Leer n
	Mientras n<2 O n>10 Hacer
		Escribir 'Error: El numero debe estar entre 2 y 10. Ingrese de nuevo:'
		Leer n
	FinMientras
	Escribir ''
	Escribir '--- PATRON 1 ---'
	Para i<-1 Hasta n Con Paso 1 Hacer
		Para j<-1 Hasta i Con Paso 1 Hacer
			Escribir '*'Sin Saltar
		FinPara
		Escribir ''
	FinPara
	Escribir ''
	Escribir '--- PATRON 2 ---'
	Para i<-n Hasta 1 Con Paso -1 Hacer
		Para j<-1 Hasta i Con Paso 1 Hacer
			Escribir '*'Sin Saltar
		FinPara
		Escribir ''
	FinPara
	Escribir ''
	Escribir '--- PATRON 3 ---'
	Para i<-1 Hasta n Con Paso 1 Hacer
		Para j<-1 Hasta i Con Paso 1 Hacer
			Escribir jSin Saltar
		FinPara
		Escribir ''
	FinPara
FinAlgoritmo
