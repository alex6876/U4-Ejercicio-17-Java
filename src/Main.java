public class Main {

    public static void main(String[] args) {

        LiquidadorSueldos liquidador = new LiquidadorSueldos();

        TrabajadorCorporativo ventas =
                new EmpleadoVentas("Carlos", 100000);

        TrabajadorCorporativo sistemas =
                new EmpleadoSistemas("Martin", 150000);

        TrabajadorCorporativo rrhh =
                new EmpleadoRRHH("Laura", 120000);

        liquidador.liquidarSueldo(ventas);

        liquidador.liquidarSueldo(sistemas);

        liquidador.liquidarSueldo(rrhh);
    }
}