public class HumanClient implements Client{
    //StringDrink drink;
    //StringRecipe recipe;
    //StringBar bar;
    OrderingStrategy strategy;

    public HumanClient(OrderingStrategy strategy) {
        this.strategy=strategy;
    }

    @Override
    public void wants(StringDrink drink, StringRecipe recipe, StringBar bar) {
        strategy.wants(drink, recipe, bar);
    }

    public void happyHourStarted(Bar bar) {

        strategy.happyHourStarted((StringBar) bar);
    }

    public void happyHourEnded(Bar bar) {
        bar.happyHourEnded((StringBar)bar);
    }
}
