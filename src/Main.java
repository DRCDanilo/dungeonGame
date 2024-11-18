import javax.imageio.ImageIO;
import javax.swing.*;

import java.io.File;

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

        Sprite test = new Sprite(200,300, ImageIO.read(new File("./img/tree.png")),64,64);
        renderEngine.addToRenderList(test);

    }

    public static void main(String[] args) throws Exception{
        Main main = new Main();

        System.out.println("I got this!");
    }

}
