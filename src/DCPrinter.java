import java.util.List;

public class DCPrinter {

	public static void printList(List<Player> players) {
		System.out.println("Player list:");

		for (Player n : players) {
			System.out.println("" + n.id + ") " + n.name);
		}
	}

	public static void emptyLine(int c) {
		for (int i = 1; i < c + 1; i++) {
			System.out.println(" ");
		}
	}

	public static void printRoundResults(List<Player> players) {
		System.out.println("Round results");
		DCPrinter.printResults(players);
	}

	public static void finalResults(List<Player> players) {
		System.out.println("Final results");
		DCPrinter.printResults(players);
	}

	public static void printResults(List<Player> players) {
		String line = "--------------------------------";
		System.out.println(line);
		
		System.out.print("| ");
		System.out.printf("%2s", "ID");
		System.out.print(" | ");
		System.out.printf("%8s", "NAME");
		System.out.print(" | ");
		
		System.out.printf("%2s", "TS");
		System.out.print(" | ");
		System.out.printf("%2s", "FR");
		System.out.print(" | ");
		System.out.printf("%2s", "AD");
		System.out.println(" |");
		
		System.out.println(line);
		
		for (Player p : players) {
			System.out.print("| ");
			System.out.printf("%2s", p.id);
			System.out.print(" | ");
			System.out.printf("%8s", p.name);
			System.out.print(" | ");

			if (p.hasFinished()) {
				System.out.print("F");
				System.out.printf("%1d", p.f);
				System.out.print(" | ");
				System.out.printf("%2d", p.getFRound());
				
				
				//-------------
				
				System.out.print(" | ");
				System.out.printf("%2d", ( p.f +  (p.getFRound()-1)*5         ));
				
				
			} else {
				System.out.printf("%2d", p.target);
				System.out.print(" | ");
				System.out.printf("%2s", " ");
				
				//-------------
				
				System.out.print(" | ");
				System.out.printf("%2d", p.getCurrentRound()*5);
				
			}
			System.out.println(" |");
			System.out.println(line);
		}
	}

}
