package model.persona;

import model.recomendacion.Recomendacion;
import model.recomendacion.Tiempo;

import java.util.ArrayList;
import java.util.Collections;

public class Persona {

    public static int MIN_EDAD = 0;

    public int edad;
    public GrupoEtario grupo;
    public Recomendacion recomendacion;

    public Persona() {
        this.edad = 0;
        this.grupo = GrupoEtario.NoDeterminado;
        this.recomendacion = new Recomendacion(Tiempo.NoDeterminado, new ArrayList<>());
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        if (edad < MIN_EDAD) {
            throw new IllegalArgumentException("edad: minimo valor permitido " + MIN_EDAD);
        }
        this.edad = edad;
    }

    public GrupoEtario getGrupo() {
        return grupo;
    }

    public void setGrupo(GrupoEtario grupo) {
        this.grupo = grupo;
    }

    public Recomendacion getRecomendacion() {
        return recomendacion;
    }

    public void setRecomendacion(Recomendacion recomendacion) {
        this.recomendacion = recomendacion;
    }


    @Override
    public String toString() {
        return "Persona{" +
                "edad=" + edad +
                ", grupo=" + grupo +
                ", recomendacion=" + recomendacion +
                '}';
    }
}
