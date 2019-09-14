
public class CollisionCircle {
	int x;
	int y;
	int radius;
	
	CollisionCircle(int newX,int newY,int newRadius){
		
		int x=newX;
		int y=newY;
		int radius=newRadius;
	
		
	}
	
	boolean intersectsCircle(CollisionCircle c) {
		int maxDistance=radius+c.radius;
		int changeInX=Math.abs(x-c.x);
		int changeInY=Math.abs(y-c.y);
		double distance= Math.sqrt((changeInY*changeInY)+(changeInX*changeInX));
		
		if(distance<=maxDistance) {
			return true;
		}
		
		return false;
		
	}
	
	void setBounds(int xx, int yy) {
		x=xx;
		y=yy;
	}
	
	
	
	
	
	
	
	
}
