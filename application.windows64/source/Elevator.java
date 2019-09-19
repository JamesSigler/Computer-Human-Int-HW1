import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class Elevator extends PApplet {

int[] dimY = {70*11, 70*10, 70*9, 70*8, 70*7, 70*6, 70*5, 70*4, 70*3, 70*2, 75};

PImage[] but1 = new PImage[2];
PImage[] but2 = new PImage[2];
PImage[] but3 = new PImage[2];
PImage[] but4 = new PImage[2];
PImage[] but5 = new PImage[2];
PImage[] but6 = new PImage[2];
PImage[] but7 = new PImage[2];
PImage[] but8 = new PImage[2];
PImage[] but9 = new PImage[2];
PImage[] but10 = new PImage[2];
PImage[] but11 = new PImage[2];
PImage[] butO = new PImage[2];
PImage[] butC = new PImage[2];
PImage[] Alrm = new PImage[2];
PImage[] Help = new PImage[2];

int currF = 0;
int nextF = 0;
int count = 0;
boolean Open = true;
boolean Up = true;

public void setup()
{
  //1:2 ratio
  
  
  //background metal
  PImage back = loadImage("metBack.jpg");
  image(back, 0, 0, width, height);
  
  
  
}

public void draw()
{
  fill(0);
  rect(50, 50, 350, 800);
  
  noFill();
  rect(90, 280, 90, 160);
  
  dispTD();
  
  but1[0]  = loadImage("buttonG.png");
  image(but1[0], 330, 770, 50, 50);
  but2[0]  = loadImage("button2.png");
  image(but2[0], 330, 700, 50, 50);
  but3[0]  = loadImage("button3.png");
  image(but3[0], 330, 630, 50, 50);
  but4[0]  = loadImage("button4.png");
  image(but4[0], 330, 560, 50, 50);
  but5[0]  = loadImage("button5.png");
  image(but5[0], 330, 490, 50, 50);
  but6[0]  = loadImage("button6.png");
  image(but6[0], 330, 420, 50, 50);
  but7[0]  = loadImage("button7.png");
  image(but7[0], 330, 350, 50, 50);
  but8[0]  = loadImage("button8.png");
  image(but8[0], 330, 280, 50, 50);
  but9[0]  = loadImage("button9.png");
  image(but9[0], 330, 210, 50, 50);
  but10[0]  = loadImage("button10.png");
  image(but10[0], 330, 140, 50, 50);
  but11[0]  = loadImage("button11.png");
  image(but11[0], 330, 70, 50, 50);
  butO[0]  = loadImage("buttonO.png");
  image(butO[0], 70, 770, 50, 50);
  butC[0]  = loadImage("buttonC.png");
  image(butC[0], 70, 700, 50, 50);
  Alrm[0] = loadImage("Em.png");
  image(Alrm[0], 110, 290, 50,50);
  Help[0] = loadImage("H.png");
  image(Help[0], 110, 380, 50,50);
  
  PImage build = loadImage("building.png");
  image(build, 220, 70, 70, 750);

  PImage fCir = loadImage("fCir.png");
  image(fCir, 235, dimY[currF], 40, 30);
  
  if(currF < nextF)
  {
    Up = true; 
  }
  else
  {
    Up = false;
  }
  
  
  if(Up == true)
  {
    
    while(currF < nextF)
    {
      int seconds = second();
      if((frameCount/frameRate)%seconds==5)
      {
        image(fCir, 235, dimY[currF], 40, 30);
      }
      currF++;
    }
  }
  else
  {
    while(currF > nextF)
    {
      int seconds = second();
      if((frameCount/frameRate)%seconds==5)
      {
      image(fCir, 235, dimY[nextF], 40, 30);
      }
      currF--;
    }
  }
  
  fill(153, 217, 234);
  rect(60,150,140,70);
  
  fill(255);
  textSize(28);
  text("map", 235, 70);
  
  fill(63,72,204);
  stroke(63,72,204);
  PFont dig = createFont("DS-DIGI.TTF", 72);
  textFont(dig);
  
  if(nextF == 0)
  {
    String G = "G";
    text(G, 115, 210 );
  }
  else
  {
    text(str(nextF+1), 115, 210 );
  }
  Braille();
 
}

public void mouseClicked()
{
  //Buttons///////////////////////////////////////////////////////////////////////
  but1[1] = loadImage("buttonGp.png");
  but2[1] = loadImage("button2p.png");
  but3[1] = loadImage("button3p.png");
  but4[1] = loadImage("button4p.png");
  but5[1] = loadImage("button5p.png");
  but6[1] = loadImage("button6p.png");
  but7[1] = loadImage("button7p.png");
  but8[1] = loadImage("button8p.png");
  but9[1] = loadImage("button9p.png");
  but10[1] = loadImage("button10p.png");
  but11[1] = loadImage("button11p.png");
  butO[1] = loadImage("buttonOp.png");
  butC[1] = loadImage("buttonCp.png");
  Alrm[1] = loadImage("Emp.png");
  Help[1] = loadImage("Hp.png");
  ////////////////////////////////////////////////////////////////////////////////
  //Button G//////////////////////////////////////////////////////////////////////
  if((mouseX > 330 && mouseX < 380)&&(mouseY > 770 && mouseY < 820))
  {
    image(but1[1], 330, 770, 50, 50);
    noLoop();
    
    frameRate(2);
    currF = nextF;
    nextF = 0;
    print("Floor 1\n");
    loop();
  }
  //////////////////////////////////////////////////////////////////////////////
  //Button 2////////////////////////////////////////////////////////////////////
  if((mouseX > 330 && mouseX < 380)&&(mouseY > 700 && mouseY < 750))
  {
    image(but2[1], 330, 700, 50, 50);
    noLoop();
    
    frameRate(2);
    currF = nextF;
    nextF = 1;
    print("Floor 2\n");
    loop();
  }
  //////////////////////////////////////////////////////////////////////////////////////
  //Button 3////////////////////////////////////////////////////////////////////////////
  if((mouseX > 330 && mouseX < 380)&&(mouseY > 630 && mouseY < 680))
  {
    image(but3[1], 330, 630, 50, 50);
    noLoop();

    frameRate(2);
    currF = nextF;
    nextF = 2;
    print("Floor 3\n");
    loop();
  }
  ////////////////////////////////////////////////////////////////////
  //Button 4//////////////////////////////////////////////////////////
  if((mouseX > 330 && mouseX < 380)&&(mouseY > 560 && mouseY < 610))
  {
    image(but4[1], 330, 560, 50, 50);
    noLoop();
    

      frameRate(2);
      currF = nextF;
      nextF = 3;
      print("Floor 4\n");
      loop();

  }
  ///////////////////////////////////////////////////////////////////////////
  //Button 5/////////////////////////////////////////////////////////////////
  if((mouseX > 330 && mouseX < 380)&&(mouseY > 490 && mouseY < 540))
  {
    image(but5[1], 330, 490, 50, 50);
    noLoop();
    
      frameRate(2);
      currF = nextF;
      nextF = 4;
      print("Floor 5\n");
      loop();

  }
  ////////////////////////////////////////////////////////////////////////////////
  //Button 6//////////////////////////////////////////////////////////////////////
  if((mouseX > 330 && mouseX < 380)&&(mouseY > 420 && mouseY < 470))
  {
    image(but6[1], 330, 420, 50, 50);
    noLoop();
    
    frameRate(2);
    currF = nextF;
    nextF = 5;
    print("Floor 6\n");
    loop();

  }
  //////////////////////////////////////////////////////////////////////////////////////////
  //Button 7////////////////////////////////////////////////////////////////////////////////
  if((mouseX > 330 && mouseX < 380)&&(mouseY > 350 && mouseY < 400))
  {
    image(but7[1], 330, 350, 50, 50);
    noLoop();

    frameRate(2);
    currF = nextF;
    nextF = 6;
    print("Floor 7\n");
    loop();
  }
  ///////////////////////////////////////////////////////////////////////////////////////////
  //Button 8/////////////////////////////////////////////////////////////////////////////////
  if((mouseX > 330 && mouseX < 380)&&(mouseY > 280 && mouseY < 330))
  {
    image(but8[1], 330, 280, 50, 50);
    noLoop();
    
    frameRate(2);
    currF = nextF;
    nextF = 7;
    print("Floor 8\n");
    loop();
  }
  /////////////////////////////////////////////////////////////////////////
  //Button 9///////////////////////////////////////////////////////////////
  if((mouseX > 330 && mouseX < 380)&&(mouseY > 210 && mouseY < 260))
  {
    image(but9[1], 330, 210, 50, 50);
    noLoop();

    frameRate(2);
    currF = nextF;
    nextF = 8;
    print("Floor 9\n");
    loop();

  }
  //////////////////////////////////////////////////////////////////////////
  //Button 10///////////////////////////////////////////////////////////////
  if((mouseX > 330 && mouseX < 380)&&(mouseY > 140 && mouseY < 190))
  {
    image(but10[1], 330, 140, 50, 50);
    noLoop();

    frameRate(2);
    currF = nextF;
    nextF = 9;
    print("Floor 10\n");
    loop();
  }
  /////////////////////////////////////////////////////////////////////////
  //Button 11///////////////////////////////////////////////////////////////
  if((mouseX > 330 && mouseX < 380)&&(mouseY > 70 && mouseY < 120))
  {
    image(but11[1], 330, 70, 50, 50);
    noLoop();

    frameRate(2);
    currF = nextF;
    nextF = 10;
    print("Floor 11\n");
    loop();
  }
  /////////////////////////////////////////////////////////////////////////
  //Button O///////////////////////////////////////////////////////////////
  if((mouseX > 70 && mouseX < 120)&&(mouseY > 770 && mouseY < 820))
  {
    image(butO[1], 70, 770, 50, 50);
    noLoop();
    
    frameRate(2);
    print("Opening Door.\n");
    Open = true;
    loop();
  }

  /////////////////////////////////////////////////////////////////////////
  //Button C///////////////////////////////////////////////////////////////
  if((mouseX > 70 && mouseX < 120)&&(mouseY > 700 && mouseY < 750))
  {
    image(butC[1], 70, 700, 50, 50);
    noLoop();
    
    frameRate(2);
    print("Closing Door.\n");
    Open = false;
    loop();
  }
  /////////////////////////////////////////////////////////////////////////
  //Button Alrm////////////////////////////////////////////////////////////
  if((mouseX > 110 && mouseX < 160)&&(mouseY > 290 && mouseY < 340))
  {
    image(Alrm[1], 110, 290, 50,50);
    noLoop();
    
    frameRate(2);
    print("*Alarm noises*\n");
    Open = true;
    loop();
  }
  /////////////////////////////////////////////////////////////////////////
  //Button Alrm////////////////////////////////////////////////////////////
  if((mouseX > 110 && mouseX < 160)&&(mouseY > 380 && mouseY < 430))
  {
    image(Help[1], 110, 380, 50,50);
    noLoop();
    
    frameRate(2);
    print(" \"Hello? Are you in need of assistance?\"\n");
    Open = true;
    loop();
  }
  
}
//////////////////////////////////////////////////////////////////////////////////
//Display Time Date///////////////////////////////////////////////////////////////
public void dispTD()
{
 String seconds = String.valueOf(second());
 String minutes = String.valueOf(minute());
 String hours = String.valueOf(hour());
 
 if(Integer.parseInt(minutes) < 10)
 {
   minutes = ("0" + minutes);
 }
 if(Integer.parseInt(seconds) < 10)
 {
   seconds = ("0" + seconds);
 }
 if(Integer.parseInt(hours) > 12)
 {
   hours = str(Integer.parseInt(hours) - 12);
 }
 
 int months = month();
 int years = year();
 int days = day();
 
 String time = hours + ":" + minutes + ":" + seconds;
 String date = months + "/" + days + "/" + years;
 
 textSize(32);
 fill(255);
 text(time, 70, 130);
 
 textSize(32);
 fill(255);
 text(date, 70, 90);
}

public void Braille()
{

  PImage Br1 = loadImage("B1.png");
  image(Br1, 411, 770, 58, 47);
  PImage Br2 = loadImage("B2.png");
  image(Br2, 411, 700, 58, 47);
  PImage Br3 = loadImage("B3.png");
  image(Br3, 411, 630, 58, 47);
  PImage Br4 = loadImage("B4.png");
  image(Br4, 411, 560, 58, 47);
  PImage Br5 = loadImage("B5.png");
  image(Br5, 411, 490, 58, 47);
  PImage Br6 = loadImage("B6.png");
  image(Br6, 411, 420, 58, 47);
  PImage Br7 = loadImage("B7.png");
  image(Br7, 411, 350, 58, 47);
  PImage Br8 = loadImage("B8.png");
  image(Br8, 411, 280, 58, 47);
  PImage Br9 = loadImage("B9.png");
  image(Br9, 411, 210, 58, 47);
  PImage Br10 = loadImage("B10.png");
  image(Br10, 411, 140, 58, 47);
  PImage Br11 = loadImage("B11.png");
  image(Br11, 411, 70, 58, 47);
  
}
  public void settings() {  size(500, 900); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "--present", "--window-color=#666666", "--stop-color=#cccccc", "Elevator" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
