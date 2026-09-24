<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>README - Estacionamiento Universitario</title>
    <style>
        body { font-family: -apple-system, BlinkMacSystemFont, "Segoe UI", Roboto, Helvetica, Arial, sans-serif; line-height: 1.6; color: #333; max-width: 900px; margin: 0 auto; padding: 20px; }
        h1 { border-bottom: 2px solid #eaecef; padding-bottom: 10px; }
        h2 { border-bottom: 1px solid #eaecef; padding-bottom: 5px; margin-top: 30px; }
        table { width: 100%; border-collapse: collapse; margin: 20px 0; font-size: 14px; }
        th, td { border: 1px solid #dfe2e5; padding: 10px; text-align: left; }
        th { background-color: #f6f8fa; font-weight: bold; }
        tr:nth-child(even) { background-color: #f9f9f9; }
        pre { background-color: #f6f8fa; padding: 15px; border-radius: 6px; overflow-x: auto; border: 1px solid #eaecef; }
        code { font-family: "Courier New", Courier, monospace; }
        .highlight { background-color: #fffbdd; padding: 2px 4px; border-radius: 3px; }
    </style>
</head>
<body>

    <h1>Ejercicio 5: Estacionamiento Universitario</h1>

    <h2>1. Explicación de la Solución</h2>
    <p>El programa resuelve el problema de gestión de tarifas de un estacionamiento universitario mediante un sistema iterativo. Utiliza un bucle principal <code>do-while</code> que permite registrar múltiples vehículos hasta que el usuario decida detener el proceso. Para determinar la tarifa a cobrar, se emplea una estructura condicional múltiple <code>switch</code> que evalúa el tipo de vehículo (Motocicleta, Automóvil o Camioneta) y aplica el precio por hora correspondiente.</p>
    <p>Para garantizar la integridad de los datos, se implementó una validación estricta con un <code>do-while</code> anidado que impide el ingreso de horas negativas o iguales a cero. Durante la ejecución, el sistema utiliza <strong>contadores</strong> independientes para llevar el registro de la cantidad de cada tipo de vehículo ingresado, y un <strong>acumulador</strong> global que suma el dinero total recaudado. Al finalizar el ciclo principal, se calcula el promedio de pago dividiendo el acumulador entre la suma total de los contadores, protegiendo la operación matemática para evitar divisiones por cero.</p>

    <h2>2. Análisis del Problema</h2>
    <ul>
        <li><strong>Entradas:</strong> 
            <ul>
                <li><code>tipoVehiculo</code> (Entero): Selección del menú (1. Motocicleta, 2. Automóvil, 3. Camioneta).</li>
                <li><code>horas</code> (Decimal): Tiempo de estacionamiento. Restricción: Debe ser estrictamente &gt; 0.</li>
                <li><code>continuar</code> (Entero): Bandera de control para registrar más vehículos (1 = Sí, 0 = No).</li>
            </ul>
        </li>
        <li><strong>Procesos:</strong>
            <ul>
                <li>Validación de entrada de horas mediante ciclo repetitivo.</li>
                <li>Cálculo de pago individual: <code>tarifa_segun_tipo * horas</code>.</li>
                <li>Actualización de contadores (<code>contMoto++</code>, <code>contAuto++</code>, <code>contCamioneta++</code>).</li>
                <li>Actualización de acumulador (<code>totalRecaudado += pago</code>).</li>
                <li>Cálculo de totales finales (Suma de contadores) y promedio (<code>totalRecaudado / totalVehiculos</code>).</li>
            </ul>
        </li>
        <li><strong>Salidas:</strong>
            <ul>
                <li>Monto a pagar por el vehículo actual.</li>
                <li>Reporte final con el desglose de vehículos, cantidad total, dinero total recaudado y promedio pagado.</li>
            </ul>
        </li>
    </ul>

    <h2>3. Pseudocódigo</h2>
<pre><code>Inicio
    Definir contMoto = 0, contAuto = 0, contCamioneta = 0
    Definir totalRecaudado = 0.0
    Definir continuar como Entero
    
    Hacer
        Escribir "1. Motocicleta | 2. Automóvil | 3. Camioneta"
        Leer tipoVehiculo
        
        Si tipoVehiculo >= 1 Y tipoVehiculo <= 3 Entonces
            Hacer
                Escribir "Horas estacionado (mayor que cero): "
                Leer horas
                Si horas <= 0 Entonces
                    Escribir "Error. Las horas deben ser mayores a 0."
                Fin Si
            Mientras horas <= 0
            
            pago = 0.0
            
            Segun tipoVehiculo Hacer
                Caso 1:
                    pago = horas * 0.50
                    contMoto = contMoto + 1
                Caso 2:
                    pago = horas * 1.00
                    contAuto = contAuto + 1
                Caso 3:
                    pago = horas * 1.50
                    contCamioneta = contCamioneta + 1
            Fin Segun
            
            totalRecaudado = totalRecaudado + pago
            Escribir "A pagar por este vehículo: $", pago
        Sino
            Escribir "Tipo de vehículo inválido."
        Fin Si
        
        Escribir "¿Registrar otro vehículo? (1 = Sí, 0 = No): "
        Leer continuar
        
    Mientras continuar == 1
    
    totalVehiculos = contMoto + contAuto + contCamioneta
    Si totalVehiculos > 0 Entonces
        promedio = totalRecaudado / totalVehiculos
    Sino
        promedio = 0.0
    Fin Si
    
    Escribir "===== REPORTE ====="
    Escribir "Motocicletas: ", contMoto
    Escribir "Automóviles: ", contAuto
    Escribir "Camionetas: ", contCamioneta
    Escribir "Total vehículos: ", totalVehiculos
    Escribir "Total recaudado: $", totalRecaudado
    Escribir "Promedio pagado: $", promedio
Fin</code></pre>

    <h2>4. Casos de Prueba</h2>
    <table>
        <thead>
            <tr>
                <th>ID Caso</th>
                <th>Descripción / Tipo</th>
                <th>Entradas Proporcionadas</th>
                <th>Resultado Esperado (Salida)</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td><strong>CP-01</strong></td>
                <td>Flujo Normal (Básico)</td>
                <td>Tipo: <code>2</code> (Auto)<br>Horas: <code>2</code><br>Continuar: <code>0</code></td>
                <td>Pago vehículo: <strong>$2.00</strong><br>Reporte: 1 Auto, Total: 1, Recaudado: $2.00, Promedio: $2.00</td>
            </tr>
            <tr>
                <td><strong>CP-02</strong></td>
                <td>Múltiples vehículos</td>
                <td>Tipo: <code>1</code>, Horas: <code>3</code>, Cont: <code>1</code><br>Tipo: <code>3</code>, Horas: <code>1</code>, Cont: <code>0</code></td>
                <td>Pago Moto: <strong>$1.50</strong><br>Pago Camioneta: <strong>$1.50</strong><br>Reporte: 1 Moto, 1 Camioneta, Recaudado: $3.00, Promedio: $1.50</td>
            </tr>
            <tr>
                <td><strong>CP-03</strong></td>
                <td>Límite: Horas incorrectas</td>
                <td>Tipo: <code>1</code> (Moto)<br>Horas: <code>-5</code> <span class="highlight">(Error)</span><br>Horas: <code>0</code> <span class="highlight">(Error)</span><br>Horas: <code>2</code><br>Continuar: <code>0</code></td>
                <td>El sistema rechaza <code>-5</code> y <code>0</code> mostrando mensaje de error. Acepta el <code>2</code>. Pago: <strong>$1.00</strong>.</td>
            </tr>
            <tr>
                <td><strong>CP-04</strong></td>
                <td>Entrada: Tipo inválido</td>
                <td>Tipo: <code>5</code> (Inválido)<br>Continuar: <code>0</code></td>
                <td>Muestra "Opción de vehículo no válida". No solicita horas ni suma valores.</td>
            </tr>
        </tbody>
    </table>

    <h2>5. Trazas (Prueba de Escritorio)</h2>
    <p><em>Escenario: Se ingresa un Auto por 2 horas. Luego se ingresa una Moto, se introduce un error en las horas (-1), se corrige (4 horas) y se finaliza.</em></p>
    <table>
        <thead>
            <tr>
                <th>Paso</th>
                <th>Entrada</th>
                <th><code>tipo</code></th>
                <th><code>horas</code></th>
                <th>Condición (Validación)</th>
                <th><code>pago</code></th>
                <th><code>contAuto</code></th>
                <th><code>contMoto</code></th>
                <th><code>totalRecaudado</code></th>
                <th><code>continuar</code></th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td>1</td>
                <td><em>Inicio</em></td>
                <td>-</td>
                <td>-</td>
                <td>-</td>
                <td>0.0</td>
                <td>0</td>
                <td>0</td>
                <td>0.0</td>
                <td>-</td>
            </tr>
            <tr>
                <td>2</td>
                <td>Tipo: 2</td>
                <td>2</td>
                <td>-</td>
                <td><code>(2 >= 1 && 2 <= 3)</code> &rarr; true</td>
                <td>0.0</td>
                <td>0</td>
                <td>0</td>
                <td>0.0</td>
                <td>-</td>
            </tr>
            <tr>
                <td>3</td>
                <td>Horas: 2</td>
                <td>2</td>
                <td>2.0</td>
                <td><code>(2.0 <= 0)</code> &rarr; false</td>
                <td>0.0</td>
                <td>0</td>
                <td>0</td>
                <td>0.0</td>
                <td>-</td>
            </tr>
            <tr>
                <td>4</td>
                <td><em>Cálculo</em></td>
                <td>2</td>
                <td>2.0</td>
                <td><code>switch(2)</code></td>
                <td><strong>2.00</strong></td>
                <td><strong>1</strong></td>
                <td>0</td>
                <td><strong>2.00</strong></td>
                <td>-</td>
            </tr>
            <tr>
                <td>5</td>
                <td>Cont: 1</td>
                <td>2</td>
                <td>2.0</td>
                <td><code>(1 != 0)</code> &rarr; true <em>(repite)</em></td>
                <td>2.00</td>
                <td>1</td>
                <td>0</td>
                <td>2.00</td>
                <td><strong>1</strong></td>
            </tr>
            <tr>
                <td>6</td>
                <td>Tipo: 1</td>
                <td>1</td>
                <td>2.0</td>
                <td><code>(1 >= 1 && 1 <= 3)</code> &rarr; true</td>
                <td>2.00</td>
                <td>1</td>
                <td>0</td>
                <td>2.00</td>
                <td>1</td>
            </tr>
            <tr>
                <td>7</td>
                <td>Horas: -1</td>
                <td>1</td>
                <td>-1.0</td>
                <td><code>(-1.0 <= 0)</code> &rarr; <span class="highlight">true (Error)</span></td>
                <td>2.00</td>
                <td>1</td>
                <td>0</td>
                <td>2.00</td>
                <td>1</td>
            </tr>
            <tr>
                <td>8</td>
                <td>Horas: 4</td>
                <td>1</td>
                <td>4.0</td>
                <td><code>(4.0 <= 0)</code> &rarr; false</td>
                <td>2.00</td>
                <td>1</td>
                <td>0</td>
                <td>2.00</td>
                <td>1</td>
            </tr>
            <tr>
                <td>9</td>
                <td><em>Cálculo</em></td>
                <td>1</td>
                <td>4.0</td>
                <td><code>switch(1)</code></td>
                <td><strong>2.00</strong></td>
                <td>1</td>
                <td><strong>1</strong></td>
                <td><strong>4.00</strong></td>
                <td>1</td>
            </tr>
            <tr>
                <td>10</td>
                <td>Cont: 0</td>
                <td>1</td>
                <td>4.0</td>
                <td><code>(0 != 0)</code> &rarr; false <em>(sale)</em></td>
                <td>2.00</td>
                <td>1</td>
                <td>1</td>
                <td>4.00</td>
                <td><strong>0</strong></td>
            </tr>
        </tbody>
    </table>

</body>
</html>
