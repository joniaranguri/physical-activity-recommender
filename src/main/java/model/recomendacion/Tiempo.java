package model.recomendacion;

import java.util.Objects;

public enum Tiempo {
    NoDeterminado,
    Minimo60MinutosPorDia,
    Minimo150MinutosPorSemana,
    Entre150Y300MinutosPorSemana;

    public Boolean isa(Tiempo tiempo) {
        return Objects.equals(this.toString(), tiempo.toString());
    }
}
