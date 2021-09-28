
public class Driver {
	public static void main(String[] args) {
		Rectangle rectangle = new Rectangle(30,30);
		rectangle.display();
		Obstacle o0 = new Obstacle(1,2,3,5,2);
		Obstacle o1 = new Obstacle(1,2,6,5,2);
		Obstacle o2 = new Obstacle(1,7,11,5,2);
		Obstacle o3 = new Obstacle(1,1,17,10,3);
		Obstacle o4 = new Obstacle(1,15,1,5,17);
		Obstacle o5 = new Obstacle(1,4,20,15,9);
		rectangle.obstacles.add(o0);
		rectangle.obstacles.add(o1);
		rectangle.obstacles.add(o2);
		rectangle.obstacles.add(o3);
		rectangle.obstacles.add(o4);
		rectangle.obstacles.add(o5);
		rectangle.fillObstacles();
		rectangle.display();
		rectangle.fillFromLeft();
		rectangle.display();
		rectangle.fillFromRight();
		rectangle.display();
	}
}
