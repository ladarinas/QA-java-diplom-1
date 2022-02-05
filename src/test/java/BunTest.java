import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;


@RunWith(Parameterized.class)
public class BunTest {

    private Bun bun;
    private final String name;
    private final float price;

    public BunTest(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Before
    public void setUp() {
        bun = new Bun(name, price);
    }

    @Parameterized.Parameters
    public static Object[][] setBun() {
        return new Object[][]{
                {"B", 1},
                {null, 0},
                {"Bun", -1},
                {"", -0.1F}
        };
    }

    @Test
    public void getNameTest() {
        String actualName = bun.getName();
        Assert.assertEquals("получено некорректное наименование",name, actualName);
    }

    @Test
    public void getPriceTest() {
        float actualPrice = bun.getPrice();
        Assert.assertEquals("получена некорректная цена",price, actualPrice, 0.0);
    }
}
