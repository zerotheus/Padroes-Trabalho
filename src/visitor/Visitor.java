package visitor;

import model.CPF;
import model.CartaoCredito;
import model.EMail;
import model.RG;

//visitor em visitor
public interface Visitor {
    
    public void visiteEmail(EMail email);
    public void visiteCpf(CPF cpf);
    public void visiteRG(RG rg);
    public void visiteCartao(CartaoCredito cartaoDeCredito);

}
