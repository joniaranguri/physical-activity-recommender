package model.recomendacion;

import model.actividades.Actividad;

import java.util.List;

import static java.util.Collections.emptyList;

public class Recomendacion {
	
	public List<Actividad> actividades;
	public Tiempo tiempo;

	public Recomendacion(Tiempo tiempo, List<Actividad> actividades) {
		this.tiempo = tiempo;
		this.actividades = actividades;
	}

	public List<Actividad> getActividades() {
		return actividades;
	}

	public void setActividades(List<Actividad> actividades) {
		this.actividades = actividades;
	}

	public Tiempo getTiempo() {
		return tiempo;
	}

	public void setTiempo(Tiempo tiempo) {
		this.tiempo = tiempo;
	}

	public boolean sinActividades(){
		return this.actividades.isEmpty();
	}

	@Override
	public String toString() {
		return "Recomendacion{" +
				"actividades=" + actividades +
				", tiempo=" + tiempo +
				'}';
	}
}
