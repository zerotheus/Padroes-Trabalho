package model;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

import visitor.FormatadorVisitor;
import visitor.VisitorValidador;

//Product em Builder
//client em visitor 
public class Perfil {

	private List<Documento> documentos;
	private String nome;
	private String user;
	private String pwd;

	public Perfil(String nome, String user, String pwd) {
		this(nome, user, pwd, new LinkedList<Documento>());
	}

	public Perfil(String nome, String user, String pwd, List<Documento> documentos) {
		this.documentos = documentos;
		this.nome = nome;
		this.user = user;
		this.pwd = pwd;
	}

	public void adicionar(Documento documento) {
		this.documentos.add(documento);
	}

	public String getNome() {
		return this.nome;
	}

	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append(this.nome + "\n");
		for (Documento doc : this.documentos) {
			FormatadorVisitor formatador = new FormatadorVisitor();
			VisitorValidador validador = new VisitorValidador();
			doc.accept(formatador);
			doc.accept(validador);
			str.append(formatador.getFormatada() + (validador.validou() ? " [Válido]" : "") + "\n");
		}
		return str.toString();
	}

	public String getUser() {
		return user;
	}

	public String getPwd() {
		return pwd;
	}

	public Stream<Documento> documentos() {
		return this.documentos.stream();
	}

}
