package tp1.epidata.modelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


public class Comparar {
	private List<String> criterios=new ArrayList<String>();
	
	private Map<String, List<Personaje>> resultado=new HashMap<String, List<Personaje>>();
	
	public Comparar() {
		// TODO Auto-generated constructor stub
	}
	public int calcularPromedio(List<Personaje>liga, String criterio) {
		int cantLiga=liga.size();
		int sum=0;
		for (Personaje personaje : liga) {
			sum=personaje.getValorCaracteristica(criterio)+sum;
			
		}	
		
		return (sum/cantLiga);	
		
	}
	
	
	
	
	
	public void compararCriterio(List<Personaje> liga, List<Personaje> personRestantes) {
		
		/*
		 * Si personRestantes es vacio entonces no se puede efectuar la comparacion
		 * Si genero una lista sea de villanos o heroes los presonRestantes seran:
		 * una liga(contrario al que elegimos)
		 * un solo personaje
		 */
		
		
		int promLiga;
		int restante;
		for (String criterio : this.criterios) {
			promLiga=calcularPromedio(liga, criterio);
			restante=calcularPromedio(personRestantes, criterio);
			if (promLiga>restante) {
				resultado.put(criterio, liga);
				
			}else if (promLiga<restante) {
				resultado.put(criterio, personRestantes);
				
			}
		}
	}
		
	
	public void compararCriterio(List<Personaje> todos) {
		/*
		 * compararemos cada uno de los criterios por los personajes 
		 */
		
		
		
		
		for (String criterio : this.criterios) {
			
			Map<Personaje,Integer>aux=new HashMap<Personaje,Integer>();
			List<Personaje>listaux=new ArrayList<Personaje>();
			
			for (Personaje personaje : todos) {
				aux.put(personaje, personaje.getValorCaracteristica(criterio));
			}
			//ordenamos el map aux por valor
			Map<Personaje,Integer>mapOrdenada=sortValues(aux);
			
			Iterator it=mapOrdenada.keySet().iterator();
			while (it.hasNext()) {
				Personaje keyper=(Personaje) it.next();
				listaux.add(keyper);
			}
			 
			resultado.put(criterio, listaux);
			
		}
		
		
		
		
	}
	
	
	private static Map<Personaje,Integer> sortValues(Map<Personaje,Integer> map){
		
		List list = new LinkedList(map.entrySet());  
		//Custom Comparator  
		Collections.sort(list, new Comparator(){
			public int compare(Object o1, Object o2){
				return ((Comparable) ((Map.Entry) (o1)).getValue()).compareTo(((Map.Entry) (o2)).getValue());
			}  
		});  
		//copying the sorted list in HashMap to preserve the iteration order  
		HashMap sortedHashMap = new LinkedHashMap();  
		for (Iterator it = list.iterator(); it.hasNext();)   
		{  
		 Map.Entry entry = (Map.Entry) it.next();  
		sortedHashMap.put(entry.getKey(), entry.getValue());  
		}   
		return sortedHashMap;  
		}  
		
		
		
	
	
	public void setCriterio(String criterio) {
		this.criterios.add(criterio);
		
	}
	
	public void publicarResultado() {
		
		
		Iterator it=resultado.keySet().iterator();
		while(it.hasNext()) {
			String key= (String) it.next();
			System.out.println("Resultados:");
			for (Personaje personaje : resultado.get(key)) {
				
				System.out.println("Criterio: " +key + "  lista "+ personaje.getNombre()+ " :" + personaje.getValorCaracteristica(key));
				System.out.println("");
			}
			
		}
		
	}
	
	

}
