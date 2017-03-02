/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pa5;

import java.awt.Color;

/**
 *
 * @author Fink
 */
   
///////////////////////////////////////////////////////////////
//////////Shape   
///////////////////////////////////////////////////////////////      
    
    public  class shape
    {private  int x1,x2,y1,y2,LW, dashLength;
     private  boolean filled, gradient, dashed;
     private  Color col1,col2; 
     private String name;
    public shape(String nam,int ex1, int why1, int ex2, int why2, Color c1, Color c2, boolean isFilled ,boolean isGrad, boolean isDashed, int width,int dash)
    {name=nam;
    x1=ex1;
        y1=why1;
        x2=ex2;
        y2=why2;
        col1=c1;
        col2=c2;
         dashed=isDashed;
        LW=width;
        dashLength=dash;
          gradient=isGrad;
    if(name.equals("Line"))
    { filled= false;}else
        filled=isFilled;  
    }
            public int getX1()
            {
                return x1;
            }
            public int getX2()
            {
                return x2;
            }
            public int getY1()
            {
                return y1;
            }
            public int getY2()
            {
                return y2;
            }
            public int getLW()
            {
                return LW;
            }
            public int getDashLength()
            {
                return dashLength;
            }
            public boolean isFilled()
            {
                return filled;
            }
            public boolean isGradient()
            {
                return gradient;
            }
            public boolean isDashed()
            {
                return dashed;
            }
            public Color getCol1()
            {
                return col1;
            }
            public Color getCol2()
            {
                return col2;
            }
            public String getName()
            {
                return name;
            }
    
    
    
    
    
    
    
    }
    
    
    
    
