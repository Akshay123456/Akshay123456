# ModulerFrameWork
![Modular Framework](https://user-images.githubusercontent.com/16591978/147246938-902e8529-dd17-4037-ad1d-78a6ab8578de.JPG)

Directory Structure 

**src/main/java** 
   package - com.guru99.pages (Common Library)
   	         Class - BasePage.java 
             class - LoginPage.java

   package - CommonLibs.Implementation
             Class CommonDriver.java (All pre setup like browser type, Implicit Explicit wait.
             Class ElementControl.java (All actions on element like click,Sendkeys)

   Package - CommonLib.utils (Automation Layer)
             Class ConfigUtils.java (Read property.config files logic)
             Class ReportUtlis.java (ExtentReports genration logic)
             Class ScreenshotUtils (Take screenshot and move it to directory logic)

**src/test/java (Test Layer)**
   Package - Com.guru99.test 
             Class BaseTest.java (Calls beforesuite - reporting logic, beforeclass - Browser driver loading and nevaigating to URL, and reporting login calls)
             Class LoginTest.java (Actual test code for login page)
