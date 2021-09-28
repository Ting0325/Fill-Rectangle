
public class Driver {
	public static void main(String[] args) {
		Rectangle rectangle = new Rectangle(20,10);
		rectangle.display();
		Obstacle o0 = new Obstacle(1,2,3,5,2);
		Obstacle o1 = new Obstacle(1,2,6,5,2);
		rectangle.obstacles.add(o0);
		rectangle.obstacles.add(o1);
		rectangle.fillObstacles();
		rectangle.display();
		rectangle.fillFromLeft();
		rectangle.display();
		rectangle.fillFromRight();
		rectangle.display();
	}
}
