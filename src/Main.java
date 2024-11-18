import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.KeyEvent;
import java.io.File;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class Main {

    JFrame displayZoneFrame;
    RenderEngine renderEngine;
    GameEngine gameEngine;


    public Main() throws Exception{
        displayZoneFrame = new JFrame("Java Labs");
        displayZoneFrame.setSize(400,600);
        displayZoneFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);

        renderEngine = new RenderEngine();

        DynamicSprite hero = new DynamicSprite(200,300,
                ImageIO.read(new File("./img/heroTileSheetLowRes.png")),48,50);

        gameEngine = new GameEngine(hero);



        Timer renderTimer = new Timer(50,(time)-> renderEngine.update());
        Timer gameTimer = new Timer(50,(time)-> gameEngine.update());

        renderTimer.start();
        gameTimer.start();

        displayZoneFrame.setVisible(true);
        displayZoneFrame.getContentPane().add(renderEngine);

        displayZoneFrame.addKeyListener(gameEngine);

        Sprite test = new Sprite(200,300, ImageIO.read(new File("./img/tree.png")),64,64);
        renderEngine.addToRenderList(test);


        renderEngine.addToRenderList(hero);



    }

    public static void main(String[] args) throws Exception{
        Main main = new Main();

        System.out.println("I got this!");
    }

}
