package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import entities.Reservation;
import exceptions.DomainException;

public class Main {

	public static void main(String[] args) {
		 
	Scanner sc = new Scanner(System.in);
	SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		
	try {
		System.out.print("Número do quarto: ");
		int numero = sc.nextInt();
		
		System.out.print("Check-in -> (DD/MM/AAAA): ");
		Date checkIn = formato.parse(sc.next());
		
		System.out.print("Check-out -> (DD/MM/AAAA): ");
		Date checkOut = formato.parse(sc.next());
		
		Reservation reserva = new Reservation(numero, checkIn, checkOut);
		System.out.println("Reserva: " + reserva);
		
		
		System.out.print("\nDeseja alterar os dias da sua reseva (s/n) ? ");
		char resp = sc.next().charAt(0);
		
		if(resp == 's') {
			System.out.print("Check-in -> (DD/MM/AAAA): ");
			checkIn = formato.parse(sc.next());
			
			System.out.print("Check-out -> (DD/MM/AAAA): ");
			checkOut = formato.parse(sc.next());
			
			reserva.updateDates(checkIn, checkOut);
			System.out.println("Reserva: " + reserva);
		
		}
		
		System.out.println("Tenha uma boa estadia! :) ");
	}
	catch (ParseException error){
		System.out.println("Data -> Formato inválido");
	}
	catch(DomainException error) {
		System.out.println("Erro na reserva: " + error.getMessage());
	}
	catch(RuntimeException error) {
		System.out.println("Erro inesperado");
	}
	finally {
		if(sc != null) {
			sc.close();
		}
	}
	
	}

}
