package gitExercice03;

import java.util.Scanner;

public class GitExo03 {

	public static void main(String[] args) {

		boolean isNumberValid = false;
		int gameChoice = 0;

		Scanner scan = new Scanner(System.in);

		System.out.println("Entrer le nombre de chevaux au départ: (12 - 20)");
		int horsesOnStart = Integer.parseInt(scan.nextLine());
		while (horsesOnStart < 12 || horsesOnStart > 20) {

			System.out.println("Veuillez entrer un nombre entre 12 et 20");
			horsesOnStart = Integer.parseInt(scan.nextLine());
		}
		System.out.println("Voulez vous jouer au tiercé (1), au quarté (2) ou au quinté (3) ?");
		gameChoice = Integer.parseInt(scan.nextLine());
		switch (gameChoice) {
		case 1:
			System.out.println("On joue au tiercé");
			break;
		case 2:
			System.out.println("On joue au quarté");
			break;
		case 3:
			System.out.println("On joue au quinté");
			break;
		}
	
	}

}
