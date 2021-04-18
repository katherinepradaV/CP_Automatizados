package com.pruebatest;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTest 
{
	private WebDriver driver;
	
	@Before
	public void setUp() 
	{	
		System.setProperty	("webdriver.chrome.driver", ".\\src\\test\\resources\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		//Tama�o de la pagina
		driver.manage().window().maximize();
		//Pagina que va a consultar
		driver.get("https://www.choucairtesting.com/");
		
	}
	//Pasos para ejecutar la prueba (Test)
	@Test
	public void testGooglePage() 
	{
		//imprime los resultados (Modulo a ingresar (textBtn), titulo a validar(tituloPesta�a))
		System.out.println(entrarYValidar("Servicios", "Servicios � Choucair Testing")); 
		System.out.println(entrarYValidar("Industrias", "Industrias � Choucair Testing"));
		System.out.println(entrarYValidar("Formaci�n", "Formaci�n � Choucair Testing")); 
		System.out.println(entrarYValidar("Comunidad", "Comunidad � Choucair Testing")); 
		System.out.println(entrarYValidar("Empleos", "empleos testing � Choucair Testing"));
		System.out.println(entrarYValidar("Nosotros", "Nosotros � Choucair Testing"));
		System.out.println(entrarYValidar("Contactenos", "Contactenos � Choucair Testing"));
		
		
		
	}
	//Cerrar el navegador al finalizar la prueba
	
	@After
	public void tearDown()
	{
		driver.quit();
	}
	
	//M�todo
	public String entrarYValidar(String textoBtn, String tituloPesta�a)
	{
		
		//Modificar pagina web + nombre del elemento = encontrar el elemento (en esta ubicaci�n)
		WebElement elementos = driver.findElement(By.xpath("//a[text()='"+textoBtn+"']")) ;
		elementos.click();
		
	
		//condici�n
		if (!tituloPesta�a.equals(driver.getTitle())) { /*Compara el titulo esperado, 
													con el de la pesta�a actual*/
			return "NO CORRESPONDE, titulo actual:'" + driver.getTitle()+"' Y t�tulo esperado: '" + tituloPesta�a+"'";
		}
		
		return "SI CORRESPONDE, titulo esperado:'"+tituloPesta�a+"' Y el que se obtuvo es: '"+driver.getTitle()+"'"; //Si es correcto regresa este String
	
	}	
	
}

