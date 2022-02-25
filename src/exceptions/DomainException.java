package exceptions;

public class DomainException extends RuntimeException {
	
	public DomainException(String mensagem) {
		super(mensagem);
	}
}
