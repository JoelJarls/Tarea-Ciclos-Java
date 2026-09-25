Algoritmo ControlVentasCafeteria
    Definir opcionMenu, opcionProducto, cantidad Como Entero
    Definir totalRecaudado, promedioVenta, precio Como Real
    Definir totalVentas, totalProductos Como Entero
    Definir cantCafe, cantSandwich, cantJugo, cantEmpanada Como Entero
    Definir mayorCantidad Como Entero
    
    totalVentas <- 0
    totalProductos <- 0
    totalRecaudado <- 0.0
    cantCafe <- 0
    cantSandwich <- 0
    cantJugo <- 0
    cantEmpanada <- 0
    
    Repetir
        Escribir "==================================="
        Escribir "      CAFETERÍA UNIVERSITARIA      "
        Escribir "==================================="
        Escribir "1. Registrar venta"
        Escribir "2. Mostrar estadísticas"
        Escribir "3. Mostrar tabla de productos"
        Escribir "4. Salir"
        Escribir "==================================="
        Escribir "Ingrese una opción: "
        Leer opcionMenu
        
        Según opcionMenu Hacer
            1:
                Repetir
                    Escribir "--- SELECCIONE PRODUCTO ---"
                    Escribir "1. Café       $1.00"
                    Escribir "2. Sándwich   $2.50"
                    Escribir "3. Jugo       $1.50"
                    Escribir "4. Empanada   $1.25"
                    Escribir "Seleccione producto (1-4): "
                    Leer opcionProducto
                Hasta Que opcionProducto >= 1 Y opcionProducto <= 4
                
                Repetir
                    Escribir "Ingrese la cantidad (mayor a 0): "
                    Leer cantidad
                Hasta Que cantidad > 0
                
                precio <- 0.0
                Según opcionProducto Hacer
                    1:
                        precio <- 1.00
                        cantCafe <- cantCafe + cantidad
                    2:
                        precio <- 2.50
                        cantSandwich <- cantSandwich + cantidad
                    3:
                        precio <- 1.50
                        cantJugo <- cantJugo + cantidad
                    4:
                        precio <- 1.25
                        cantEmpanada <- cantEmpanada + cantidad
                FinSegún
                
                totalVentas <- totalVentas + 1
                totalProductos <- totalProductos + cantidad
                totalRecaudado <- totalRecaudado + (precio * cantidad)
                
                Escribir "Venta registrada con éxito."
                
            2:
                Si totalVentas > 0 Entonces
                    promedioVenta <- totalRecaudado / totalVentas
                    
                    Escribir "=== ESTADÍSTICAS DE VENTAS ==="
                    Escribir "Número de ventas: ", totalVentas
                    Escribir "Cantidad total de productos: ", totalProductos
                    Escribir "Total recaudado: $", totalRecaudado
                    Escribir "Promedio por venta: $", promedioVenta
                    
                    mayorCantidad <- cantCafe
                    Si cantSandwich > mayorCantidad Entonces
                        mayorCantidad <- cantSandwich
                    FinSi
                    Si cantJugo > mayorCantidad Entonces
                        mayorCantidad <- cantJugo
                    FinSi
                    Si cantEmpanada > mayorCantidad Entonces
                        mayorCantidad <- cantEmpanada
                    FinSi
                    
                    Escribir "Producto(s) con mayor cantidad vendida (" , mayorCantidad , " unidades):"
                    Si cantCafe = mayorCantidad Entonces
                        Escribir "- Café"
                    FinSi
                    Si cantSandwich = mayorCantidad Entonces
                        Escribir "- Sándwich"
                    FinSi
                    Si cantJugo = mayorCantidad Entonces
                        Escribir "- Jugo"
                    FinSi
                    Si cantEmpanada = mayorCantidad Entonces
                        Escribir "- Empanada"
                    FinSi
                Sino
                    Escribir "No hay ventas registradas aún."
                FinSi
                
            3:
                Escribir "=== TABLA DE PRODUCTOS ==="
                Escribir "1. Café       $1.00"
                Escribir "2. Sándwich   $2.50"
                Escribir "3. Jugo       $1.50"
                Escribir "4. Empanada   $1.25"
                
            4:
                Escribir "¡Gracias por usar el sistema!"
                
            De Otro Modo:
                Escribir "Opción no válida. Intente nuevamente."
        FinSegún
        
    Hasta Que opcionMenu = 4
FinAlgoritmo
