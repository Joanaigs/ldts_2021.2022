import com.googlecode.lanterna.*;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;

import java.util.ArrayList;
import java.util.List;


public class Arena {
    private final int width;
    private final int height;
    private final Hero hero=new Hero(10, 10);
    private final Coin coin=new Coin();
    private final Monster monster=new Monster();
    private final List<Wall> walls;

    private final Position position= hero.getPosition();
    Arena(int x, int y){
        this.height=y;
        this.width=x;
        this.walls = createWalls();
    }
    private List<Wall> createWalls() {
        List<Wall> walls = new ArrayList<>();
        for (int c = 0; c < width; c++) {
            walls.add(new Wall(c, 0));
            walls.add(new Wall(c, height - 1));
        }
        for (int r = 1; r < height - 1; r++) {
            walls.add(new Wall(0, r));
            walls.add(new Wall(width - 1, r));
        }
        return walls;
    }
    public void moveHero(Position position) {
        if (canHeroMove())
            hero.setPosition(position);
        checkCollision();
    }

    public boolean canHeroMove() {
        for (Wall wall : walls) {
            if (wall.getPosition().getX() == position.getX() && wall.getPosition().getY() == position.getY())
                return false;
        }
        return true;
    }

    public void moveMonsters(){
        List<Monster> monsters=monster.getMonsters();
        for(Monster monst: monsters) {
            Position pos = monst.move();
            if (canMonsterMove(pos))
                monst.setPosition(pos);
        }
    }
    public boolean canMonsterMove(Position pos) {
        for (Wall wall : walls) {
            if (wall.getPosition().getX() == pos.getX() && wall.getPosition().getY() == pos.getY())
                return false;
        }
        return true;
    }

    public void processKey(KeyStroke key) {
        if (key.getKeyType() == KeyType.ArrowUp) {
            moveHero(hero.moveUp());
        }
        else if (key.getKeyType() == KeyType.ArrowDown)
            moveHero(hero.moveDown());
        else if(key.getKeyType()==KeyType.ArrowLeft)
            moveHero(hero.moveLeft());
        else if(key.getKeyType()==KeyType.ArrowRight)
            moveHero(hero.moveRight());
        moveMonsters();
    }

    public void checkCollision(){
        List<Coin> coins=coin.getCoins();
        for(int i=0;i<coins.size(); i++) {
            if(coins.get(i).getX()==hero.getPosition().getX()&&coins.get(i).getY()== hero.getPosition().getY()){
                coin.retrieveCoins(i);
                break;
            }
        }
    }

    public boolean verifyMonsterCollisions1()
    {
        List<Monster> monsters=monster.getMonsters();
        for(Monster monst: monsters) {
            if(monst.getPosition().getY()==hero.getPosition().getY()&&monst.getPosition().getX()==hero.getPosition().getX()) {
                return true;
            }
        }
        return false;
    }

    public void draw(TextGraphics graphics) {
        graphics.setBackgroundColor(TextColor.Factory.fromString("#5db38e"));
        graphics.enableModifiers(SGR.BOLD);
        graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(width * 2, height * 2), ' ');
        hero.draw(graphics);
        for (Wall wall : walls)
            wall.draw(graphics);
        coin.draw(graphics);
        List<Monster> monsters=monster.getMonsters();
        for(Monster monst: monsters)
            monst.draw(graphics);
    }
}
