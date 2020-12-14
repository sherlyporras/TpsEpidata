package tp1.epidata.excepciones;

public class CaracteristicasInexistentes extends Exception{

	@Override
	public String getMessage() {
		return message;
	}	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String message="No existe caracteristica.";
	

	
	
	
	

}
