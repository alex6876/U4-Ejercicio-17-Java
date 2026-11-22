# Simulación de Liquidación de Sueldos y Bonos Corporativos (Clases Abstractas y Polimorfismo en Java)

Este proyecto es una aplicación en Java que modela un sistema de liquidación salarial anual, implementando una arquitectura basada en clases abstractas y herencia para administrar distintos perfiles de trabajadores corporativos (ventas, sistemas y recursos humanos) con porcentajes diferenciados de bonificación anual calculados sobre su remuneración base. Pone en práctica conceptos fundamentales de la Programación Orientada a Objetos (POO) como la generalización de atributos protegidos (`protected`), el uso de constructores mediante `super`, la definición de métodos abstractos (`abstract`), la sobrescritura polimórfica de comportamiento (`@Override`), el encapsulamiento mediante métodos de consulta y el procesamiento desacoplado en memoria sin persistencia en base de datos.

---

## Clases y Estructura del Sistema

El diseño del software se organiza a través de una clase base abstracta, sus respectivas subclases especializadas por área, un componente liquidador y un punto de ejecución:

* **`TrabajadorCorporativo` (Clase Abstracta)**: Centraliza los atributos y el contrato común para cualquier colaborador dentro de la organización.
* **Atributos protegidos (`protected`)**: `nombre` y `sueldoBase`, accesibles directamente por las subclases para gestionar la identidad y calcular bonificaciones.
* **Constructor**: Inicializa `nombre` y `sueldoBase`.
* **Métodos operativos**:
* `abstract double calcularBonoAnual()`: Método abstracto que obliga a cada tipo de empleado a definir su propia regla para calcular el bono anual.
* `getNombre()` / `getSueldoBase()`: Métodos de acceso público para consultar de forma encapsulada el nombre y el sueldo base del trabajador.




* **`EmpleadoVentas`**: Extiende de `TrabajadorCorporativo` para modelar el perfil comercial.
* **Constructor**: Invoca a `super(nombre, sueldoBase)` para inicializar los datos base del empleado.
* **Sobrescritura (`@Override`)**:
* `calcularBonoAnual()`: Calcula el sueldo anual (`sueldoBase * 12`) y retorna el `15%` (`sueldoAnual * 0.15`).




* **`EmpleadoSistemas`**: Extiende de `TrabajadorCorporativo` para modelar el perfil tecnológico.
* **Constructor**: Utiliza `super(nombre, sueldoBase)` para asignar los atributos heredados.
* **Sobrescritura (`@Override`)**:
* `calcularBonoAnual()`: Calcula el sueldo anual (`sueldoBase * 12`) y retorna el `20%` (`sueldoAnual * 0.20`).




* **`EmpleadoRRHH`**: Extiende de `TrabajadorCorporativo` para modelar el perfil de gestión de talento y personas.
* **Constructor**: Llama a `super(nombre, sueldoBase)` para configurar nombre y sueldo base.
* **Sobrescritura (`@Override`)**:
* `calcularBonoAnual()`: Calcula el sueldo anual (`sueldoBase * 12`) y retorna el `10%` (`sueldoAnual * 0.10`).




* **`LiquidadorSueldos`**: Componente controlador encargado de consolidar la remuneración anual y el bono de cada trabajador.
* **Método operativo**: `liquidarSueldo(TrabajadorCorporativo trabajador)`: Recibe polimórficamente cualquier instancia de `TrabajadorCorporativo`, calcula el sueldo anual a doce meses, invoca dinámicamente `calcularBonoAnual()`, suma ambos importes e imprime el detalle de liquidación por consola.


* **`Main`**: Punto de entrada del programa. Instancia `LiquidadorSueldos`, crea trabajadores de ventas, sistemas y recursos humanos referenciados como `TrabajadorCorporativo` y ejecuta `liquidarSueldo(...)` para cada uno.

---

## Reglas de Negocio y Control de Validación

* **Contrato Estricto de Bonificación:** Mediante la clase abstracta `TrabajadorCorporativo`, cualquier nuevo perfil laboral que se incorpore al sistema debe implementar obligatoriamente `calcularBonoAnual()`.
* **Porcentajes Diferenciados por Área:** Cada subclase encapsula su propio porcentaje sobre el ingreso anual proyectado a doce meses (`15%` para ventas, `20%` para sistemas y `10%` para recursos humanos), evitando condicionales centralizados en el liquidador.
* **Desacoplamiento mediante Polimorfismo:** `LiquidadorSueldos` opera exclusivamente sobre la abstracción `TrabajadorCorporativo`, resolviendo en tiempo de ejecución el cálculo de bono correspondiente a cada empleado.

---

## Salida por Consola

Al ejecutar la clase `Main`, el programa genera el siguiente resultado:

```text
=== LIQUIDACION SALARIAL ===
Empleado: Carlos
Sueldo anual: $1200000.0
Bono anual: $180000.0
Total a cobrar: $1380000.0
-------------------------
=== LIQUIDACION SALARIAL ===
Empleado: Martin
Sueldo anual: $1800000.0
Bono anual: $360000.0
Total a cobrar: $2160000.0
-------------------------
=== LIQUIDACION SALARIAL ===
Empleado: Laura
Sueldo anual: $1440000.0
Bono anual: $144000.0
Total a cobrar: $1584000.0
-------------------------

```

---

## Conceptos de Programación Aplicados

* **Abstracción y Polimorfismo:** Uso de una clase abstracta y sobrescritura de métodos (`@Override`) para calcular bonos diferenciados bajo una misma referencia.
* **Herencia y Encapsulamiento:** Reutilización de atributos protegidos y constructores mediante `super`, exponiendo valores mediante métodos `getNombre()` y `getSueldoBase()`.
* **Separación de Responsabilidades:** División clara entre las reglas de bonificación de cada perfil, la lógica de liquidación en `LiquidadorSueldos` y la ejecución de casos de prueba en `Main`.
