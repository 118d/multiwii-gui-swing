package eu.kprod.gui.instrument;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.geom.Point2D;
import java.io.IOException;
import java.io.InputStream;

import eu.kprod.ds.MwDataSourceListener;
import eu.kprod.gui.comp.MwJPanel;

public abstract class MwInstrumentJPanel extends MwJPanel implements
MwDataSourceListener {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    static Font writing = null;

    Point2D centerPoint;
    int radiusx;
    int radiusy;
    int maxRadiusX = 220;
    int maxRadiusY = 220;

    Dimension dimPanel;

     int dimMarker5Deg;
     int dimMarker10Deg;

    
    public MwInstrumentJPanel(Dimension dimension) {
if (dimension ==null){
        // Instance variables initialization
        
}else {
    dimPanel= dimension;
    this.maxRadiusX = dimPanel.width;
    this.maxRadiusY = dimPanel.height;
}
this.radiusx = ((Double) (0.45 * this.maxRadiusX)).intValue();
this.radiusy = ((Double) (0.45 * this.maxRadiusY)).intValue();
dimPanel = new Dimension(this.maxRadiusX, this.maxRadiusY);
//        this.setMinimumSize(dimPanel);
        // Define a center point as a reference
        this.centerPoint = new Point2D.Float(this.maxRadiusX / 2,
                this.maxRadiusY / 2);

        if (writing == null) {

            InputStream is = this.getClass().getResourceAsStream(
                    "/01Digitall.ttf");

            try {
                writing = Font.createFont(Font.TRUETYPE_FONT, is);

                writing = writing.deriveFont(12.0f);

            } catch (FontFormatException e) {
                System.out.println("Format fonts not correct!!!");
            } catch (IOException e) {
                System.out.println("Fonts not found!!!");
            }
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return dimPanel;
    }

    @Override
    public void resetAllValues() {
       resetAllValuesImpl();
       repaint();
        
    }

     abstract void resetAllValuesImpl();
     
     @Override
    protected void paintComponent(Graphics g) {
        // TODO Auto-generated method stub
        super.paintComponent(g);
       
    }
}