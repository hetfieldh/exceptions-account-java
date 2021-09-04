package application;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Account;
import model.exception.DomainException;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		try {

			System.out.println("Enter account data: ");
			System.out.print("Number: ");
			int number = sc.nextInt();
			sc.nextLine();
			System.out.print("Holder: ");
			String holder = sc.nextLine();
			System.out.print("Initial balance: ");
			double balance = sc.nextDouble();
			System.out.print("Withdraw limit: ");
			double withdrawLimit = sc.nextDouble();

			Account acc = new Account(number, holder, balance, withdrawLimit);

			System.out.println();
			System.out.print("Enter amount for withdraw: ");
			double amount = sc.nextDouble();

			acc.withdraw(amount);

			System.out.println();
			System.out.print("New balance: " + acc.getBalance());

			sc.close();

			// captura do metodo de excecao personalizada
		} catch (DomainException e) {
			System.out.println();
			System.out.println("### Error ###");
			System.out.println("Error in " + e.getMessage());
		} catch (InputMismatchException e) {
			System.out.println();
			System.out.println("### Error ###");
			System.out.println("FATAL Error: Only numbers are accepted!" );
		}
	}
}