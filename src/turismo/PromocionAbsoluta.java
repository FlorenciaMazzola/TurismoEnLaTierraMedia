package turismo;

import java.util.ArrayList;
import java.util.List;

public class PromocionAbsoluta extends Promocion  {
	public PromocionAbsoluta(String nombrePromocion,TipoAtracciones tipoAtracciones, String tipoPromocion,
			String atraccion1, String atraccion2, double descuento) {
		super(nombrePromocion,tipoAtracciones,tipoPromocion, atraccion1, atraccion2, descuento);		
	}
	
	
	@Override
	public List<Atraccion> calcularPromocion(List<Atraccion> atracciones) {
		atraccionesPromocion = new ArrayList();	
		for(int i=0 ; i<atracciones.size(); i++) {
			if(atracciones.get(i).getNombre().equals(atraccion1)||
					atracciones.get(i).getNombre().equals(atraccion2)) {	
				atraccionesPromocion.add(atracciones.get(i));
			}
		}
		return atraccionesPromocion;
	}
	
	@Override
	public double calcularCosto(List<Atraccion> atracciones) {
		for(int i=0 ; i<atracciones.size(); i++) {
			if(atracciones.get(i).getNombre().equals(atraccion1)||atracciones.get(i).getNombre().equals(atraccion2)) {	
				
				costoTotal += atracciones.get(i).getCosto();
			}
		}		
		costoTotal -= this.descuento; 
		return costoTotal;
	}


	@Override
	public double calcularTiempo(List<Atraccion> atracciones) {
		for(int i=0 ; i<atracciones.size(); i++) {
			if(atracciones.get(i).getNombre().equals(atraccion1)||atracciones.get(i).getNombre().equals(atraccion2)) {	
				
				tiempoRequeridoPromocion += atracciones.get(i).getTiempo();
			}
		}	
		return tiempoRequeridoPromocion;
	}
	
	@Override
	public String toString() {
		return  "Promocion [nombrePromocion=" + nombrePromocion + ", tipoPromocion=" + tipoPromocion
				+ ", atraccion1=" + atraccion1 + ", atraccion2=" + atraccion2 + ", descuento=" + descuento +"]";
	}
	
	/*
	@Override
	public List<Atraccion> calcularPromocion(List<Atraccion> atracciones, Usuario usuario ) {
		atraccionesPromocion= new ArrayList();
				
		for(int i=0 ; i<atracciones.size(); i++) {
			if(atracciones.get(i).getNombre().equals(atraccion1)||
					atracciones.get(i).getNombre().equals(atraccion2)) {
			
				atraccionesPromocion.add(atracciones.get(i));
			}
		}
		
		costoTotal = (atraccionesPromocion.get(0).getCosto()+
				atraccionesPromocion.get(1).getCosto())-
				(atraccionesPromocion.get(0).getCosto()/3
						+atraccionesPromocion.get(1).getCosto()/3);
		
		tiempoRequeridoPromocion = atraccionesPromocion.get(0).getPromedioTiempo()+atraccionesPromocion.get(1).getPromedioTiempo();
		
		if(usuario.getTiempoDisponible() >= tiempoRequeridoPromocion && usuario.getPresupuesto()>=costoTotal ) {
		System.out.println("Atraccion "+atraccionesPromocion.get(0).getNombre());
		System.out.println("Atraccion "+atraccionesPromocion.get(1).getNombre());
		System.out.println("el costo es de "+costoTotal);
		System.out.println("el tiempo requerido es de " +tiempoRequeridoPromocion);
		}
		
		return atraccionesPromocion;
	}*/

}
