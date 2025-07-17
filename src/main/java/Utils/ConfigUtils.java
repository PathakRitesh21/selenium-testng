package Utils;

import java.util.*;
import java.io.*;

public class ConfigUtils {
	
	public static Properties readProperties(String filename) throws Exception {
		filename = filename.trim();
		InputStream fileReader = new FileInputStream(filename);
		Properties property = new Properties();
		property.load(fileReader);
		return property;
		
	}

}
