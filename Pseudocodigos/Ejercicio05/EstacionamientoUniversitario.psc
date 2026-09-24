Algoritmo EstacionamientoUniversitario
	Definir tipo, horas, respuesta Como Entero
	Definir cantMotos, cantAutos, cantCamionetas, totalVehiculos Como Entero
	Definir tarifa, pagoVehiculo, totalRecaudado, promedioPagado Como Real
	cantMotos <- 0
	cantAutos <- 0
	cantCamionetas <- 0
	totalVehiculos <- 0
	totalRecaudado <- 0.0
	Repetir
		Escribir '=== REGISTRO DE VEHICULO ==='
		Escribir 'Tipo de vehiculo:'
		Escribir '1. Motocicleta ($0.50/h)'
		Escribir '2. Automovil ($1.00/h)'
		Escribir '3. Camioneta ($1.50/h)'
		Escribir 'Seleccione una opcion (1-3):'
		Leer tipo
		Mientras tipo<1 O tipo>3 Hacer
			Escribir 'Opcion invalida. Ingrese un tipo valido (1, 2 o 3):'
			Leer tipo
		FinMientras
		Escribir 'Ingrese las horas estacionado:'
		Leer horas
		Mientras horas<=0 Hacer
			Escribir 'Error: Las horas deben ser mayores que cero. Ingrese de nuevo:'
			Leer horas
		FinMientras
		Según tipo Hacer
			1:
				tarifa <- 0.50
				cantMotos <- cantMotos+1
			2:
				tarifa <- 1.00
				cantAutos <- cantAutos+1
			3:
				tarifa <- 1.50
				cantCamionetas <- cantCamionetas+1
		FinSegún
		pagoVehiculo <- horas*tarifa
		totalRecaudado <- totalRecaudado+pagoVehiculo
		totalVehiculos <- totalVehiculos+1
		Escribir 'Monto a pagar por este vehiculo: $', pagoVehiculo
		Escribir 'Desea registrar otro vehiculo? (1: Si / 0: No):'
		Leer respuesta
	Hasta Que respuesta=0
	Escribir ''
	Escribir '===== REPORTE ====='
	Escribir 'Motocicletas: ', cantMotos
	Escribir 'Automoviles: ', cantAutos
	Escribir 'Camionetas: ', cantCamionetas
	Escribir 'Total vehiculos: ', totalVehiculos
	Escribir 'Total recaudado: $', totalRecaudado
	Si totalVehiculos>0 Entonces
		promedioPagado <- totalRecaudado/totalVehiculos
		Escribir 'Promedio pagado: $', promedioPagado
	SiNo
		Escribir 'Promedio pagado: $0.00'
	FinSi
	Escribir '==================='
FinAlgoritmo
