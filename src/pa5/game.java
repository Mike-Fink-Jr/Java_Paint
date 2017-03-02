/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pa5;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Fink
 */
public  class game extends JFrame
 {

   // private final JFrame frame;
   private final JPanel panel, bottomP;
private final DrawPanel  drawPanel;
    
    private  String currShape;
    private  boolean isFilled;
    private  boolean isGradient;
    private  boolean isDashed;
    boolean dragging;
    private Color color1;
    private  Color color2;
    private  int LineWidth;
    private  int DashedLength;  // ;1=filled;2=Gradient;3= color1; 4= color2; 5= line Width; 6= dashLength; 7=dashed 
    private  ArrayList<shape> shapes;
    private  int x1,x2,y1,y2;
    
    private final JButton undoInput,clearInput;
    private final JCheckBox filledInput, gradientInput, dashedInput;
    private final JComboBox shapeInput;
    private final JLabel one,two,mouseCoord;
    private final JButton color1Input, color2Input;
    private final JTextField lineWidthInput, dashedLengthInput;
    private shape tempShape;
       Graphics2D g2 ; 
       
       
 public game() 
    { //initialize buttons
        
        tempShape=null;
        
        
        currShape="Line";
        shapes = new ArrayList<shape>();
        undoInput= new JButton("Undo");
        clearInput= new JButton("Clear");
        filledInput= new JCheckBox("Filled");
        gradientInput= new JCheckBox("Gradient");
        dashedInput= new JCheckBox("Dashed");
        String[] shapeList=new String[]{"Line","Rectangle","Oval"};
           
    isFilled=false;
    isGradient=false;
    isDashed=false;
    dragging=false;
    color1=Color.BLACK;
    color2= Color.BLACK;
    LineWidth=10;
    DashedLength=10;
    shapeInput= new JComboBox(shapeList);
    color1Input = new JButton("Color 1");
    color2Input = new JButton("Color 2");
            lineWidthInput= new JTextField(2);
    dashedLengthInput= new JTextField(2);
    one= new JLabel("Line Width:");
    two = new JLabel("Dash Length:");
    mouseCoord= new JLabel("");
    bottomP= new JPanel();
    bottomP.add(mouseCoord);
    drawPanel= new DrawPanel();
    drawPanel.setPreferredSize(new Dimension(1000,600));
    bottomP.setPreferredSize(new Dimension(100,50));
    setTitle("Java 2D Drawings");
     drawPanel.setBackground(Color.WHITE);
        //frame = new JFrame("Microsoft Paint");
       // frame.
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    //    frame.
    setLayout(new FlowLayout());
    //    frame.
    setPreferredSize(new Dimension(1000 , 725));
          
       // frame.
 
       // frame.
    getContentPane().setBackground(Color.WHITE);
       // frame.
    setVisible(true);
        
        undoInput.addActionListener(new undoListener());
        shapeInput.addActionListener(new shapeListener());
        clearInput.addActionListener(new clearListener());
        filledInput.addActionListener(new filledListener());
        gradientInput.addActionListener(new gradientListener());
        color1Input.addActionListener(new Color1Listener());
         color2Input.addActionListener(new Color2Listener());
         lineWidthInput.addActionListener(new LineWidthListener()); 
          dashedLengthInput.addActionListener(new dashedLengthListener());
           dashedInput.addActionListener(new dashListener());
            
          
        //add buttons
        panel = new JPanel();
        panel.setPreferredSize(new Dimension( 1000,50));
    
           panel.add(undoInput);
           panel.add(clearInput);
           
           panel.add(shapeInput);
           panel.add(filledInput);
           panel.add(gradientInput);
           panel.add(color1Input);
           panel.add(color2Input);
           panel.add(one);
           panel.add(lineWidthInput);
           panel.add(two);
           panel.add(dashedLengthInput);
           panel.add(dashedInput);
           
           
           
           
           //frame.
           getContentPane().add(panel);    
           getContentPane().add(drawPanel);    
           getContentPane().add(bottomP);    
           
        
    
     
       // frame.
           drawPanel.repaint();
      
        //frame.
           drawPanel.addMouseListener(new mouse());
        ///frame.
           drawPanel.addMouseMotionListener(new mouse());
         //  frame.
           drawPanel.repaint();
       pack();
    }
 
 class shapeListener implements ActionListener//0
    {

        @Override
        public void actionPerformed(ActionEvent e)
        {  
            currShape=shapeInput.getSelectedItem().toString();
            
        
        }
        
    }
 class filledListener implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e)
        {
          
        isFilled = filledInput.isSelected();
      
            
        }
        
    }
  class gradientListener implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e)
        {
        
      isGradient =   gradientInput.isSelected();
        
            
            
        }
        
    } class LineWidthListener implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e)
        {
             int x=Integer.parseInt(lineWidthInput.getText());
            if(x!=0)
            {LineWidth =x; }
            
        }
        
    }
  class dashedLengthListener implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e)
        {
            
            int x=Integer.parseInt(dashedLengthInput.getText());
            if(x!=0)
            { DashedLength =x;
            }
            
        }
        
    }
   class dashListener implements ActionListener//7
    {

        @Override
        public void actionPerformed(ActionEvent e)
        {
               AbstractButton ab = (AbstractButton) e.getSource();
       isDashed = ab.getModel().isSelected();
       
            
            
        }
        
    }
  class clearListener implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e)
        {
            drawPanel.clear();
             drawPanel.repaint();
            
        }
        
    }
 class undoListener implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e)
        {
            drawPanel.undo();
         drawPanel.repaint();
         }   
            
        }
        
 
     class Color2Listener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {  color2= JColorChooser.showDialog(panel, e.getActionCommand(), color2);
            
            
        
        
        }}
     
     
     
     
         class Color1Listener implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e)
        {
            
            color1= JColorChooser.showDialog(panel, e.getActionCommand(), color1);
            
            
            
            
        }
        }
         
         
         
    
class mouse implements MouseListener, MouseMotionListener
{    
        
   public void mousePressed(MouseEvent e) {
        // save coord x,y when mouse is pressed
        x1 = e.getX();
        y1 = e.getY();
      }
        
    
        
      public void mouseDragged(MouseEvent e) {
        // coord x,y when drag mouse
        x2 = e.getX();
        y2 = e.getY();
        mouseCoord.setText("("+e.getX()+","+e.getY()+")");
        drawPanel.setTempShape(new shape(currShape,x1,y1,x2,y2,color1,color2,isFilled, isGradient,isDashed,LineWidth,DashedLength));
          //frame.
        drawPanel.repaint();   
         
      }
   
      public void mouseReleased(MouseEvent evt) 
      {
    drawPanel.addShape();
         //shapes.add(tempShape);
      //frame.
       drawPanel.repaint();
      }
      
       
     public void mouseEntered(MouseEvent evt) { } public void mouseExited(MouseEvent evt) { }public void mouseClicked(MouseEvent evt) { }  
     public void mouseMoved(MouseEvent evt) 
     {mouseCoord.setText("("+evt.getX()+","+evt.getY()+")");
     }       
     } 
}

      
        
