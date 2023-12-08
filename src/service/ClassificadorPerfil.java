package service;

import java.util.Iterator;

import model.CPF;
import model.CartaoCredito;
import model.Documento;
import model.Perfil;


public class ClassificadorPerfil implements Classificador{
	
	private Perfil perfil;
	
	public ClassificadorPerfil(Perfil perfil) {
		this.perfil = perfil;
	}
	
	
	
	
	public NivelPerfil nivel() {
		boolean hasCPF = false;
		Integer qtdeCC = 0;
		Integer pontuacao = perfil.documentos()
				                  .filter(doc->doc.validar())
				                  .mapToInt(doc->doc.pontuar())
				                  .sum();
		Iterator<Documento> docs = perfil.documentos().iterator();
		while(docs.hasNext()) {
			Documento doc = docs.next();
			if(doc.getClass().equals(CPF.class))
				hasCPF = true;
			else if(doc.getClass().equals(CartaoCredito.class))
				qtdeCC++;
		}
		
		if(hasCPF && pontuacao >= 5)
			return NivelPerfil.OURO;
		else if(qtdeCC >= 1 && pontuacao >=5)			
			return NivelPerfil.PRATA;
		else if(pontuacao >=3)
			return NivelPerfil.BRONZE;
		return NivelPerfil.NAO_VERIFICADO;
	}




	@Override
	public Perfil getPerfil() {
		return this.perfil ;
	}
	
	

}
