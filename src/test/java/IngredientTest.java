import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;


@RunWith(Parameterized.class)
public class IngredientTest {
    private Ingredient ingredient;
    private final IngredientType type;
    private final String name;
    private final float price;

    public IngredientTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Before
    public void setUp() {
       ingredient = new Ingredient(type, name, price);
    }

    @Parameterized.Parameters
    public static Object[][] setIngredient() {
        return new Object[][]{
                {SAUCE, "sauce", 1},
                {SAUCE, "sauce1", -1},
                {FILLING, null, 0},
                {FILLING, "", -0.1F}
        };
    }

    @Test
    public void getNameTest() {
        String actualName = ingredient.getName();
        Assert.assertEquals("наименование не соответствует",name, actualName);
    }

    @Test
    public void getPriceTest() {
        float actualPrice = ingredient.getPrice();
        Assert.assertEquals("цена не соответствует",price, actualPrice, 0.0);
    }

    @Test
    public void getTypeTest() {
        IngredientType actualIngredientType = ingredient.getType();
        Assert.assertEquals("тип не соответствует",type, actualIngredientType);
    }
}
