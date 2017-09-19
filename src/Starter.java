import java.io.Console;
import java.util.ArrayList;
import java.util.List;

public class Starter {

    static Console _cnsl = System.console();

    public static void main(String[] args) {
	
	DCPrinter.emptyLine(100);

	List<Player> players = new ArrayList<Player>();
	
	DCGame.init(players, _cnsl);
	
	DCPrinter.emptyLine(1);
	
	DCPrinter.printList(players);
	
	DCPrinter.emptyLine(1);
	
	DCGame.play(players, _cnsl);
	
	DCPrinter.emptyLine(2);
	
	DCPrinter.finalResults(players);	
	
	DCPrinter.emptyLine(3);
	
	DCGame.end(_cnsl);
	
    }

}
