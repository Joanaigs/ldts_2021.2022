public class StringCaseChanger implements StringTransformer{
    @Override
    public void execute(StringDrink drink) {
        String temp = "";
        for(int i = 0; i < drink.getText().length(); i++){
            char t = drink.getText().charAt(i), t1;
            if(Character.isLowerCase(t))
                t1=Character.toUpperCase(t);
            else t1=Character.toLowerCase(t);
            temp+=t1;
        }
        drink.setText(temp);
    }

    @Override
    public void undo(StringDrink drink) {
        execute(drink);
    }
}
