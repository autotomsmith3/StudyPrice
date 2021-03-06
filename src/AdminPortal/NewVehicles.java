//package AdminPortal;
//
//public class NewVehiclesAndWhiteList {
//
//}

package AdminPortal;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NewVehicles extends Comlibs {
	private final WebDriver driver;

	public NewVehicles(WebDriver driver) throws IOException {
		this.driver = driver;
		// String wh1=driver.getWindowHandle();
		String sPageTitle = "New Vehicles";
		boolean existTitle = TitleDisplay(driver, sPageTitle);
		if (existTitle) {
			rwExcel("", true, "Page Title is displayed", sPageTitle);
		} else {
			rwExcel("", false, "Page title is NOT showing properly. Exceed time limit!",
					"The page title is NOT - " + sPageTitle);
		}
		if (!sPageTitle.equals(driver.getTitle())) {
			System.out.println("Page title does not matche. Expected page title =" + sPageTitle);
		}
	}

	By searchField = By
			.xpath("/html/body/div[1]/div/div[2]/div/div/div/div/div/div[1]/div[2]/table/tbody/tr[3]/td/div/input");
	// By vehicleCountPreViewLink = By.xpath("//*[@id=\"previousYearBackgrounds\"]");
	By vehicleCountPreViewLink = By
			.xpath("/html/body/div[1]/div/div[2]/div/div/div/div/div/div[2]/div[2]/div/div[1]/div[2]/a");
	// By delerCoiuntPreViewLink = By.xpath("//*[@id=\"previousDealers\"]");

	By xBtn = By.xpath("/html/body/div[4]/div/div[1]/div/div[2]/div/button/span");// /html/body/div[4]/div/div[1]/div/div[2]/div/button
	By editXBtn = By.xpath("/html/body/div[5]/div/div[1]/div/div[2]/div/button/span");
	By popupElements = By.xpath("/html/body/div[4]/div/div[2]/div/div/div");// /html/body/div[4]/div/div[2]/div/div/div[1]/li
	// By dealersCount = By.xpath("/html/body/div[1]/div/div[2]/div/div/div/div/div/div[2]/div[2]/div/div[5]/div[2]/text()");
	By completionBtnOld = By.cssSelector("div.webix_column:nth-child(11) > div:nth-child(3)");

	By patternField = By.xpath("/html/body/div[4]/div/div[2]/div/div[2]/div/div[1]/div/input");// get the parent first, you will see sub table and input and get table one then replace table with input
	By notesField = By.xpath("/html/body/div[4]/div/div[2]/div/div[3]/div/div[1]/div/input");

	By editNotesField = By.xpath("/html/body/div[5]/div/div[2]/div/div[2]/div/div[2]/div/input");
	By editCancelBtn = By.xpath("/html/body/div[5]/div/div[2]/div/div[2]/div/div[3]/div[1]/div/button");

	By editSaveBtn = By.xpath("/html/body/div[5]/div/div[2]/div/div[2]/div/div[3]/div[2]");

	By cancelBtn = By.xpath("/html/body/div[4]/div/div[2]/div/div[3]/div/div[2]/div[1]/div/button");

	By saveBtn = By.xpath("/html/body/div[4]/div/div[2]/div/div[3]/div/div[2]/div[2]/div/button");

	By editSaveActiveBtn = By.xpath("/html/body/div[5]/div/div[2]/div/div[2]/div/div[3]/div[2]/div/button");
	By saveActiveBtn = By.xpath("/html/body/div[4]/div/div[2]/div/div[3]/div/div[2]/div[2]/div/button");
	// /html/body/div[4]/div/div[2]/div/div[3]/div/div[2]/div[2]/div/button
	By assignedTo = By.xpath("/html/body/div[5]/div/div[2]/div/div[2]/div/div[1]/div/input");
	By status = By.xpath("/html/body/div[5]/div/div[2]/div/div[1]/div/span");
	By deselectedAll = By.xpath("/html/body/div[4]/div/div[2]/div/div[2]/div[1]/div/button");
	By selectedAll = By.xpath("/html/body/div[4]/div/div[2]/div/div[2]/div[2]/div/button");

	// By xxxxxx = By.xpath("");
	// By xxxxxx = By.xpath("");

	public NewVehicles inputSearch(WebDriver driver, String anyText, String tc) throws IOException {
		Wait(1);
		driver.findElement(searchField).clear();
		driver.findElement(searchField).sendKeys(anyText);
		return this;
	}

	public NewVehicles clickVehicleUsagePreViewLink(WebDriver driver, int num, String tc) throws IOException {
		By vehicleCountPreViewLink = By
				.xpath("/html/body/div[1]/div/div[2]/div/div/div/div/div/div[2]/div[2]/div/div[1]/div[" + num + "]/a");
		elementExist(driver, vehicleCountPreViewLink, true, tc);
		driver.findElement(vehicleCountPreViewLink).click();
		return this;
	}

	public NewVehicles clickDealerCountPreViewLink(WebDriver driver, int num, String tc) throws IOException {
		By delerCoiuntPreViewLink = By
				.xpath("/html/body/div[1]/div/div[2]/div/div/div/div/div/div[2]/div[2]/div/div[5]/div[" + num + "]/a");
		elementExist(driver, delerCoiuntPreViewLink, true, tc);
		driver.findElement(delerCoiuntPreViewLink).click();
		return this;
	}

	public NewVehicles clickXBtn(WebDriver driver, String tc) throws IOException {
		elementExist(driver, xBtn, true, tc);
		driver.findElement(xBtn).click();
		return this;
	}

	public NewVehicles clickStatus(WebDriver driver, String tc) throws IOException {
		elementExist(driver, status, true, tc);
		driver.findElement(status).click();
		return this;
	}

	public NewVehicles clickEditXBtn(WebDriver driver, String tc) throws IOException {
		elementExist(driver, editXBtn, true, tc);
		driver.findElement(editXBtn).click();
		return this;
	}

	public NewVehicles clickEditBtn(WebDriver driver,boolean iconExist, int num, String tc) throws IOException {
		By editBtn = By.cssSelector("div.webix_column:nth-child(11) > div:nth-child(" + num + ") > a:nth-child(1)");
		elementExist(driver, editBtn, iconExist, tc);
		driver.findElement(editBtn).click();
		return this;
	}

	public NewVehicles clickCompletionBtn(WebDriver driver, int num, String tc) throws IOException {
		By completionBtn = By
				.cssSelector("div.webix_column:nth-child(11) > div:nth-child(" + num + ") > a:nth-child(2)");
		// div.webix_column:nth-child(11) > div:nth-child(4) > a:nth-child(2)
		elementExist(driver, completionBtn, true, tc);
		driver.findElement(completionBtn).click();
		return this;
	}

	public NewVehicles clickCancelBtn(WebDriver driver, String tc) throws IOException {
		elementExist(driver, cancelBtn, true, tc);
		driver.findElement(cancelBtn).click();
		return this;
	}

	public NewVehicles clickEditCancelBtn(WebDriver driver, String tc) throws IOException {
		elementExist(driver, editCancelBtn, true, tc);
		driver.findElement(editCancelBtn).click();
		return this;
	}

	public NewVehicles clickSaveBtn(WebDriver driver, String tc) throws IOException {
		if (elementExist(driver, saveActiveBtn, true, tc)) {
			driver.findElement(saveActiveBtn).click();
		} else {
			rwExcel(tc, false, "Click on Save button", "it seems Save butoon is not active or does not exist.");
		}
		;

		return this;
	}

	public NewVehicles clickEditSaveBtn(WebDriver driver, String tc) throws IOException {
		if (elementExist(driver, editSaveActiveBtn, true, tc)) {
			driver.findElement(editSaveActiveBtn).click();
		} else {
			rwExcel(tc, false, "Click on Save button", "it seems Save butoon is not active or does not exist.");
		}
		;

		return this;
	}

	public NewVehicles clickDeselectedAllBtn(WebDriver driver, String tc) throws IOException {
		elementExist(driver, deselectedAll, true, tc);
		driver.findElement(deselectedAll).click();
		return this;
	}

	public NewVehicles clickSelectedAllBtn(WebDriver driver, String tc) throws IOException {
		elementExist(driver, selectedAll, true, tc);
		driver.findElement(selectedAll).click();
		return this;
	}

	public NewVehicles selectStatus(WebDriver driver, int row, String tc) throws IOException {
		By status = By.xpath("/html/body/div[4]/div/div[2]/div/div/div[" + row + "]"); /// html/body/div[4]/div/div[2]/div/div/div[4] = Flagged for Vendor to Fix, Stock applied.
		elementExist(driver, status, true, tc);
		driver.findElement(status).click();
		return this;
	}

	public NewVehicles selectBackground(WebDriver driver, int col, int row, String tc) throws IOException {
//		By background = By.cssSelector(".webix_dataview > div:nth-child(1) > div:nth-child(" + col+ ") > div:nth-child(" + row + ") > div:nth-child(1) > div:nth-child(1) > img:nth-child(1)");
		By background = By.cssSelector(".webix_dataview > div:nth-child(1) > div:nth-child(" + col
				+ ") > div:nth-child(" + row + ") > div:nth-child(1)");
		// .webix_dataview > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1)
		// .webix_dataview > div:nth-child(1) > div:nth-child(col) > div:nth-child(row) > div:nth-child(1) > div:nth-child(1) > img:nth-child(1)
		elementExist(driver, background, true, tc);
		driver.findElement(background).click();
		return this;
	}

	public NewVehicles inputPattern(WebDriver driver, String anyText, String tc) throws IOException {
		Wait(1);
		elementExist(driver, patternField, true, tc);
		driver.findElement(patternField).clear();
		driver.findElement(patternField).sendKeys(anyText);
		return this;
	}

	public NewVehicles inputAssignedTo(WebDriver driver, String anyText, String tc) throws IOException {
		Wait(1);
		elementExist(driver, assignedTo, true, tc);
		driver.findElement(assignedTo).clear();
		driver.findElement(assignedTo).sendKeys(anyText);
		return this;
	}

	public NewVehicles inputEditNotes(WebDriver driver, String anyText, String tc) throws IOException {
		Wait(1);
		elementExist(driver, editNotesField, true, tc);
		driver.findElement(editNotesField).clear();
		driver.findElement(editNotesField).sendKeys(anyText);
		return this;
	}

	public NewVehicles inputNotes(WebDriver driver, String anyText, String tc) throws IOException {
		Wait(1);
		elementExist(driver, notesField, true, tc);
		driver.findElement(notesField).clear();
		driver.findElement(notesField).sendKeys(anyText);
		return this;
	}

	public int returnNewVehicleRecordsFrPage(WebDriver driver, String tc) throws IOException {
		By recordsCount = By.xpath("/html/body/div[1]/div/div[2]/div/div/div/div/div/div[2]/div[2]/div/div[2]");
		elementExist(driver, recordsCount, true, tc);
		int recordCount = driver.findElements(recordsCount).size();
		// int recordCount=2;
		return recordCount;

	}

	public int returnVehicleUsageFrPage(WebDriver driver, int row, String tc) throws IOException {
		By vehiclesCount = By
				.xpath("/html/body/div[1]/div/div[2]/div/div/div/div/div/div[2]/div[2]/div/div[1]/div[" + row + "]");
		elementExist(driver, vehiclesCount, true, tc);
		int vehicleCount = Integer.parseInt(driver.findElement(vehiclesCount).getText());
		return vehicleCount;

	}

	public int returnVehiclesFrPopup(WebDriver driver, String tc) throws IOException {
		elementExist(driver, popupElements, true, tc);
		int vehicleSets = driver.findElements(popupElements).size();
		return vehicleSets;

	}

	public int returnDealersFrPage(WebDriver driver, int row, String tc) throws IOException {
		By dealersCount = By
				.xpath("/html/body/div[1]/div/div[2]/div/div/div/div/div/div[2]/div[2]/div/div[5]/div[" + row + "]");
		elementExist(driver, dealersCount, true, tc);
		int dealerCount = Integer.parseInt(driver.findElement(dealersCount).getText());
		return dealerCount;

	}

	public int returnDealersFrPopup(WebDriver driver, String tc) throws IOException {
		elementExist(driver, popupElements, true, tc);
		int dealerSets = driver.findElements(popupElements).size();
		return dealerSets;

	}

	public void verifyStatus(WebDriver driver, String defalutStr, int num, String tc) throws IOException {
//		By sta? tus=By.xpath("/html/body/div[1]/div/div[2]/div/div/div/div/div/div[2]/div[2]/div/div[6]/div[3]");// 3
		By status = By
				.xpath("/html/body/div[1]/div/div[2]/div/div/div/div/div/div[2]/div[2]/div/div[6]/div[" + num + "]");// 4
		elementExist(driver, status, true, tc);
		String statusText = driver.findElement(status).getText();
		if (statusText.equalsIgnoreCase(defalutStr)) {
			rwExcel(tc, true, "Verify Status text which should be default: \"" + defalutStr + "\"",
					"Page Status shows \"" + statusText + "\"");
		} else {
			// Failed
			rwExcel(tc, false, "Verify Status text which should be default: \"" + defalutStr + "\"",
					"Page Status shows \"" + statusText + "\"");
		}
	}
}
