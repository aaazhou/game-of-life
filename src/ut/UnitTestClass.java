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
		cell.getCellSateFromFile("CellState");
		
		int [][]a=cell.getCellState();
		
		for(int i=0;i<10;i++) {
			for(int j=0;j<10;j++) 
				System.out.print(a[i][j]+" ");
			System.out.println("");
		}
		
		boolean flag=compareCell(testCell,a);
		assertEquals(true,flag);
		
		
	}
	
	@Test
	public void testGetLifeAround() {
		cell.setCellState(testCell);   //Ö±½Ó¸³Öµ
		int a=cell.getLifeAround(0, 9);
		
		assertEquals(2,a);
	}
	
	@Test
	public void testChangeCellState() {
		cell.setCellState(testCell);
		cell.changeCellState();
		
		System.out.println("");

		int [][]a=cell.getCellState();
		for(int i=0;i<10;i++) {
			for(int j=0;j<10;j++) 
				System.out.print(a[i][j]+" ");
			System.out.println("");
		}
		
		
	}
	
	
	private boolean compareCell(int[][]testCell,int[][]a) {
		for(int i=0;i<10;i++) {
			for(int j=0;j<10;j++) {
				if(testCell[i][j]!=a[i][j])
					return false;
			}
		}
		
		return true;
	}

}
