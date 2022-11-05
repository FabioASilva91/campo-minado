package com.fabio.cm.visao;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

import com.fabio.cm.excecao.ExplosaoException;
import com.fabio.cm.excecao.SairException;
import com.fabio.cm.modelo.Tabuleiro;

public class TabuleiroConsole {
	
	private Tabuleiro tabuleiro;
	private Scanner entrada = new Scanner(System.in);
	
	public TabuleiroConsole(Tabuleiro tabuleiro) {
		this.tabuleiro = tabuleiro;
		
		executarjogo();
	}

	private void executarjogo() {
		try {
			boolean continuar = true;
			
			while (continuar) {
				cicloDoJogo();
				
				System.out.println("Outra partida? (S/n)");
				String resposta = entrada.nextLine();
				
				if ("n".equalsIgnoreCase(resposta)) {
					continuar = false;
				}else {
					tabuleiro.reiniciar();
				}
			}
		} catch (SairException e) {
			System.out.println("Tchau!!!!");
		} finally {
			entrada.close();
		}
		
	}

	private void cicloDoJogo() {
		try {
			while (!tabuleiro.objeticoAlcancado()) {
				System.out.println(tabuleiro);
				
				String digitado = CapturaValorDigitado("Digite (x, y): ");
				
				Iterator<Integer> xy =  Arrays.stream(digitado.split(","))
					.map(e -> Integer.parseInt(e.trim())).iterator();
				
				digitado = CapturaValorDigitado("1 - Abrir ou 2 - (Des)marcar");
				if ("1".equals(digitado)) {
					tabuleiro.abrir(xy.next(), xy.next());
				} else if("2".equals(digitado)) {
					tabuleiro.alterarMarcacao(xy.next(), xy.next());
				}
				
			}
			
			System.out.println("Você ganhou!!!");
		} catch (ExplosaoException e) {
			System.out.println("Você perdeu!");
		}
		
	}
	
	private String CapturaValorDigitado(String texto) {
		System.out.println(texto);
		String digitato = entrada.nextLine();
		
		if("sair".equalsIgnoreCase(digitato)) {
			throw new SairException();
		}
		return digitato;
	}
	

}
