package gitExercice03;

import java.util.*;

public class GitExo03 {

	// Jet du dé
	public static int dieRoll() {
		int min = 1;
		int max = 6;
		int randomNumber = (int) (Math.random() * (max - min + 1)) + min;
		return randomNumber;
	}

	// Calcul de la distance au tour en fonction de la vitesse
	public static int speedCalc(int speed) {
		int distance = 0;
		switch (speed) {
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
	public static int speedModif(int dieRoll, int actualSpeed) {
		int speedIncDec = 0;

		if (dieRoll == 1) {
			if (actualSpeed == 3 || actualSpeed == 4) {
				speedIncDec = -1;
			}
			if (actualSpeed == 5 || actualSpeed == 6) {
				speedIncDec = -2;
			}
		} else if (dieRoll == 2) {
			if (actualSpeed == 0) {
				speedIncDec = 1;
			}
			if (actualSpeed == 5 || actualSpeed == 6) {
				speedIncDec = -1;
			}
		} else if (dieRoll == 3) {
			if (actualSpeed >= 0 || actualSpeed <= 3) {
				speedIncDec = 1;
			}
		} else if (dieRoll == 4) {
			if (actualSpeed >= 0 || actualSpeed <= 3) {
				speedIncDec = 1;
			}
		} else if (dieRoll == 5) {
			if (actualSpeed == 0) {
				speedIncDec = 2;
			}
			if (actualSpeed >= 1 || actualSpeed <= 4) {
				speedIncDec = 1;
			}
		} else if (dieRoll == 6) {
			if (actualSpeed >= 0 || actualSpeed <= 2) {
				speedIncDec = 2;
			}
			if (actualSpeed >= 3 || actualSpeed <= 5) {
				speedIncDec = 1;
			}
			if (actualSpeed == 6) {
				speedIncDec = 3;
			}
		}
System.out.println("speedIncDec: " + speedIncDec);
		return speedIncDec;
	}

	
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		// Liste des chevaux
		HashMap<Integer, Integer[]> horsesListHashMap = new HashMap<>();
		speedModif(6,6);
		// Variables
		int raceDistance = 2400;
		int gameChoice = 0;
		int horsesOnStart = 1;

		int horseSpeedValueIndex = 0;
		int horseDistanceValueIndex = 1;
		int horseTimeValueIndex = 2;

		// Mise en place des règles du jeu
		// Choix du nombre de chevaux au départ
		System.out.println("Entrer le nombre de chevaux au départ: (12 - 20)");
		horsesOnStart = Integer.parseInt(scan.nextLine());
		while (horsesOnStart < 12 || horsesOnStart > 20) {

			System.out.println("Veuillez entrer un nombre entre 12 et 20");
			horsesOnStart = Integer.parseInt(scan.nextLine());
		}

		// Remplissage de la liste des chevaux avec le nombre entré par l'utilisateur
		// Initialisation des valeurs à 0
		for (int i = 0; i < horsesOnStart; i++) {
			horsesListHashMap.put(i, new Integer[] { 0, 0, 0 });
		}

		// Jet du dé et mise à jour des infos des chevaux
		for (int i = 0; i < horsesOnStart; i++) {
			int randomDieRoll = dieRoll();

			// On récupère le cheval concerné
			Integer[] values = horsesListHashMap.get(i);

			values[horseSpeedValueIndex] += speedModif(randomDieRoll,values[horseSpeedValueIndex]);
			values[horseDistanceValueIndex] += speedCalc(values[horseSpeedValueIndex]);
			horsesListHashMap.put(i, values);
			System.out.println(Arrays.toString(values));
		}

		// Affichage des infos de tous les chevaux

		for (int i = 0; i < horsesListHashMap.size(); i++) {

			Integer[] values = horsesListHashMap.get(i);

			int speedValue = values[horseSpeedValueIndex];
			int distanceValue = values[horseDistanceValueIndex];
			int timeValue = values[horseTimeValueIndex];

			System.out.println("Infos cheval n°= " + (i + 1) + " : " + "vitesse: " + speedValue + "; " + "distance: "
					+ distanceValue + "; " + "temps:" + timeValue);
		}

		System.out.println("calcul de la vitesse:" + speedCalc(2));

	}

//	public static void main(String[] args) {
//	// Variables
//	int raceDistance = 2400;
//	int gameChoice = 0;
//	int totalHorsesNumber = 12;
//
//		int horseKey = 1;
//
//		int horseSpeed = 0;
//		int horseDistance = 1;
//		int horseTime = 2;
//
//		// Liste des chevaux
//		HashMap<Integer, Integer[]> horsesListHashMap = new HashMap<>();
//
//		Scanner scan = new Scanner(System.in);
//
//		// Jet de dé
//		int min = 1;
//		int max = 6;
//		int randomNumber = (int) (Math.random() * (max - min + 1)) + min;
//
//		// Remplissage de la map
//		for (int i = 0; i < totalHorsesNumber; i++) {
//			horsesListHashMap.put(i, new Integer[] { 0, 0, 0 });
//		}

	// Affichage de la map
//		for (Map.Entry<Integer, Integer[]> entry : horsesListHashMap.entrySet()) {
//			int horseNumber = entry.getKey();
//			Integer[] values = entry.getValue();
//
//			System.out.println("Cheval numéro : " + horseNumber + ", données : ");
//			for (Integer valueInteger : values) {
//				System.out.println(+valueInteger + " ");
//			}
//			System.out.println();
//		}

	// Affichage des infos d'un cheval
//		if (horsesListHashMap.containsKey(horseKey)) {
//			Integer[] values = horsesListHashMap.get(horseKey);
//
//			int speedValue = values[horseSpeed];
//			int distanceValue = values[horseDistance];
//			int timeValue = values[horseTime];
//
//			System.out.println("Infos cheval n°= " + horseKey + " : " + "vitesse: " + speedValue + "; " + "distance: "
//					+ distanceValue + "; " + "temps:" + timeValue);
//		}

	// Affichage des infos de tous les chevaux

//		for (int i = 0; i < horsesListHashMap.size();i++) {
//			
//			Integer[] values = horsesListHashMap.get(i);
//
//			int speedValue = values[horseSpeed];
//			int distanceValue = values[horseDistance];
//			int timeValue = values[horseTime];
//
//			System.out.println("Infos cheval n°= " + (i + 1) + " : " + "vitesse: " + speedValue + "; " + "distance: "
//					+ distanceValue + "; " + "temps:" + timeValue);
//		}

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

//	}

}
