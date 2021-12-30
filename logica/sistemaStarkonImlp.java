package logica;


public class sistemaStarkonImlp implements sistemaStarkon{


	@Override
	//checks each list for the information 
	public String verEntregas(String rut, ListaDobleDocumentos listaDobleDocumentos, ListaDobleEncomiendas listaDobleEncomiendas, ListaDobleValijas listaDobleValijas) {
		
		String destino = "Recibidos: \n";
		String entrega = "Enviados: \n";
		
		
		for (int i = 0; i < listaDobleDocumentos.getCantidadDocumento(); i++) {
			if(listaDobleDocumentos.getDocumento(i).getRut_destino().equals(rut)) {
				destino =listaDobleDocumentos.getDocumento(i).toString() + "\n";
			}
			
			if(listaDobleDocumentos.getDocumento(i).getRut_remitente().equals(rut)) {
				entrega =""+ listaDobleDocumentos.getDocumento(i).toString() + "\n";
			}		
		}
		
		for (int i = 0; i < listaDobleEncomiendas.getCantidadEncomienda(); i++) {
			if(listaDobleEncomiendas.getEncomienda(i).getRut_destino().equals(rut)) {
				destino =listaDobleEncomiendas.getEncomienda(i).toString() + "\n";
			}
			
			if(listaDobleEncomiendas.getEncomienda(i).getRut_remitente().equals(rut)) {
				entrega =""+ listaDobleEncomiendas.getEncomienda(i).toString() + "\n";
			}		
		}
		
		for (int i = 0; i < listaDobleValijas.getCantidadValija(); i++) {
			if(listaDobleValijas.getValija(i).getRut_destino().equals(rut)) {
				destino =listaDobleValijas.getValija(i).toString() + "\n";
			}
			
			if(listaDobleValijas.getValija(i).getRut_remitente().equals(rut)) {
				entrega =""+ listaDobleValijas.getValija(i).toString() + "\n";
			}		
		}
		
		
		String salida = entrega +"\n"+destino;
		return salida;
		
	}


	public String verEntregasTipo(ListaDobleDocumentos listaDobleDocumentos, ListaDobleEncomiendas listaDobleEncomiendas, ListaDobleValijas listaDobleValijas) {
		
		String doc = "Documentos: \n";
		String enco = "Encomiendas: \n";
		String vali = "Valijas: \n";
		
		
		for (int i = 0; i < listaDobleDocumentos.getCantidadDocumento(); i++) {
			float resultado = calcular(listaDobleDocumentos.getDocumento(i).getPeso(), listaDobleDocumentos.getDocumento(i).getGrosor(), 0, 0, null);
			doc =listaDobleDocumentos.getDocumento(i).toString() + "Cobrado: $"+ resultado +" CLP"+ "\n";
			
		
		}
		
		for (int i = 0; i < listaDobleEncomiendas.getCantidadEncomienda(); i++) {
			float resultado = calcular(listaDobleEncomiendas.getEncomienda(i).getPeso(), listaDobleEncomiendas.getEncomienda(i).getLargo(), 
					listaDobleEncomiendas.getEncomienda(i).getAncho(),listaDobleEncomiendas.getEncomienda(i).getProfundidad(),null);
			enco =listaDobleEncomiendas.getEncomienda(i).toString() + "Cobrado: $"+ resultado +" CLP" + "\n";
			
			
		
		}
		
		for (int i = 0; i < listaDobleValijas.getCantidadValija(); i++) {
			float resultado = calcular(listaDobleValijas.getValija(i).getPeso(),0, 0,0,listaDobleValijas.getValija(i).getMaterial());
			vali =listaDobleValijas.getValija(i).toString() + "Cobrado: $" + resultado + " CLP"+ "\n";
				
		}
		
		
		String salida = doc +"\n"+enco +"\n" +vali ;
		return salida;
		
	}

	public float calcular(int dato1, int dato2, int dato3, int dato4, String material) {//gives the price in CLP for each entrega
		float resultado = 0;
		dato1 = dato1 * 1000;
		if (dato4 != 0) { //doc		
			resultado = dato1*(dato2*10)*100;
		}
		
		if (material == null && dato4 > 0) { // enco
			dato2 = dato2*100;
			dato3 = dato3*100;
			dato4 = dato4*100;
			
			resultado = dato1*(dato2*dato3*dato4)*50;
		}
		
		if (material != null) {// valija
			switch (material) {
			case "Cuero": {
				resultado = 200*dato1*150;
				
			}
			case "Plástico": {
				resultado = 150*dato1*150;
				
			}
			case "Tela": {
				resultado = 100*dato1*150;
		
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + material);
			}
		}
		
		return resultado;
		
	}


	@Override
	public String verEntregasLocalizacion(ListaDobleDocumentos listaDobleDocumentos,
			ListaDobleEncomiendas listaDobleEncomiendas, ListaDobleValijas listaDobleValijas) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String registroGanancias(ListaDobleDocumentos listaDobleDocumentos,
			ListaDobleEncomiendas listaDobleEncomiendas, ListaDobleValijas listaDobleValijas) {
		// TODO Auto-generated method stub
		return null;
	}

	public float calcularGanancias() {
		return 0;
		// TODO Auto-generated method stub

	}
	
	@Override
	public String entregasCliente(ListaDobleDocumentos listaDobleDocumentos,
			ListaDobleEncomiendas listaDobleEncomiendas, ListaDobleValijas listaDobleValijas) {
		String envios = "Envios \n";
		for (int i = 0; i < listaDobleDocumentos.getCantidadDocumento(); i++) {
			envios =""+listaDobleDocumentos.getDocumento(i).toString() + "\n";
		}
		
		for (int i = 0; i < listaDobleEncomiendas.getCantidadEncomienda(); i++) {
			envios =""+ listaDobleEncomiendas.getEncomienda(i).toString() + "\n";		
		}
		
		for (int i = 0; i < listaDobleValijas.getCantidadValija(); i++) {
			envios =""+ listaDobleValijas.getValija(i).toString() + "\n";
		}
		return envios;
	}


		
	
	
	
	

}
