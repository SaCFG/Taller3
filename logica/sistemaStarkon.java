package logica;

public interface sistemaStarkon {



	String verEntregas(String rut, ListaDobleDocumentos listaDobleDocumentos,
			ListaDobleEncomiendas listaDobleEncomiendas, ListaDobleValijas listaDobleValijas);
	String verEntregasTipo(ListaDobleDocumentos listaDobleDocumentos, 
			ListaDobleEncomiendas listaDobleEncomiendas, ListaDobleValijas listaDobleValijas);
	String verEntregasLocalizacion(ListaDobleDocumentos listaDobleDocumentos, 
			ListaDobleEncomiendas listaDobleEncomiendas, ListaDobleValijas listaDobleValijas);
	
	String	registroGanancias(ListaDobleDocumentos listaDobleDocumentos, 
			ListaDobleEncomiendas listaDobleEncomiendas, ListaDobleValijas listaDobleValijas);
	
	String 	entregasCliente(ListaDobleDocumentos listaDobleDocumentos, 
			ListaDobleEncomiendas listaDobleEncomiendas, ListaDobleValijas listaDobleValijas);
}
