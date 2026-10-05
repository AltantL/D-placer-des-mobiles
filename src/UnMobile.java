import java.awt.*;
import javax.swing.*;
import java.util.Random;

class UnMobile extends JPanel implements Runnable
{
    int saLargeur , saHauteur , sonDebDessin, boucle;
    final int sonPas = 20, sonTemps=50, sonCote =40;
    static Semaphore semaphore = new SemaphoreBinaire(2); // static car même pour tous
    UnMobile(int telleLargeur, int telleHauteur, int boucle)
    {
        super(); // JPpanel
        saLargeur = telleLargeur;
        saHauteur = telleHauteur;
        boucle = boucle;
        setSize(telleLargeur, telleHauteur) ;

    }
    public void run(){


        for (int i = 0; i < boucle; i++) {

            for(sonDebDessin =0; sonDebDessin < (saLargeur - sonPas)/3; sonDebDessin+= sonPas)
                {mouvement();}

            semaphore.syncWait();

            setForeground(Color.RED);

            for(sonDebDessin =(saLargeur - sonPas)/3; sonDebDessin < (saLargeur - sonPas)*2/3; sonDebDessin+= sonPas)
                {mouvement();}

            setForeground(Color.BLACK);

            semaphore.syncSignal();

            for(sonDebDessin =(saLargeur - sonPas)*2/3; sonDebDessin < (saLargeur - sonPas); sonDebDessin+= sonPas)
                {mouvement();}

            //-----------

            for(sonDebDessin =(saLargeur - sonPas); sonDebDessin > (saLargeur - sonPas)*2/3; sonDebDessin-= sonPas)
                {mouvement();}

            semaphore.syncWait();

            setForeground(Color.RED);

            for(sonDebDessin =(saLargeur - sonPas)*2/3; sonDebDessin > (saLargeur - sonPas)/3; sonDebDessin-= sonPas)
                {mouvement();}

            setForeground(Color.BLACK);

            semaphore.syncSignal();

            for(sonDebDessin =(saLargeur - sonPas)/3; sonDebDessin > 0; sonDebDessin-= sonPas)
                {mouvement();}
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