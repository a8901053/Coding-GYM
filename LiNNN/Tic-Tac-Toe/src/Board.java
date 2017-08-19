import Exception.ChoiceDuplicatedException;

public class Board {
	public static final int SIZE = 9;

	private Block[] blocks;

	public Board() {
		blocks = new Block[SIZE];
		for (int j = 0; j < SIZE; j++)
			blocks[j] = new Block();
	}

	public String displayBoard(int k) {
		String bString = "";
			bString += blocks[k-1].displayBlock(k);
		
		return bString;
	}
	
	@Override
	public String toString() {
		String board = "";
		for (int k = 1; k < 10; k++) {
			board += displayBoard(k);
		}
		
		return board;
	}

	public void confPosition(int choice, Group group) throws ChoiceDuplicatedException {
		if (blocks[choice - 1].haveBeenChosen() == true)
			throw new ChoiceDuplicatedException();
		blocks[choice - 1].setGroup(group);
	}

	public boolean gameWinner() {
		for (int i = 0; i < 3; i++) {
			if (blocks[i % 9].haveBeenChosen() && blocks[i % 9].getGroup() == blocks[(i + 3) % 9].getGroup()
					&& blocks[i % 9].getGroup() == blocks[(i + 6) % 9].getGroup())
				return true;
		}

		if (blocks[0].haveBeenChosen() && blocks[0].getGroup() == blocks[1].getGroup()
				&& blocks[0].getGroup() == blocks[2].getGroup())
			return true;
		else if (blocks[3].haveBeenChosen() && blocks[3].getGroup() == blocks[4].getGroup()
				&& blocks[3].getGroup() == blocks[5].getGroup())
			return true;
		else if (blocks[6].haveBeenChosen() && blocks[6].getGroup() == blocks[7].getGroup()
				&& blocks[6].getGroup() == blocks[8].getGroup())
			return true;
		else if (blocks[0].haveBeenChosen() && blocks[0].getGroup() == blocks[4].getGroup()
				&& blocks[0].getGroup() == blocks[8].getGroup())
			return true;
		else if (blocks[2].haveBeenChosen() && blocks[2].getGroup() == blocks[4].getGroup()
				&& blocks[2].getGroup() == blocks[6].getGroup())
			return true;

		return false;

	}

	public boolean draw() {
		boolean draw = false;
		int count = 0;
		for (int i = 0; i < 9; i++) {
			if (blocks[i].haveBeenChosen())
				count++;
		}
		if (count == 9)
			draw = true;
		return draw;
	}
	
	public int gameJudge() {
		if (gameWinner())
			return 1;
		else if (draw())
			return 2;
		return 0;
	}
	
}