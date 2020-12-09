package edu.epidata;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
//import javax.persistence.Query;
import javax.persistence.TypedQuery;

import java.util.List;

public class Principal {

	public static void main(String[] args) {
		//Crea el Entity manager factory con la configuración
		//llamada editorial
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Editorial");
		EntityManager em = emf.createEntityManager();
		
		//Inicia la transacción con la DBs
		//Persiste una persona
		//Hace el commit
		/*em.getTransaction().begin();
		em.persist(new Persona("Juan","Perez","juan@perez.com"));
		em.getTransaction().commit();
		em.close();
		
		
		//Inicio otra session
		em = emf.createEntityManager();
		em.getTransaction().begin();
		
		//Pregunto por todas las Personas. Persona en este caso
		//es la clase Persona, ya que la query es sobre JPQL
		TypedQuery<Persona> qp = em.createQuery("SELECT p FROM Persona p",Persona.class);
		for (Persona p: qp.getResultList()) {
		System.out.println(p);
		}
		em.getTransaction().commit();
		em.close();
		emf.close();*/
		System.out.println("**Query1:Cuantos libros editó cada persona en un año dado (2017).**");
		em.getTransaction().begin();
		TypedQuery<Reporte1Query> query1 = em.createQuery("SELECT new "+ "edu.epidata.Reporte1Query(t.id, count(*))"
				+ " FROM Libro l JOIN l.editores t"
				+ " WHERE l.anio = :anio"
				+ " GROUP BY t.id ",
				Reporte1Query.class);
		
				query1.setParameter("anio", 2017);
				List<Reporte1Query> resp1 = query1.getResultList();
				//Imprime los resultados
				resp1.forEach(r -> System.out.println(r));
		em.getTransaction().commit();
		System.out.println();
		System.out.println("**Query2: Cuantas páginas reviso cada persona en un año dado (2017).**");
		em.getTransaction().begin();
		TypedQuery<Reporte2Query> query2 = em.createQuery("SELECT new "+ "edu.epidata.Reporte2Query(rev.id, sum(cap.paginas))"
						+ " FROM Capitulo cap JOIN cap.revisor rev JOIN cap.libro libro"
						+ " WHERE libro.anio = :anio"
						+ " GROUP BY rev.id ",
						Reporte2Query.class);
				
						query2.setParameter("anio", 2017);
						List<Reporte2Query> resp2 = query2.getResultList();
						//Imprime los resultados
						resp2.forEach(r -> System.out.println(r));
		em.getTransaction().commit();
		
		System.out.println();
		System.out.println("**Query3: En cuantos libros participó cada persona como autor de capítulo.**");
		em.getTransaction().begin();
		TypedQuery<Reporte3Query> query3 = em.createQuery("SELECT new "+ "edu.epidata.Reporte3Query(autor.id, count(DISTINCT cap.libro.id))"
						+ " FROM Capitulo cap JOIN cap.autores autor"
						+ " GROUP BY autor.id ",
						Reporte3Query.class);				
						
						List<Reporte3Query> resp3 = query3.getResultList();
						//Imprime los resultados
						resp3.forEach(r -> System.out.println(r));
		em.getTransaction().commit();
		
				em.close();
				emf.close();

	}

}
