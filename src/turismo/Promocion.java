package turismo;

import java.util.Collection;
import java.util.List;


public abstract class Promocion implements Ofertable {
	protected List<Atraccion> atraccionesPromocion;
	
	protected double costoTotal; //
	protected String nombrePromocion; //
	protected TipoAtracciones tipoAtracciones;
	protected String tipoPromocion; //
	//protected double costo;
	protected double tiempoRequeridoPromocion; //

	protected String atraccion1;
	protected String atraccion2;
	protected String atraccion3;
	protected double descuento;
	
	private Usuario usuario;

	protected List<Promocion> listaPromocion;
	
	public Promocion(String nombrePromocion,TipoAtracciones tipoAtracciones, String tipoPromocion,
			String atraccion1, String atraccion2) {
		this.nombrePromocion = nombrePromocion;
		this.tipoAtracciones = tipoAtracciones;
		this.tipoPromocion = tipoPromocion;
		this.atraccion1=atraccion1;
		this.atraccion2=atraccion2;
		
	}
	
	public Promocion(String nombrePromocion,TipoAtracciones tipoAtracciones, String tipoPromocion,
			String atraccion1, String atraccion2, String atraccion3) {
		this.nombrePromocion = nombrePromocion;
		this.tipoAtracciones = tipoAtracciones;
		this.tipoPromocion = tipoPromocion;
		this.atraccion1=atraccion1;
		this.atraccion2=atraccion2;
		this.atraccion3=atraccion3;	
	}
	
	public Promocion(String nombrePromocion,TipoAtracciones tipoAtracciones, String tipoPromocion,
			String atraccion1, String atraccion2, double descuento) {
		this.nombrePromocion = nombrePromocion;
		this.tipoAtracciones = tipoAtracciones;
		this.tipoPromocion = tipoPromocion;
		this.atraccion1=atraccion1;
		this.atraccion2=atraccion2;
		this.descuento=descuento;	
	}
		
	@Override
	public String getNombre() {
		return nombrePromocion;
	}
	
	@Override
	public double getCosto() {
		return costoTotal;
	}

	public String getTipoPromocion() {
		return tipoPromocion;
	}
	@Override
	public double getTiempo() {
		return tiempoRequeridoPromocion;
	}
	
	@Override
	public boolean esPromocion() {
		return true;
	}
	
	@Override
	public TipoAtracciones getTipoAtraccion() {
		return tipoAtracciones;
	}

	public abstract List<Atraccion> calcularPromocion(List<Atraccion> atracciones);
	
	public abstract double calcularCosto(List<Atraccion> atracciones);
	
	public abstract double calcularTiempo(List<Atraccion> atracciones);
}
