import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Graphics2D;

public class Main {
    public static void main(String[] args) {
        Function f=new Function(new ComplexNumber[]{new ComplexNumber(1, 0)});
        ComplexNumber[] zeros=new ComplexNumber[] {
                new ComplexNumber(1, 1),
                new ComplexNumber(1, -1),
                new ComplexNumber(-1, 1)
        };
        for(int i = 0; i<zeros.length; i++) {
            f=f.addZero(zeros[i]);
        }


        JFrame frame=new JFrame();
        frame.setSize(800, 800);
        frame.setVisible(true);
        Graphics2D g=(Graphics2D)frame.getGraphics();
        for(int i = 0; i<800; i++) {
            for(int j = 0; j<800; j++) {
                ComplexNumber here=new ComplexNumber(i/80.0-5, j/80.0-5);

                ComplexNumber newtons=f.newtonsMethod(here);

                for(int k = 0; k<zeros.length; k++) {
                    if(newtons.subtract(zeros[k]).length()<0.01) {
                        if(k==0) g.setColor(Color.BLUE);
                        else if(k==1) g.setColor(Color.RED);
                        else if(k==2) g.setColor(Color.GREEN);
                        else g.setColor(Color.ORANGE);
                        g.fillRect(i, j, 1, 1);
                        break;
                    }
                }
            }
        }
    }
}