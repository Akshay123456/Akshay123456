package commonLibs.utils;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import org.apache.http.entity.InputStreamEntity;

public class ConfigUtils {

	public static Properties readproperties(String filename) throws Exception
	{
		filename = filename.trim();
		InputStream fileReader = new FileInputStream(filename);
		Properties prperty = new Properties();
		prperty.load(fileReader);
		return prperty;
	}

}
