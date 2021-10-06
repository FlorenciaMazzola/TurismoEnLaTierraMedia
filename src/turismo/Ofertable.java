package turismo;

public interface Ofertable {
	
	public String getNombre();
	
	public double getCosto();
	
	public double getTiempo();
	
	public boolean esPromocion();
	
	public TipoAtracciones getTipoAtraccion();
}
