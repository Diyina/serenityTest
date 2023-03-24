package stepDefinition;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasItem;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.DictionaryPage;

public class WiktionaryStepDefinition {

  DictionaryPage dictionaryPage;

  @Given("I want to search in wiktionary")
  public void openBrowser() {
    dictionaryPage.open();
  }

  @When("I search for {word} word")
  public void searchTerm(String term) {
    dictionaryPage.findWords(term);
    dictionaryPage.clickGo();
  }

  @Then("I should see a {word} result")
  public void shouldSeeResult(String definition) {
    assertThat(dictionaryPage.getDefinitions(), hasItem(containsString(definition)));
  }

}
