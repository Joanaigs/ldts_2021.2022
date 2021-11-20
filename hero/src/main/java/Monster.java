import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Monster extends Element{
    private Position position;
    private List<Monster> monsters;
    private final Random random = new Random();

    Monster(int x, int y){
        super(x, y);
        position=new Position(x, y);
    }

    public Monster(){
        super();
        this.monsters=createMonsters();
    }
    public List<Monster> getMonsters() {
        return monsters;
    }

    public void setPosition(Position position)
    {
        this.position.setX(position.getX());
        this.position.setY(position.getY());
    }

    public Position getPosition() {
        return position;
    }

    private List<Monster> createMonsters() {
        ArrayList<Monster> monsters = new ArrayList<>();
        int width = 40;
        int height = 20;
        for (int i = 0; i < 5; i++)
            monsters.add(new Monster(random.nextInt(width - 2) + 1, random.nextInt(height - 2) + 1));
        return monsters;
    }

    public Position move() {
        Random random = new Random();
        int randNumber=random.nextInt(8);
        if(randNumber==0)
            return new Position(position.getX(), position.getY()-1);
        else if(randNumber==1)
            return new Position(position.getX()+1, position.getY()-1);
        else if(randNumber==2)
            return new Position(position.getX()+1, position.getY());
        else if(randNumber==3)
            return new Position(position.getX()+1, position.getY()+1);
        else if(randNumber==4)
            return new Position(position.getX(), position.getY()+1);
        else if(randNumber==5)
            return new Position(position.getX()-1, position.getY()+1);
        else if(randNumber==6)
            return new Position(position.getX()-1, position.getY());
        else if(randNumber==7)
            return new Position(position.getX()-1, position.getY()-1);
        return getPosition();
    }

    public void draw(TextGraphics graphics)
    {
        graphics.setForegroundColor(TextColor.Factory.fromString("#88001b"));
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(position.getX(), position.getY()), "M");
        //graphics.putString(new TerminalPosition(position.getX() / 2, position.getY() / 2), "\\/");
        //graphics.putString(new TerminalPosition(position.getX() / 2, position.getY() / 2 + 1), "/\\");
    }
}
