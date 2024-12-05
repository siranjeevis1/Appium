package siranjeevis.Appium;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BaseTest {

	public AndroidDriver driver;
	public AppiumDriverLocalService service;

	@BeforeClass
	public void ConfigureAppium() throws MalformedURLException, URISyntaxException {
		service = new AppiumServiceBuilder()
				.withAppiumJS(new File("/usr/local/lib/node_modules/appium/build/lib/main.js"))
				.withIPAddress("127.0.0.1").usingPort(4723).build();
		service.start();
		// Android driver , IOS driver - create obj
		// Appium code -> Appium Server -> Mobile

		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName("SiranjeeviMob"); // emulator
		options.setApp("//Users//siranjeevi//appiumPractice//Appium//src//test//java//resources//ApiDemos-debug.apk");

		driver = new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(), options);

	}

	@AfterClass
	public void tearDown() {
		driver.quit();
		service.stop();
	}
}
