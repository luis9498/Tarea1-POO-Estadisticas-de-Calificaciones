# Tarea 1: Cálculo de Estadísticas de Calificaciones con Arreglos

## Descripción de la Tarea

Desarrollar un **programa en Java** que utilice **arreglos** para almacenar calificaciones de estudiantes y calcular estadísticas educativas. El programa debe procesar un conjunto de notas, validar los datos y generar un informe detallado con métricas clave.

### Objetivo General
Aplicar conceptos fundamentales de arreglos en Java para resolver un problema real de procesamiento de datos educativos, implementando operaciones comunes como suma, búsqueda de extremos, y filtrado de información.

---

## Objetivos Específicos

1. Crear y manipular arreglos de datos numéricos en Java
2. Implementar operaciones básicas: suma, promedio, máximo, mínimo
3. Validar datos de entrada dentro de rangos permitidos
4. Contar elementos que cumplan criterios específicos
5. Generar un informe de estadísticas de forma clara y estructurada
6. Utilizar métodos para organizar el código de manera modular

---

## Requisitos Técnicos

### Lenguaje de Programación
- **Java** (versión 8 o superior)
- Se debe compilar sin errores

### Herramientas Permitidas
- Clases y métodos estándar de Java
- Ciclos `for`, `for-each`, y `while`
- Arrays unidimensionales (`int[]`, `double[]`)
- Métodos personalizados

### Restricciones
- **NO se permite** usar `ArrayList` ni colecciones
- Debes trabajar únicamente con arreglos primitivos
- No se permite usar librerías externas

---

## Casos de Validación

### Datos VÁLIDOS (deben aceptarse)

```
Conjunto 1: [85, 92, 78, 88, 95, 75, 82, 90]
Conjunto 2: [100, 100, 100, 100, 100, 100, 100, 100]
Conjunto 3: [0, 50, 100, 25, 75, 60, 40, 80]
Conjunto 4: [70, 70, 70, 70, 70, 70, 70, 70]
Conjunto 5: [88, 92, 85, 90, 87, 89, 91, 86]
Conjunto 6: [100, 95, 98, 97, 99, 96, 94, 100]
Conjunto 7: [0, 0, 0, 0, 0, 0, 0, 0]
Conjunto 8: [65, 72, 81, 55, 68, 79, 73, 67]
```

### Datos INVÁLIDOS (deben detectarse errores)

| Datos                           | Tipo de Error                                      |
| ------------------------------- | -------------------------------------------------- |
| `[85, 92, 120, 88]`             | Valor fuera de rango (máximo es 100)               |
| `[85, 92, -5, 88]`              | Valor negativo (mínimo es 0)                       |
| `[85, 92]`                      | Cantidad insuficiente (menos de 8 elementos)       |
| `[85, 92, 78, 88, 95, 75, 82]`  | Falta un elemento (menos de 8)                     |
| `[85, "noventa", 78, 88]`       | Valor no numérico                                  |
| `[null, 92, 78, 88]`            | Valor nulo                                         |

---

## Especificaciones del Programa

### Estructura General

```
Entrada: 8 calificaciones (enteros o decimales)
Proceso: Análisis y cálculo de estadísticas
Salida: Reporte detallado con métricas
```

### Definiciones de Cálculos

#### 1. Promedio
$$\text{Promedio} = \frac{\sum_{i=0}^{n-1} \text{calificacion}_i}{n}$$

Donde `n = 8` (cantidad de calificaciones)

#### 2. Máximo
- El valor más alto del arreglo

#### 3. Mínimo
- El valor más bajo del arreglo

#### 4. Aprobados
- Calificaciones >= 70 (cálculo de frecuencia)

#### 5. Porcentaje de Aprobados
$$\text{Porcentaje} = \frac{\text{Cantidad de Aprobados}}{8} \times 100$$

---

## Requisitos de Implementación

### 1. Estructura del Programa

```
┌─────────────────────────────────┐
│  Entrada de Calificaciones      │
│  (8 valores)                    │
└────────────┬────────────────────┘
             ↓
┌─────────────────────────────────┐
│  Validación de Datos            │
│  (Rango 0-100, cantidad)        │
└────────────┬────────────────────┘
             ↓
┌─────────────────────────────────┐
│  Cálculos Estadísticos          │
│  - Promedio                     │
│  - Máximo y Mínimo              │
│  - Conteo de aprobados          │
└────────────┬────────────────────┘
             ↓
┌─────────────────────────────────┐
│  Generación de Reporte          │
│  (Salida formateada)            │
└─────────────────────────────────┘
```

