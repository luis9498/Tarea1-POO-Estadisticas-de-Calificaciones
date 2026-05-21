# DOCUMENTACION - Tarea 1: Cálculo de Estadísticas de Calificaciones con Arreglos

## Descripción del Programa

Este programa en Java permite ingresar un conjunto de 8 calificaciones de estudiantes separadas por comas, valida los datos ingresados y genera un reporte detallado con estadísticas educativas como promedio, nota máxima, nota mínima, cantidad de aprobados y reprobados.

---

## Explicación de cada Método

### `main(String[] args)`
Método principal que controla el flujo del programa. Ejecuta un bucle infinito que solicita calificaciones al usuario hasta que se ingresen datos válidos, luego llama al método de reporte.

### `leerCalificaciones()`
Lee una línea de texto ingresada por el usuario, la separa por comas y convierte cada valor a entero. Retorna un arreglo de 8 enteros o `null` si se detecta algún error de formato (valores vacíos, texto no numérico, o cantidad incorrecta de datos).

### `validarCalificaciones(int[] calificaciones)`
Recibe el arreglo de calificaciones y verifica que cada valor esté dentro del rango válido [0, 100]. Retorna `true` si todos los datos son correctos, o `false` si alguno está fuera de rango.

### `calcularPromedio(int[] calificaciones)`
Suma todos los elementos del arreglo y divide entre la cantidad total (8). Retorna un valor `double` con precisión decimal.

### `encontrarMaximo(int[] calificaciones)`
Recorre el arreglo comparando cada elemento con el valor máximo actual. Retorna el entero más alto encontrado.

### `encontrarMinimo(int[] calificaciones)`
Recorre el arreglo comparando cada elemento con el valor mínimo actual. Retorna el entero más bajo encontrado.

### `contarAprobados(int[] calificaciones)`
Cuenta cuántos elementos del arreglo son mayores o iguales a 70 (nota mínima de aprobación). Retorna la cantidad de aprobados.

### `mostrarReporte(int[] calificaciones)`
Genera e imprime en consola un reporte visual con bordes, mostrando todas las métricas calculadas: calificaciones ingresadas, promedio, máximo, mínimo, aprobados, reprobados y porcentaje de aprobación.

---

## Flujo del Programa

```
INICIO
  │
  ▼
Solicitar calificaciones al usuario
  │
  ▼
¿Son exactamente 8 valores? ──No──► Mostrar error → volver a solicitar
  │
 Sí
  │
  ▼
¿Todos los valores son numéricos? ──No──► Mostrar error → volver a solicitar
  │
 Sí
  │
  ▼
¿Todos están entre 0 y 100? ──No──► Mostrar error → volver a solicitar
  │
 Sí
  │
  ▼
Calcular: Promedio, Máximo, Mínimo, Aprobados, Reprobados, Porcentaje
  │
  ▼
Mostrar Reporte Final
  │
  ▼
FIN
```

---

## Instrucciones de Compilación y Ejecución

### Requisitos
- Java JDK 8 o superior instalado
- NetBeans IDE (recomendado) o cualquier terminal con `javac`

### Desde NetBeans
1. Abrir el proyecto `CalculadoraCalificaciones1` en NetBeans
2. Presionar **F6** o clic en el botón **Run Project**

### Desde terminal
```bash
# Compilar
javac CalculadoraCalificaciones1.java

# Ejecutar
java calculadoracalificaciones1.CalculadoraCalificaciones1
```

---

## Ejemplos de Salida

### Entrada válida
```
Entrada: 85, 92, 78, 88, 95, 75, 82, 90
```

### Salida esperada
```
╔══════════════════════════════════════════════════════╗
║            REPORTE DE CALIFICACIONES                 ║
╠══════════════════════════════════════════════════════╣
║                                                      ║
║  Calificaciones ingresadas:                          ║
║                          85 - 92 - 78 - 88 - 95 - 75 - 82 - 90  ║
║                                                      ║
║  ─── ESTADÍSTICAS ───                                ║
║  Promedio:               85.63                       ║
║  Calificación máxima:    95                          ║
║  Calificación mínima:    75                          ║
║                                                      ║
║  ─── ANÁLISIS DE RESULTADOS ───                      ║
║  Cantidad de aprobados (>=70):  8                    ║
║  Cantidad de reprobados (<70):  0                    ║
║  Porcentaje de aprobados:       100.0%               ║
║                                                      ║
╚══════════════════════════════════════════════════════╝
```

### Entrada inválida (fuera de rango)
```
Entrada: 85, 110, 78, 88, 95, 75, 82, 90
-> Valor incorrecto detectado: 110
-> Error encontrado en la calificacion numero: 2
Error: Las calificaciones deberan estar entre 0 y 100
```
