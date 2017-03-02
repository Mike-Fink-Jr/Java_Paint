/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pa5;

import java.awt.BasicStroke;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author Fink
 */
public class DrawPanel extends JPanel
{                                         private  shape tempShape;
                                          private  ArrayList<shape> shapes;  

   public void setTempShape(shape t)
        {tempShape=t;}
   
   public void addShape()
   {shapes.add(tempShape);
 }
   
    public DrawPanel()
    { tempShape=null;
        shapes= new ArrayList<shape>();
    }
    
    
    public void paintComponent(Graphics g) {
        super.paintComponents(g);
     
      Graphics2D g2 = (Graphics2D) g;
      if(tempShape!=null)
      {drawMethod(tempShape, g2);
      }
       
       if(shapes.size()>0)
       for(int x=0; x<shapes.size();x++)
       {   drawMethod(shapes.get(x),g2);
           
       }
       
           
      
      
    
    
    }
    public void drawMethod(shape s, Graphics2D g2)
    {  
        g2.setStroke(new BasicStroke(s.getLW()));           ////line thickness 
          
        
        if(s.isDashed())
        { Stroke dashed = new BasicStroke(s.getLW(), BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 10, new float[]{s.getDashLength()}, 0);
        g2.setStroke(dashed);
        }  
           
           if(s.isGradient())
        {  GradientPaint gp5 = new GradientPaint(s.getX1(), s.getY1(), s.getCol1(), s.getX2(), s.getY2(), s.getCol2());

        g2.setPaint(gp5);
        }else
               g2.setPaint(s.getCol1()) ;
           
       if(s.getName().equals("Rectangle"))
       {
         if(s.isFilled())
        {g2.fillRect(s.getX1(), s.getY1(), s.getX2()-s.getX1(), s.getY2()-s.getY1());
       
       
       }else
       {g2.drawRect(s.getX1(), s.getY1(), s.getX2()-s.getX1(), s.getY2()-s.getY1());} }
       
       else if(s.getName().equals("Line"))
    {
        g2.drawLine(s.getX1(), s.getY1(), s.getX2(), s.getY2());
           
    }
    else if(s.getName().equals("Oval"))          
    {
         if(s.isFilled())
    {g2.fillOval(s.getX1(), s.getY1(), s.getX2()-s.getX1(), s.getY2()-s.getY1());} 
       
       
       else{ g2.drawOval(s.getX1(), s.getY1(), s.getX2()-s.getX1(), s.getY2()-s.getY1());} }
    }
    
public void clear()
{shapes.clear();
    tempShape=null;
}
public void undo()
{   tempShape=null;  
    if(!shapes.isEmpty())
          shapes.remove(shapes.size()-1);
          
         
}
}
