import javax.swing.*;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class Main {

    JFrame displayZoneFrame;
    RenderEngine renderEngine;


    public Main() throws Exception{
        displayZoneFrame = new JFrame("Java Labs");
        displayZoneFrame.setSize(400,600);
        displayZoneFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);

        renderEngine = new RenderEngine();



        Timer renderTimer = new Timer(50,(time)-> renderEngine.update());

        renderTimer.start();
        displayZoneFrame.setVisible(true);
        displayZoneFrame.getContentPane().add(renderEngine);

    }

    public static void main(String[] args) throws Exception{
        Main main = new Main();

        System.out.println("I got this!");
    }

}
