package service;

import java.util.Iterator;
import java.util.List;

import model.CPF;
import model.CartaoCredito;
import model.Documento;
import model.Perfil;
import visitor.PontuarVisitor;
import visitor.VisitorValidador;

//Serviço em Proxy
public class ClassificadorPerfil implements Classificador {

	private Perfil perfil;

	public ClassificadorPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	public NivelPerfil nivel() {
		boolean hasCPF = false;
		Integer qtdeCC = 0;
		Integer pontuacao = 0;
		List<Documento> documentos = perfil.documentos().toList();
		for (Documento documento : documentos) {
			VisitorValidador validador = new VisitorValidador();
			PontuarVisitor pontuador = new PontuarVisitor();
			documento.accept(validador);
			if (validador.validou()) {
				documento.accept(pontuador);
				pontuacao += pontuador.getPontos();
			}
		}
		Iterator<Documento> docs = perfil.documentos().iterator();
		while (docs.hasNext()) {
			Documento doc = docs.next();
			if (doc.getClass().equals(CPF.class))
				hasCPF = true;
			else if (doc.getClass().equals(CartaoCredito.class))
				qtdeCC++;
		}
		if (hasCPF && pontuacao >= 5)
			return NivelPerfil.OURO;
		else if (qtdeCC >= 1 && pontuacao >= 5)
			return NivelPerfil.PRATA;
		else if (pontuacao >= 3)
			return NivelPerfil.BRONZE;
		return NivelPerfil.NAO_VERIFICADO;
	}

	@Override
	public Perfil getPerfil() {
		return this.perfil;
	}

}
