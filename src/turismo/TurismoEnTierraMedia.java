package turismo;

import java.util.ArrayList;
import java.util.List;

public class TurismoEnTierraMedia {
	
	private static List<Usuario> listaUsuarios;
	private static List<Atraccion> listaAtracciones;
	private static List<Promocion> listaPromociones;
	private Visita visita;

	public TurismoEnTierraMedia() {
		listaUsuarios = new ArrayList<Usuario>();
		listaUsuarios=LeerYEscribirArchivo.leerDatosDeUsuarios("Usuarios.txt");
		
		listaAtracciones = new ArrayList<Atraccion>();
		listaAtracciones=LeerYEscribirArchivo.leerDatosAtracciones("Atracciones.txt");
		
		listaPromociones = new ArrayList<Promocion>();
		listaPromociones=LeerYEscribirArchivo.leerDatosPromociones("Promociones.txt");	
	}
	
	public static void main(String[] args) {
		TurismoEnTierraMedia primerVisita = new TurismoEnTierraMedia();	
		Visita visita = new Visita(listaUsuarios, listaAtracciones, listaPromociones);
		
		//System.out.println(visita.getUsuarios());	
		//visita.ordenarAtracciones(listaAtracciones);
		//System.out.println(visita.getAtraccionArray());
		//System.out.println(visita.getPromociones());
		
		visita.armarPropuesta(listaUsuarios);
		
		
	}
	
	
	/*
	

	Scanner sc = new Scanner(System.in);

	// Se instancian tipos ENUM
	TipoAtracciones Aventura = TipoAtracciones.AVENTURA;
	TipoAtracciones Paisaje = TipoAtracciones.PAISAJE;
	TipoAtracciones Degustacion = TipoAtracciones.DEGUSTACION;
	Usuario usuario;
	
	public void inicio() throws IOException {

		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("////////////////////////////////////////////////////////////");
		System.out.println("/////////////Bienvenido al Parque Tierra Media//////////////");
		System.out.println("////////////////////////////////////////////////////////////");
		System.out.println("		Seleccione una opcion								");
		System.out.println("															");
		System.out.println("	1-	Ingresar Usuario existente							");
		System.out.println("	2-	Ingresar nuevo Tipo de Usuario						");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

		Scanner sc = new Scanner(System.in);
		int opcion = sc.nextInt();
		
		while (opcion != 1 && opcion != 2) {
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			System.out.println(" SE HA INGRESADO UN DATO ERRONEO ('" + opcion + "' no está entre las opciones)");
			inicio();
		}
		
 		switch (opcion) {
		case 1:
			usuarioGuardado();
			break;

		case 2:
			crearNuevoUsuario();
			break;
		}

	}

	private void usuarioGuardado() throws IOException {
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("////////////////////////////////////////////////////////////");
		System.out.println("////////////	 Parque Tierra Media	////////////////////");
		System.out.println("////////////////////////////////////////////////////////////");
		System.out.println("	Seleccione un Usuario Guardado							");
		System.out.println("	1-	Eowyn												");
		System.out.println("	2-	Gandalf												");
		System.out.println("	3-	Sam													");
		System.out.println("	4-	Galadriel											");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

		// aca se crea el perfil de usuario que elige el usuario
		int opcion = sc.nextInt();
		switch (opcion) {
		case 1:
			usuario = new Usuario(Aventura, 10, 8);
			break;

		case 2:
			usuario = new Usuario(Paisaje, 100, 5);
			break;
		case 3:
			usuario = new Usuario(Degustacion, 36, 8);
			break;

		case 4:
			usuario = new Usuario(Paisaje, 120, 2);
			break;
		}

		sugerenciaPromo();
	}

	private void crearNuevoUsuario() throws IOException {
		Scanner nombre = new Scanner(System.in);
		Scanner numerosDouble = new Scanner(System.in);
		TipoAtracciones atraccionUsuario = null;

		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("////////////////////////////////////////////////////////////");
		System.out.println("////////////	 Parque Tierra Media	////////////////////");
		System.out.println("////////////////////////////////////////////////////////////");
		System.out.println("															");
		System.out.println("	Ingrese los datos para un nuevo perfil de usuario		");
		System.out.println("															");
		System.out.println("	Nombre: ");
		String usuarioNombre = nombre.nextLine(); // lee el nombre de usuario
		System.out.println("															");
		System.out.println("	Seleccione su atraccion Preferida: ");
		System.out.println("			1-Aventura");
		System.out.println("			2-Paisajes");
		System.out.println("			3-Degustacion");
		int usuarioAtraccion = sc.nextInt(); // lee la atraccion del usuario////se debe controlar que el entero sea
												// menor a 3
		while (usuarioAtraccion != 1 && usuarioAtraccion != 2 && usuarioAtraccion != 3) {
			System.out.println("SELECCIONE UNA OPCION VALIDA: 1-Aventura, 2-Paisaje, 3-Degustacion.");
			usuarioAtraccion = sc.nextInt();
		}

		switch (usuarioAtraccion) {
		case 1:
			atraccionUsuario = TipoAtracciones.AVENTURA;
			break;

		case 2:
			atraccionUsuario = TipoAtracciones.PAISAJE;
			break;
		case 3:
			atraccionUsuario = TipoAtracciones.DEGUSTACION;
			break;
		}

		System.out.println("															");
		System.out.println("	Presupuesto: ");
		Double usuarioPresupuesto = numerosDouble.nextDouble(); // lee elpresupuesto de usuario
		System.out.println("															");
		System.out.println("	Tiempo Disponible(Horas): ");
		Double usuarioTiempo = numerosDouble.nextDouble(); // lee el tiempo del usuario

		usuario = new Usuario(atraccionUsuario, usuarioPresupuesto, usuarioTiempo);
		usuario.setNombre(usuarioNombre);

		System.out.println(usuario.toString());
		System.out.println("															");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

		sugerenciaPromo();

	}

	private void sugerenciaPromo() throws IOException {
		List<Promocion> promoUsuario = new ArrayList<Promocion>();
		promoUsuario = this.darPromoPorGusto(this.listaPromociones, usuario);

		List<Atraccion> promo1 = new ArrayList<Atraccion>();
		List<Atraccion> promo2 = new ArrayList<Atraccion>();
		List<Atraccion> promo3 = new ArrayList<Atraccion>();

		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("////////////////////////////////////////////////////////////");
		System.out.println("////////////	 Parque Tierra Media	////////////////////");
		System.out.println("////////////////////////////////////////////////////////////");
		System.out.println("Promociones Sugeridas, seleccione la opcion que desee	");
		System.out.println("															");	
		System.out.println("0-No aceptar ninguna opcion");
		System.out.println("															");
		System.out.println("1-" + promoUsuario.get(0).getTipoPromocion());
		promo1 = promoUsuario.get(0).calcularPromocion(atraccionArray,usuario);
		System.out.println("															");
		System.out.println("2-" + promoUsuario.get(1).getTipoPromocion());
		promo2 = promoUsuario.get(1).calcularPromocion(atraccionArray,usuario);
		System.out.println("															");
		System.out.println("3-" + promoUsuario.get(2).getTipoPromocion());
		promo3 = promoUsuario.get(2).calcularPromocion(atraccionArray,usuario);
		
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

		int opcion = sc.nextInt();
		
		switch (opcion) {
		case 0:
			break;
		case 1:
			usuario.aceptarPromo(promo1, promoUsuario.get(0).getCostoTotal());
			break;

		case 2:
			usuario.aceptarPromo(promo2, promoUsuario.get(1).getCostoTotal());
			break;
		case 3:
			usuario.aceptarPromo(promo3, promoUsuario.get(2).getCostoTotal());
			break;
		}
		
		if(usuario.getPresupuesto()>0 && usuario.getTiempoDisponible()>0)
			sugerenciaPorGustoDeAtraccion();
		// sugerenciaPorGustoDeAtraccionArchivo();
	}

	private void sugerenciaPorGustoDeAtraccion() throws IOException {
		List<Atraccion> preferenciasUsuario = new ArrayList<Atraccion>();
		preferenciasUsuario = this.darSugerenciaPorGusto(usuario);

		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("////////////////////////////////////////////////////////////");
		System.out.println("////////////	 Parque Tierra Media	////////////////////");
		System.out.println("////////////////////////////////////////////////////////////");
		System.out.println("	Atracciones sugeridas segun su gusto									");
		System.out.println("															");
		System.out.println("0-Ninguna  ");
		for (int i = 0; i < preferenciasUsuario.size(); i++) {
			System.out.println(i + 1 + "-" + preferenciasUsuario.get(i).getNombre());
			System.out.println("Costo:" + preferenciasUsuario.get(i).getCosto() + " Tiempo:"
					+ preferenciasUsuario.get(i).getPromedioTiempo());
		}

		System.out.println();
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

		int opcion = sc.nextInt();
		// esto se puede mejorar...
		switch (opcion) {
		case 0:
			sugerenciaPromoNoGustan();
			break;
		case 1:
			usuario.aceptarAtraccion(preferenciasUsuario.get(opcion));
			break;
		case 2:
			usuario.aceptarAtraccion(preferenciasUsuario.get(opcion));
			break;
		case 3:
			usuario.aceptarAtraccion(preferenciasUsuario.get(opcion));
		}
		if(usuario.getPresupuesto()>0 && usuario.getTiempoDisponible()>0)
			sugerenciaPromoNoGustan();
	}

	private void sugerenciaPromoNoGustan() throws IOException {
		List<Promocion> promoUsuario = new ArrayList<Promocion>();
		promoUsuario = this.darPromoRestante(this.listaPromociones, usuario);
		
		List<Atraccion> promo1 = new ArrayList<Atraccion>();
		List<Atraccion> promo2 = new ArrayList<Atraccion>();
		List<Atraccion> promo3 = new ArrayList<Atraccion>();
		List<Atraccion> promo4 = new ArrayList<Atraccion>();
		List<Atraccion> promo5 = new ArrayList<Atraccion>();
		List<Atraccion> promo6 = new ArrayList<Atraccion>();
		
		
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("////////////////////////////////////////////////////////////");
		System.out.println("////////////	 Parque Tierra Media	////////////////////");
		System.out.println("////////////////////////////////////////////////////////////");
		System.out.println("	Promociones sugeridas									");
		System.out.println("															");
		System.out.println("0-Ninguna");
		System.out.println("															");
		promo1 = promoUsuario.get(0).calcularPromocion(atraccionArray, usuario);
		promo2 = promoUsuario.get(1).calcularPromocion(atraccionArray, usuario);
		promo3 = promoUsuario.get(2).calcularPromocion(atraccionArray, usuario);
		promo4 = promoUsuario.get(3).calcularPromocion(atraccionArray, usuario);
		promo5 = promoUsuario.get(4).calcularPromocion(atraccionArray, usuario);
		promo6 = promoUsuario.get(5).calcularPromocion(atraccionArray, usuario);
		/*for (int i = 0; i < promoUsuario.size(); i++) {
			System.out.println(i + 1 + "-" + promoUsuario.get(i).getTipoPromocion());
			promoUsuario.get(i).calcularPromocion(atraccionArray, usuario);
			System.out.println("															");
		}*/
	/*
		System.out.println();
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		
		int opcion = sc.nextInt();
		
		switch (opcion) {
		case 0:
			sugerenciaDeAtraccionNoGustan();
			break;
		case 1:
			usuario.aceptarPromo(promo1, promoUsuario.get(0).getCostoTotal());
			break;
		case 2:
			usuario.aceptarPromo(promo2, promoUsuario.get(1).getCostoTotal());
			break;
		case 3:
			usuario.aceptarPromo(promo3, promoUsuario.get(2).getCostoTotal());
			break;
		case 4:
			usuario.aceptarPromo(promo4, promoUsuario.get(3).getCostoTotal());
			break;
		case 5:
			usuario.aceptarPromo(promo5, promoUsuario.get(4).getCostoTotal());
			break;
		case 6:
			usuario.aceptarPromo(promo6, promoUsuario.get(5).getCostoTotal());
			break;	
		}
		
		if(usuario.getPresupuesto()>0 && usuario.getTiempoDisponible()>0)
			sugerenciaDeAtraccionNoGustan();
	}

	private void sugerenciaDeAtraccionNoGustan() throws IOException {
		List<Atraccion> preferenciasUsuario = new ArrayList<Atraccion>();
		preferenciasUsuario = this.darSugerenciaQueNoSeaDeSuGustoPeroQuePuedaUsarla(usuario);
		// preferenciasUsuario = this.darSugerenciaPorGusto(usuario);//esto devolvia
		// atracciones que si le gustaban al usuario

		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("////////////////////////////////////////////////////////////");
		System.out.println("////////////	 Parque Tierra Media	////////////////////");
		System.out.println("////////////////////////////////////////////////////////////");
		System.out.println("Sugerencia de atracciones que no coinciden con gusto		");
		System.out.println(" 0-Ninguna												");
		// aca se tendria que hacer un iterador de la lista para que nombre bien todas
		// las atracciones
		for (int i = 0; i < preferenciasUsuario.size(); i++) {
			System.out.println(i + 1 + "-" + preferenciasUsuario.get(i).getNombre());
			System.out.println("Costo:" + preferenciasUsuario.get(i).getCosto() + " Tiempo:"
					+ preferenciasUsuario.get(i).getPromedioTiempo());
		}
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

		int opcion = sc.nextInt();
		switch (opcion) {
		case 0:
			break;
		case 1:
			usuario.aceptarAtraccion(preferenciasUsuario.get(opcion));
			break;
		case 2:
			usuario.aceptarAtraccion(preferenciasUsuario.get(opcion));
			break;
		case 3:
			usuario.aceptarAtraccion(preferenciasUsuario.get(opcion));
			break;
		case 4:
			usuario.aceptarAtraccion(preferenciasUsuario.get(opcion));
			break;
		case 5:
			usuario.aceptarAtraccion(preferenciasUsuario.get(opcion));
			break;
		case 6:
			usuario.aceptarAtraccion(preferenciasUsuario.get(opcion));
			break;	
		}
		
	}*/

}
