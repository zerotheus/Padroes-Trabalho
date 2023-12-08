import java.time.LocalDate;

import builder.UsuarioBuilder;
import model.CPF;
import model.CartaoCredito;
import model.EMail;
import model.Perfil;
import model.RG;

public class TesteUm {
    
    private UsuarioBuilder usuarioBuilder = new UsuarioBuilder();

    private void adicionaUmRg(){
        RG rg = new RG("Yasmin", "44.160.170-4", "SSA", LocalDate.now().plusYears(5));
        usuarioBuilder.adicionarRG(rg);
    }    

    private void tentaAdicionaRGMasFalha(){
        RG rg = new RG("Yasmin", "36.786.806-4", "SSA", LocalDate.now().plusYears(5));
        usuarioBuilder.adicionarRG(rg);
    }
    
    private void adicionaCPF(){
        CPF cpf = new CPF("Yasmin", "84881594044");
        usuarioBuilder.adicionarCPF(cpf);
    }

    private void tentaAdicionarCPFMasFalha(){
        CPF cpf = new CPF("Yasmin", "69390262070");
        usuarioBuilder.adicionarCPF(cpf);
    }

    private void adicionaTresCartoes(){
        CartaoCredito cartaoCredito = new CartaoCredito("Yasmin", "5383332454190193", "666", LocalDate.now().plusYears(5));
        usuarioBuilder.adicionaCartaoDeCredito(cartaoCredito);

        CartaoCredito cartaoCreditoDois = new CartaoCredito("Yasmin", "5203647009179393", "389", LocalDate.now().plusYears(5));
        usuarioBuilder.adicionaCartaoDeCredito(cartaoCreditoDois);

        CartaoCredito cartaoCreditoTres = new CartaoCredito("Yasmin", "5386198457209521", "627", LocalDate.now().plusYears(5));
        usuarioBuilder.adicionaCartaoDeCredito(cartaoCreditoTres);
    }

    private void tentaAdicionarCartaoMasFalha(){
        CartaoCredito cartaoCredito = new CartaoCredito("Yasmin", "5268 4793 2840 1478", "836", LocalDate.now().plusYears(5));
        usuarioBuilder.adicionaCartaoDeCredito(cartaoCredito);
    }

    private void adicionaDoisEmails(){
        EMail email = new EMail("Bollaz@gmail.com");
        EMail emailDois = new EMail("YazSZ@gmail.com");
        usuarioBuilder.adicionarEmail(email);
        usuarioBuilder.adicionarEmail(emailDois);
    }

    private void tenteAdicionarEmailComFalha(){
        EMail email = new EMail("YazBollaz@gmail.com");
        usuarioBuilder.adicionarEmail(email);

    }

    private void defineSenha(){
        usuarioBuilder.definirSenha("Odeio Sergio Moro");
    }

    private void definirUsuario(){
        usuarioBuilder.definirUsuario("Roubou seu coracao");
    }

    public void teste(){
        adicionaUmRg();
        tentaAdicionaRGMasFalha();
        adicionaCPF();
        tentaAdicionarCPFMasFalha();
        adicionaTresCartoes();
        tentaAdicionarCartaoMasFalha();
        adicionaDoisEmails();
        tenteAdicionarEmailComFalha();
        Perfil yasmin = usuarioBuilder.getPerfil("yasmin");
        System.out.println(yasmin.toString());
        System.out.println(yasmin.getPwd());
        System.out.println(yasmin.getUser());
        defineSenha();
        definirUsuario();
        Perfil vagabundo = usuarioBuilder.getPerfil("Lula");
        System.out.println(vagabundo.toString());
        System.out.println(vagabundo.getUser() + " usuario");
        System.out.println(vagabundo.getPwd() + " senha");

        definirUsuario();
        Perfil fakeLula = usuarioBuilder.getPerfil("Lula");
        System.out.println(fakeLula.toString() + "So com Usuario");
        System.out.println(fakeLula.getUser()+ " Usuario");
        System.out.println(fakeLula.getPwd() + " Senha");

        defineSenha();
        Perfil lula = usuarioBuilder.getPerfil("Lulinha");
        System.out.println(lula.toString() + " So com senha");
        System.out.println(lula.getUser() + " Usuario");
        System.out.println(lula.getPwd() + " Senha");
    }

}
