package view;

import javax.swing.JOptionPane;
import controller.CPFController;

public class Principal {

	public static void main(String[] args) {
		String CPF = JOptionPane.showInputDialog("Insira o seu CPF, sem pontos e hífen, para que possamos validá-lo");
		CPFController.validaCPF(CPF);
	}
}
