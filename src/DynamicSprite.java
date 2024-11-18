import java.awt.*;

public class DynamicSprite extends SolidSprite{
    boolean isWalking = true;
    double speed = 5;
    final int  spriteSheetNumberOfColumn = 10;
    int timeBetweenFrame = 200;
    Direction direction=Direction.EAST;

    public DynamicSprite(double x, double y, Image image, double width, double height) {
        super(x, y, image, width, height);
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    @Override
    public void draw(Graphics g){
        int index = ((int)(System.currentTimeMillis())/timeBetweenFrame)%spriteSheetNumberOfColumn;

        g.drawImage(image,(int) x, (int) y, (int) (x+width),(int) (y+height),
                (int) (index*this.width), (int) (direction.getFrameLineNumber()*height),
                (int) ((index+1)*this.width), (int)((direction.getFrameLineNumber()+1)*this.height),null);

    }
}
