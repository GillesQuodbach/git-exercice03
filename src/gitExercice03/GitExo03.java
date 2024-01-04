package gitExercice03;

import java.util.*;
import org.omg.CORBA.portable.ValueBase;

public class GitExo03 {

	// TODO récupérer toutes les valeurs de distances du tableau, la premère arrivée
	// à 2400 => STOP

	// Jet du dé
	public static int dieRoll() {
		int min = 1;
		int max = 6;
		int randomNumber = (int) (Math.random() * (max - min + 1)) + min;
		return randomNumber;
	}

	// Calcul de la distance à parcourir pendant le tour en fonction de la vitesse
	public static int distanceCalc(int lapSpeed) {
		int distance = 0;
		switch (lapSpeed) {
		case 0:
			distance = 0;
			break;
		case 1:
			distance = 23;
			break;
		case 2:
			distance = 46;
			break;
		case 3:
			distance = 69;
			break;
		case 4:
			distance = 92;
			break;
		case 5:
			distance = 115;
			break;
		case 6:
			distance = 138;
		}
		return distance;

	}

	// Modification de la vitesse en fonction du jet de dé
	public static int updateSpeedCalc(int dieRoll, int actualSpeed) {
		int speedIncDec = 0;
		// Vitesse = 0
		if ((actualSpeed == 0) && (dieRoll == 2 || dieRoll == 3 || dieRoll == 4)) {
			return speedIncDec = 1;
		} else if (actualSpeed == 0 && (dieRoll == 5 || dieRoll == 6)) {
			return speedIncDec = 2;
		} else if (actualSpeed == 0 && (dieRoll == 1)) {
			return speedIncDec = 0;
		}
		// Vitesse = 1 ET Vitesse = 2
		if ((actualSpeed == 1 || actualSpeed == 2) && (dieRoll == 1 || dieRoll == 2)) {
			return speedIncDec = 0;
		} else if ((actualSpeed == 1 || actualSpeed == 2) && (dieRoll == 3 || dieRoll == 4 || dieRoll == 5)) {
			return speedIncDec = 1;
		} else if ((actualSpeed == 1 || actualSpeed == 2) && (dieRoll == 6)) {
			return speedIncDec = 2;
		}
		// Vitesse = 3
		if ((actualSpeed == 3) && (dieRoll == 1)) {
			return speedIncDec = -1;
		} else if (actualSpeed == 3 && (dieRoll == 2 || dieRoll == 3)) {
			return speedIncDec = 0;
		} else if (actualSpeed == 3 && (dieRoll == 4 || dieRoll == 5 || dieRoll == 6)) {
			return speedIncDec = 1;
		}
		// Vitesse = 4
		if ((actualSpeed == 4) && (dieRoll == 1)) {
			return speedIncDec = -1;
		} else if (actualSpeed == 4 && (dieRoll == 2 || dieRoll == 3 || dieRoll == 4)) {
			return speedIncDec = 0;
		} else if (actualSpeed == 4 && (dieRoll == 5 || dieRoll == 6)) {
			return speedIncDec = 1;
		}
		// Vitesse = 5
		if ((actualSpeed == 5) && (dieRoll == 1)) {
			return speedIncDec = -2;
		} else if (actualSpeed == 5 && (dieRoll == 2 )) {
			return speedIncDec = -1;
		} else if (actualSpeed == 5 && (dieRoll == 3 || dieRoll == 4 || dieRoll == 5)) {
			return speedIncDec = 0;
		} else if (actualSpeed == 5 && (dieRoll == 6 )) {
			return speedIncDec = 1;
		}
		// Vitesse = 6
				if ((actualSpeed == 6) && (dieRoll == 1)) {
					return speedIncDec = -2;
				} else if (actualSpeed == 6 && (dieRoll == 2 )) {
					return speedIncDec = -1;
				} else if (actualSpeed == 6 && (dieRoll == 3 || dieRoll == 4 || dieRoll == 5)) {
					return speedIncDec = 0;
				} else if (actualSpeed == 6 && (dieRoll == 6 )) {
					return speedIncDec = -10;
				}
		return speedIncDec;
	
	}

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		boolean replay = true;
		// Liste des chevaux
		HashMap<Integer, Integer[]> horsesListHashMap = new HashMap<>();

		// Variables
		int raceDistance = 2400;
		int gameChoice = 0;

		int horseSpeedValueIndex = 0;
		int horseDistanceValueIndex = 1;
		int horseTimeValueIndex = 2;

		ArrayList<Integer> tierceWinnerArrayList = new ArrayList<>();
		ArrayList<Integer> quarteWinnerArrayList = new ArrayList<>();
		ArrayList<Integer> quinteWinnerArrayList = new ArrayList<>();

		// Mise en place des règles du jeu
		// Choix du nombre de chevaux au départ
		System.out.println("Entrer le nombre de chevaux au départ: (12 - 20)");
		int horsesOnStart = Integer.parseInt(scan.nextLine());
		while (horsesOnStart < 12 || horsesOnStart > 20) {

			System.out.println("Veuillez entrer un nombre entre 12 et 20");
			horsesOnStart = Integer.parseInt(scan.nextLine());
		}

		// Remplissage de la liste des chevaux avec le nombre entré par l'utilisateur
		// Initialisation des valeurs à 0
		for (int i = 0; i < horsesOnStart; i++) {
			horsesListHashMap.put(i, new Integer[] { 0, 0 });
		}
		while (replay) {
			// Jet du dé et mise à jour des infos des chevaux
			for (int i = 0; i < horsesOnStart; i++) {
				// On récupère le cheval concerné
				Integer[] values = horsesListHashMap.get(i);

				// jet du dé (OK)
				int randomDieRoll = dieRoll();
				System.out.println("Valeur du lancé du dé: " + randomDieRoll);

				// Calcul du delta à appliquer
				
				System.out.println("Valeur du delta vitesse:" + updateSpeedCalc(randomDieRoll,values[1]));

		


				// Update de la distance actuelle
//				int updatedDistance = values[1] + distanceDelta;
//				System.out.println("horse values = " + Arrays.toString(values));
//				// Mise a jour des valeurs
//				values[0] += updatedDelta;
//				values[1] += updatedDistance;
//				// Mise a jour du tableau
//				horsesListHashMap.put(i, values);
//				System.out.println("horse values = " + Arrays.toString(values));
				System.out.println("Relancer le dé ? Y/N");
				String playerDieRoll = scan.nextLine().toLowerCase();

				if (playerDieRoll.equals("y")) {
					replay = true;
				} else {
					replay = false;
				}
			}

		}
	}

}