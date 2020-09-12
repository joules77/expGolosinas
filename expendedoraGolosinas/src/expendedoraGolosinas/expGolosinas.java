package expendedoraGolosinas;

import java.util.InputMismatchException;
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
					if(validarPos(nombreGolosinas, pos)) {
						//extraigo la fila y la columna
						fila = extraerNumero(pos, 0);
						columna = extraerNumero(pos, 1);
						//indico si hay valores en la matriz
						if(hayValorPosicion(cantidad, fila, columna)) {
							//muestro golosina
							System.out.println("Aqui tiene su golosina: " +nombreGolosinas[fila][columna] +"Gracias por su compra");
							//reduzco la cantidad en 1
							reducirPosicion(cantidad, fila, columna, 1);
							//aumento la cantidad
							ventasTotales += precio[fila][columna];
						}else {
							System.out.println("No hay mas golosinas de este tipo, elija otra opcion");
						}
					}else {
						System.out.println("La posicion introducida no es valida intente de nuevo");
					}
					break;
				case 2:
					//muestro las golosinas
					mostrarGolosinas(nombreGolosinas, precio);
					break;
				case 3:
					//pido el password
					password = pedirCadena("Intriduce la contraseña");
					//compruebo si es correcta la contraseña
					if(cadenaIguales(password, "Maquina Expendedora 2020")) {
						//pido la posicion
						pos = pedirCadena("Introduce la posicion que quiera");
						//extraigo los numeros
						fila = extraerNumero(pos, 0);
						columna = extraerNumero(pos, 1);
						//validamos la posicion dada
						if(validarPos(nombreGolosinas, pos)) {
							//introducimos la cantidad
							cantidadNueva = pedirInteger("Introduce la cantidad");
							//aumentamos la cantidad en el valor dado
							aumentarPosicion(cantidad, fila, columna, cantidadNueva);
							System.out.println("Se ha incrementado la cantidad");
						}else {
							System.out.println("La posicion introducida no es valida");
						}
						
					}else {
						System.out.println("La contraseña es incorrecta");
					}
					break;
				case 4:
					//muestro las ventas
					System.out.println("Las ventas han sido de: " + ventasTotales);
					
					salir = true;
					break;
					default:
						System.out.println("las ocupaciones son entre 1 y 7");
				}
			//controla la excepcion en caso de que se introduzca un valor incorrecto	
			}catch(InputMismatchException e) {
				System.out.println("Debes ecribir un numero");
				sc.next();
			}
		}
		System.out.println("Fin del menu");
	}
	/*
	 * rellena la matriz con numeros
	 * param matriz
	 * param num
	 * */
	public static void rellenarMatriz(int[][] matriz, int num) {
		for(int i = 0; i < matriz.length; i++) {
			for(int j = 0; j < matriz.length; j++) {
				matriz[i][j] = num;
			}
		}
	}
	/*
	 * pide una cadena
	 * param mensaje
	 * return
	 * */
	public static String pedirCadena(String mensaje) {
		System.out.println(mensaje);
		String cadena = sc.next();
		
		return cadena;
	}
	/*
	 * pedir un integer
	 * param mensaje
	 * return
	 * */
	public static int pedirInteger(String mensaje) {
		System.out.println(mensaje);
		int numero = sc.nextInt();
		
		return numero;
	}
	/*
	 * valida si una posicion es correcta
	 * param matriz
	 * param pos
	 * return
	 * */
	public static boolean validarPos(String [][] matriz, String pos) {
		if(pos.length() != 2) {
			return false;
		}
		if(!(esNumero(pos.substring(0, 1)) && esNumero(pos.substring(1, 2)))) {
			return false;
		}
		int fila = extraerNumero(pos, 0);
		int columna = extraerNumero(pos, 1);
		
		if(!((fila >= 0 && fila < matriz.length) && (columna >= 0 && columna < matriz[0].length))) {
			return false;
		}
		return true;
	}
	/*
	 * indico si un string es un numero
	 * param num
	 * return
	 * */
	public static boolean esNumero(String num) {
		try {
			Integer.parseInt(num);
			return true;
		}catch(NumberFormatException e) {
			return false;
		}
	}
	/*
	 * extraigo el numero, -1 si ha habido un error
	 * param numero
	 * param pos
	 * return
	 * */
	public static int extraerNumero(String numero, int pos) {
		int num = -1;
		if(esNumero(numero)) {
			num = Integer.parseInt(numero.substring(pos, pos + 1));
		}
		return num;
	}
	/*
	 * reduce la cantidad de una posicion en concreto
	 * param matriz
	 * param fila
	 * param columna
	 * param cantidad
	 * */
	public static void reducirPosicion(int[][] matriz, int fila, int columna, int cantidad) {
		matriz[fila][columna] -= cantidad;
	}
	/*
	 * indica si en una posicion hay un valor mayor que 0
	 * param matriz
	 * param fila
	 * param columna
	 * return
	 * */
	public static boolean hayValorPosicion(int[][] matriz, int fila, int columna) {
		if(matriz[fila][columna] > 0) {
			return true;
		}
		return false;
	}
	/*
	 * muestra las golosinas
	 * param nombres
	 * param precios
	 * */
	public static void mostrarGolosinas(String[][] nombres, double[][] precios) {
		for(int i = 0; i < nombres.length; i++) {
			for(int j = 0; j < nombres[i].length; j++) {
				System.out.println(i + "" + j + "" + nombres[i][j] + "" + precios[i][j]);
			}
		}
	}
	/*
	 * indica si dos cadenas son iguales
	 * param cadena1
	 * param cadena2
	 * return
	 * */
	public static boolean cadenaIguales(String cadena1, String cadena2) {
		if(cadena1.equals(cadena2)) {
			return true;
		}else {
			return false;
		}
	}
	/*
	 * aumenta la cantidad de una posicion
	 * param matriz
	 * param fila
	 * param columna
	 * param cantidad
	 * */
	public static void aumentarPosicion(int[][] matriz, int fila, int columna, int cantidad) {
		matriz[fila][columna] += cantidad;
	}

}