### 2. Funcionalidades Obligatorias

- ✅ Leer 8 calificaciones desde entrada del usuario o archivo
- ✅ Validar que todas las calificaciones estén en el rango [0, 100]
- ✅ Validar que se proporcionen exactamente 8 calificaciones
- ✅ Calcular y mostrar:
  - Promedio (con 2 decimales)
  - Calificación máxima
  - Calificación mínima
  - Cantidad de calificaciones >= 70 (aprobados)
  - Porcentaje de aprobados (con 1 decimal)
  - Cantidad de reprobados
- - ✅ Manejo de errores:
  - Validación de entrada
  - Mensajes de error claros
  - Opción para reintentar entrada

### 3. Funcionalidades Opcionales
- ✅ Crear los siguientes métodos:
  ```java
  static int[] leerCalificaciones()
  static boolean validarCalificaciones(int[] calificaciones)
  static double calcularPromedio(int[] calificaciones)
  static int encontrarMaximo(int[] calificaciones)
  static int encontrarMinimo(int[] calificaciones)
  static int contarAprobados(int[] calificaciones)
  static void mostrarReporte(int[] calificaciones)
  ```

---

## Entrega de la Tarea

### Archivos Requeridos

1. **Código fuente** - `CalculadoraCalificaciones.java`
   - Programa completo y funcional
   - Compilable sin errores
   - Bien comentado

2. **Archivo de pruebas** - `pruebas.txt`
   - Una conjunto de 8 calificaciones por línea
   - Incluir casos válidos e inválidos
   - Mínimo 12 casos de prueba
   - Formato: `85, 92, 78, 88, 95, 75, 82, 90`

3. **Documentación** - `DOCUMENTACION.md` con:
   - Descripción del programa
   - Explicación de cada método
   - Flujo del programa (puede usar diagrama)
   - Instrucciones de compilación y ejecución
   - Ejemplos de salida

4. **README.md** - Archivo de descripción general (opcional pero recomendado)

### Estructura de Carpeta

```
tu-usuario/2026/POO/Tareas/
└── Tarea1_Estadisticas_Calificaciones/
    ├── CalculadoraCalificaciones.java
    ├── pruebas.txt
    ├── DOCUMENTACION.md
    └── README.md (opcional)
```

---

## Criterios de Evaluación

| Criterio                              | Puntuación | Descripción                                           |
| ------------------------------------- | ---------- | ----------------------------------------------------- |
| **Compilación y Ejecución**           | 20%        | El programa compila sin errores y ejecuta correctamente |
| **Validación de Datos**               | 20%        | Validación correcta de entrada (rango y cantidad)    |
| **Cálculos Correctos**                | 20%        | Todos los cálculos son precisos y formateados        |
| **Estructura del Código**             | 20%        | Uso adecuado de métodos, sin código duplicado        |
| **Documentación y Pruebas**           | 20%        | Código comentado, documentación clara, pruebas completas |

**Nota**: No seguir los requisitos mínimos resultará en deducción de puntos.

---

## Ejemplo de Salida Esperada

### Entrada 1: `85, 92, 78, 88, 95, 75, 82, 90`
```
╔════════════════════════════════════════════════╗
║      REPORTE DE CALIFICACIONES                 ║
╠════════════════════════════════════════════════╣
║                                                ║
║  Calificaciones ingresadas:                    ║
║  85 - 92 - 78 - 88 - 95 - 75 - 82 - 90         ║
║                                                ║
║  ─── ESTADÍSTICAS ───                          ║
║                                                ║
║  Promedio:              86.19                  ║
║  Calificación máxima:   95                     ║
║  Calificación mínima:   75                     ║
║                                                ║
║  ─── ANÁLISIS DE RESULTADOS ───                ║
║                                                ║
║  Cantidad de aprobados (≥70):   8              ║
║  Cantidad de reprobados (<70):  0              ║
║  Porcentaje de aprobados:       100.0%         ║
║                                                ║
║                                                ║
╚════════════════════════════════════════════════╝
```

