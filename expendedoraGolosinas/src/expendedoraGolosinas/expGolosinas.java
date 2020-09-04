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

}
