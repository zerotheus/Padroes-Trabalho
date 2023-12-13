package model;

import visitor.Visitor;

//Element em Visitor
public interface Documento {
	public void accept(Visitor visitor);
}
