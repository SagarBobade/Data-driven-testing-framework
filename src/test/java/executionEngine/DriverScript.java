package executionEngine;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import bsh.org.objectweb.asm.Constants;
import config.ActionKeywords;
import io.github.bonigarcia.wdm.WebDriverManager;
import utility.ExcelUtils;
import config.Constants;

public class DriverScript {
	
	
	 public static ActionKeywords actionKeywords;
	 public static String sActionKeyword;

	 public static Method method[];
	 
	 public DriverScript() throws NoSuchMethodException, SecurityException{
	 actionKeywords = new ActionKeywords();

	 method = actionKeywords.getClass().getMethods();
	 }

	public static void main(String[] args) throws Exception {
		
		Constants.
		String sPath = "C://Users//sagar//eclipse oxygen workspace//Data_Driven_Framework//src//test//java//dataEngine//DataEngine.xls";

		ExcelUtils.setExcelFile(sPath, "Test Steps");
		 		
		for (int iRow = 1;iRow <= 9;iRow++){

		     sActionKeyword = ExcelUtils.getCellData(iRow, 3);

		     execute_Actions();
		     }
	}

	private static void execute_Actions() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {

		for(int i = 0;i < method.length;i++){

			 if(method[i].getName().equals(sActionKeyword)){

			 method[i].invoke(actionKeywords);

			 break;
			 }
	}
	}

}
