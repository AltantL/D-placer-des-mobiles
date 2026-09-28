import java.awt.*;
import javax.swing.*;

class UnMobile extends JPanel implements Runnable
{
    int saLargeur , saHauteur , sonDebDessin ,sleeps;
    final int sonPas = 10, sonTemps=50, sonCote =40;
    UnMobile(int telleLargeur, int telleHauteur, int sleep)
    {
        super( ) ;
        saLargeur = telleLargeur;
        saHauteur = telleHauteur;
        sleeps = sleep;
        setSize(telleLargeur, telleHauteur) ;

    }
    public void run()
    {
        try{Thread.sleep(sleeps);}
        catch(InterruptedException telleExcp)
        {telleExcp.printStackTrace();}
        for (int i = 0; i <20; i++) {
            for(sonDebDessin =0; sonDebDessin < saLargeur - sonPas; sonDebDessin+= sonPas)
            {
                repaint();
                try{Thread.sleep(sonTemps);}
                catch(InterruptedException telleExcp)
                {telleExcp.printStackTrace();}
            }
            for(sonDebDessin =saLargeur; sonDebDessin > 0; sonDebDessin-= sonPas)
            {
                repaint();
                try{Thread.sleep(sonTemps);}
                catch(InterruptedException telleExcp)
                {telleExcp.printStackTrace();}
            }
        }

    }
    public void paintComponent(Graphics telCG)
    {
        super.paintComponent(telCG);
        telCG.fillRect(sonDebDessin, saHauteur/2, sonCote, sonCote);
    }
}