import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class  Coin extends Element {
    private int x;
    private int y;
    private List<Coin> coins;

    public Coin(int x, int y) {
        super(x, y);
        this.x = x;
        this.y = y;
    }

    public Coin(){
        super();
        this.coins=createCoins();
    }

    public List<Coin> getCoins() {
        return coins;
    }


    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    private List<Coin> createCoins() {
        Random random = new Random();
        ArrayList<Coin> coins = new ArrayList<>();
        int width = 40;
        int height = 20;
        for (int i = 0; i < 5; i++)
            coins.add(new Coin(random.nextInt(width - 2) + 1, random.nextInt(height - 2) + 1));
        return coins;
    }

    public void retrieveCoins(int i) {
        coins.remove(i);
    }

    public void draw(TextGraphics graphics)
    {
        for(Coin coin:coins) {
            graphics.setForegroundColor(TextColor.Factory.fromString("#ffcb1e"));
            graphics.enableModifiers(SGR.BOLD);
            graphics.putString(new TerminalPosition(coin.getX(), coin.getY()), "0");
        }
    }


}
