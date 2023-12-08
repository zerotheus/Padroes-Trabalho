package builder;

import model.CPF;
import model.CartaoCredito;
import model.EMail;
import model.RG;

// interface Builder
public interface Builder {
    
    public void adicionarCPF(CPF cpf);
    
    public void adicionarRG(RG rg);
    
    public void adicionaCartaoDeCredito(CartaoCredito cartaoDeCredito);

    public void adicionarEmail(EMail email);

    public void definirUsuario(String usuario);
    
    public void definirSenha(String senha);    

    public void reset();

}
