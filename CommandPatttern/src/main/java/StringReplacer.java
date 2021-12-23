public class StringReplacer implements StringTransformer{
    char replace , newChar;
    public StringReplacer(char a, char x) {
        replace = a;
        newChar = x;
    }

    @Override
    public void execute(StringDrink drink) {
        drink.setText(drink.getText().replace(replace, newChar));
    }

    @Override
    public void undo(StringDrink drink) {
        drink.setText(drink.getText().replace(newChar, replace));
    }
}
