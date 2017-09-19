import java.io.Console;
import java.util.List;

public class DCGame {

	public static void doRound(List<Player> players, int round,
			Console systemConsole) {
		System.out.println("Round " + round);

		for (Player p : players) {
			if (p.hasNotFinished()) {

				System.out.print("" + p.id + ") " + p.name + ": ");
				String k = DCReader.readTarget(systemConsole, p);
				
				if (k.substring(0, 1).equalsIgnoreCase("f")) {
					int r = Integer.valueOf(k.substring(1));
					p.doFinish(r, round);
				} else {
					int r = Integer.valueOf(k);
					p.doProgress(r, round);
				}
			}
		}
		DCPrinter.emptyLine(1);
		DCPrinter.printRoundResults(players);
		DCPrinter.emptyLine(1);
	}

	public static void init(List<Player> players, Console systemConsole) {

		System.out.print("Number of players: ");

		Integer k = DCReader.readPlayerNumber(systemConsole);

		for (int i = 0; i < k; i++) {
			int id = i + 1;
			System.out.print("" + id + ") ");
			String name = DCReader.readPlayerName(systemConsole);
			players.add(new Player(id, name));
		}

	}

	public static void play(List<Player> players, Console systemConsole) {
		System.out.println("Go ");
		DCPrinter.emptyLine(1);

		int round = 1;
		int kk = 0;
		while (kk < 20 + 1) {
			DCGame.doRound(players, round, systemConsole);
			if (DCGame.isOver(players)) {
				break;
			}
			round++;
			kk++;
		}
	}

	private static boolean isOver(List<Player> players) {
		return getNotFinishedPlayers(players) < 2;
	}

	private static int getNotFinishedPlayers(List<Player> players) {
		int r = 0;
		for (Player p : players) {
			if (p.hasNotFinished()) {
				r++;
			}
		}
		return r;
	}

	public static void end(Console systemConsole) {

		System.out.println("Game Over");
		System.out.println("Press enter to exit");
		try {
			systemConsole.readLine();
		} catch (Exception e) {

		}
	}

}
