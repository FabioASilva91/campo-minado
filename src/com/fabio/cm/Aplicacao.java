package com.fabio.cm;

import com.fabio.cm.modelo.Tabuleiro;
import com.fabio.cm.visao.TabuleiroConsole;

public class Aplicacao {
	
	public static void main(String[] args) {
		
		Tabuleiro tabuleiro = new Tabuleiro(6, 6, 6);
		new TabuleiroConsole(tabuleiro);
		

	}

}
