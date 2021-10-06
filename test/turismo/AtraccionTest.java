package turismo;

import static org.junit.Assert.*;
import org.junit.Test;


public class AtraccionTest {

	@Test
	public void crearAtraccionParametrizadaTest() {
		Atraccion atraccion = new Atraccion("Moria", 10, 2, 6, TipoAtracciones.AVENTURA);
		assertNotNull(atraccion);
	}

	@Test
	public void quePuedaObtenerNombreAtraccionTest() {
		Atraccion atraccion = new Atraccion("Moria", 10, 2, 6, TipoAtracciones.AVENTURA);
		assertEquals("Moria", atraccion.getNombre());
	}

	@Test
	public void quePuedaObtenerCostoAtraccionTest() {
		Atraccion atraccion = new Atraccion("Moria", 10, 2, 6, TipoAtracciones.AVENTURA);
		assertEquals(10, atraccion.getCosto(),0.0);
	}

	@Test
	public void quePuedaObtenerPromedioTiempoTest() {
		Atraccion atraccion = new Atraccion("Moria", 10, 2, 6, TipoAtracciones.AVENTURA);
		assertEquals(2, atraccion.getTiempo(), 0.001);
	}

	@Test
	public void quePuedaObtenerCupoAtraccionTest() {
		Atraccion atraccion = new Atraccion("Moria", 10, 2, 6, TipoAtracciones.AVENTURA);
		assertEquals(6, atraccion.getCupoPersonas());
	}

	@Test
	public void quePuedaObtenerTipoAtraccionTest() {
		Atraccion atraccion = new Atraccion("Moria", 10, 2, 6, TipoAtracciones.AVENTURA);
		assertEquals(TipoAtracciones.AVENTURA, atraccion.getTipoAtracciones());
	}

	@SuppressWarnings("unlikely-arg-type")
	@Test
	public void quePuedaObtenerSiDosAtraccionesSonIgualesTest() {
		Atraccion atraccion1 = new Atraccion("Moria", 10, 2, 6, TipoAtracciones.AVENTURA);
		Atraccion atraccion2 = new Atraccion("Moria", 10, 2, 6, TipoAtracciones.AVENTURA);
		equals(atraccion1.equals(atraccion2));
	}

	@Test
	public void quePuedaObtenerSiDosAtraccionesNoSonIgualesTest() {
		Atraccion atraccion1 = new Atraccion("Moria", 10, 2, 6, TipoAtracciones.AVENTURA);
		Atraccion atraccion2 = new Atraccion("La Comarca", 3, 6.5, 150, TipoAtracciones.DEGUSTACION);
		assertFalse(atraccion1.equals(atraccion2));
	}

	@Test
	public void queSiHayCupoEnLaAtraccionRetorneTrueTest() {
		Atraccion atraccion1 = new Atraccion ("Moria", 10, 2, 6, TipoAtracciones.AVENTURA);
		assertTrue(atraccion1.hayCupo());
	}


}
