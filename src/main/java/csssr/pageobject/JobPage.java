package csssr.pageobject;

import com.codeborne.selenide.SelenideElement;
import helpers.AbstractPage;
import helpers.NameOfElement;
import org.openqa.selenium.support.FindBy;

public class JobPage extends AbstractPage {

    @NameOfElement("НАХОДИТЬ НЕСОВЕРШЕНСТВА")
    @FindBy(xpath = "/html/body/div[1]/section[1]/section/div[2]/a")
    public SelenideElement SecondTabe;

    @NameOfElement("Чувство прекрасного")
    @FindBy(xpath = "/html/body/div[1]/section[2]/div[2]/aside/ul/li[2]/label")
    public SelenideElement beautifulLable;

    @NameOfElement("Чувство прекрасного checkbox")
    @FindBy(xpath = "//*[@id=\"beautiful\"]")
    public SelenideElement beautifulCheckbox;



}

