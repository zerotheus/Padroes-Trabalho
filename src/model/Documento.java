package model;

import visitor.Visitor;

public interface Documento {
	public String formatar();
	public boolean validar();
	public Integer pontuar();
	public void accept(Visitor visitor);
}
