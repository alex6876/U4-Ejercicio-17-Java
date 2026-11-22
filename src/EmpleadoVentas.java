public class EmpleadoVentas extends TrabajadorCorporativo {

    public EmpleadoVentas(String nombre, double sueldoBase) {
        super(nombre, sueldoBase);
    }

    @Override
    public double calcularBonoAnual() {

        double sueldoAnual = sueldoBase * 12;

        return sueldoAnual * 0.15;
    }
}