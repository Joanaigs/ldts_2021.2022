import java.util.ArrayList;
import java.util.List;

public class StringRecipe{
    List<StringTransformer> transformers;
    public StringRecipe(List<StringTransformer> transformers) {
        this.transformers=transformers;
    }

    private StringRecipe getRecipe() {
        StringInverter si = new StringInverter();
        StringCaseChanger cc = new StringCaseChanger();
        StringReplacer sr = new StringReplacer('A', 'X');
        List<StringTransformer> transformers = new ArrayList<>();
        transformers.add(si);
        transformers.add(cc);
        transformers.add(sr);
        StringRecipe recipe = new StringRecipe(transformers);
        return recipe;
    }

    public void mix(StringDrink drink) {
        for (StringTransformer method : transformers) {
            method.execute(drink);
        }
    }

}
