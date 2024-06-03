package forward;

import model.actividades.Actividad;
import model.actividades.Intensidad;
import model.persona.Persona;
import model.recomendacion.Recomendacion;
import model.recomendacion.Tiempo;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import utils.KnowledgeSessionHelper;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static utils.TestCaseUtils.assertResults;
import static utils.TestCaseUtils.print;

public class ForwardActivityRecommenderTests {
    String K_SESSION_NAME = "kforward-chaining-session";

    KieSession sessionStatefull;
    static KieContainer kieContainer;

    public ForwardActivityRecommenderTests() {
    }

    @BeforeClass
    public static void beforeallTestSetup() {
        kieContainer = KnowledgeSessionHelper.createRuleBase();
    }

    private void prepareKnowledgeSession() {
        sessionStatefull = KnowledgeSessionHelper.getStatefulKnowledgeSessionWithCallback(kieContainer, K_SESSION_NAME);
    }

    @Before
    public void setUp() {
        print("----------Start----------");
        print();
        this.prepareKnowledgeSession(); // Inicializa una nueva base de hechos
    }

    @After
    public void tearDown() {
        print();
        print("----------End----------");
        print();
    }

    @Test
    public void personaJovenTest() {
        print("Caso de prueba: Persona joven");
        Persona persona = new Persona();
        persona.setEdad(7);
        print(persona);
        Tiempo tiempoEsperado = Tiempo.Minimo60MinutosPorDia;
        List<Actividad> actividadesEsperadas = Arrays.asList(
                new Actividad(Actividad.Nombre.Jardineria, Intensidad.Recreacional),
                new Actividad(Actividad.Nombre.Paseos, Intensidad.Recreacional),
                new Actividad(Actividad.Nombre.CaminarRitmoSuave, Intensidad.Recreacional));

        sessionStatefull.insert(persona);
        sessionStatefull.fireAllRules();

        Recomendacion recomendacion = persona.getRecomendacion();

        assertResults(recomendacion, actividadesEsperadas, tiempoEsperado);
    }

    @Test
    public void personaAdolescenteTest() {
        print("Caso de prueba: Persona adolescente");
        Persona persona = new Persona();
        persona.setEdad(15);
        print(persona);
        Tiempo tiempoEsperado = Tiempo.Minimo60MinutosPorDia;
        List<Actividad> actividadesEsperadas = Arrays.asList(
                new Actividad(Actividad.Nombre.Correr, Intensidad.Intensa),
                new Actividad(Actividad.Nombre.Nadar, Intensidad.Intensa),
                new Actividad(Actividad.Nombre.BailarConBuenRitmo, Intensidad.Intensa),
                new Actividad(Actividad.Nombre.Futbol, Intensidad.Intensa),
                new Actividad(Actividad.Nombre.Voley, Intensidad.Intensa),
                new Actividad(Actividad.Nombre.Hockey, Intensidad.Intensa),
                new Actividad(Actividad.Nombre.Basquetbol, Intensidad.Intensa));

        sessionStatefull.insert(persona);
        sessionStatefull.fireAllRules();

        Recomendacion recomendacion = persona.getRecomendacion();

        assertResults(recomendacion, actividadesEsperadas, tiempoEsperado);
    }

    @Test
    public void personaAdultaTest() {
        print("Caso de prueba: Persona adulta");
        Persona persona = new Persona();
        persona.setEdad(18);
        print(persona);
        Tiempo tiempoEsperado = Tiempo.Minimo150MinutosPorSemana;
        List<Actividad> actividadesEsperadas = Arrays.asList(
                new Actividad(Actividad.Nombre.CaminarRitmoNormal, Intensidad.Moderada),
                new Actividad(Actividad.Nombre.Trotar, Intensidad.Moderada),
                new Actividad(Actividad.Nombre.BailarSuave, Intensidad.Moderada));

        sessionStatefull.insert(persona);
        sessionStatefull.fireAllRules();

        Recomendacion recomendacion = persona.getRecomendacion();

        assertResults(recomendacion, actividadesEsperadas, tiempoEsperado);
    }

    @Test
    public void personaTerceraEdadTest() {
        print("Caso de prueba: Persona tercera edad");
        Persona persona = new Persona();
        persona.setEdad(65);
        print(persona);
        Tiempo tiempoEsperado = Tiempo.Entre150Y300MinutosPorSemana;
        List<Actividad> actividadesEsperadas = Arrays.asList(
                new Actividad(Actividad.Nombre.CaminarRitmoNormal, Intensidad.Moderada),
                new Actividad(Actividad.Nombre.Trotar, Intensidad.Moderada),
                new Actividad(Actividad.Nombre.BailarSuave, Intensidad.Moderada));

        sessionStatefull.insert(persona);
        sessionStatefull.fireAllRules();

        Recomendacion recomendacion = persona.getRecomendacion();

        assertResults(recomendacion, actividadesEsperadas, tiempoEsperado);
    }

    @Test
    public void personaInfanteTest() {
        print("Caso de prueba: Persona Infante");
        Persona persona = new Persona();
        persona.setEdad(2);
        print(persona);
        Tiempo tiempoEsperado = Tiempo.NoDeterminado;
        List<Actividad> actividadesEsperadas = Collections.emptyList();

        sessionStatefull.insert(persona);
        sessionStatefull.fireAllRules();

        Recomendacion recomendacion = persona.getRecomendacion();

        assertResults(recomendacion, actividadesEsperadas, tiempoEsperado);
    }

    @Test(expected = IllegalArgumentException.class)
    public void edadNegativaTest() {
        print("Caso de prueba: Persona con edad negativa");
        Persona persona = new Persona();

        persona.setEdad(-2);
    }
}
