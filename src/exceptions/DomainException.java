package exceptions;

public class DomainException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	//  serve para rastrear a compatibilidade de vers�es serializadas das classes
	public DomainException(String mensagem) {
		super(mensagem);
	}
}
