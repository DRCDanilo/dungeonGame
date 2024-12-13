import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import static javax.swing.JOptionPane.showMessageDialog;

public class DynamicSprite extends SolidSprite{
    private Direction direction = Direction.NORTH;
    private double speed = 5;
    private double timeBetweenFrame = 250;
    private boolean isWalking =true;
    private final int spriteSheetNumberOfColumn = 10;
    static int life = 3;
    boolean oneTimeMessage = true;


    public DynamicSprite(double x, double y, Image image, double width, double height) {
        super(x, y, image, width, height);
    }

    private boolean isMovingPossible(ArrayList<Sprite> environment) throws IOException {
        Rectangle2D.Double moved = new Rectangle2D.Double();
        switch(direction){
            case EAST: moved.setRect(super.getHitBox().getX()+speed,super.getHitBox().getY(),
                    super.getHitBox().getWidth(), super.getHitBox().getHeight());
                break;
            case WEST:  moved.setRect(super.getHitBox().getX()-speed,super.getHitBox().getY(),
                    super.getHitBox().getWidth(), super.getHitBox().getHeight());
                break;
            case NORTH:  moved.setRect(super.getHitBox().getX(),super.getHitBox().getY()-speed,
                    super.getHitBox().getWidth(), super.getHitBox().getHeight());
                break;
            case SOUTH:  moved.setRect(super.getHitBox().getX(),super.getHitBox().getY()+speed,
                    super.getHitBox().getWidth(), super.getHitBox().getHeight());
                break;
        }

        for (Sprite s : environment){
            if ((s instanceof SolidSprite) && (s!=this)){
                if (((SolidSprite) s).intersect(moved)){
                    if(((SolidSprite) s).image == ImageIO.read(new File("./img/enemy.png")))
                    {
                        //L.image = imageEnemy = ImageIO.read(new File("./img/enemy.png"));
                        System.out.println("aaa");
                        //lifeDecrease=true;

                    }
                    return false;

                }
            }
        }
        return true;
    }

    public void decreaseLife() {
        if (life > 0) {
            life--;
        }
    }



    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    private void move(){
        switch (direction){
            case NORTH -> {
                this.y-=speed;
            }
            case SOUTH -> {
                this.y+=speed;
            }
            case EAST -> {
                this.x+=speed;
            }
            case WEST -> {
                this.x-=speed;
            }
        }

        if(this.x >= 400)
        {
            if(oneTimeMessage)
            {
                System.out.println("You Did It!");
                showMessageDialog(null, "Good Game, You Did It!", "Congratulations", JOptionPane.PLAIN_MESSAGE);
                oneTimeMessage = false;
            }

        }

    }

    public void moveIfPossible(ArrayList<Sprite> environment) throws IOException {
        if (isMovingPossible(environment)){
            move();
        }
        else
        {
            //System.out.println("no me estoy moviendo");//QUE SE HACE SI NO SE PUEDE MOVER?
            decreaseLife();
        }
    }

    @Override
    public void draw(Graphics g) {
        int index= (int) (System.currentTimeMillis()/timeBetweenFrame%spriteSheetNumberOfColumn);

        g.drawImage(image,(int) x, (int) y, (int) (x+width),(int) (y+height),
                (int) (index*this.width), (int) (direction.getFrameLineNumber()*height),
                (int) ((index+1)*this.width), (int)((direction.getFrameLineNumber()+1)*this.height),null);
    }



    public boolean isAnEnemy(ArrayList<Sprite> enemies) throws IOException {
        Rectangle2D.Double moved = new Rectangle2D.Double();
        switch(direction){
            case EAST: moved.setRect(super.getHitBox().getX()+speed,super.getHitBox().getY(),
                    super.getHitBox().getWidth(), super.getHitBox().getHeight());
                break;
            case WEST:  moved.setRect(super.getHitBox().getX()-speed,super.getHitBox().getY(),
                    super.getHitBox().getWidth(), super.getHitBox().getHeight());
                break;
            case NORTH:  moved.setRect(super.getHitBox().getX(),super.getHitBox().getY()-speed,
                    super.getHitBox().getWidth(), super.getHitBox().getHeight());
                break;
            case SOUTH:  moved.setRect(super.getHitBox().getX(),super.getHitBox().getY()+speed,
                    super.getHitBox().getWidth(), super.getHitBox().getHeight());
                break;
        }

        for (Sprite s : enemies){
            if ((s instanceof SolidSprite) && (s!=this)){
                if (((SolidSprite) s).intersect(moved)){
                    if(true)//((SolidSprite) s).image == ImageIO.read(new File("./img/enemy.png")))
                    {
                        //L.image = imageEnemy = ImageIO.read(new File("./img/enemy.png"));
                        System.out.println("W+" + life+moved);

                        //decreaseLife();


                    }
                    return false;

                }
            }
        }
        return true;
    }





}