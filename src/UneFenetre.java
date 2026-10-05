import java.awt.*;
import javax.swing.*;

public class UneFenetre extends JFrame {

    UnMobile[] mesMobiles;
    Thread[] mesThread;
    private final int LARG = 1500, HAUT=800;

    public UneFenetre(int nbLig, int boucle){

        /*
        * ajouter sonMobile a la fenetre
        * creer une thread laThread avec sonMobile
        * afficher la fenetre
        * lancer laThread
        * */


        super("TP mobile");
        Container leConteneur = getContentPane();
        leConteneur.setLayout(new GridLayout(nbLig, 1));

        mesMobiles = new UnMobile[nbLig];
        mesThread = new Thread[nbLig];

        for (int i = 0; i < nbLig; i++) {
            mesMobiles[i] = new UnMobile(LARG,HAUT/nbLig, boucle);
            leConteneur.add(mesMobiles[i]);
        }

        setSize(LARG,HAUT);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        for (int i = 0; i < nbLig; i++) {
            mesThread[i] = new Thread(mesMobiles[i]);
            mesThread[i].start();
        }

    }
}
