public class StringInverter implements StringTransformer{

    @Override
    public void execute(StringDrink drink) {
        String temp = "";
        for(int i = drink.getText().length()-1; i >= 0; i--){
            temp = temp + drink.getText().charAt(i);
        }
        drink.setText(temp);
    }

    @Override
    public void undo(StringDrink drink) {
        execute(drink);
    }
}
