public class SmartStrategy implements OrderingStrategy{

    @Override
    public void wants(StringDrink drink, StringRecipe recipe, StringBar bar) {
        if(bar.isHappyHour()){

        }
    }

    @Override
    public void happyHourStarted(StringBar bar) {

    }

    @Override
    public void happyHourEnded(StringBar bar) {

    }
}
