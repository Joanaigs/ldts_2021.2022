import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class Hero extends Element{
    private final Position position;
    Hero(int x, int y){
        super(x, y);
        position=new Position(x, y);
    }
    public void setPosition(Position position)
    {
        this.position.setX(position.getX());
        this.position.setY(position.getY());
    }

    public Position getPosition() {
        return position;
    }

    public Position moveUp() {
        return new Position(position.getX(), position.getY() - 1);
    }
    public Position moveRight(){
        return new Position(position.getX()+1, position.getY());
    }
    public Position moveDown(){
        return new Position(position.getX(), position.getY() +1);
    }
    public Position moveLeft(){
        return new Position(position.getX()-1, position.getY());
    }
    public void draw(TextGraphics graphics)
    {
        graphics.setForegroundColor(TextColor.Factory.fromString("#ffffff"));
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(position.getX(), position.getY()), "X");
        //graphics.putString(new TerminalPosition(position.getX() / 2, position.getY() / 2), "\\/");
        //graphics.putString(new TerminalPosition(position.getX() / 2, position.getY() / 2 + 1), "/\\");
    }
}
