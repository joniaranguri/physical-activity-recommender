package utils;

import model.actividades.Actividad;
import model.recomendacion.Recomendacion;
import model.recomendacion.Tiempo;
import org.junit.Assert;

import java.util.List;

public class TestCaseUtils {

    ////////////////TEST CASES UTILS ////////////////

    public static void print(Object object) {
        System.out.println(object);
    }

    public static void println(Object object) {
        System.out.println("\n" + object);
    }


    public static void print() {
        print("");
    }

    public static void assertResults(Recomendacion recomendacion, List<Actividad> actividadesEsperadas, Tiempo tiempoEsperado) {
        Tiempo tiempoResultado = recomendacion.getTiempo();
        List<Actividad> actividadesResultado = recomendacion.getActividades();

        actividadesResultado.sort(Actividad::compareTo);
        actividadesEsperadas.sort(Actividad::compareTo);

        println("Resultados");

        printResults(tiempoEsperado.toString(), tiempoResultado.toString());
        assert (tiempoResultado.isa(tiempoEsperado));

        assertActivitiesResult(actividadesEsperadas, actividadesResultado);
    }

    private static void printResults(String expected, String result) {
        println("Esperaba: " + expected);
        print("Recibi: " + result);
        Boolean isOk = result.equals(expected);
        String condition = isOk ? "Ok" : "Fallo";
        print("Caso de prueba: " + condition);
    }

    private static void assertActivitiesResult(List<Actividad> actividadesEsperadas, List<Actividad> actividadesResultado) {
        println("Actividades Esperadas:");
        for (Actividad actividad : actividadesEsperadas) {
            print(actividad.toString());
        }

        println("Actividades Resultantes:");
        for (Actividad actividad : actividadesResultado) {
            print(actividad.toString());
        }

        for (int i = 0; i < actividadesEsperadas.size(); i++) {
            boolean currentCheck = actividadesEsperadas.get(i).toString().equals(actividadesResultado.get(i).toString());
            if (!currentCheck) {
                print("Caso de prueba: Fallo");
            }
            Assert.assertTrue(currentCheck);
        }
        print("Caso de prueba: Ok");
    }
}
