
package calculadoracalificaciones1;
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
        misNotas = leerCalificaciones();//capturo la entrada del teclado
        if (validarCalificaciones(misNotas) == true){
           
            break;//rompe el bucle si se cumple lo pedido
        }
           System.out.println("\n[Programa terminado por errores en los datos de entrada");
           System.out.println("Por favor, intente ingresar de nuevo la lista de calificaciones.\n");
        
}
       mostrarReporte(misNotas); //
    }

    static int[] leerCalificaciones() {
        Scanner teclado = new Scanner(System.in);
        
        
        System.out.println("╔════════════════════════════════════╗");
        System.out.println("║      INGRESE LAS CALIFICACIONES         ║");
        System.out.println("╚════════════════════════════════════╝");
        System.out.print("Entrada: ");
        
        
        String lineaCompleta = teclado.nextLine();
       
        
        String[] textosSeparados = lineaCompleta.split(",");
         if (textosSeparados.length != 8){
             System.out.println("Error: ingrese 8 calificaciones");
          return null;  
         }
        int[] notas = new int[8];
       try{
        for (int i = 0; i < 8; i++) {
            
            String textoLimpio = textosSeparados[i].trim();
            if (textoLimpio.isEmpty()){
                   System.out.println("-> Error: Se detecta un valor nulo o vacio");
                  return null;
            }      
        
            
            
            notas[i] = Integer.parseInt(textoLimpio);
}
        }catch (NumberFormatException e){
          System.out.println("-> Error: se detecto un valor no numerico en la entrada");
          return null;
         }
        if (validarCalificaciones(notas) == false){
            System.out.println("");
          
}
       
        return notas;
    }
    static boolean validarCalificaciones(int[] calificaciones) {
           if (calificaciones == null){
             return false;
}
           boolean todoValido = true;
            for (int i= 0; i<8; i++){
               if (calificaciones[i] < 0 || calificaciones[i] > 100){
                 System.out.println("-> Valor incorrecto detectado:" + calificaciones[i]);
                 System.out.println("-> Error encontrado en la calificacion numero: " + (i +1));
                
                 System.out.println("Error: Las calificaciones deberan estar entre 0 y 100");
                todoValido = false;
                }
            
            }
        return todoValido;
     }
    static double calcularPromedio(int[] calificaciones){
        int suma = 0;
    for (int i = 0; i < calificaciones.length; i++){
       suma += calificaciones[i];
}
return (double) suma/calificaciones.length;
}
    static int encontrarMaximo(int [] calificaciones){
        int max = calificaciones[0];
        for (int i = 1; i < calificaciones.length; i++){
            if (calificaciones[i] > max){
               max = calificaciones[i];
            }
        }
        return max;
    }
    static int encontrarMinimo(int[] calificaciones){
         int min = calificaciones[0];
         for(int i =1; i < calificaciones.length; i++){
             if(calificaciones[i] < min){
                min = calificaciones[i];
            }
        }
        return min;
    }
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
       double promedio = calcularPromedio(calificaciones);
       int maximo = encontrarMaximo(calificaciones);
       int minimo = encontrarMinimo(calificaciones);
       int aprobados = contarAprobados(calificaciones);
       int reprobados = calificaciones.length - aprobados;
       double porcentajeAprobados = ((double) aprobados / calificaciones.length) * 100;
       
      System.out.println("╔══════════════════════════════════════════════════════╗");
        System.out.println("║            REPORTE DE CALIFICACIONES                         ║");
        System.out.println("╠══════════════════════════════════════════════════════╣");
        System.out.println("║                                                              ║");
        System.out.println("║  Calificaciones ingresadas:                                  ║");
        System.out.print("║                          ");
        for (int i = 0; i < calificaciones.length; i++) {
            System.out.print(calificaciones[i] + (i < calificaciones.length - 1 ? " - " : ""));
        }
        System.out.println("  ║\n║                                                              ║");
        System.out.println("║  ─── ESTADÍSTICAS ───                                       ║");
        System.out.printf("║  Promedio:               %.2f                               ║%n", promedio);
        System.out.printf("║  Calificación máxima:    %d                                 ║%n", maximo);
        System.out.printf("║  Calificación mínima:    %d                                  ║%n", minimo);
        System.out.println("║                                                              ║");
        System.out.println("║  ─── ANÁLISIS DE RESULTADOS ───                             ║");
        System.out.printf("║  Cantidad de aprobados (>=70):  %d                            ║%n", aprobados);
        System.out.printf("║  Cantidad de reprobados (<70):   %d                           ║%n", reprobados);
        System.out.printf("║  Porcentaje de aprobados:       %.1f%%                         ║%n", porcentajeAprobados);
        System.out.println("║                                                              ║");
        System.out.println("╚══════════════════════════════════════════════════════╝");
}

}
    
    
    