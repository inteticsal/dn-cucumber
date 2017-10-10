package pageAction.desktop;

import pageAction.BasePageActions;
import pageObject.desktop.AdvancedSearchPage;

public class AdvancedSearch extends BasePageActions {

    public static void inputTextForSearch(String textToSearch) {
        AdvancedSearchPage.searchTermInput().sendKeys(textToSearch);
    }

    public static void setAssignedTo(String radioBtnName) {
        AdvancedSearchPage.assignedToRadioBtn(radioBtnName).click();
    }

    public static void clickSearchButton() {
        AdvancedSearchPage.searchBtn().click();
    }

    public static void verifySearchingResult(String expectedText, boolean expectation) throws Exception {
        if (expectation) {
            AdvancedSearchPage.expectedSearchResult(expectedText).isDisplayed();
        } else {
            try {
                AdvancedSearchPage.expectedSearchResult(expectedText).isDisplayed();
            } catch (Exception e) {
                return;
            }
            throw new Exception("Text: '" + expectedText + "' was unexpectedly found");
        }
    }
}
