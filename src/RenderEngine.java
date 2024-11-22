import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class RenderEngine extends JPanel implements Engine{


    private List<Displayable> renderList;


    public RenderEngine() {
        renderList = new ArrayList<Displayable>();

    }


    public void setRenderList(List<Displayable> renderList) {
        this.renderList = renderList;
    }

    public void addToRenderList(Displayable displayable){
        if (!renderList.contains(displayable)){
            renderList.add(displayable);
        }
    }

    @Override
    public void paint(Graphics g){
        super.paint(g);
        for (Displayable renderObject : renderList){
            renderObject.draw(g);
        }
    }


    @Override
    public void update() {
        //System.out.println("RenderEngine");
        this.repaint();
    }


}
