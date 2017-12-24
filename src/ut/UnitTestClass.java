package ut;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import CellActivity.Cell;

public class UnitTestClass {
	
	private Cell cell=new Cell();
	
	int[][]testCell={{0,1,0,1,0,1,1,0,1,0},
			         {1,0,1,0,1,0,0,1,0,1},
			         {1,0,1,0,1,0,0,0,0,0},
			         {0,0,0,0,0,0,0,0,0,0},
			         {0,0,0,0,1,0,1,0,1,0},
			         {1,1,1,0,1,0,1,0,1,1},
			         {1,1,1,1,1,0,0,0,0,0},
			         {0,0,1,0,1,1,1,1,1,1},
			         {0,1,0,1,0,0,0,0,0,1},
			         {1,1,1,1,1,0,0,0,0,0}};

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGetCellSateFromFile() {
		boolean flag=cell.getCellSateFromFile("CellState");
		
		int [][]a=cell.getCellState();
		
		for(int i=0;i<10;i++) {
			for(int j=0;j<10;j++) 
				System.out.print(a[i][j]+" ");
			System.out.println("");
		}
		
		
	}

}
