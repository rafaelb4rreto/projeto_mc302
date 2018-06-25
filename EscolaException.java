public class EscolaException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EscolaException() {
		
	}
	
	public EscolaException(String message) {
		
		super(message);
		
	}

	public EscolaException(String message,Throwable cause) {
		
		super(message, cause);
	}

	public EscolaException(Throwable cause) {
		
		super(cause);
	}
}