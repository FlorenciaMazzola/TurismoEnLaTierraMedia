package turismo;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Usuario {
	private String nombre;
	private TipoAtracciones tipoAtraccionPreferida;
	private double presupuesto;
	private double tiempoDisponible;
	
	
	//sobre estas lista se crea el itinerario
	private List<Atraccion> itinerarioAtracciones=new ArrayList<Atraccion>();
	private List<Atraccion> itinerarioPromo=new ArrayList<Atraccion>();
	private double costoTotalItinerario;//este es el costo que sale todas las atracciones y promosciones
	private double tiempoNecesarioItinerario;

	public Usuario(String nombre,TipoAtracciones tipoAtraccionPreferida, double presupuesto, double tiempoDisponible) {
		if (presupuesto > 0 && tiempoDisponible > 0) {
			this.nombre = nombre;
			this.presupuesto = presupuesto;
			this.tiempoDisponible = tiempoDisponible;
			this.tipoAtraccionPreferida = tipoAtraccionPreferida;
		} else {
			System.out.println("Datos invalidos ingresados");
		}

	}

	public TipoAtracciones getTipoAtraccionPreferida() {
		return tipoAtraccionPreferida;
	}

	public double getPresupuesto() {
		return presupuesto;
	}

	public double getTiempoDisponible() {
		return tiempoDisponible;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String usuarioNombre) {
		this.nombre = usuarioNombre;

	}
	
	public void aceptarPromo(List<Atraccion> promo, double costoPromo) throws IOException {
		for(int i=0;i<promo.size();i++) {
			this.tiempoDisponible -= promo.get(i).getTiempo();
			promo.get(i).recibirPersona();
			this.tiempoNecesarioItinerario += promo.get(i).getTiempo();
			itinerarioPromo.add(promo.get(i));
			
		}
		this.presupuesto -= costoPromo;
		this.costoTotalItinerario += costoPromo;
		
		System.out.println("Promocion Aceptada");
	}
	
	
	
	
	public void aceptarAtraccion(Atraccion atraccionAceptada) throws IOException {
		List<Atraccion> lista = new ArrayList<Atraccion>();
		this.presupuesto -= atraccionAceptada.getCosto();
		this.tiempoDisponible -= atraccionAceptada.getTiempo();
		atraccionAceptada.recibirPersona();
		this.costoTotalItinerario += atraccionAceptada.getCosto();
		this.tiempoNecesarioItinerario += atraccionAceptada.getTiempo();
		this.itinerarioAtracciones.add(atraccionAceptada);
		
		System.out.println("Atraccion "+ atraccionAceptada.getNombre()+" aceptada");
		
		PrintWriter salida = new PrintWriter(new FileWriter("ArchiSalida.txt"));

		salida.println("	Atracciones sugeridas segun el gusto de "+ this.nombre);
		salida.println("															");
		
		for(int i = 0; i < itinerarioPromo.size(); i++) {
			salida.println("Pack " + itinerarioPromo.get(i).toString() );
		}
		salida.println("Atraccion aceptada: ");
		for (int i = 0; i < itinerarioAtracciones.size(); i++) {
			salida.println(itinerarioAtracciones.get(i).getNombre());
			salida.println("Costo:" + itinerarioAtracciones.get(i).getCosto() + " Tiempo:"
					+ itinerarioAtracciones.get(i).getTiempo());
		}

		
		salida.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");		
		salida.close();
		
		
	}

	@Override
	public String toString() {
		return "Usuario [tipoAtraccionPreferida=" + tipoAtraccionPreferida + ", presupuesto=" + presupuesto
				+ ", tiempoDisponible=" + tiempoDisponible + "]";
	}

}
