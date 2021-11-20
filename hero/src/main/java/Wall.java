import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;


public class Wall extends Element {
    private final int column;
    private final int row;

    public Wall( int column, int row) {
        super(column, row);
        this.column = column;
        this.row = row;
    }

    public void draw(TextGraphics graphics) {
        graphics.setForegroundColor(TextColor.Factory.fromString("#000000"));
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(column, row),"|");
    }

    public Position getPosition() {
        return new Position(column, row);
    }
}
