
public class CollisionCircle {
	int x;
	int y;
	int radius;
	int trueX;
	int trueY;
	
	CollisionCircle(int newX,int newY,int newRadius){
		
		x=newX;
		y=newY;
		radius=newRadius;
		trueX=x+radius;
		trueY=y+radius;
	
		
	}
	
	boolean intersectsCircle(CollisionCircle c) {
		int maxDistance=radius+c.radius;
		int changeInX=Math.abs(trueX-c.trueX);
		int changeInY=Math.abs(trueY-c.trueY);
		
		
		double distance= Math.sqrt((changeInY*changeInY)+(changeInX*changeInX));
		
		if(distance<=maxDistance) {
			return true;
		}
		
		return false;
		
	}
	
	void setBounds(int xx, int yy) {
		trueX=xx+radius;
		trueY=yy+radius;
		x=xx;
		y=yy;
	}
	
	
	
	
	
	
	
	
}
