
package calculadoracalificaciones1;
// =========================================================================
// EXPLICACIÓN DEL IMPORT Y EL SCANNER:
// 1. 'import java.util.Scanner;' -> Le dice a Java que vamos a usar una herramienta 
//    que no viene activa por defecto. Es como sacar el Scanner de la caja de herramientas de Java.
// 2. 'Scanner teclado = new Scanner(System.in);' -> Aquí creamos el objeto receptor.
//    - 'teclado' es el nombre que le damos a nuestra herramienta.
//    - 'System.in' le especifica a Java que el Scanner debe escuchar la ENTRADA ESTÁNDAR (el teclado).
// 3. 'teclado.nextLine();' -> Es el comando que le dice al programa: "Detente aquí y 
//    espera a que el usuario escriba toda la línea de texto y presione ENTER".
// =========================================================================
import java.util.Scanner;
/** Proyecto calculo de Estadisticas de Calificaciones con arreglos
objetivos: Aplicar conceptos fundamentales de arreglos en Java para resolver un problema real de procesamiento 
de datos educativos, implementando operaciones comunes como suma, búsqueda de extremos, y filtrado de 
información.
cumple con programacion modular, control de errores
*/

public class CalculadoraCalificaciones1 {
    
    public static void main(String[] args) {
       //declaro el arreglo
       int[] misNotas;
        while(true){ //inicio un bucle infinito
        misNotas = leerCalificaciones();//captura los datos
        if (validarCalificaciones(misNotas) == true){
           
            break;//rompe el bucle si se cumple lo pedido
        }
           System.out.println("\n[Programa terminado por errores en los datos de entrada");
           System.out.println("Por favor, intente ingresar de nuevo la lista de calificaciones.\n");
        
}
       mostrarReporte(misNotas); //imprime el reporte final
    }

