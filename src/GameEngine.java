import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static javax.swing.JOptionPane.showMessageDialog;

public class GameEngine implements Engine, KeyListener {
    DynamicSprite hero;
    int count;
    int timeToScape = 10;

    public GameEngine(DynamicSprite hero) {
        this.hero = hero;
    }

    @Override
    public void update() {


    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch(e.getKeyCode()){
            case KeyEvent.VK_UP :
                hero.setDirection(Direction.NORTH);
                break;
            case KeyEvent.VK_DOWN:
                hero.setDirection(Direction.SOUTH);
                break;
            case KeyEvent.VK_LEFT:
                hero.setDirection(Direction.WEST);
                break;
            case KeyEvent.VK_RIGHT:
                hero.setDirection(Direction.EAST);
                break;

        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    public void oneSecond()
    {
        count++;
        if( (count == timeToScape) && (hero.x <=400) )
        {
            showMessageDialog(null, "Time Is Up, You Lost!", "Attention", JOptionPane.ERROR_MESSAGE);
            count = 0;


        }
    }

}
