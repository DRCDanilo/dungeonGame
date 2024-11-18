import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class GameRender extends JPanel {
    //public abstract void update();
    private List<Displayable> renderList;

    public GameRender() {
        renderList = new ArrayList<Displayable>() {
        };
    }

    public void setRenderList(List<Displayable> renderList) {
        this.renderList = renderList;
    }

    public void addToRenderList(Displayable displayable) {
        this.renderList.add(displayable);
    }
}
