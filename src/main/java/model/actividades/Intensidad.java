package model.actividades;

import java.util.Objects;

public enum Intensidad {
    NoDeterminado,
    Intensa,
    Moderada,
    Recreacional;

    public Boolean isa(Intensidad intensidad) {
        return Objects.equals(this.toString(), intensidad.toString());
    }
}
