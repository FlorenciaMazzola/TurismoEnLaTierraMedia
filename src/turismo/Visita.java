package turismo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Visita implements Comparator<Ofertable> {
	TipoAtracciones Aventura = TipoAtracciones.AVENTURA;
	TipoAtracciones Paisaje = TipoAtracciones.PAISAJE;
	TipoAtracciones Degustacion = TipoAtracciones.DEGUSTACION;
	protected List<Usuario> listaUsuarios;
	protected List<Atraccion> listaAtracciones;
	protected List<Promocion> listaPromociones;
	protected List<Promocion> promoSugerida;
	protected List<Atraccion> preferencias;
	protected List<Atraccion> preferenciasPromos;
	
	public Visita(List<Usuario> listaUsuarios, List<Atraccion> listaAtracciones, List<Promocion> listaPromociones) {
		this.listaUsuarios = listaUsuarios;
		this.listaAtracciones = listaAtracciones;
		this.listaPromociones = listaPromociones;
	}

	
	public List<Promocion> getPromociones(){		
		return listaPromociones;		
	}
	
	public List<Usuario> getUsuarios(){		
		return listaUsuarios;		
	}
	public List<Atraccion> getAtraccionArray() {
		return listaAtracciones;
	}
	
	public List<Atraccion> getPreferencias() {
		return preferencias;
	}
	
	public List<Promocion> getPromoSugerida() {
		return promoSugerida;
	}

	// Odena las atracciones por Costo, en caso de igual costo por la de mayor
	// duraciï¿½n
	public void ordenarAtracciones(List<Atraccion> atracciones) {
		Collections.sort(listaAtracciones);
	}

	
	public List<Atraccion> obtenerPromocionGustoUsuario(Usuario usuario){
	//	List<Promocion> promoAbsoluta = new ArrayList<Promocion>();
	//	List<Promocion> promoAxB = new ArrayList<Promocion>();
	//	List<Promocion> promoprocentual = new ArrayList<Promocion>();
		
		for(int i=0; i<listaPromociones.size(); i++) {
			
			if(listaPromociones.get(i).getTipoAtraccion()== usuario.getTipoAtraccionPreferida()) {
				System.out.println("--------------------------------------------------------");
				System.out.println("Promoción: "+listaPromociones.get(i).getNombre());
				System.out.println("Tipo: " +listaPromociones.get(i).getTipoPromocion());
				System.out.println("Lista de atracciones de la promocion: "+ listaPromociones.get(i).calcularPromocion(listaAtracciones));
				System.out.println("Costo de la promoción: "+listaPromociones.get(i).calcularCosto(listaAtracciones));
				System.out.println("Tiempo requerido: "+listaPromociones.get(i).calcularTiempo(listaAtracciones));
			} 
			
		}
		
		
		return null;
	}
	

	public List<Atraccion> darSugerenciaPorGusto(Usuario usuario ) {

		List<Atraccion> preferencias = new ArrayList<Atraccion>();

		for (Atraccion atraccion : listaAtracciones) {// recorrer toda la lista de atracciones disponibles
			if (atraccion.getTipoAtracciones() == usuario.getTipoAtraccionPreferida()
					&& atraccion.getCosto() <= usuario.getPresupuesto()
					&& atraccion.getTiempo() <= usuario.getTiempoDisponible()) {
				preferencias.add(atraccion);
			}
		}
		System.out.println(preferencias);
		return preferencias;
	}
	
	//sugerencia basado en que no sean de su preferencia
	public List<Atraccion> darSugerenciaQueNoSeaDeSuGustoPeroQuePuedaUsarla(Usuario usuario) {

		List<Atraccion> preferencias = new ArrayList<Atraccion>();

		for (Atraccion atraccion : listaAtracciones) {// recorrer toda la lista de atracciones disponibles
			if (atraccion.getTipoAtracciones() != usuario.getTipoAtraccionPreferida()
					&& atraccion.getCosto() <= usuario.getPresupuesto()
					&& atraccion.getTiempo() <= usuario.getTiempoDisponible()) {
				preferencias.add(atraccion);
			}
		}
		System.out.println(preferencias);
		return preferencias;
	}

	public List<Atraccion> obtenerPromocionQueNoSeaDelGustoUsuario(Usuario usuario){
			for(int i=0; i<listaPromociones.size(); i++) {
				
				if(listaPromociones.get(i).getTipoAtraccion()!= usuario.getTipoAtraccionPreferida()) {
					System.out.println("--------------------------------------------------------");
					System.out.println("Promoción: "+listaPromociones.get(i).getNombre());
					System.out.println("Tipo: " +listaPromociones.get(i).getTipoPromocion());
					System.out.println("Lista de atracciones de la promocion: "+ listaPromociones.get(i).calcularPromocion(listaAtracciones));
					System.out.println("Costo de la promoción: "+listaPromociones.get(i).calcularCosto(listaAtracciones));
					System.out.println("Tiempo requerido: "+listaPromociones.get(i).calcularTiempo(listaAtracciones));
				} 			
			}
				
			return null;
		}
	
	//Estan comentada cada una de las llamadas para ir probando la funcionalidad de cada una
	public void armarPropuesta(List<Usuario> listausuarios){
		for (Usuario usuario:  listaUsuarios ) {
			System.out.println("==============================");
			System.out.println("Usuario: "+usuario.getNombre());
			this.obtenerPromocionGustoUsuario(usuario);
			//this.darSugerenciaPorGusto(usuario);
			//this.obtenerPromocionQueNoSeaDelGustoUsuario(usuario);
			//this.darSugerenciaQueNoSeaDeSuGustoPeroQuePuedaUsarla(usuario);
			
		}	
	}


	@Override
	public int compare(Ofertable o1, Ofertable o2) {
		/*
		if(o1.getTipoAtraccion()==usuario.getTipoAtraccionPreferida() && o2.getTipoAtraccion()!=usuario.getTipoAtraccionPreferida()) {
			return -1;
		}else if(o1.getTipoAtraccion()!=usuario.getTipoAtraccionPreferida() && o2.getTipoAtraccion()==usuario.getTipoAtraccionPreferida()) {
			return 1;
		}*/
		
		if(o1.esPromocion() && !o2.esPromocion()){
			return -1;
		} else if(!o1.esPromocion() && o2.esPromocion()){
			return 1;
		}
		
		if(o1.getCosto() > o2.getCosto()){
			return -1;
		} else if(o1.getCosto() < o2.getCosto()){
			return 1;
		}
		
		if(o1.getTiempo() > o2.getTiempo()){
			return -1;
		} else if(o1.getTiempo() < o2.getTiempo()){
			return 1;
		}
			
		return 0;
	}

}
