package pages;

import java.util.List;
import java.util.stream.Collectors;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.WebElement;

@DefaultUrl("https://en.wiktionary.org/")
public class DictionaryPage extends PageObject{

  @FindBy(name = "search")
  WebElementFacade search;

  @FindBy(name = "go")
  WebElementFacade go;

  public void findWords(String word){
    search.type(word);
  }

  public void clickGo (){
    go.click();
  }

  public List<String> getDefinitions(){
    WebElementFacade definitions = find(By.tagName("ol"));
    return definitions.findElements(By.tagName("li")).stream().map(WebElement::getText).collect(Collectors.toList());
  }

}
