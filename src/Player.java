public class Player {

	int id;
	String name;
	int target; // if it is -1 then he has finished
	int f; // ex.: F5; // if it is -1 then he has not finished
	private int fround;
	private int currentRound;

	public int getCurrentRound() {
		return currentRound;
	}

	public void setCurrentRound(int currentRound) {
		this.currentRound = currentRound;
	}

	public int getFRound() {
		return fround;
	}

	public void setFRound(int fround) {
		this.fround = fround;
	}

	public boolean hasNotFinished() {
		return (this.target != -1);
	}

	public boolean hasFinished() {
		return (this.target == -1);
	}

	public void doFinish(int f, int round) {
		this.target = -1;
		this.f = f;
		this.fround = round;
	}

	public void doProgress(int t, int round) {
		this.target = t;
		this.currentRound = round;
	}

	public Player(int id, String name) {
		this.id = id;
		this.name = name;
		this.target = 0;
		this.f = -1;
	}

}
