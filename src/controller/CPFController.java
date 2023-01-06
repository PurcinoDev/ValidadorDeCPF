package controller;

import javax.swing.*;

public class CPFController {
	
	public CPFController() {
		super();
	}
	
	public void validaCPF(String CPF) {
		int[] CpfArray = CPFtoArray(CPF);
		
		if (verificaCodigo(1, CpfArray) == true) {
			JOptionPane.showMessageDialog(null, "O CPF é válido");
		} else {
			JOptionPane.showMessageDialog(null, "O CPF é inválido");
		}
	}
	
//	Transforma o CPF em um vetor
	private int[] CPFtoArray(String CPF) {
		int[] CpfArray = new int[11];
		for(int i = 0; i <= 10; i++) {
			CpfArray[i] = Integer.parseInt(String.valueOf(CPF.charAt(i)));
		}
		return CpfArray;
	}
	
//	Verifica o Codigo
	private boolean verificaCodigo(int posicaoCodigo, int[] Cpf) {
		int j = 0;
		if (posicaoCodigo == 1) {
			j = 10;
		} else {
			j = 11;
		}
		
		
		int indexParameter = 7 + posicaoCodigo;
		
		int resultado = 0;
		for (int i = 0 ; i <= indexParameter; i++) {
			resultado += j * Cpf[i];
			j--;
		}
		
		int restoDiv = resultado % 11;
		if (restoDiv < 2) {
			if (Cpf[indexParameter + 1] == 0) {
				if (posicaoCodigo == 1) {
					return verificaCodigo(2, Cpf);
				} else {
					return true;
				}
			} else {
				return false;
			}
		} else {
			int dif = 11 - restoDiv;
			if (Cpf[indexParameter + 1] == dif) {
				if (posicaoCodigo == 1) {
					return verificaCodigo(2, Cpf);
				} else {
					return true;
				}
			} else {
				return false;
			}
		}
	}
	
	
	
}
