package visitor;

import model.CPF;
import model.CartaoCredito;
import model.EMail;
import model.RG;

//Concrete visitor em visitor
public class PontuarVisitor implements Visitor{

    private int pontuacao = 0;

    @Override
    public void visiteEmail(EMail email) {
        VisitorValidador validador = new VisitorValidador();
        email.accept(validador);
        if(validador.validou()){
            this.pontuacao = 1;
            return;
        }
        this.pontuacao = 0;
    }

    @Override
    public void visiteCpf(CPF cpf) {
        VisitorValidador validador = new VisitorValidador();
        cpf.accept(validador);
        if(validador.validou()){
            this.pontuacao = 3;
            return;
        }
        this.pontuacao = 0;
    }

    @Override
    public void visiteRG(RG rg) {
        VisitorValidador validador = new VisitorValidador();
        rg.accept(validador);
        if(validador.validou()){
            this.pontuacao = 1;
            return;
        }
        this.pontuacao = 0;
    }

    @Override
    public void visiteCartao(CartaoCredito cartaoDeCredito) {
        VisitorValidador validador = new VisitorValidador();
        cartaoDeCredito.accept(validador);
        if(validador.validou()){
            this.pontuacao = 2;
            return;
        }
        this.pontuacao = 0;
    }
   
    public Integer getPontos(){
        return this.pontuacao;
    }

    
}
