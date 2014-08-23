package com.scb;

public class GameOfLife {
	private int[][] map;

	public GameOfLife(int[][] map) {
		this.map = map;
	}

	public boolean getAliveStatus(int x, int y) {
		return map[x][y] == 1;
	}

	// Su Yu
	public int getCountOfAliveNeibour(int x, int y) {
		if ((x == 0) || (y == 0) || (x == (map.length - 1))
				|| (y == (map[0].length - 1))) {
			return 0;
		} else {
			return map[x - 1][y - 1] + map[x][y - 1] + map[x + 1][y - 1]
					+ map[x - 1][y] + map[x + 1][y] + map[x - 1][y + 1]
					+ map[x][y + 1] + map[x + 1][y + 1];
		}
	}

	public int getNextStatusOnPostion(int x, int y) {
		if (getAliveStatus(x, y)) {
			if (getCountOfAliveNeibour(x, y) == 2
					|| getCountOfAliveNeibour(x, y) == 3) {
				return 1;
			} else {
				return 0;
			}
		} else {
			if (getCountOfAliveNeibour(x, y) == 3) {
				return 1;
			} else {
				return 0;
			}
		}
	}

	public String moveToNextStatus() {
		int[][] nextMap = new int[map.length][map[0].length];
		
		for (int i = 1; i < map.length - 1; i++) {
			for (int j = 1; j < map[0].length - 1; j++) {
				nextMap[i][j] = getNextStatusOnPostion(i, j);
			}
		}
		
		for (int i = 1; i < map.length - 1; i++) {
			for (int j = 1; j < map[0].length - 1; j++) {
				map[i][j] = nextMap[i][j];
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				sb.append(map[i][j]);
			}
		}

		return sb.toString();
	}
}