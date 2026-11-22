public class EmpleadoRRHH extends TrabajadorCorporativo {

    public EmpleadoRRHH(String nombre, double sueldoBase) {
        super(nombre, sueldoBase);
    }

    @Override
    public double calcularBonoAnual() {

        double sueldoAnual = sueldoBase * 12;

        return sueldoAnual * 0.10;
    }
}