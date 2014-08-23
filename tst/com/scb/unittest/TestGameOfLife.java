package com.scb.unittest;

import static org.junit.Assert.*;
import com.scb.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestGameOfLife {
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	// Meng, Xianwen 1492129
	@Test
	public void testCellStatusShouldBeAlive() {
		int[][] map = { 
				{ 0, 0, 0, 0, 0 }, 
				{ 0, 1, 1, 0, 0 }, 
				{ 0, 0, 1, 1, 0 },
				{ 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0 } };
		GameOfLife game = new GameOfLife(map);
		int x = 1, y = 2;
		assertTrue(game.getAliveStatus(x, y));
	}

	// Wang Xiaoli 1492166
	@Test
	public void testCountOfNeighbourShouldBeThree() {
		int[][] map = { 
				{ 0, 0, 0, 0, 0 }, 
				{ 0, 1, 1, 0, 0 }, 
				{ 0, 0, 1, 1, 0 },
				{ 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0 } };
		GameOfLife game = new GameOfLife(map);
		int x = 1, y = 2;
		assertEquals(3, game.getCountOfAliveNeibour(x, y));
	}

	// Su Yu 1492140
	@Test
	public void testAliveCellShouldDieWhenAliveNeighborIsLessThanTwo() {
		int[][] map = { 
				{ 0, 0, 0, 0, 0 }, 
				{ 0, 1, 0, 0, 0 }, 
				{ 0, 0, 1, 1, 0 },
				{ 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0 } };
		GameOfLife game = new GameOfLife(map);
		int x = 1, y = 1;
		assertEquals(0, game.getNextStatusOnPostion(x, y));

	}

	// Yan yunchao 1492161
	@Test
	public void testAliveCellShouldDieWhenAliveNeighborIsMoreThanThree() {
		int[][] map = { 
				{ 0, 0, 0, 0, 0 }, 
				{ 0, 1, 1, 0, 0 }, 
				{ 0, 0, 1, 1, 0 },
				{ 0, 1, 1, 1, 0 },
				{ 0, 0, 0, 0, 0 } };
		GameOfLife game = new GameOfLife(map);
		int x = 2, y = 2;
		assertEquals(0, game.getNextStatusOnPostion(x, y));

	}

	// Zhang Xuan 1492142
	@Test
	public void testAliveCellShouldLiveWhenAliveNeighborIsBetweenTwoAndThree() {
		int[][] map = { 
				{ 0, 0, 0, 0, 0 }, 
				{ 0, 1, 1, 0, 0 }, 
				{ 0, 0, 1, 1, 0 },
				{ 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0 } };
		GameOfLife game = new GameOfLife(map);
		int x = 2, y = 2;
		assertEquals(1, game.getNextStatusOnPostion(x, y));
	}

	// Cao Huiibn 1491743
	@Test
	public void testDeadCellShouldLiveWhenAliveNeighborExactlyThree() {
		int[][] map = { 
				{ 0, 0, 0, 0, 0 }, 
				{ 0, 1, 1, 0, 0 }, 
				{ 0, 0, 1, 1, 0 },
				{ 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0 } };
		GameOfLife game = new GameOfLife(map);
		int x = 2, y = 1;
		assertEquals(1, game.getNextStatusOnPostion(x, y));
	}
	
	// Meng, Xianwen 1492129
	@Test
	public void testMoveToNextStatus() {
		int[][] map = { 
				{ 0, 0, 0, 0, 0 }, 
				{ 0, 1, 1, 0, 0 }, 
				{ 0, 0, 1, 1, 0 },
				{ 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0 } };
		GameOfLife game = new GameOfLife(map);
		
		String expectedResult =
				  "00000"
				+ "01110"
				+ "01110"
				+ "00000"
				+ "00000";
		assertEquals(expectedResult, game.moveToNextStatus());
						
	}
}

