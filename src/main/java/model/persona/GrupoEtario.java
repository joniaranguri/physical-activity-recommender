package model.persona;

import java.util.Objects;

public enum GrupoEtario {
    NoDeterminado,
    Joven,
    Adolescente,
    Adulto,
    TerceraEdad;

    public Boolean isa(GrupoEtario grupoEtario) {
        return Objects.equals(this.toString(), grupoEtario.toString());
    }
}
