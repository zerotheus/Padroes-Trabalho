package visitor;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import model.CPF;
import model.CartaoCredito;
import model.EMail;
import model.RG;

//Concrete visitor em visitor
public class FormatadorVisitor implements Visitor {

    private String formatada;

    public String getFormatada() {
        return formatada;
    }

    @Override
    public void visiteEmail(EMail email) {
        this.formatada = "E-MAIL\n" + email.getConta();
    }

    @Override
    public void visiteCpf(CPF cpf) {
        StringBuilder fmt = new StringBuilder();
        String nome = cpf.getNome(), numero = cpf.getNumero();
        fmt.append("CPF\n");
        fmt.append(nome + " - ");
        fmt.append(numero.substring(0, 3) + "." +
                numero.substring(3, 6) + "." +
                numero.substring(6, 9) + "-" +
                numero.substring(9, 11));
        this.formatada = fmt.toString();
    }

    @Override
    public void visiteRG(RG rg) {
        String nome = rg.getNome(), numero = rg.getNumero(), expedidor = rg.getExpedidor();
        LocalDate validade = rg.getValidade();
        StringBuilder fmt = new StringBuilder();
        fmt.append("RG\n");
        fmt.append(nome + "\n");
        fmt.append(numero.substring(0, numero.length() - 2) + "-");
        fmt.append(numero.substring(numero.length() - 2, numero.length()) + " - ");
        fmt.append(expedidor + "\n");
        fmt.append("Validade: " + validade.format(DateTimeFormatter.ofPattern("dd/MM/yy")));
        this.formatada = fmt.toString();
    }

    @Override
    public void visiteCartao(CartaoCredito cartaoDeCredito) {
        StringBuilder fmt = new StringBuilder();
        String nome = cartaoDeCredito.getNome(), numero = cartaoDeCredito.getNumero();
        String cvc = cartaoDeCredito.getCvc();
        LocalDate vencimento = cartaoDeCredito.getVencimento();
        fmt.append("CART�O DE CR�DITO\n");
        fmt.append(nome + "\n");
        fmt.append(numero.substring(0, 4) + " ");
        fmt.append(numero.substring(4, 8) + " ");
        fmt.append(numero.substring(8, 12) + " ");
        fmt.append(numero.substring(12, 16) + "\n");
        fmt.append(cvc + "\n");
        fmt.append(vencimento.format(DateTimeFormatter.ofPattern("MM/yy")));
        this.formatada = fmt.toString();
    }

}
