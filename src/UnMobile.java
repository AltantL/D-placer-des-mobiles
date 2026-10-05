import java.awt.*;
import javax.swing.*;

class UnMobile extends JPanel implements Runnable
{
    int saLargeur , saHauteur , sonDebDessin;
    final int sonPas = 10, sonTemps=50, sonCote =40;
    Semaphore semaphore = new SemaphoreGeneral(4);
    UnMobile(int telleLargeur, int telleHauteur)
    {
        super(); // JPpanel
        saLargeur = telleLargeur;
        saHauteur = telleHauteur;
        setSize(telleLargeur, telleHauteur) ;

    }
    public void run() // lance
    {
        for (int i = 0; i <20; i++) {
            semaphore.syncWait();
            for(sonDebDessin =0; sonDebDessin < saLargeur - sonPas; sonDebDessin+= sonPas)
            {
                mouvement();
            }
            for(sonDebDessin =saLargeur; sonDebDessin > 0; sonDebDessin-= sonPas)
            {
                mouvement();
            }
            semaphore.syncSignal();
        }

    }

    private void mouvement() {
        repaint();
        try{Thread.sleep(sonTemps);}
        catch(InterruptedException telleExcp)
        {telleExcp.printStackTrace();}
    }

    public void paintComponent(Graphics telCG)
    {
        super.paintComponent(telCG);
        telCG.fillRect(sonDebDessin, saHauteur/2, sonCote, sonCote);
    }
}