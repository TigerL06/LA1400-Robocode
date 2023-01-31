package KochLiam.Astat2;
import robocode.*;


public class Astat extends JuniorRobot
{

	
	public void setColors() {
		setColors(black, red, black, red, black);
	}

	public void getToCorner() {
	
		int heightdistance;
		int widthdistance;
		heightdistance = fieldHeight - robotY;
		widthdistance = fieldWidth - robotX;
		turnTo(0);
		ahead(heightdistance);
		turnTo(90);
		ahead(widthdistance);
	
	}


	public void run() {
	
		setColors();
		getToCorner();


		while(true) {
			//Ordinary movements
			ahead(360);
			turnGunRight(360);
			back(100);
			turnGunRight(360);
			ahead(180);
			
		}
	}

   public void attackPattern() {
		int my_scannedAngle = scannedAngle;
		int my_scannedDistance = scannedDistance;
		
	
		turnGunTo(scannedAngle);
		
		if(my_scannedDistance < 100){
			fire(2);
		}
	
		if(my_scannedDistance < 50){
				fire(3);
		}
         
		if(my_scannedDistance > 100){
			ahead(50);
		}

	}

	
	public void onScannedRobot() {
		attackPattern();
	}


	

	
	public void onHitByBullet() {
		//variable declaration
		int my_hitByBulletBearing = hitByBulletBearing;
	    //Common moves when attacked
		back(20);
		turnAheadLeft(100, 90 + hitByBulletBearing);
		retreatWhenLowEnergy();
	
		}
		
	
	
	
	public void onHitWall() {
		//Common moves when I hit the wall
		back(250);
		turnRight(150);
		turnGunRight(360); 
	}
		

	public void retreatWhenLowEnergy() {
       
		 if (energy < 20) {
            back(fieldHeight / 2);
            turnRight(180);
            ahead(fieldHeight / 4);
            turnRight(90);
        }
    }

	
}
