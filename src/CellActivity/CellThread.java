package CellActivity;

public class CellThread extends Thread {
	
	private Cell cell;
	
	public void run() {
		cell=new Cell();
		cell.getCellSateFromFile("CellState");
		
		cell.printCellState();
		
		try {
			while(true) {
			    sleep(1000);
			    
			    cell.changeCellState();
			    
			    cell.printCellState();
			    System.out.println("");
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] arg) {
		CellThread ct=new CellThread();
		ct.start();
	}
	


}
