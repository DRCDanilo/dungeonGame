import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class DrawLifeBar implements Displayable
{

    protected double x;
    protected double y;
    protected Image image;
    protected double width;
    protected double height;
    protected DynamicSprite sprite;
    protected int life;

    public DrawLifeBar( double x, double y, Image image, double width, double height, DynamicSprite sprite, int life )
    {

        this.x = x;
        this.y = y;
        this.image = image;
        this.width = width;
        this.height = height;
        this.sprite = sprite;
        this.life = life;

    }

    @Override
    public void draw(Graphics g) throws IOException {
        //if(sprite.lifeDecrease)
        switch(life)
        {
            case 3:
                image = ImageIO.read(new File("./img/l3.png"));
                break;
            case 2:
                image = ImageIO.read(new File("./img/l2.png"));
                break;
            case 1:
                image = ImageIO.read(new File("./img/l1.png"));
                break;
            case 0:
                image = ImageIO.read(new File("./img/l0.png"));
                break;
            default:
                break;
        }
        g.drawImage(image,(int)x,(int)y,null);
    }
}
