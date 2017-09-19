import java.io.Console;

public class DCReader {

	public static Integer readPlayerNumber(Console systemConsole) {
		Integer result = 0;
		while (result == 0) {
			try {
				String k = systemConsole.readLine();
				result = Integer.valueOf(k);
			} catch (Exception e) {
				System.out.println("Parse error!");
			}
		}
		return result;
	}

	public static String readPlayerName(Console systemConsole) {
		String result = "";
		while (result.equalsIgnoreCase("")) {
			try {
				result = systemConsole.readLine();
				if (result.equalsIgnoreCase("")) {
					System.out.println("Empty name!");
				}
			} catch (Exception e) {
				System.out.println("Parse error!");
			}
		}
		return result;
	}

	public static String readTarget(Console systemConsole, Player p) {
		String result = "";
		while (result.equalsIgnoreCase("")) {
			try {
				result = systemConsole.readLine();
				if (result.equalsIgnoreCase("")) {
					System.out.println("Empty target sector!");
					result = "";
					continue;
				}
				if (result.substring(0, 1).equalsIgnoreCase("f")
						&& result.length() > 1) {
					Integer.parseInt(result.substring(1));
					break;
				}
				
				try { 
					Integer.parseInt(result); 
				} catch (Exception ex) {
					System.out.println("Parse error!");
					result = "";
					continue;
				}

				int r = Integer.valueOf(result);
				
				if (r < p.target) {
					System.out.println("Target sector cannot grow down!");
					result = "";
					continue;
				}

				
			} catch (Exception e) {
				System.out.println("Parse error!");
				result = "";
				continue;
			}
		}
		return result;
	}

}
