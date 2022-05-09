import processing.core.PApplet;

public class Sketch extends PApplet {
	

  float[] circleY = new float[15];
  float[] circleX = new float[15];
  boolean[] circleHideStatus = new boolean[15];
  float[] squareX = {310, 340, 370};



  int lives = 3;


	
  /**
   * Called once at the beginning of execution, put your size all in this method
   */
  public void settings() {
	// put your size call here
    size(400, 400);
  }

  /** 
   * Called once at the beginning of execution.  Add initial set up
   * values here i.e background, stroke, fill etc.
   */
  public void setup() {
    background(210, 255, 173);

    for (int i = 0; i < circleY.length; i++) {
      circleY[i] = random(height);
    }

    for(int i = 0; i < circleX.length; i++) {
      circleX[i] = random(width);
    }

    for(int i = 0; i < circleHideStatus.length; i++) {
      circleHideStatus[i] = false;
    }


  }

  /**
   * Called repeatedly, anything drawn to the screen goes here
   */
  public void draw() {
    
    background(50);

	  
	  for(int i = 0; i < lives; i++) {
      fill(255, 0, 0);
      rect(squareX[i], 20, 20, 20);
    }
    

    fill(255, 255, 255);
    for (int i = 0; i < circleY.length; i++) {

      ellipse(circleX[i], circleY[i], 25, 25);

 
      if (circleY[i] > height) {
        circleY[i] = 0;
      }

      if(circleX[i] > width) {
        circleX[i] = 0;
      }

      if(keyPressed){
        if(keyCode == DOWN) {
          circleY[i]++;
        }
        else if (keyCode == UP){
          circleY[i]--;
        }
      }

      circleY[i]  +=2;

    }
  

    
 


  }
  
  // define other methods down here.
}