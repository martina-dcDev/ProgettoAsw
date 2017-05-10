package it.uniroma3.asw;

public class IndicatoreGiudizioException extends Exception {

	private static final long serialVersionUID = 1L;

	public IndicatoreGiudizioException(){
		
	}

	public IndicatoreGiudizioException(String message){
		super(message);
	}
	
	public IndicatoreGiudizioException(Throwable cause){
		super(cause);
	}
	
	public IndicatoreGiudizioException(String message, Throwable cause){
		super(message,cause);
	}
}
