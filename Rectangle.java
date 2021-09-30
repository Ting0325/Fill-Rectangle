import java.util.ArrayList;
import java.util.List;

public class Rectangle {
	List<Obstacle> obstacles;
	private final int width;
	private final int height;
	private int wallLeft;
	private int wallRight;
	private int[][] arr;
	private int rectIndex;
	
	public Rectangle(int width, int height) {
		this.width = width;
		this.height = height;
		this.arr = new int[height][width];
		obstacles = new ArrayList<Obstacle>();
		this.wallLeft = 0;
		this.wallRight = this.width-1;
		this.rectIndex = 3;
	}
	
	public void display() {
		for(int  i = this.height-1 ;i >= 0 ; i --) {
			for(int  j = 0;j < this.width; j ++) {
				System.out.print((char)(arr[i][j]+65));
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public void fillObstacles() {
		System.out.println(obstacles.size());
		for(Obstacle e: obstacles) {
			for(int i = e.y; i < e.y+e.height;i ++) {
				for(int j = e.x; j < e.x+e.width;j ++) {
					arr[i][j] = e.index;
				}
			}
		}
	}
	
	public void fillFromLeft() {
		int prvWidth = 0;
		//int filledIndex = 4;
		for(int i = 0; i < height;i ++) {	
			for(int j = wallLeft; j < width;j ++) {				
				if(arr[i][j] != wallLeft || j == width-1) {
					if(j == width-1) {
						arr[i][j] = rectIndex; 
					}
					if(j != prvWidth && i !=wallLeft) {
						rectIndex ++;
						if(j==width-1) {
							for(int b = j; b >=wallLeft;b-- ) {
								arr[i][b] = rectIndex;
							}
						}else {
							for(int b = j-1; b >=wallLeft;b-- ) {
								arr[i][b] = rectIndex;
							}
						}
							

					}
					prvWidth = j;

					break;
				}
				arr[i][j] = rectIndex;
			}
		}
	}
	
	public void fillFromRight() {
		int prvWidth = 0;
		//int filledIndex = 7;
		for(int i = 0; i < height;i ++) {
			int currWidth = 0;
			for(int j = wallRight; j >=0;j --) {	
				if(arr[i][j] != 0) {					
					if(currWidth != prvWidth && currWidth !=0) {
						rectIndex ++;
						for(int b = j+1; b < wallRight+1;b++ ) {
							arr[i][b] = rectIndex;
						}
					}

					prvWidth = currWidth;
					break;
				}
				arr[i][j] = rectIndex;
				currWidth ++;
			}
		}
	}
	
	public void advLeft() {
		label:for(int i = wallLeft;i < wallRight;i ++) {
			for(int j = 0;j < height;j ++) {
				if(arr[j][i]==0) {
					wallLeft = i;
					System.out.println("wallLeft: "+wallLeft);
					break label;
				}	
			}
		}
	}
	public void advRight() {
		label:for(int i = wallRight;i > wallLeft;i --) {
			for(int j = 0;j < height;j ++) {
				if(arr[j][i]==0) {
					wallRight = i;
					System.out.println("wallRight: "+wallRight);
					break label;
				}	
			}
		}
	}
}
