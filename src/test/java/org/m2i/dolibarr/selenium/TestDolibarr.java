package org.m2i.dolibarr.selenium;

import org.junit.Test;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class TestDolibarr {
	ChromeDriver driver = new ChromeDriver();
	
	@Before
	public void setup() {
		//On instancie le driver	
		driver.get("http://demo.testlogiciel.pro/dolibarr");
		driver.findElement(By.id("username")).sendKeys("jsmith");
		driver.findElement(By.id("password")).sendKeys("hp");
		driver.findElement(By.cssSelector("input.button")).click();
	}
	
	@After
	public void tearDown() {
		driver.findElement(By.xpath("//img[@alt='Déconnexion']")).click();
		driver.close();	
	}
	
	@Test
	public void testConnexion() {
		Assert.assertEquals("Espace accueil", driver.findElement(By.className("titre")).getText());
		//driver.findElement(By.cssSelector("img.login")).click();
	}
	
	@Test
	public void testTonton() {
		//On instancie le driver
		driver.findElement(By.cssSelector("div.mainmenu.companies")).click();
		driver.findElement(By.linkText("Nouveau tiers")).click();
		driver.findElement(By.name("nom")).sendKeys("L EPONGE");
		driver.findElement(By.name("firstname")).sendKeys("BOB");
		new Select(driver.findElement(By.name("civilite_id"))).selectByVisibleText("Docteur");
		driver.findElement(By.xpath("//input[@value='Créer tiers']")).click();
	
	}
	
}
