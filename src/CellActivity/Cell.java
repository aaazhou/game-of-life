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
		}
		
		return flag;

	}
	
	//获取周围细胞存活状态
	public int getLifeAround(int i,int j) {
		int res=0;
		if(i<0||j<0|i>=10||j>=10)
			return -1;
		
		int k=i;
		
		if(j-1>=0&&cellState[k][j-1]==1)
		    res++;
	
		//细胞本身存活状态不计入
//	    if(cellState[k][j]==1)
//		    res++;
	    
	    if(j+1<10&&cellState[k][j+1]==1)
	    	res++;
		
		if(i-1>=0) {
			k=i-1;
			
		    if(j-1>=0&&cellState[k][j-1]==1)
			    res++;
		
		    if(cellState[k][j]==1)
			    res++;
		    
		    if(j+1<10&&cellState[k][j+1]==1)
		    	res++;
		}
		
		if(i+1<10) {
			k=i+1;
			
		    if(j-1>=0&&cellState[k][j-1]==1)
			    res++;
		
		    if(cellState[k][j]==1)
			    res++;
		    
		    if(j+1<10&&cellState[k][j+1]==1)
		    	res++;
		}
		
		
		return res;
	}
	
	public void changeCellState() {
		int lifeNumber=0;
		for(int i=0;i<10;i++) {
			for(int j=0;j<10;j++) {
				lifeNumber=this.getLifeAround(i, j);
				if(lifeNumber<2)
					cellState[i][j]=0;
				else if(lifeNumber>3)
					cellState[i][j]=0;
				else if(lifeNumber==3&&cellState[i][j]==0)
					cellState[i][j]=1;
			}
		}
	}

	public int[][] getCellState() {
		return cellState;
	}

	public void setCellState(int[][] cellState) {
		this.cellState = cellState;
	}
	
	
}
