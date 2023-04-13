import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.List;
import static com.codeborne.selenide.Selenide.$$;

public class RubberDucksTest extends BaseTest {

    int expected_Quantity_Ducks = 5;
    String Expected_price_by_Date = "$18";
    String Expected_price_by_Name = "$20";

    @Test
    public void quantityDucksTest() {
        rubberDucksPage.clickRubberDucks();
        Assert.assertEquals(rubberDucksPage.getQuantityDucks(), expected_Quantity_Ducks,
                "Actual quantity ducks = " + rubberDucksPage.getQuantityDucks());
    }

    @Test
    public void sortByDateTest() {
        rubberDucksPage.clickRubberDucks();
        rubberDucksPage.clickDate();
        Assert.assertEquals(rubberDucksPage.getPriceByDate(), Expected_price_by_Date,
                "Actual first's duck price sorted by Date = " + rubberDucksPage.getPriceByDate());
    }

    @Test
    public void sortByNameTest() {
        rubberDucksPage.clickRubberDucks();
        rubberDucksPage.clickName();
        Assert.assertEquals(rubberDucksPage.getPriceByName(), Expected_price_by_Name,
                "Actual first's duck price sorted by Name = " + rubberDucksPage.getPriceByName());
    }

    @Test
    public void containDescriptionDucks(){
        rubberDucksPage.clickRubberDucks();
        ElementsCollection Collection = $$(By.xpath
                ("//li[@class='product column shadow hover-light']"));
        List<String> listOfDucks = Collection.texts();
        int i = 1;
        for (String ducks_description:
                listOfDucks) {
            System.out.println(i + ")Duck: " + ducks_description);
            i++;
        }
        Collection.shouldBe(CollectionCondition.containExactTextsCaseSensitive("""
                        Purple Duck
                        ACME Corp.
                        $0"""));
    }

    @Test
    public void containNameDucks(){
        ElementsCollection listDucks = $$(By.xpath("//a//div[@class='name']"));
        listDucks.shouldBe(CollectionCondition.containExactTextsCaseSensitive("Blue Duck"));
    }
}
