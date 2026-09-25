Algoritmo ParqueaderoUniversitario
	Definir MAX_VEHICULOS Como Entero
	MAX_VEHICULOS <- 100
	// Arreglos paralelos para almacenar los datos
	Dimensionar tipos(100), roles(100), horas_array(100)
	Dimensionar dias(100), boletos(100), valores(100)
	Definir cantidad_vehiculos, opc, i, horas_ingresadas Como Entero
	Definir tipo_ing, rol_ing, dia_ing, boleto_str Como Cadena
	Definir tarifa_base, subtotal, descuento, total Como Real
	// Variables para estadísticas y recaudación
	Definir cCarros, cMotos, cBicis, cEstudiantes, cDocentes, cVisitantes, total_horas Como Entero
	Definir total_recaudado, mayor_pagado, menor_pagado Como Real
	cantidad_vehiculos <- 0
	opc <- 0
	Mientras opc<>5 Hacer
		Escribir '================================'
		Escribir '   PARQUEADERO UNIVERSITARIO'
		Escribir '================================'
		Escribir '1. Registrar vehículo'
		Escribir '2. Mostrar vehículos registrados'
		Escribir '3. Mostrar estadísticas'
		Escribir '4. Mostrar recaudación'
		Escribir '5. Salir'
		Escribir '================================'
		Escribir 'Seleccione una opción: '
		Leer opc
		Según opc Hacer
			1:
				Si cantidad_vehiculos<MAX_VEHICULOS Entonces
					Escribir 'Tipo de vehículo (Carro/Moto/Bicicleta): '
					Leer tipo_ing
					Escribir 'Rol (Estudiante/Docente/Visitante): '
					Leer rol_ing
					horas_ingresadas <- 0
					Mientras horas_ingresadas<=0 Hacer
						Escribir 'Número de horas (> 0): '
						Leer horas_ingresadas
					FinMientras
					Escribir 'Día de la semana (Lunes a Domingo): '
					Leer dia_ing
					Escribir '¿Boleto perdido? (Si/No): '
					Leer boleto_str
					// Cálculo de tarifa base
					tarifa_base <- 0
					Si tipo_ing='Carro' Entonces
						tarifa_base <- 1.00
					SiNo
						Si tipo_ing='Moto' Entonces
							tarifa_base <- 0.60
						SiNo
							Si tipo_ing='Bicicleta' Entonces
								tarifa_base <- 0.25
							FinSi
						FinSi
					FinSi
					subtotal <- horas_ingresadas*tarifa_base
					// Descuento por rol
					descuento <- 0
					Si rol_ing='Estudiante' Entonces
						descuento <- 0.20
					SiNo
						Si rol_ing='Docente' Entonces
							descuento <- 0.10
						FinSi
					FinSi
					subtotal <- subtotal-(subtotal*descuento)
					// Recargos de fin de semana y boleto
					Si dia_ing='Sábado' O dia_ing='Sabado' O dia_ing='Domingo' Entonces
						subtotal <- subtotal+(subtotal*0.15)
					FinSi
					total <- subtotal
					Si boleto_str='Si' O boleto_str='si' O boleto_str='Sí' Entonces
						total <- total+2.00
					FinSi
					// Guardar datos en los arreglos paralelos
					cantidad_vehiculos <- cantidad_vehiculos+1
					tipos[cantidad_vehiculos] <- tipo_ing
					roles[cantidad_vehiculos] <- rol_ing
					horas_array[cantidad_vehiculos] <- horas_ingresadas
					dias[cantidad_vehiculos] <- dia_ing
					boletos[cantidad_vehiculos] <- boleto_str
					valores[cantidad_vehiculos] <- total
					Escribir 'Vehículo registrado. Total a pagar: $', total
				SiNo
					Escribir 'Memoria llena. No se pueden registrar más vehículos.'
				FinSi
			2:
				Si cantidad_vehiculos=0 Entonces
					Escribir 'No hay vehículos registrados.'
				SiNo
					Para i<-1 Hasta cantidad_vehiculos Con Paso 1 Hacer
						Escribir 'Vehículo ', i, ' - Tipo: ', tipos[i], ' | Rol: ', roles[i], ' | Horas: ', horas_array[i], ' | Pagado: $', valores[i]
					FinPara
				FinSi
			3:
				Si cantidad_vehiculos=0 Entonces
					Escribir 'No hay vehículos registrados.'
				SiNo
					cCarros <- 0
					cMotos <- 0
					cBicis <- 0
					cEstudiantes <- 0
					cDocentes <- 0
					cVisitantes <- 0
					total_horas <- 0
					Para i<-1 Hasta cantidad_vehiculos Con Paso 1 Hacer
						Si tipos[i]='Carro' Entonces
							cCarros <- cCarros+1
						SiNo
							Si tipos[i]='Moto' Entonces
								cMotos <- cMotos+1
							SiNo
								cBicis <- cBicis+1
							FinSi
						FinSi
						Si roles[i]='Estudiante' Entonces
							cEstudiantes <- cEstudiantes+1
						SiNo
							Si roles[i]='Docente' Entonces
								cDocentes <- cDocentes+1
							SiNo
								cVisitantes <- cVisitantes+1
							FinSi
						FinSi
						total_horas <- total_horas+horas_array[i]
					FinPara
					Escribir '--- ESTADÍSTICAS ---'
					Escribir 'Carros: ', cCarros, ' | Motos: ', cMotos, ' | Bicicletas: ', cBicis
					Escribir 'Estudiantes: ', cEstudiantes, ' | Docentes: ', cDocentes, ' | Visitantes: ', cVisitantes
					Escribir 'Total horas: ', total_horas
					Escribir 'Promedio permanencia: ', total_horas/cantidad_vehiculos
				FinSi
			4:
				Si cantidad_vehiculos=0 Entonces
					Escribir 'No hay vehículos registrados.'
				SiNo
					total_recaudado <- 0
					mayor_pagado <- 0
					menor_pagado <- 999999
					Para i<-1 Hasta cantidad_vehiculos Con Paso 1 Hacer
						total_recaudado <- total_recaudado+valores[i]
						Si valores[i]>mayor_pagado Entonces
							mayor_pagado <- valores[i]
						FinSi
						Si valores[i]<menor_pagado Entonces
							menor_pagado <- valores[i]
						FinSi
					FinPara
					Escribir '--- RECAUDACIÓN ---'
					Escribir 'Total recaudado: $', total_recaudado
					Escribir 'Mayor valor pagado: $', mayor_pagado
					Escribir 'Menor valor pagado: $', menor_pagado
				FinSi
			5:
				Escribir 'Saliendo del sistema...'
			De Otro Modo:
				Escribir 'Opción no válida.'
		FinSegún
	FinMientras
FinAlgoritmo
