package service;
import model.Perfil;

// Interface do serviço em Proxy
public interface Classificador {
	
	public NivelPerfil nivel();
	public Perfil getPerfil();
	
}
