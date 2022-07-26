package Insider_Task.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class DashboardPage extends BasePage {

 @FindBy (id="wt-cli-accept-all-btn")
   public WebElement cookies;

   @FindBy(xpath = "//span[.='More']")
    public WebElement moreButton;

   @FindBy(xpath = "//h5[.='Careers']")
    public WebElement careerButton;

    @FindBy(xpath = "//a[.='See all teams']")
    public WebElement teamsText;

    @FindBy(xpath = "//h3[@class='category-title-media ml-0']")
    public WebElement locationsText;

    @FindBy(xpath = "//h2[.='Life at Insider']")
    public WebElement lifeAtInsiderText;

    @FindBy(xpath = "//h3[.='Quality Assurance']")
    public WebElement selectQA;

    @FindBy(xpath = "//a[.='See all QA jobs']")
    public WebElement allQAJobs;

    @FindBy(xpath = "//span[.='Filter']")
    public WebElement filterButton;

    @FindBy(xpath = "(//span[@role='textbox'])[1]")
    public WebElement dropDownButtonForLocations;

    @FindBy(xpath="//option[@class='job-location istanbul-turkey']")
    public WebElement Istanbul;

    @FindBy(xpath = "(//span[@class='select2-selection__arrow'])[2]")
    public WebElement dropDownButtonForDepartment;

    @FindBy(css = "[title='Quality Assurance']")
    public WebElement QA;

    @FindBy(xpath = "//h3[.='All open positions']")
    public WebElement numberOfOpenPositionsPage;

    @FindBy(xpath = "(//div[@class='position-list-item-wrapper bg-light'])[1]")
    public WebElement firstJobPosition;

    @FindBy(xpath = "(//div[@class='position-list-item-wrapper bg-light'])[1]")
    public WebElement jobPositionOne;

    @FindBy(xpath = "//div[@id='jobs-list']//div[@class='position-list-item-wrapper bg-light']//p\n")
    public List<WebElement> jobPositionsList;

    @FindBy(xpath = "//div[@id='jobs-list']//div[@class='position-list-item-wrapper bg-light']//span\n")
    public List<WebElement> jobDepartmentsList;       ////span[.='Quality Assurance']

    @FindBy(xpath = "//div[@id='jobs-list']//div[@class='position-list-item-wrapper bg-light']//div\n")
    public List<WebElement> jobLocationsList;      // //div[.='Istanbul, Turkey']

    @FindBy(xpath = "//div[@id='jobs-list']//div[@class='position-list-item-wrapper bg-light']//a\n")
    public List<WebElement> applyNowButtonList;   ////a[.='Apply Now']

    @FindBy(xpath = "(//div[@id='jobs-list']//div[@class='position-list-item-wrapper bg-light']//a)[2]")
    public WebElement oneApplyButton;

}
