import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

public class DynamicSprite extends SolidSprite{
    boolean isWalking = true;
    double speed = 5;
    final int  spriteSheetNumberOfColumn = 10;
    int timeBetweenFrame = 200;
    Direction direction = Direction.EAST;

    public DynamicSprite(double x, double y, Image image, double width, double height) {
        super(x, y, image, width, height);
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }


    private void move(){

        switch(direction){

            case NORTH->{
                this.y -= speed;
                break;
            }

            case EAST->{
                this.y -= speed;
            }

            case SOUTH->{
                this.y -= speed;
            }

            case WEST->{
                this.y -= speed;
            }

            default ->{break;}

        }

    }


    private boolean isMovingPossible (ArrayList<Sprite> environment){

        Rectangle2D.Double hitBox = new Rectangle2D.Double();
        switch(direction){
            case EAST: hitBox.setRect(super.getHitBox().getX()+speed,super.getHitBox().getY(),
                    super.getHitBox().getWidth(), super.getHitBox().getHeight());
                break;
            case WEST:  hitBox.setRect(super.getHitBox().getX()-speed,super.getHitBox().getY(),
                    super.getHitBox().getWidth(), super.getHitBox().getHeight());
                break;
            case NORTH:  hitBox.setRect(super.getHitBox().getX(),super.getHitBox().getY()-speed,
                    super.getHitBox().getWidth(), super.getHitBox().getHeight());
                break;
            case SOUTH:  hitBox.setRect(super.getHitBox().getX(),super.getHitBox().getY()+speed,
                    super.getHitBox().getWidth(), super.getHitBox().getHeight());
                break;
        }

        for(Sprite i : environment){
            if((i instanceof SolidSprite) && (i != this))
            {
                if(((SolidSprite) i).intersect(hitBox))
                {
                    return false;
                }
            }
        }
        return true;

    }

    public void moveIfPossible(ArrayList<Sprite> environment)
    {
        if(isMovingPossible(environment))
        {
            move();
        }
    }




    @Override
    public void draw(Graphics g){
        int index = ((int)(System.currentTimeMillis())/timeBetweenFrame)%spriteSheetNumberOfColumn;

        g.drawImage(image,(int) x, (int) y, (int) (x+width),(int) (y+height),
                (int) (index*this.width), (int) (direction.getFrameLineNumber()*height),
                (int) ((index+1)*this.width), (int)((direction.getFrameLineNumber()+1)*this.height),null);

    }
}
