package gitExercice03;

import java.util.*;
import org.omg.CORBA.portable.ValueBase;

public class GitExo03 {

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
		} else if (actualSpeed == 5 && (dieRoll == 2)) {
			return speedIncDec = -1;
		} else if (actualSpeed == 5 && (dieRoll == 3 || dieRoll == 4 || dieRoll == 5)) {
			return speedIncDec = 0;
		} else if (actualSpeed == 5 && (dieRoll == 6)) {
			return speedIncDec = 1;
		}
		// Vitesse = 6
		if ((actualSpeed == 6) && (dieRoll == 1)) {
			return speedIncDec = -2;
		} else if (actualSpeed == 6 && (dieRoll == 2)) {
			return speedIncDec = -1;
		} else if (actualSpeed == 6 && (dieRoll == 3 || dieRoll == 4 || dieRoll == 5)) {
			return speedIncDec = 0;
		} else if (actualSpeed == 6 && (dieRoll == 6)) {
			return speedIncDec = -10;
		}
		return speedIncDec;

	}

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		boolean replay = true;
		boolean wantToReplay = false;
		int horsesOnStart = 0;
		int userGameResponse = 0;
		boolean validHorseNumberInput = false;
		boolean validGameNumberInput = false;
		// Liste des chevaux au départ
		HashMap<Integer, Integer[]> horsesListHashMap = new HashMap<>();

		// Liste des vainqueurs
		Set<Integer> winnerSetList = new HashSet<>();

		// Mise en place des règles du jeu
		// Choix du nombre de chevaux au départ
		System.out.println("Entrer le nombre de chevaux au départ: (12 - 20)");
		while (!validHorseNumberInput) {
			String input = scan.nextLine();

			try {

				horsesOnStart = Integer.parseInt(input);
				if (horsesOnStart >= 12 && horsesOnStart <= 20) {
					validHorseNumberInput = true;
				} else {
					System.out.println("Veuillez entrer un nombre entre 12 et 20");

				}
			} catch (NumberFormatException e) {
//			horsesOnStart = Integer.parseInt(scan.nextLine());
				System.out.println("Merci d'entrer un nombre valide !");
			}

		}
		// Remplissage de la liste des chevaux avec le nombre entré par l'utilisateur
		// Initialisation des valeurs à 0
		for (int i = 0; i < horsesOnStart; i++) {
			horsesListHashMap.put(i, new Integer[] { 0, 0 });
		}

		System.out.println("Voulez-vous jouer au tiercé (1), au quarté (2) ou au quinté (3) ?");

		while (!validGameNumberInput) {
			String input = scan.nextLine();
			try {

				userGameResponse = Integer.parseInt(input);
				if (userGameResponse == 1 || userGameResponse == 2 || userGameResponse == 3) {

					validGameNumberInput = true;
				} else {
					System.out.println("Veuillez entrer 1 ou 2 ou 3 !");

				}
			} catch (NumberFormatException e) {
				System.out.println("Veuillez entrer un chiffre valide !");
			}

		}
		int winnerSetListSize = 0;

		switch (userGameResponse) {
		case 1:
			winnerSetListSize = 3;
			break;
		case 2:
			winnerSetListSize = 4;
			break;
		case 3:
			winnerSetListSize = 5;
		}

		while (replay && (winnerSetListSize > winnerSetList.size())) {
			int counter = 1;
			;
			for (int i = 0; i < horsesOnStart; i++) {
				// On récupère le cheval concerné
//				System.out.println("Nombre de boucles = " + counter++);
				Integer[] values = horsesListHashMap.get(i);
				System.out.println("Infos cheval " + (i + 1) + " " + Arrays.toString(values));

				// jet du dé (OK)
				int randomDieRoll = dieRoll();
//				System.out.println("Valeur du lancé du dé: " + randomDieRoll);

				// Calcul du delta à appliquer
				int lapDelta = updateSpeedCalc(randomDieRoll, values[0]);
//				System.out.println("Valeur du delta vitesse:" + lapDelta);

				values[0] += lapDelta;
				if (values[0] <= 0) {
					values[0] = 0;
				} else if (values[0] >= 6) {
					values[0] = 6;
				}

				// Calcul de la distance avec vitesse actuelle
				values[1] += distanceCalc(values[0]);

				horsesListHashMap.put(i, values);

				if ((values[1] >= 2400) && (winnerSetList.size() < winnerSetListSize)) {
					winnerSetList.add(i);
				}

			}
//			while (true) {
			System.out.println("Relancer le dé ? Y/N");
			while (!wantToReplay) {
				String input = scan.nextLine().toLowerCase();

				String playerDieRollInput = input.toLowerCase();
				if (playerDieRollInput.equals("y")) {
					wantToReplay = true;
					break;
				} else if (playerDieRollInput.equals("n")) {
					System.out.println("A bientôt !");
					replay = false;
					return;

				} else {
					System.out.println("Veuillez saisir y ou n !!!");
				}

			}
		}
		System.out.println("La courses est terminée !");
		System.out.println("Liste d'arrivée: " + (winnerSetList));

	}
}