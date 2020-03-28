package fundamentos;

import java.util.Scanner;

public class ValorUser {
    
	public static void main(String[]args) {
		
		try (Scanner entrada = new Scanner(System.in)) {
			System.out.print("Digite seu nome: ");
			String nome = entrada.nextLine();
			
			System.out.print("Digite sua idade:  ");
			int idade = entrada.nextInt();
			
			if(idade > 18) {
				System.out.print("ola senhor "+ nome +" Voce tem "+ idade +" de idade voce e um adulto ");
			}else {
				System.out.print("ola senhor "+ nome + " voce tem "+ idade +" de idade Voce e um adolecente ");
			}
		}
		
 	

	}
}
