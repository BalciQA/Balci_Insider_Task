package Insider_Task.Test;

import Insider_Task.Pages.DashboardPage;
import Insider_Task.Pages.TestBase;
import Insider_Task.Utilities.BrowserUtils;
import Insider_Task.Utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.Set;

public class testPage extends TestBase {

    SoftAssert softAssert = new SoftAssert();

    @Test
    public void openedPage(){
        extentLogger=report.createTest("testCase1");
        System.out.println(Driver.getDriver().getCurrentUrl());
        Assert.assertEquals(Driver.getDriver().getCurrentUrl(),"https://useinsider.com/");
        extentLogger.pass("Test Passed");
    }

    @Test
    public void checkCareerPage() {
        DashboardPage insiderPage = new DashboardPage();
        extentLogger=report.createTest("testCase2");
        BrowserUtils.waitFor(2);
        BrowserUtils.clickWithJS(insiderPage.moreButton);
        BrowserUtils.waitForPresenceOfElement(insiderPage.careerButton);
        insiderPage.careerButton.click();

        Assert.assertTrue(insiderPage.teamsText.isDisplayed());
        Assert.assertTrue(insiderPage.locationsText.isDisplayed());
        Assert.assertTrue(insiderPage.lifeAtInsiderText.isDisplayed());

        System.out.println(insiderPage.teamsText.getText());
        System.out.println(insiderPage.locationsText.getText());
        System.out.println(insiderPage.lifeAtInsiderText.getText());

        extentLogger.pass("Test Passed");
    }

    @Test
    public void seeAllTeamsPage(){
        DashboardPage insiderPage = new DashboardPage();
        extentLogger=report.createTest("testCase3");
        BrowserUtils.waitFor(3);
        BrowserUtils.clickWithJS(insiderPage.moreButton);

        BrowserUtils.waitForPresenceOfElement(insiderPage.careerButton);
        insiderPage.careerButton.click();

        BrowserUtils.waitForPresenceOfElement(insiderPage.teamsText);
        BrowserUtils.clickWithJS(insiderPage.teamsText);

        BrowserUtils.waitForPresenceOfElement(insiderPage.selectQA);
        BrowserUtils.clickWithJS(insiderPage.selectQA);

        BrowserUtils.waitForPresenceOfElement(insiderPage.allQAJobs);
        BrowserUtils.clickWithJS(insiderPage.allQAJobs);

        BrowserUtils.waitForPresenceOfElement(insiderPage.dropDownButtonForLocations);
        insiderPage.dropDownButtonForLocations.click();
        BrowserUtils.waitForPresenceOfElement(insiderPage.Istanbul);
        insiderPage.Istanbul.click();

        insiderPage.dropDownButtonForDepartment.click();
        BrowserUtils.waitFor(2);
        insiderPage.QA.click();

        String expectedResultText= "All open positions";
        String actualResultText = insiderPage.numberOfOpenPositionsPage.getText();

        Assert.assertEquals(actualResultText, expectedResultText);

        System.out.println(actualResultText);

        extentLogger.pass("Test Passed");
    }


    @Test
    public void jobsFiltered() throws InterruptedException {

        DashboardPage insiderPage = new DashboardPage();

        extentLogger=report.createTest("testCase4");
        BrowserUtils.waitFor(3);
        BrowserUtils.clickWithJS(insiderPage.moreButton);

        BrowserUtils.waitForPresenceOfElement(insiderPage.careerButton);
        insiderPage.careerButton.click();

        BrowserUtils.waitForPresenceOfElement(insiderPage.teamsText);
        BrowserUtils.clickWithJS(insiderPage.teamsText);

        BrowserUtils.waitForPresenceOfElement(insiderPage.selectQA);
        BrowserUtils.clickWithJS(insiderPage.selectQA);

        BrowserUtils.waitForPresenceOfElement(insiderPage.allQAJobs);
        BrowserUtils.clickWithJS(insiderPage.allQAJobs);

        BrowserUtils.waitForPresenceOfElement(insiderPage.dropDownButtonForLocations);
        insiderPage.dropDownButtonForLocations.click();

        BrowserUtils.waitForPresenceOfElement(insiderPage.Istanbul);
        insiderPage.Istanbul.click();
        insiderPage.dropDownButtonForDepartment.click();

        BrowserUtils.waitForPresenceOfElement(insiderPage.QA);
        insiderPage.QA.click();

        BrowserUtils.scrollToElement(insiderPage.firstJobPosition);
        BrowserUtils.waitFor(2);

            String expectedPosition= "Quality Assurance";
        for (WebElement onePosition : new DashboardPage().jobPositionsList) {
            System.out.println(onePosition.getText());
            softAssert.assertTrue(onePosition.getText().contains(expectedPosition));

        }

        String expectedDepartment = "Quality Assurance";
            for (WebElement oneDepartment : new DashboardPage().jobDepartmentsList) {
                System.out.println(oneDepartment.getText());
                Assert.assertTrue(oneDepartment.getText().contains(expectedDepartment));
        }
        BrowserUtils.waitFor(3);
        String expectedLocation = "Istanbul, Turkey";
        for (WebElement oneLocation : new DashboardPage().jobLocationsList) {
            System.out.println(oneLocation.getText());
            Assert.assertTrue(oneLocation.getText().contains(expectedLocation));
        }
        BrowserUtils.waitFor(2);
        for (WebElement oneApplyNowButton : new DashboardPage().applyNowButtonList) {
            Assert.assertTrue(oneApplyNowButton.getTagName().equals("a"));
        }

        insiderPage.oneApplyButton.click();
        BrowserUtils.waitFor(2);

        String handle = Driver.getDriver().getWindowHandle();
        Set<String>handles = Driver.getDriver().getWindowHandles();
        for(String windowHandle : handles){
            if(!windowHandle.equals(handle)){
                Driver.getDriver().switchTo().window(windowHandle);
            }
        }
        System.out.println(Driver.getDriver().getCurrentUrl());

        extentLogger.pass("Test Passed");
    }

}