    static int[] leerCalificaciones() {
        Scanner teclado = new Scanner(System.in);//el receptor del teclado
        
        
        System.out.println("╔════════════════════════════════════╗");
        System.out.println("║      INGRESE LAS CALIFICACIONES         ║");
        System.out.println("╚════════════════════════════════════╝");
        System.out.print("Entrada: ");
        
        
        String lineaCompleta = teclado.nextLine();//captura la cadena de texto
       
        
        String[] textosSeparados = lineaCompleta.split(",");// Tokeniza la cadena usando comas como delimitador
         if (textosSeparados.length != 8){
            // CONTROL DE LONGITUD: Valida la cantidad exacta de elementos (Restricción de 8 notas)
             System.out.println("Error: ingrese 8 calificaciones");
          return null;  //retorna como bandera de error
         }
        int[] notas = new int[8];//inicia el arreglo definitivos de enteros
       // BLOQUE TRY-CATCH: Blindaje contra datos corruptos (letras o espacios vacíos)
       try{
        for (int i = 0; i < 8; i++) {
            
            String textoLimpio = textosSeparados[i].trim();//elimina espacios en balnco residuales
            if (textoLimpio.isEmpty()){
                   System.out.println("-> Error: Se detecta un valor nulo o vacio");
                  return null;
            }      
        
            // Conversión de tipo (Parsing): Transforma el String a primitivo int
            
            notas[i] = Integer.parseInt(textoLimpio);
}
        }catch (NumberFormatException e){
        // Captura la excepción de formato si el texto contiene caracteres no numéricos
          System.out.println("-> Error: se detecto un valor no numerico en la entrada");
          return null;
         }
        if (validarCalificaciones(notas) == false){
            System.out.println("");
          
}
       
        return notas;//retorna el arreglo procesado con exito
    }
    static boolean validarCalificaciones(int[] calificaciones) {
        // Control de nulidad preventiva por si falló el método de lectura
           if (calificaciones == null){
             return false;
}
           boolean todoValido = true;//variable bandera 
         // CONTROL DE RANGO: Verifica matemáticamente el intervalo cerrado [0, 100]
            for (int i= 0; i<8; i++){
               if (calificaciones[i] < 0 || calificaciones[i] > 100){
                 System.out.println("-> Valor incorrecto detectado:" + calificaciones[i]);
                 System.out.println("-> Error encontrado en la calificacion numero: " + (i +1));
                
                 System.out.println("Error: Las calificaciones deberan estar entre 0 y 100");
                todoValido = false;// Desactiva la bandera si encuentra un dato fuera de rango
                }
            
            }
        return todoValido;
     }
     // Calcula la media aritmética (Castea a double para preservar precisión decimal)
    static double calcularPromedio(int[] calificaciones){
        int suma = 0;
    for (int i = 0; i < calificaciones.length; i++){
       suma += calificaciones[i];
}
return (double) suma/calificaciones.length;
}
    // Algoritmo de búsqueda lineal para determinar el valor máximo
    static int encontrarMaximo(int [] calificaciones){
        int max = calificaciones[0];
        for (int i = 1; i < calificaciones.length; i++){
            if (calificaciones[i] > max){
               max = calificaciones[i];
            }
        }
        return max;
    }
    // Algoritmo de búsqueda lineal para determinar el valor mínimo
    static int encontrarMinimo(int[] calificaciones){
         int min = calificaciones[0];
         for(int i =1; i < calificaciones.length; i++){
             if(calificaciones[i] < min){
                min = calificaciones[i];
            }
        }
        return min;
    }
     // Contador de frecuencias para determinar la cantidad de alumnos condicionales (Aprobados >= 70)
    static int contarAprobados(int[] calificaciones){
        int aprobados = 0;
        for (int i = 0; i < calificaciones.length; i++){
           if (calificaciones[i] >= 70){
             aprobados++;
            }
        }
        return aprobados;
    }
    
static void mostrarReporte(int[] calificaciones){
     // Almacenamiento local de las métricas calculadas
       double promedio = calcularPromedio(calificaciones);
       int maximo = encontrarMaximo(calificaciones);
       int minimo = encontrarMinimo(calificaciones);
       int aprobados = contarAprobados(calificaciones);
    // Cálculos complementarios automáticos para el análisis
       int reprobados = calificaciones.length - aprobados;
       double porcentajeAprobados = ((double) aprobados / calificaciones.length) * 100;
        // --- FORMATO CON ESPACIOS MANUALES (System.out.printf) ---
        // Se utilizan especificadores de formato básicos integrados en bloques de texto fijos:
        // %.2f  -> Inserta el promedio limitándolo estrictamente a 2 posiciones decimales.
        // %d    -> Inserta los valores numéricos enteros enteros (máximo, mínimo, cantidades).
        // %.1f%% -> Muestra el porcentaje con un decimal y escapa el símbolo de por ciento con %%.
        // Los espacios en blanco están ajustados textualmente para coincidir con el borde derecho (║).
       
      System.out.println("╔══════════════════════════════════════════════════════╗");
        System.out.println("║            REPORTE DE CALIFICACIONES                         ║");
        System.out.println("╠══════════════════════════════════════════════════════╣");
        System.out.println("║                                                              ║");
        System.out.println("║  Calificaciones ingresadas:                                  ║");
        System.out.print("║                          ");// Margen izquierdo fijo antes de listar los elementos del arreglo
       // CICLO ITERATIVO: Recorre el arreglo e imprime las notas en línea separadas por guiones
 for (int i = 0; i < calificaciones.length; i++) {
            System.out.print(calificaciones[i] + (i < calificaciones.length - 1 ? " - " : ""));
        }
        // Cierre de la línea de calificaciones y salto de bloque
        System.out.println("  ║\n║                                                              ║");
        System.out.println("║  ─── ESTADÍSTICAS ───                                       ║");
        // IMPRESIÓN FORMATEADA: Sección de métricas promedio y valores extremos
        System.out.printf("║  Promedio:               %.2f                               ║%n", promedio);
        System.out.printf("║  Calificación máxima:    %d                                 ║%n", maximo);
        System.out.printf("║  Calificación mínima:    %d                                  ║%n", minimo);
        System.out.println("║                                                              ║");
        System.out.println("║  ─── ANÁLISIS DE RESULTADOS ───                             ║");
      // IMPRESIÓN FORMATEADA: Sección cuantitativa y porcentual del rendimiento del grupo
        System.out.printf("║  Cantidad de aprobados (>=70):  %d                            ║%n", aprobados);
        System.out.printf("║  Cantidad de reprobados (<70):   %d                           ║%n", reprobados);
        System.out.printf("║  Porcentaje de aprobados:       %.1f%%                         ║%n", porcentajeAprobados);
        System.out.println("║                                                              ║");
       // Cierre del marco inferior del reporte visual
        System.out.println("╚══════════════════════════════════════════════════════╝");
}

}
    
    
    