package CellActivity;

import java.io.BufferedReader;
import java.io.FileReader;

public class Cell {

	private int[][] cellState;
	
	public Cell() {
		setCellState(new int[10][10]);
	}
	
	public boolean getCellSateFromFile(String path) {
		boolean flag=true;
		
		try{
			BufferedReader br=new BufferedReader(new FileReader(path));
			
			String line="";
			
			for(int i=0;i<10;i++) {
				if(!br.ready()) {
					flag=false;
					throw new Exception("读取文件出错");
				}
				
				line=br.readLine();
				
				if(line.length()!=10) {
					flag=false;
					throw new Exception("读取文件出错");
				}
				
				byte[] b=line.getBytes();
				for(int j=0;j<10;j++) {
					if(b[j]!='1'&&b[j]!='0') {
						flag=false;
						throw new Exception("文件内容有误");
					}
					
					cellState[i][j]=b[j]-48;
				}
				
				
			}
			
			
			
			br.close();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			return flag;
		}
	}

	public int[][] getCellState() {
		return cellState;
	}

	public void setCellState(int[][] cellState) {
		this.cellState = cellState;
	}
	
	
}
