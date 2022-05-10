import processing.core.PApplet;

public class Sketch extends PApplet {
	
  boolean boolMousePressed = false;

  float[] circleY = new float[15];
  float[] circleX = new float[15];
  boolean[] circleHideStatus = new boolean[15];
  float[] squareX = {310, 340, 370};

  float fltCharacterPosX = 100;
  float fltCharacterPosY = 100; 

  boolean boolUpPressed = false;
  boolean boolDownPressed = false;
  boolean boolRightPressed = false;
  boolean boolLeftPressed = false;



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

    if(boolUpPressed) {
      fltCharacterPosY = fltCharacterPosY - 2;
    }
    if(boolDownPressed) {
      fltCharacterPosY = fltCharacterPosY + 2;
    }
    if(boolRightPressed) {
      fltCharacterPosX = fltCharacterPosX + 2;
    }
    if(boolLeftPressed) {
      fltCharacterPosX = fltCharacterPosX - 2;
    }


    fill(0, 0, 255);
    ellipse(fltCharacterPosX, fltCharacterPosY, 20, 20);


    




	  
	  for(int i = 0; i < lives; i++) {
      fill(255, 0, 0);
      rect(squareX[i], 20, 20, 20);
    }
    
    


    fill(255, 255, 255);
    for (int i = 0; i < circleY.length; i++) {

      if(circleHideStatus[i] == false) {
        ellipse(circleX[i], circleY[i], 25, 25);
        circleY[i] +=2;
      }
      

 
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



      if (dist(fltCharacterPosX, fltCharacterPosY, circleX[i], circleY[i]) <= 15 && circleHideStatus[i] == false) {
        lives--;
        circleHideStatus[i] = true;
      }

      if(dist(mouseX, mouseY, circleX[i], circleY[i]) <=15 && boolMousePressed == true && circleHideStatus[i] == false) {
        circleHideStatus[i] = true;
      }

      if(lives == 0) {
        background(255);
      }

    }

  }

  public void keyPressed() {
    if(key == 'w') {
      boolUpPressed = true;
    }
    else if(key == 's') {
      boolDownPressed = true;
    }
    else if(key == 'd') {
      boolRightPressed = true;
    } 
    else if(key == 'a') {
      boolLeftPressed = true;
    }
  }

  public void keyReleased() {
    if(key == 'w') {
      boolUpPressed = false;
    }
    else if(key == 's') {
      boolDownPressed = false;
    }
    else if(key == 'd') {
      boolRightPressed = false;
    } 
    else if(key == 'a') {
      boolLeftPressed = false;
    }
  }


  public void mousePressed() {
    boolMousePressed = true;
  }

  public void mouseReleased() {
    boolMousePressed = false;
  }



  
  // define other methods down here.
}