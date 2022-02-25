package exceptions;

public class DomainException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	//  serve para rastrear a compatibilidade de versões serializadas das classes
	public DomainException(String mensagem) {
		super(mensagem);
	}
}
