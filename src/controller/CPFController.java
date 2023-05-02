package controller;

import javax.swing.JOptionPane;

public class CPFController {

	public static void validaCPF(String CPF) {
		int[] CpfArray = CPFtoArray(CPF);

		if (verificaCodigo(CpfArray) == true) {
			JOptionPane.showMessageDialog(null, "O CPF é válido");
		} else {
			JOptionPane.showMessageDialog(null, "O CPF é inválido");
		}
	}

	// Transforma o CPF em um vetor
	private static int[] CPFtoArray(String CPF) {
		int[] CpfArray = new int[Math.min(CPF.length(), 11)];
		for (int i = 0; i < CpfArray.length; i++) {
			CpfArray[i] = Integer.parseInt(CPF.substring(i, i + 1));
		}
		return CpfArray;
	}

	// Verifica o Codigo
	private static boolean verificaCodigo(int[] Cpf) {
		int soma = 0;
		for (int i = 0; i < 9; i++) {
			soma += Cpf[i] * (10 - i);
		}
		int resto = soma % 11;
		int primeiro_digito;
		if (resto < 2) {
			primeiro_digito = 0;
		} else {
			primeiro_digito = 11 - resto;
		}
		soma = 0;
		for (int i = 0; i < 9; i++) {
			soma += Cpf[i] * (11 - i);
		}
		soma += primeiro_digito * 2;
		resto = soma % 11;
		int segundo_digito;
		if (resto < 2) {
			segundo_digito = 0;
		} else {
			segundo_digito = 11 - resto;
		}
		if (primeiro_digito == Cpf[9] && segundo_digito == Cpf[10]) {
			return true;
		} else {
			return false;
		}
	}
}
