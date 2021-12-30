package logica;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.LinkedList;

import java.util.Scanner;



import dominio.Cliente;
import dominio.Documento;
import dominio.Encomienda;
import dominio.Oficina;
import dominio.Valija;




public class App {
	private static ArrayList listaOficininas = new ArrayList<Oficina>();
	private static LinkedList listaClientes = new LinkedList<Cliente>();
	
	public static void main(String[] args){
		ListaDobleDocumentos listaDobleDocumentos = new ListaDobleDocumentos();
		ListaDobleEncomiendas listaDobleEncomiendas = new ListaDobleEncomiendas();
		ListaDobleValijas listaDobleValijas = new ListaDobleValijas();
		
		sistemaStarkonImlp sistema = new sistemaStarkonImlp();
		
		
		leerClientes();
		leerLocalizaciones();
		leerEntregas();
		
		
		menu();
		
		
	}


	public static void leerEntregas(){
		File archivo = null;
	    FileReader fr = null;
	    BufferedReader br = null;
		try {
			archivo = new File ("C:\\Entregas.txt"); //this needs to be changed depending on where you store your txt
			fr = new FileReader (archivo);
			br = new BufferedReader(fr);
			String linea;
			
			while ((linea = br.readLine()) != null) {
				String [] partes = linea.split(",");
				String tipo = partes[1];
				switch (tipo) { //reads the type of entrega and decides which one to use
				case "D": {
					leerDocumento(linea, null );
				}
				case "E": {
					leerEncomienda(linea, null);			
				}
				case "V": {
					leerValija(linea, null);			
				}
				default:
					throw new IllegalArgumentException("dato erroneo en tipo de entrega");
				}
			}
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	}
	
	public static void leerDocumento(String linea,ListaDobleDocumentos listaDobleDocumentos) { // enter a documento
		String [] partes = linea.split(",");
		int code =Integer.parseInt(partes[0]);
		String rut_remitente = partes[2];
		String rut_destino = partes[3];
		int peso = Integer.parseInt(partes[4]);
		int grosor = Integer.parseInt(partes[5]);
		Documento d = new Documento(code, rut_remitente, rut_destino, peso, grosor);
		listaDobleDocumentos.insertarPrimer(d);
	}

	public static void leerEncomienda(String linea, ListaDobleEncomiendas listaDobleEncomiendas) { // enter a encomienda
		String [] partes = linea.split(",");
		int code =Integer.parseInt(partes[0]);
		String rut_remitente = partes[2];
		String rut_destino = partes[3];
		int peso = Integer.parseInt(partes[4]);
		int largo = Integer.parseInt(partes[5]);
		int ancho = Integer.parseInt(partes[6]);
		int profundidad = Integer.parseInt(partes[7]);
		Encomienda e = new Encomienda(code, rut_remitente, rut_destino, peso, largo, ancho, profundidad);
		listaDobleEncomiendas.insertarPrimer(e);
	
	}
	
	public static void leerValija(String linea, ListaDobleValijas listaDobleValijas) { //enter a valija
		String [] partes = linea.split(",");
		int code =Integer.parseInt(partes[0]);
		String rut_remitente = partes[2];
		String rut_destino = partes[3];
		int peso = Integer.parseInt(partes[4]);
		String material = partes[5];
		Valija v = new Valija(code, rut_remitente, rut_destino, peso, material);
		listaDobleValijas.insertarPrimer(v);
	}
	
	public static void leerClientes(){
		File archivo = null;
	    FileReader fr = null;
	    BufferedReader br = null;
		try {
			archivo = new File ("C:\\Cliente.txt"); //this needs to be changed depending on where you store your txt
			fr = new FileReader (archivo);
			br = new BufferedReader(fr);
			String linea;
			
			while ((linea = br.readLine()) != null) {
				String [] partes = linea.split(",");
				String rut = partes[0];
				String nombre_completo = partes[1] +" "+ partes[2];
				int saldo = Integer.parseInt(partes[3]);
				String localizacion = partes[4];
				listaClientes.add(new Cliente(rut, nombre_completo, saldo, localizacion));
				
			}
			
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	}
	
	public static void leerLocalizaciones(){
		File archivo = null;
	    FileReader fr = null;
	    BufferedReader br = null;
		try {
			archivo = new File ("C:\\localización.txt"); //this needs to be changed depending on where you store your txt
			fr = new FileReader (archivo);
			br = new BufferedReader(fr);
			String linea;
			
			while ((linea = br.readLine()) != null) {
				String [] partes = linea.split(",");
				String localizacion = partes[0];
				listaOficininas.add(new Oficina(localizacion));				
			}
			
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	}
	
	
	public static void menu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Ingrese su rut o un 0 para cerrar el sistema: ");
		String entrada = sc.next();
		int caso = 0;
		
		if(entrada.equals("0")) salir();
		
		while(caso == 0) {
			if (listaClientes.contains(entrada)) {
				caso = 1;
			}
			else if (!listaClientes.contains(entrada)) {
				caso = 4;
			}
		}
		
		
		switch (caso) {
		case 1:
			{
			menuCliente(entrada, null);
		}
		case 2:
			{
				int done = 0;
				
				while(done == 0){
					System.out.println("Ingrese contraseña");
					String pass = sc.next();
					
					if(pass == "choripan123") { // password = password of the system?
						done = 1;
						menuAdmin(null);				
					}
					
					else {
						System.out.println("Contraseña incorrecta");
					}
				}
		}
		case 3: //creates a new client
			{
			String nombre_completo;
			int saldo;
			String localizacion;
			System.out.println("Ingrese su primer nombre y primer apellido: ");
			nombre_completo = sc.next();
			System.out.println("Ingrese su saldo: ");
			saldo = Integer.parseInt(sc.next());
			System.out.println("Ingrese su localizacíon: ");
			localizacion = sc.next();
				
			listaClientes.add(new Cliente(entrada, nombre_completo, saldo, localizacion));
				
			menuCliente(entrada, null);	
		}
		case 4:
		{
			menu();// to close the system 
		}
		default:
			System.out.println("Cuenta no encontrada desea registrase?");
			System.out.println("No = 4");
			System.out.println("Si = 3");
			caso = Integer.parseInt(sc.next());
		}
	}
		

	

	public static void menuCliente(String rut, sistemaStarkon sistem) {
		int opci = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("Elija una opcion");
		System.out.println("1) Realizar una entrega:");
		System.out.println("2) Recargar saldo");
		System.out.println("3) Ver tus entregas:");
		System.out.println("4) volver a menu");
		int entrada = Integer.parseInt(sc.next()) ;
		switch (opci) {
		case 1: {
			
		}
		case 2: {
			System.out.print("¿Cuanto saldo desea recargar?");
			int saldo = Integer.parseInt(sc.next());
			for (int j = 0; j < listaClientes.size(); j++) {
				Cliente cliente = (Cliente) listaClientes.get(j);
				if(cliente.getRut().equals(rut)) {
					cliente.setSaldo(cliente.getSaldo() + saldo);
				}
			}			
		}
		case 3: {
			System.out.print(sistem.verEntregas(rut, null, null, null));			
		}
		case 4: {
			menu();
			
		}
		default:
			throw new IllegalArgumentException("Opcion no valida: " + opci);
		}
	}
	
	
	public static void menuAdmin(sistemaStarkon sistem) {
		int opci = 0;
		System.out.println("Elija una opcion");
		System.out.println("1) Entregas por tipo");
		System.out.println("2) Entregas por localización");
		System.out.println("3) Entregas por cliente");
		System.out.println("4) Registro de ganancias");
		System.out.println("5) salir");
		switch (opci) {
		case 1: {
			
			System.out.print(sistem.verEntregasTipo(null, null, null));
		}
		case 2: {
			System.out.print(sistem.verEntregasLocalizacion(null, null, null));
			
		}
		case 3: {
			System.out.print(sistem.entregasCliente(null, null, null));
			
		}
		case 4: {
			System.out.print(sistem.registroGanancias(null, null, null));
			
		}
		case 5: {
			menu();
			
		}
		default:
			throw new IllegalArgumentException("Opcion no valida: " + opci);
		}
	}


	public static void salir() {//rewrite of txts
		
		
	}
	
}
