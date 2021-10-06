package turismo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class LeerYEscribirArchivo {
private static TipoAtracciones tipoAtraccion;
	
	
	public static ArrayList<Usuario> leerDatosDeUsuarios(String Usuarios) {
		ArrayList<Usuario> lista = new ArrayList<Usuario>();
		Scanner sc = null;

		try {
			sc = new Scanner(new File(Usuarios));
			while (sc.hasNext()) {
				String linea = sc.nextLine();
				String[] array = linea.split(",");
				String nombre = array[0];
				TipoAtracciones nombre_atrac = TipoAtracciones.AVENTURA;
				switch (array[1]) {

				case "Degustacion":
					nombre_atrac = TipoAtracciones.DEGUSTACION;
					break;

				case "Paisaje":
					nombre_atrac = TipoAtracciones.PAISAJE;
					break;
				}
				double presupuesto = Double.parseDouble(array[2]);
				double tiempo = Double.parseDouble(array[3]);
				Usuario usuario = new Usuario(nombre,nombre_atrac, presupuesto, tiempo);
				if (!lista.contains(usuario)) {
					lista.add(usuario);
				}
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		sc.close();
		return lista;
	}
	
//	 public static void escriboArchivoOrdenDni(List<Promocion> list,String file)throws IOException {
// 		PrintWriter salida = new PrintWriter(new FileWriter(file));
// 		for(int i=0; i<list.size(); i++) {
// 			salida.println(list.get(i).toString());
// 		}
// 		salida.close();
// 	}

	public static ArrayList<Atraccion> leerDatosAtracciones(String Usuarios) {
		ArrayList<Atraccion> listaAtracciones = new ArrayList<Atraccion>();
		Scanner sc = null;

		try {
			sc = new Scanner(new File(Usuarios));
			while (sc.hasNext()) {
				String linea = sc.nextLine();
				String[] array = linea.split(",");
				String nombre_atrac = array[0];
				int costo = Integer.parseInt(array[1]);
				double promedioTiempo = Double.parseDouble(array[2]);
				int cupoPersonas = Integer.parseInt(array[3]);
				
				
				
				if(array[4].equals("Aventura")) {
					tipoAtraccion = TipoAtracciones.AVENTURA;
				}else if(array[4].equals("Paisaje")) {
					tipoAtraccion = TipoAtracciones.PAISAJE;
				}else if(array[4].equals("Degustacion")){
					tipoAtraccion = TipoAtracciones.DEGUSTACION;
				}
				
				
				//int descuento = Integer.parseInt(array[1]) / 3;

				
				Atraccion atraccion = new Atraccion(nombre_atrac, costo, promedioTiempo, cupoPersonas, tipoAtraccion);
				if (!listaAtracciones.contains(atraccion)) {
					listaAtracciones.add(atraccion);
				}
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		sc.close();
		return listaAtracciones;
	}

	public static ArrayList<Promocion> leerDatosPromociones(String Usuarios) {
		ArrayList<Promocion> listaPromociones = new ArrayList<Promocion>();
		Scanner sc = null;
		try {
			sc = new Scanner(new File(Usuarios));
			while (sc.hasNext()) {
				String linea = sc.nextLine();
				String[] array = linea.split(",");
				String nombrePromocion = array[0];
				TipoAtracciones tipoAtracciones = TipoAtracciones.AVENTURA;
				switch (array[1]) {

				case "Degustacion":
					tipoAtracciones = TipoAtracciones.DEGUSTACION;
					break;

				case "Paisaje":
					tipoAtracciones = TipoAtracciones.PAISAJE;
					break;
				}
				
				String tipoPromocion = array[2];
				String atraccion1 = array[3];
				String atraccion2 = array[4];		

				Promocion promocion = null;
				
				switch (tipoPromocion) {
				case "Promocion Porcentual": {	
					Double descuento = Double.parseDouble(array[5]);
					promocion = new PromocionPorcentual
							(nombrePromocion,tipoAtracciones, tipoPromocion, atraccion1, atraccion2, descuento);
					break;
				}

				case "Promocion Absoluta": {
					Double descuento = Double.parseDouble(array[5]);
					promocion = new PromocionAbsoluta
							(nombrePromocion,tipoAtracciones, tipoPromocion, atraccion1, atraccion2, descuento);
					break;
				}

				case "Promocion AxB": {
					String atraccion3 = array[5];
					promocion = new PromocionAxB
							(nombrePromocion,tipoAtracciones, tipoPromocion, atraccion1, atraccion2,atraccion3);
					break;
				}

				}

				//Promocion promocion = new Promocion(nombrePromocion, tipoPromocion, atraccion1, atraccion2);
				if (!listaPromociones.contains(promocion)) {
					listaPromociones.add(promocion);
				}
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		

		sc.close();
		return listaPromociones;
	}


}
