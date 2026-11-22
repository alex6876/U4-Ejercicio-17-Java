public class LiquidadorSueldos {

    public void liquidarSueldo(TrabajadorCorporativo trabajador) {

        double sueldoAnual = trabajador.getSueldoBase() * 12;

        double bono = trabajador.calcularBonoAnual();

        double total = sueldoAnual + bono;

        System.out.println("=== LIQUIDACION SALARIAL ===");
        System.out.println("Empleado: " + trabajador.getNombre());
        System.out.println("Sueldo anual: $" + sueldoAnual);
        System.out.println("Bono anual: $" + bono);
        System.out.println("Total a cobrar: $" + total);
        System.out.println("-------------------------");
    }
}