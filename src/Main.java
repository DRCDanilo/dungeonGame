import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class Main {

    JFrame displayZoneFrame;

    RenderEngine renderEngine;
    GameEngine gameEngine;
    PhysicEngine physicEngine;


    public Main() throws Exception{
        displayZoneFrame = new JFrame("Dungeon Game");
        displayZoneFrame.setSize(400,600);
        displayZoneFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);





        DynamicSprite hero = new DynamicSprite(70,450,
                ImageIO.read(new File("./img/heroTileSheetLowRes.png")),48,50);


        //Test Danilo
        DrawLifeBar barLife = new DrawLifeBar(0,0,
                ImageIO.read(new File("./img/l3.png")),48,50,hero,DynamicSprite.life);



        renderEngine = new RenderEngine(displayZoneFrame);
        physicEngine = new PhysicEngine();
        gameEngine = new GameEngine(hero);

        Timer renderTimer = new Timer(50,(time)-> renderEngine.update());
        Timer gameTimer = new Timer(50,(time)-> gameEngine.update());
        Timer physicTimer = new Timer(50,(time)-> {
            try {
                physicEngine.update();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        Timer scapeTimer = new Timer(1000,(time)-> gameEngine.oneSecond());

        renderTimer.start();
        gameTimer.start();
        physicTimer.start();
        scapeTimer.start();

        displayZoneFrame.getContentPane().add(renderEngine);
        displayZoneFrame.setVisible(true);

        Playground level = new Playground("./data/level1.txt");
        //SolidSprite testSprite = new DynamicSprite(100,100,test,0,0);
        renderEngine.addToRenderList(level.getSpriteList());
        renderEngine.addToRenderList(hero);
        //TestDanilo
        renderEngine.addToRenderList(barLife);
        physicEngine.setEnvironment(level.getSolidEnemiesList());

        physicEngine.addToMovingSpriteList(hero);
        physicEngine.setEnvironment(level.getSolidSpriteList());




        displayZoneFrame.addKeyListener(gameEngine);
    }

    public static void main (String[] args) throws Exception {
        // write your code here
        Main main = new Main();
    }
}