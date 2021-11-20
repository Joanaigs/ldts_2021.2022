import com.googlecode.lanterna.graphics.TextGraphics;

public abstract class Element {
    private int x;
    private int y;
    public Element(int x, int y){
        this.x=x;
        this.y=y;
    }
    public Element() {}

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void draw(TextGraphics graphics)
    {}
}
