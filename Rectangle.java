import java.util.ArrayList;
import java.util.List;

public class Rectangle {
	List<Obstacle> obstacles;
	private final int width;
	private final int height;
	private int wallLeft;
	private int wallRight;
	int[][] arr;
	
	public Rectangle(int width, int height) {
		this.width = width;
		this.height = height;
		this.arr = new int[height][width];
		obstacles = new ArrayList<Obstacle>();
		this.wallLeft = 0;
		this.wallRight = this.width-1;
	}
	
	public void display() {
		for(int  i = this.height-1 ;i >= 0 ; i --) {
			for(int  j = 0;j < this.width; j ++) {
				System.out.print(arr[i][j]+"	");
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
		int filledIndex = 4;
		for(int i = 0; i < height;i ++) {	
			for(int j = 0; j < width;j ++) {				
				if(arr[i][j] != 0 || j == width-1) {
					if(j == width-1) {
						arr[i][j] = filledIndex; 
					}
					if(j != prvWidth && i !=0) {
						filledIndex ++;
						System.out.println("j:"+j+" arr[i][j]"+arr[i][j]+" prvWidth:"+prvWidth);
						for(int b = j-1; b >=0;b-- ) {
							arr[i][b] = filledIndex;
						}
					}
					prvWidth = j;

					break;
				}
				arr[i][j] = filledIndex;
			}
		}
	}
	
	public void fillFromRight() {
		int prvWidth = 0;
		int filledIndex = 7;
		for(int i = 0; i < height;i ++) {
			int currWidth = 0;
			for(int j = width-1; j >=0;j --) {	
				if(arr[i][j] != 0) {					
					if(currWidth != prvWidth && currWidth !=0) {
						filledIndex ++;
						System.out.println("currWidth:"+currWidth+" arr[i][j]"+arr[i][j]+" prvWidth:"+prvWidth);
						for(int b = j+1; b < width;b++ ) {
							arr[i][b] = filledIndex;
						}
					}

					prvWidth = currWidth;
					break;
				}
				arr[i][j] = filledIndex;
				currWidth ++;
			}
		}
	}
}
