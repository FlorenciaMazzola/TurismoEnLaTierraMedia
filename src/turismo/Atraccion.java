package turismo;

import java.util.Objects;

public class Atraccion implements Ofertable, Comparable <Atraccion>{
	private String nombre;//
	private double costo; //
	private double promedioTiempo; //
	private int cupoPersonas;
	private TipoAtracciones tipoAtracciones;//
	

	public Atraccion(String nombre, double costo, double promedioTiempo, int cupoPersonas,
			TipoAtracciones tipoAtracciones) {
		if (costo > 0 && promedioTiempo > 0 && cupoPersonas > 0) {
			this.nombre = nombre;
			this.costo = costo;
			this.promedioTiempo = promedioTiempo;
			this.cupoPersonas = cupoPersonas;
			this.tipoAtracciones = tipoAtracciones;
		}

	}

	@Override
	public  String getNombre() {
		return nombre;
	}

	@Override
	public double getCosto() {
		return costo;
	}
	
	@Override
	public double getTiempo() {
		return promedioTiempo;
	}
	
	@Override
	public boolean esPromocion() {
		return false;
	}
	
	@Override
	public TipoAtracciones getTipoAtraccion() {
		return tipoAtracciones;
	}

	public int getCupoPersonas() {
		return cupoPersonas;
	}

	public void recibirPersona() {// estaba como int, pero solamente tiene que restar un cupo del total, no
									// devolver nada
		cupoPersonas -= 1;
		// return cupoPersonas;
	}

	public boolean hayCupo() {
		return this.cupoPersonas > 0;
	}

	public TipoAtracciones getTipoAtracciones() {
		return tipoAtracciones;
	}

	@Override
	public String toString() {
		return "Atraccion [nombre=" + nombre + 
				", costo=" + costo + ", promedioTiempo=" +
				promedioTiempo+ ", cupoPersonas=" + cupoPersonas + 
				", tipoAtracciones=" + tipoAtracciones + "Descuento="+ "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(costo, cupoPersonas, nombre, promedioTiempo, tipoAtracciones);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Atraccion other = (Atraccion) obj;
		return costo == other.costo && cupoPersonas == other.cupoPersonas && Objects.equals(nombre, other.nombre)
				&& Double.doubleToLongBits(promedioTiempo) == Double.doubleToLongBits(other.promedioTiempo)
				&& tipoAtracciones == other.tipoAtracciones;
	}

	@Override
	public int compareTo(Atraccion atraccion) {
		int orden = 1;
		boolean esMayor = (this.getCosto() > atraccion.getCosto());
		if (esMayor) {
			orden = -1;
		} else if (this.getCosto() == atraccion.getCosto()) {
			if (this.getTiempo() > atraccion.getTiempo()) {
				orden = -1;
			} else if (this.getTiempo() == atraccion.getTiempo()) {
				orden = 0;
			} else {
				orden = 1;
			}
		}
		return orden;
	}

	
}
