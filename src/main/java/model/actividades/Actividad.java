package model.actividades;

import java.util.Objects;

public class Actividad implements Comparable<Actividad> {

    Nombre nombre;
    Intensidad intensidad;

    public Actividad(Nombre nombre, Intensidad intensidad) {
        this.nombre = nombre;
        this.intensidad = intensidad;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public void setNombre(Nombre nombre) {
        this.nombre = nombre;
    }

    public Intensidad getIntensidad() {
        return intensidad;
    }

    public void setIntensidad(Intensidad intensidad) {
        this.intensidad = intensidad;
    }

    @Override
    public String toString() {
        return "Actividad{" +
                "nombre=" + nombre +
                ", intensidad=" + intensidad +
                '}';
    }

    @Override
    public int compareTo(Actividad otraActividad) {
        int nombreComparison = this.nombre.compareTo(otraActividad.getNombre());
        if (nombreComparison != 0) {
            return nombreComparison;
        }
        return this.intensidad.compareTo(otraActividad.getIntensidad());
    }

    public enum Nombre {
        NoDeterminado,
        /** Moderadas **/
        CaminarRitmoNormal,
        Trotar,
        BailarSuave,

        /** Intensas **/
        Correr,
        Nadar,
        BailarConBuenRitmo,
        Futbol,
        Voley,
        Hockey,
        Basquetbol,

        /** Recreacionales **/
        CaminarRitmoSuave,
        Paseos,
        Jardineria;

        public Boolean isa(Nombre nombre) {
            return Objects.equals(this.toString(), nombre.toString());
        }
    }
}
