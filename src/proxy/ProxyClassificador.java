package proxy;

import model.Perfil;
import service.Classificador;
import service.ClassificadorPerfil;
import service.NivelPerfil;

// Proxy em Proxy
public class ProxyClassificador implements Classificador{
    private ClassificadorPerfil classificadorPerfil;
    private String usuario;
    private String senha;

    public ProxyClassificador(Perfil perfil, String usuario, String senha) {
        this.classificadorPerfil = new ClassificadorPerfil(perfil);
        this.usuario = usuario;
        this.senha = senha;
    }

    @Override
    public NivelPerfil nivel() {
        Perfil perfil = classificadorPerfil.getPerfil();
        if (perfil.getUser().equals(this.usuario) && perfil.getPwd().equals(this.senha)) {
            return classificadorPerfil.nivel();
        }
        return NivelPerfil.DESCONHECIDO;
    }

    @Override
    public Perfil getPerfil() {
        return classificadorPerfil.getPerfil();
    }
    
}
