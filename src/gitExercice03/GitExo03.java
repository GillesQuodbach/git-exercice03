package gitExercice03;

import java.awt.RenderingHints.Key;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class GitExo03 {

	public static void main(String[] args) {
		// Variables
		int raceDistance = 2400;
		int gameChoice = 0;
		int horsesNumber = 12;
		
		//Liste des chevaux
		HashMap<Integer, Integer[]> horsesListHashMap = new HashMap<>();

		Scanner scan = new Scanner(System.in);
		
		// Remplissage de la map
		for (int i = 0; i < horsesNumber;i++) {
			horsesListHashMap.put(i, new Integer[] {0,0});
		}
		
		//Affichage de la map
		for (Map.Entry<Integer, Integer[]> entry : horsesListHashMap.entrySet()) {
			int horseNumber = entry.getKey();
			Integer[] values = entry.getValue();
			
			System.out.println("Cheval numéro : " + horseNumber + ", données : ");
			for (Integer valueInteger : values) {
				System.out.println(valueInteger + " ");
			}
			System.out.println();
		}
		

		// Jet de dé
		int min = 1;
		int max = 6;
		int randomNumber = (int) (Math.random() * (max - min + 1)) + min;
//		System.out.println("Jet du dé: " + randomNumber);

//		System.out.println("Entrer le nombre de chevaux au départ: (12 - 20)");
//		int horsesOnStart = Integer.parseInt(scan.nextLine());
//		while (horsesOnStart < 12 || horsesOnStart > 20) {
//
//			System.out.println("Veuillez entrer un nombre entre 12 et 20");
//			horsesOnStart = Integer.parseInt(scan.nextLine());
//		}
//		System.out.println("Voulez vous jouer au tiercé (1), au quarté (2) ou au quinté (3) ?");
//		gameChoice = Integer.parseInt(scan.nextLine());
//		switch (gameChoice) {
//		case 1:
//			System.out.println("On joue au tiercé");
//			break;
//		case 2:
//			System.out.println("On joue au quarté");
//			break;
//		case 3:
//			System.out.println("On joue au quinté");
//			break;
//		}

	}

}
