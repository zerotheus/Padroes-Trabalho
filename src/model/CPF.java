package model;

import visitor.Visitor;

//Concrete element em Visitor
public class CPF implements Documento{
	
	public String nome;
	public String numero;
	
	
	public CPF(String nome, String numero) {
		super();
		this.nome = nome;
		this.numero = numero;
	}


	@Override
	public String formatar() {
		StringBuilder fmt = new StringBuilder();
		fmt.append("CPF\n");
		fmt.append(this.nome + " - ");
		fmt.append(this.numero.substring(0, 3) + "." + 
				   this.numero.substring(3, 6) + "." +
				   this.numero.substring(6, 9) + "-" + 
				   this.numero.substring(9, 11));
		return fmt.toString();
	}


	@Override
	public boolean validar() {
	    this.numero.replace(".", "");
	    this.numero.replace("-", "");
		return this.numeroValido();
	}


	@Override
	public Integer pontuar() {
		return 3;
	}
	
	
	private boolean numeroValido() {
	    if(this.numero.length() < 11){
			System.out.println("Digitos faltantes");
			return false;
		}
		if(!temSomenteNumeros()){
			System.out.println("CPF tem somente numeros");
			return false;
		}
		return validaCPF();
	}


	public String getNome() {
		return nome;
	}


	public String getNumero() {
		return numero;
	}


	@Override
	public void accept(Visitor visitor) {
		visitor.visiteCpf(this);
	}

	private boolean temSomenteNumeros()  {
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

	private boolean validaCPF(){
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
