package it.uniroma3.asw;

public class GiudizioDipartimentoException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public GiudizioDipartimentoException(){
		
	}

	public GiudizioDipartimentoException(String message){
		super(message);
	}
	
	public GiudizioDipartimentoException(Throwable cause){
		super(cause);
	}
	
	public GiudizioDipartimentoException(String message, Throwable cause){
		super(message,cause);
	}
}

