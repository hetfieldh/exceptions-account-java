package model.exception;

// classe de DomainException extendendo a classe RuntimeException (compilador nao obriga a tratar as excecoes)
public class DomainException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	// construtor com o argumento em String com a mensagem, lancando esta na superclasse
	public DomainException(String msg) {
		super(msg);
	}

}
