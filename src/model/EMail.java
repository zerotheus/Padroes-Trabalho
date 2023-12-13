package model;

import visitor.Visitor;

//Concrete element em Visitor
public class EMail implements Documento {

	public static final String REGEX = "^[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?$";

	private String conta;

	public EMail(String conta) {
		super();
		this.conta = conta;
	}

	public static String getRegex() {
		return REGEX;
	}

	public String getConta() {
		return conta;
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visiteEmail(this);
	}

}
