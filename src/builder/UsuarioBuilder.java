package builder;

import java.util.ArrayList;
import java.util.List;

import model.CPF;
import model.CartaoCredito;
import model.Documento;
import model.EMail;
import model.Perfil;
import model.RG;

public class UsuarioBuilder implements Builder{

    private List<Documento> documentos = new ArrayList<Documento>();
    private String senha;
    private String usuario;
    private short cpfRegistrados = 0;
    private short rgsRegistrados = 0;
    private short emailsRegistrados = 0;
    private short cartoesRegistrados = 0;

    @Override
    public void adicionarCPF(CPF cpf) {
        if(cpfRegistrados > 0){
            System.out.println("Somente permitido um cpf por usuario");
            return;
        }
        cpfRegistrados++;
        documentos.add(cpf);
        System.out.println("cpf Salvo");
    }

    @Override
    public void adicionarRG(RG rg) {
        if(rgsRegistrados > 0){
            System.out.println("Somente permitido um rg por usuario");
            return;
        }
        rgsRegistrados++;
        documentos.add(rg);
        System.out.println("rg Salvo");
    }

    @Override
    public void adicionaCartaoDeCredito(CartaoCredito cartaoDeCredito) {
        if(cartoesRegistrados > 2){
            System.out.println("Somente permtido tres cartoes por usuarios");
            return;
        }
        cartoesRegistrados++;
        documentos.add(cartaoDeCredito);
        System.out.println("Cartao adicionado");
    }

    @Override
    public void adicionarEmail(EMail email) {
        if(emailsRegistrados > 1){
            System.out.println("Somente permitido dois emails por usuario");
            return;
        }
        emailsRegistrados++;
        documentos.add(email);
        System.out.println("Email adicionado");
    }

    @Override
    public void definirUsuario(String usuario) {
        this.usuario = usuario;
    }

    @Override
    public void definirSenha(String senha) {
        this.senha = senha;
    }

    public Perfil getPerfil(String nome){
        Perfil perfil = new Perfil(nome, this.escolheUsuario(nome), this.escolheSenha(nome), this.documentos);
        this.reset();
        return perfil;
    }

    private String escolheSenha(String nome) {
        if(senha == null)
            return nome;
        return this.senha;
    }

    private String escolheUsuario(String nome) {
        if(usuario == null)
            return nome;
        return this.usuario;
    }

    @Override
    public void reset() {
        this.documentos = new ArrayList<Documento>();
        this.senha = null;
        this.usuario = null;
        this.cpfRegistrados = 0;
        this.rgsRegistrados = 0;
        this.emailsRegistrados = 0;
        this.cartoesRegistrados = 0;
    }
    
}
