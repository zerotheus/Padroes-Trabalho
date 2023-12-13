package proxy;

import model.Perfil;
import service.Classificador;
import service.NivelPerfil;

// Proxy em Proxy
public class ProxyClassificador implements Classificador {
    private Classificador classificador;
    private String usuario;
    private String senha;

    public ProxyClassificador(Classificador classificador, String usuario, String senha) {
        this.classificador = classificador;
        this.usuario = usuario;
        this.senha = senha;
    }

    @Override
    public NivelPerfil nivel() {
        Perfil perfil = classificador.getPerfil();
        if (perfil.getUser().equals(this.usuario) && perfil.getPwd().equals(this.senha)) {
            return classificador.nivel();
        }
        return NivelPerfil.DESCONHECIDO;
    }

    @Override
    public Perfil getPerfil() {
        return classificador.getPerfil();
    }

}
