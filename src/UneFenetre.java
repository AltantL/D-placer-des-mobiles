import java.awt.*;
import javax.swing.*;

public class UneFenetre extends JFrame {

    UnMobile sonMobile;
    private final int LARG = 1500, HAUT=800;

    public UneFenetre(int nbLig){

        /*TODO
        * ajouter sonMobile a la fenetre
        * creer une thread lathread avec sonMobile
        * afficher la fenetre
        * lanceer laThread
        * */


        super("TP mobile");
        Container leConteneur = getContentPane();
        setLayout(new GridLayout(nbLig, 1));

        UnMobile[] mesMobiles = new UnMobile[nbLig];
        Thread[] mesThread = new Thread[nbLig];

        for (int i = 0; i < nbLig; i++) {
            mesMobiles[i] = new UnMobile(LARG,HAUT,i*500);
            leConteneur.add(mesMobiles[i]);
            mesThread[i] = new Thread(mesMobiles[i]);
            mesThread[i].start();
        }

        setSize(LARG,HAUT);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }
}
