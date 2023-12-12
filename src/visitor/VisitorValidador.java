package visitor;

import java.time.LocalDate;
import java.util.regex.Pattern;

import model.CPF;
import model.CartaoCredito;
import model.EMail;
import model.RG;

//Concrete visitor em visitor
public class VisitorValidador implements Visitor{

    private boolean isValido = false;

    @Override
    public void visiteEmail(EMail email) {
        String REGEX = EMail.REGEX;
        isValido = Pattern.compile(REGEX)
	    	      .matcher(email.getConta())
	    	      .matches();
    }

    @Override
    public void visiteCpf(CPF cpf) {
        String numero = cpf.getNumero();
        numero.replace(".", "");
	    numero.replace("-", "");
        isValido = temSomenteNumeros(numero) && validaCPF(numero);     
    }

    @Override
    public void visiteRG(RG rg) {
        LocalDate validade = rg.getValidade();
        this.isValido = validade.isAfter(LocalDate.now());  
    }

    @Override
    public void visiteCartao(CartaoCredito cartaoDeCredito) {
        String numeroDoCartao = cartaoDeCredito.getNumero();
		numeroDoCartao.replace(" ", "");
        
        LocalDate vencimento = cartaoDeCredito.getVencimento();

        this.isValido = verificaLuhnDoCartao(numeroDoCartao) && vencimento.isAfter(LocalDate.now()); 
    }

    public boolean validou(){
        return this.isValido;
    }

    private boolean verificaLuhnDoCartao(String numero) {
		int sum = 0;
		boolean shouldDouble = false;
		for (int iCont = numero.length() - 1; iCont >= 0; iCont--) {
			int digit = numero.charAt(iCont) - '0';
		    if (shouldDouble) {
		      if ((digit *= 2) > 9) digit -= 9;
		    }
		    sum += digit;
		    shouldDouble = !shouldDouble;
		  }
		return (sum % 10) == 0;		
	}

    private boolean temSomenteNumeros(String numero)  {
        for (int i = 0; i < 9; i++) {
            if(!ehUmDigito(numero.charAt(i))){
				return false;
			}
        }
		return true;
    }

	private boolean ehUmDigito(char character)  {
        if (!Character.isDigit(character)) {
            return false;
        }
		return true;
    }

	private boolean validaCPF(String numero){
		int digitoVerificadorUm = numero.charAt(9) - '0';
		int digitoVerificadorDois = numero.charAt(10) - '0';
		int primeiraSoma = 0,segundaSoma = 0;
		int resultadoDigitoUm, resultadoDigitoDois;
		for (int i = 0;i< 10;i++){
			if(i<9){
				primeiraSoma += (10 - i) * (numero.charAt(i) - '0');
				segundaSoma += (11 - i) * (numero.charAt(i) - '0');
				continue;
			}
			segundaSoma += (11 - i) * (numero.charAt(i) - '0');
		}
		int restoUm = primeiraSoma % 11; 
		int restoDois = segundaSoma % 11;
		if (restoUm < 2) {
			resultadoDigitoUm = 0;
		}else{
			resultadoDigitoUm = 11 - restoUm;
		}
		if (restoDois < 2) {
			resultadoDigitoDois = 0;
		}else{
			resultadoDigitoDois = 11 - restoDois;
		}
		return (resultadoDigitoUm == digitoVerificadorUm) && (resultadoDigitoDois == digitoVerificadorDois);
	}

    
}
