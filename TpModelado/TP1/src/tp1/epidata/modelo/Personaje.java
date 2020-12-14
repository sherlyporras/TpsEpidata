package tp1.epidata.modelo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;





public class Personaje implements IPersonaje{
	
	private String nombre;
	private String alias;
	private Map<String, Integer> caracteristicas=new HashMap<String, Integer>();
	
	private boolean tipoh;
	private boolean tipov;
	
	private List <ICaracteristicasExtras> listaCaractExtras=new ArrayList<ICaracteristicasExtras>();
	//ICaracteristicasExtras extras;
	
	public Personaje(String nombre, String alias, boolean tipoHeroe, boolean tipoVillano) {
		
		this.nombre=nombre;
		this.alias=alias;
		this.tipoh=tipoHeroe;
		this.tipov=tipoVillano;
		
	}
	
	public String getNombre() {
		return this.nombre;
	}
	public String getAlias() {
		return this.alias;
	}
	public void cargarCaracteristicas(String nom,Integer valor) {
		this.caracteristicas.put(nom, valor);
	}
	
	public void cargarListaCaractExtras(ICaracteristicasExtras ce) {
		this.listaCaractExtras.add(ce);		
	}
	
	public int getCantExtras() {
		return this.listaCaractExtras.size();
	}
	
	
	public void calcularCaractExtras() {
		for (ICaracteristicasExtras extra : this.listaCaractExtras) {
			
			extra.cargarExtras(caracteristicas);
		}
	}
	
	public int getValorCaracteristica(String caracteristica){
		
		try {
			
			return this.caracteristicas.get(caracteristica);
			
		} catch (NullPointerException e) {
			
			System.out.println("La caracteristica no existe");
			return -1;		
			
		}
		
		
	}	
	

	@Override
	public boolean esHeroe() {
		// TODO Auto-generated method stub
		return this.tipoh;
	}

	@Override
	public boolean esVillano() {
		// TODO Auto-generated method stub
		return this.tipov;
	}
	

}