### Entrada 2: `85, 92, 120, 88` (INVÁLIDA)
```
✗ ERROR DE VALIDACIÓN

Calificaciones ingresadas: 85, 92, 120, 88

Problemas detectados:
  1. Calificación fuera de rango en posición 3: 120
     → Las calificaciones deben estar entre 0 y 100

  2. Cantidad insuficiente de calificaciones: 4
     → Se requieren exactamente 8 calificaciones

Acciones:
  ✓ Intenta nuevamente
  ✓ Verifica que cada calificación esté entre 0 y 100
  ✓ Asegúrate de ingresar 8 valores separados por comas
```

---

##  Notas Importantes

- **Fecha de Entrega**: Será anunciada en clase
- **Trabajo Individual**: Esta tarea es individual. El plagio resultará en calificación de 0
- **Compilación**: Prueba que el programa compile sin errores antes de entregar
- **Pruebas**: Ejecuta con los datos del archivo `pruebas.txt` antes de entregar
- **Nombres**: Usa nombres de variables descriptivos y en español

---

## Consejos de Implementación

1. **Comienza simple**: 
   - Primero implementa lectura y almacenamiento
   - Luego añade validación
   - Finalmente, agrega los cálculos

2. **Usa métodos**:
   ```java
   // NO hagas todo en main()
   // Mejor: crea métodos separados
   public static void main(String[] args) {
       int[] calificaciones = leerCalificaciones();
       if (validarCalificaciones(calificaciones)) {
           mostrarReporte(calificaciones);
       }
   }
   ```

3. **Prueba incrementalmente**:
   - Prueba cada método por separado
   - Verifica que los cálculos sean correctos
   - Usa valores conocidos para validar

4. **Documenta tu código**:
   ```java
   // Buen ejemplo
   /**
    * Calcula el promedio de un arreglo de calificaciones
    * @param calificaciones Arreglo de enteros (0-100)
    * @return El promedio como double
    */
   static double calcularPromedio(int[] calificaciones) {
       ...
   }
   ```

---

##  Recursos Recomendados

### Java y Arreglos
- [Oracle Java Tutorials - Arrays](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/arrays.html)
- [Java Scanner Documentation](https://docs.oracle.com/javase/10/docs/api/java/util/Scanner.html)

### Técnicas de Programación
- Métodos estáticos y modularidad
- Validación de entrada
- Formatos de salida (printf)

### En el Repositorio
- Revisa la carpeta `08_Arreglos` para ejemplos
- Estudia `OperacionesArreglos.java`
- Analiza `ArreglosMultidimensionales.java` para técnicas avanzadas

---

## Preguntas Frecuentes

**P: ¿Puedo usar `ArrayList` en lugar de arreglos?**
A: No. El objetivo es practicar con arreglos primitivos. Para trabajar con colecciones dinámicas usaremos ArrayList en temas posteriores.

**P: ¿Cómo ingreso las calificaciones?**
A: Puedes:
- Ingresarlas una por una (8 veces)
- Ingresarlas separadas por comas en una sola línea
- Leerlas de un archivo
Elige el método más conveniente y documéntalo.

**P: ¿Qué hago si el usuario ingresa texto en lugar de números?**
A: Debes capturar la excepción `InputMismatchException` y pedir que ingrese nuevamente.

**P: ¿El promedio debe tener decimales?**
A: Sí. Usa `double` para los cálculos y formatea con 2 decimales en la salida.

**P: ¿Qué es la "moda" de las calificaciones?**
A: Es la calificación que aparece más frecuentemente. Es opcional calcularlo.

**P: ¿Puedo mejorar el formato de salida con caracteres especiales?**
A: Claro. Usa caracteres Unicode o ASCII art como en el ejemplo para hacer la salida más atractiva.

---

## Temas Relacionados

Este proyecto refuerza:
- Arreglos y bucles
- Métodos y modularidad
- Validación de datos
- Operaciones matemáticas
- Manejo de errores
- Formato de salida

---

**Versión**: 1.0  
**Última actualización**: Mayo 2026  
**Creado por**: Ingeniero Ricardo Toro  
**Adaptado para**: Curso de Programación Orientada a Objetos - UNAH 2026
