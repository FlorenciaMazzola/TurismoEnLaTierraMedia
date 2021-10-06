package turismo;

import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;



public class PromocionTest {

	Atraccion atraccionMoria ;
	Atraccion atraccionMinasTirith;
	Atraccion atraccionLaComarca ;
	Atraccion atraccionMordor ;
	Atraccion atraccionAbismoDeHelm;
	Atraccion atraccionLothlorien ;
	Atraccion atraccionErebor ;
	Atraccion atraccionBosqueNegro;
	Atraccion atraccionLaRoca;
	
	Promocion promo1;

	@Test
	public void quePromocionNoSeaNullTest() {	
		atraccionMoria = new Atraccion("Moria", 10, 2, 6, TipoAtracciones.AVENTURA);
		atraccionMinasTirith = new Atraccion("Minas Tirith", 5, 2.5, 6, TipoAtracciones.PAISAJE);
		atraccionLaComarca = new Atraccion("La Comarca", 3, 6.5, 150, TipoAtracciones.DEGUSTACION);
		atraccionMordor = new Atraccion("Mordor", 25, 3, 4, TipoAtracciones.AVENTURA);
		atraccionAbismoDeHelm = new Atraccion("Abismo de Helm", 5, 2, 15, TipoAtracciones.PAISAJE);
		atraccionLothlorien = new Atraccion("Lothlorien", 35, 1, 30, TipoAtracciones.DEGUSTACION);
		atraccionErebor = new Atraccion("Erebor", 12, 3, 32, TipoAtracciones.PAISAJE);
		atraccionBosqueNegro = new Atraccion("Bosque Negro", 3, 4, 12, TipoAtracciones.AVENTURA);
		
			
		/*List<Atraccion> arrayAtracciones = new ArrayList<Atraccion>();
		arrayAtracciones.add(atraccionMoria);
		arrayAtracciones.add(atraccionMinasTirith);
		arrayAtracciones.add(atraccionLaComarca);
		arrayAtracciones.add(atraccionMordor);
		arrayAtracciones.add(atraccionAbismoDeHelm);
		arrayAtracciones.add(atraccionLothlorien);
		arrayAtracciones.add(atraccionErebor);
		arrayAtracciones.add(atraccionBosqueNegro);*/
		
		PromocionAbsoluta promo = new PromocionAbsoluta("Pack aventura",TipoAtracciones.AVENTURA,"Promocion Absoluta","Moria","Bosque Negro",3.0);
		assertNotNull(promo);
	}
	
	
	@SuppressWarnings("unlikely-arg-type")
	@Test
	public void quedeLaPromoPorcentualSeObtenga15PorcientoDeDescuentoTest() {	
		atraccionMoria = new Atraccion("Moria", 10, 2, 6, TipoAtracciones.AVENTURA);
		atraccionMinasTirith = new Atraccion("Minas Tirith", 5, 2.5, 6, TipoAtracciones.PAISAJE);
		atraccionLaComarca = new Atraccion("La Comarca", 3, 6.5, 150, TipoAtracciones.DEGUSTACION);
		atraccionMordor = new Atraccion("Mordor", 25, 3, 4, TipoAtracciones.AVENTURA);
		atraccionAbismoDeHelm = new Atraccion("Abismo de Helm", 5, 2, 15, TipoAtracciones.PAISAJE);
		atraccionLothlorien = new Atraccion("Lothlorien", 35, 1, 30, TipoAtracciones.DEGUSTACION);
		atraccionErebor = new Atraccion("Erebor", 12, 3, 32, TipoAtracciones.PAISAJE);
		atraccionBosqueNegro = new Atraccion("Bosque Negro", 3, 4, 12, TipoAtracciones.AVENTURA);
		
			
		List<Atraccion> listaAtracciones = new ArrayList<Atraccion>();
		listaAtracciones.add(atraccionMoria);
		listaAtracciones.add(atraccionMinasTirith);
		listaAtracciones.add(atraccionLaComarca);
		listaAtracciones.add(atraccionMordor);
		listaAtracciones.add(atraccionAbismoDeHelm);
		listaAtracciones.add(atraccionLothlorien);
		listaAtracciones.add(atraccionErebor);
		listaAtracciones.add(atraccionBosqueNegro);
		
		PromocionPorcentual promo = new PromocionPorcentual("Pack degustacion",TipoAtracciones.AVENTURA,"Promocion Porcentual","Lothlorien","La Comarca",0.15);
		
		List<Atraccion> atracionesPromo = new ArrayList<Atraccion>();
		atracionesPromo.add(atraccionAbismoDeHelm);
		atracionesPromo.add(atraccionLothlorien);
		
		//promo.calcularPromocion(listaAtracciones);
		promo.calcularCosto(listaAtracciones);
		promo.calcularTiempo(listaAtracciones);
		assertEquals(32.3,promo.getCosto(),0.001);	
		assertEquals(7.5,promo.getTiempo(),0.001);	
		equals(atracionesPromo.equals(promo.calcularPromocion(listaAtracciones)));	
	}
	

