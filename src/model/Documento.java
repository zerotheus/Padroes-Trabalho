package model;

import visitor.Visitor;

//Element em Visitor
public interface Documento {
	public String formatar();

	public boolean validar();

	public Integer pontuar();

	public void accept(Visitor visitor);
}
