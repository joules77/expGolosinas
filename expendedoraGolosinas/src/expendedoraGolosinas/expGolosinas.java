package expendedoraGolosinas;

import java.util.Scanner;

public class expGolosinas {
	//creamos un scanner estatico
	static Scanner sc = new Scanner(System.in);
	
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
		int cantidad[][] = new int[4][4];
		//rellenar matriz con 5
		rellenarMatriz(cantidad, 5);
		//indicamos si salimos o no
		boolean salir = false;
		int opcion, fila, columna, cantidadNueva;
		String pos, password;
		double ventasTotales = 0;
		
		//bucle para pedir las opciones hasta que se elija salir
		while(!salir) {
			//opciones
			System.out.println("1. Pedir golosinas");
			System.out.println("2. Mostrar golosinas");
			System.out.println("3. Rellenar golosinas");
			System.out.println("4. Apagar maquina");
			
			try {
				//pide opcion
				System.out.println("Introduce numero");
				opcion = sc.nextInt();
				
				//realiza una de las opciones
				switch (opcion) {
				case 1:
					//pido la posicion
					pos = pedirCadena("Introdusca la posicion que deseada");
					
					//validamos la posicion
					
				}
			}
		}
	}

}