	@SuppressWarnings("unlikely-arg-type")
	@Test
	public void quedeLaPromoAxBSeObtengaOtraAtraccionTest() {	
		atraccionMoria = new Atraccion("Moria", 10, 2, 6, TipoAtracciones.AVENTURA);
		atraccionMinasTirith = new Atraccion("Minas Tirith", 5, 2.5, 6, TipoAtracciones.PAISAJE);
		atraccionLaComarca = new Atraccion("La Comarca", 3, 6.5, 150, TipoAtracciones.DEGUSTACION);
		atraccionMordor = new Atraccion("Mordor", 25, 3, 4, TipoAtracciones.AVENTURA);
		atraccionAbismoDeHelm = new Atraccion("Abismo de Helm", 5, 2, 15, TipoAtracciones.PAISAJE);
		atraccionLothlorien = new Atraccion("Lothlorien", 35, 1, 30, TipoAtracciones.DEGUSTACION);
		atraccionErebor = new Atraccion("Erebor", 12, 3, 32, TipoAtracciones.PAISAJE);
		atraccionBosqueNegro = new Atraccion("Bosque Negro", 3, 4, 12, TipoAtracciones.AVENTURA);	
		atraccionLaRoca = new Atraccion("La Roca", 12, 3, 2,TipoAtracciones.AVENTURA);
			
		List<Atraccion> listaAtracciones = new ArrayList<Atraccion>();
		listaAtracciones.add(atraccionMoria);
		listaAtracciones.add(atraccionMinasTirith);
		listaAtracciones.add(atraccionLaComarca);
		listaAtracciones.add(atraccionMordor);
		listaAtracciones.add(atraccionAbismoDeHelm);
		listaAtracciones.add(atraccionLothlorien);
		listaAtracciones.add(atraccionErebor);
		listaAtracciones.add(atraccionBosqueNegro);
		listaAtracciones.add(atraccionLaRoca);
		
		PromocionAxB promo = new PromocionAxB("Pack paisajes",TipoAtracciones.DEGUSTACION,"Promocion AxB", "Bosque Negro","Mordor","La Roca");
		
		List<Atraccion> atracionesPromo = new ArrayList<Atraccion>();
		atracionesPromo.add(atraccionBosqueNegro);
		atracionesPromo.add(atraccionMordor);
		atracionesPromo.add(atraccionLaRoca);
		
		promo.calcularCosto(listaAtracciones);
		promo.calcularTiempo(listaAtracciones);
		assertEquals(28,promo.getCosto(),0.001);
		assertEquals(10,promo.getTiempo(),0.001);	
		equals(atracionesPromo.equals(promo.calcularPromocion(listaAtracciones)));
	}
	
	@SuppressWarnings("unlikely-arg-type")
	@Test
	public void quedeLaPromocionAbsolutaSeObtenga10DeCostoY6DeTiempoRequeridoTest() {	
		atraccionMoria = new Atraccion("Moria", 10, 2, 6, TipoAtracciones.AVENTURA);
		atraccionMinasTirith = new Atraccion("Minas Tirith", 5, 2.5, 6, TipoAtracciones.PAISAJE);
		atraccionLaComarca = new Atraccion("La Comarca", 3, 6.5, 150, TipoAtracciones.DEGUSTACION);
		atraccionMordor = new Atraccion("Mordor", 25, 3, 4, TipoAtracciones.AVENTURA);
		atraccionAbismoDeHelm = new Atraccion("Abismo de Helm", 5, 2, 15, TipoAtracciones.PAISAJE);
		atraccionLothlorien = new Atraccion("Lothlorien", 35, 1, 30, TipoAtracciones.DEGUSTACION);
		atraccionErebor = new Atraccion("Erebor", 12, 3, 32, TipoAtracciones.PAISAJE);
		atraccionBosqueNegro = new Atraccion("Bosque Negro", 3, 4, 12, TipoAtracciones.AVENTURA);
			
		List<Atraccion> listaAtracciones = new ArrayList<Atraccion>();
		listaAtracciones.add(atraccionMoria);
		listaAtracciones.add(atraccionMinasTirith);
		listaAtracciones.add(atraccionLaComarca);
		listaAtracciones.add(atraccionMordor);
		listaAtracciones.add(atraccionAbismoDeHelm);
		listaAtracciones.add(atraccionLothlorien);
		listaAtracciones.add(atraccionErebor);
		listaAtracciones.add(atraccionBosqueNegro);
		
		PromocionAbsoluta promo = new PromocionAbsoluta("Pack aventura",TipoAtracciones.AVENTURA,"Promocion Absoluta","Moria","Bosque Negro",3.0);
		
		List<Atraccion> atracionesPromo = new ArrayList<Atraccion>();
		atracionesPromo.add(atraccionMoria);
		atracionesPromo.add(atraccionBosqueNegro);
		
		promo.calcularCosto(listaAtracciones);
		promo.calcularTiempo(listaAtracciones);
		
		assertEquals(10,promo.getCosto(),0.001);
		assertEquals(6,promo.getTiempo(),0.001);
		equals(atracionesPromo.equals(promo.calcularPromocion(listaAtracciones)));
	}


}
