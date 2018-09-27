package afvink3;

/**
 * Race class
 * Class Race maakt gebruik van de class Paard
 *
 * @author Martijn van der Bruggen
 * @version alpha - aanroep van cruciale methodes ontbreekt
 * (c) 2009 Hogeschool van Arnhem en Nijmegen
 *
 * Note: deze code is bewust niet op alle punten generiek
 * dit om nog onbekende constructies te vermijden.
 *
 * Updates
 * 2010: verduidelijking van opdrachten in de code MvdB
 * 2011: verbetering leesbaarheid code MvdB
 * 2012: verbetering layout code en aanpassing commentaar MvdB
 * 2013: commentaar aangepast aan nieuwe opdracht MvdB
 *
 *************************************************
 * Afvinkopdracht: werken met methodes en objecten
 *************************************************
 * Opdrachten zitten verwerkt in de code
 * 1) Declaratie constante
 * 2) Declaratie van Paard (niet instantiering)
 * 3) Declareer een button
 * 4) Zet breedte en hoogte van het frame
 * 5) Teken een finish streep
 * 6) Creatie van 4 paarden
 * 7) Pauzeer
 * 8) Teken 4 paarden
 * 9) Plaats tekst op de button
 * 10) Start de race, methode aanroep
 *
 *
 */
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

public class Race extends JFrame implements ActionListener {

    /** declaratie van variabelen */
    private final int lengte = 250;
    private Paard[] horses = new Paard[5];
    private JButton button;
    private BufferedImage horse_image;
    /* (1) Declareer hier een constante int met de naam lengte en een waarde van 250 */
    /* (2) Declareer hier h1, h2, h3, h4 van het type Paard
     *  Deze paarden instantieer je later in het programma
     */
    /* (3) Declareer een button met de naam button van het type JButton */
    private RacePanel panel;

    public Race(){
        try {
            horse_image = ImageIO.read(new File("/home/bastiaan/IdeaProjects/Afvinkopdracht3/src/afvink3/horse.png"));
        } catch (IOException e) {
        }

        String[] names = {
                "Winey",
                "Blaze",
                "Pinky",
                "Hopper",
                "Shadow"
        };

        Color[] hColors = {
                new Color(95, 2, 31),
                new Color(236, 71, 28),
                new Color(250, 28, 183),
                new Color(50, 200, 29),
                new Color(0,0,0)
        };


        for (int x = 0; x < horses.length; x++){
            horses[x] = new Paard(names[x], hColors[x]);
            //tekenPaard(g, horses[x]);
        }
    }


    /** Applicatie - main functie voor runnen applicatie */
    public static void main(String[] args) {
        Race frame = new Race();
        /* (4) Geef het frame een breedte van 400 en hoogte van 140 */
        frame.setSize(new Dimension(400, 300));
        frame.createGUI();
        frame.setVisible(true);
    }

    /** Loop de race
     */
    private void startRace(Graphics g) {
        panel.setBackground(Color.white);
        /** Tekenen van de finish streep */
        /* (5) Geef de finish streep een rode kleur */
        //g.setColor(Color.RED);
        //g.fillRect(lengte+10, 0, 3, 200);
        /*
        String[] names = {
                "Winey",
                "Blaze",
                "Pinky",
                "Hopper",
                "Shadow"
        };

        Color[] hColors = {
                new Color(95, 2, 31),
                new Color(236, 71, 28),
                new Color(250, 28, 183),
                new Color(50, 200, 29),
                new Color(0,0,0)
        };

        for (int x = 0; x < horses.length; x++){
            horses[x] = new Paard(names[x], hColors[x]);
            //tekenPaard(g, horses[x]);
        }
        */
        //panel.repaint();


        for (Paard horse : horses){
            horse.setAfstand(0);
        }

        /**(6) Creatie van 4 paarden
         * Dit is een instantiering van de 4 paard objecten
         * Bij de instantiering geef je de paarden een naam en een kleur mee
         * Kijk in de class Paard hoe je de paarden
         * kunt initialiseren.
         */
        /** Loop tot een paard over de finish is*/

        boolean keepRunning = true;

        while (keepRunning) {

            g.setColor(Color.white);
            g.fillRect(0, 0, 300, 200);
            for (Paard horse : horses){
                horse.run();
                tekenPaard(g, horse);
                if (horse.getAfstand() >= lengte){
                    keepRunning = false;
                }
            }
            g.setColor(Color.RED);
            g.fillRect(lengte+10, 0, 3, 200);

            //panel.repaint();

            /* (7) Voeg hier een aanroep van de methode pauzeer toe zodanig
             * dat er 1 seconde pauze is. De methode pauzeer is onderdeel
             * van deze class
             */
            pauzeer(200);
            /* (8) Voeg hier code in om 4 paarden te tekenen die rennen
             * Dus een call van de methode tekenPaard
             */
            /**
            for (Paard horse : horses){
                tekenPaard(g, horse);
            }


            for (Paard horse : horses){
                if (horse.getAfstand() >= lengte){
                    keepRunning = false;
                }
            }
            */

        }
        /** Kijk welk paard gewonnen heeft
         */

        for (Paard horse : horses){
            if (horse.getAfstand() >= lengte) {
                JOptionPane.showMessageDialog(null, horse.getNaam() + " heeft gewonnen!");
            }
        }
    }

    /** Creatie van de GUI*/
    private void createGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container window = getContentPane();
        window.setLayout(new FlowLayout());
        panel = new RacePanel();
        panel.setPreferredSize(new Dimension(300, 200));
        panel.setBackground(Color.white);
        window.add(panel);
        /* (9) Zet hier de tekst Run! op de button */
        button = new JButton("Run!");
        window.add(button);
        button.addActionListener(this);
    }


    /** Teken het paard */
    private void tekenPaard(Graphics g, Paard h) {
        //g.setColor(h.getKleur());
        //g.fillRect(h.getAfstand(), 20 * h.getPaardNummer(), 10, 5);
        g.drawImage(horse_image, h.getAfstand(), 40 * (h.getPaardNummer()-1), 30, 30,null);
        //g.fillRect(10, 20 * h.getPaardNummer(), h.getAfstand(), 5);
    }

    /** Actie indien de button geklikt is*/
    public void actionPerformed(ActionEvent event) {
        Graphics paper = panel.getGraphics();
        /* (10) Roep hier de methode startrace aan met de juiste parameterisering */
        startRace (paper);
    }

    /** Pauzeer gedurende x millisecondes*/
    public void pauzeer(int msec) {
        try {
            Thread.sleep(msec);
        } catch (InterruptedException e) {
            System.out.println("Pauze interruptie");
        }
    }



    private class RacePanel extends JPanel{
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            for (Paard h : horses) {
                System.out.println(h.getAfstand());
                //g.fillRect(h.getAfstand(), 20 * h.getPaardNummer(), 10, 5);
                g.drawImage(horse_image,
                        h.getAfstand(),
                        40 * (h.getPaardNummer() - 1),
                        30,
                        30,
                        null);
                //g.fillRect(10, 20 * h.getPaardNummer(), h.getAfstand(), 5);
            }
            g.setColor(Color.RED);
            g.fillRect(lengte+10, 0, 3, 200);
        }
    }


}

