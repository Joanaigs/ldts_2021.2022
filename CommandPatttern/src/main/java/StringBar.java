import java.util.ArrayList;
import java.util.List;

public class StringBar extends Bar{
    private boolean happyHour=false;
    StringBar(){
        super();
    }
    @Override
    public boolean isHappyHour() {
        return happyHour;
    }

    @Override
    public void startHappyHour() {
        happyHour=true;
        notifyObservers();
    }

    @Override
    public void endHappyHour() {
        happyHour=false;
        notifyObservers();
    }
    @Override
    public void happyHourStarted(Bar bar){
        bar.startHappyHour();
    }
    @Override
    public void happyHourEnded(Bar bar){
        bar.endHappyHour();
    }

    public void order(StringDrink drink, StringRecipe recipe) {
        recipe.mix(drink);
    }


}
