package expendedoraGolosinas;

import java.util.Scanner;

public class expGolosinas {
	//creamos un scanner estatico
	Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		//llamamos al menu
		menu();
				
	}
	/*
	 * muestra el menu, solicita la opcion
	 * y la ejecuta
	 * */
	private static void menu() {
		//nombramos las golosinas
		String[][] nombreGolosinas = {
				{"Kitkat", "Chicles de fresa", "Pulparindos", "Paletas"},
				{"Kinder Bueno", "Bolsa de dulces variado", "Cheetos", "Snicker"},
				{"M&M´s", "Papas Sabritas", "Chicles de menta", "Gomitas"},
				{"Yakult", "Crunch", "Milkybar", "Duvalin"},
				
		};
		//precio de las golosinas
		double [][] precio = {
				{1.1, 0.8, 1.5, 0.9},
				{1.8, 1, 1.2, 1},
				{1.8, 1.3, 1.2, 0.8},
				{1.5, 1.1, 1.1, 1.1}
		};
		
		
	}

}
