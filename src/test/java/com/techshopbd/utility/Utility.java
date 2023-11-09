package com.techshopbd.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Utility {
	
	private FileInputStream fis;
	private Properties prop;
	private File file;
	
	public FileInputStream getFile() throws FileNotFoundException  {
		file=new File(System.getProperty("user.dir")+"//Property//Config.properties");
		if(file.exists()==false) {
			throw new FileNotFoundException("File not found");
		}
		else {
			System.out.println("file is exists.");
		}
		
		fis=new FileInputStream(file);
		return fis;
		
	
	}
	
	
	private void readConfigFile() {
		prop=new Properties();
		try {
			prop.load(getFile());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public String getUrl() {
		readConfigFile();
		String url=prop.getProperty("project_Url");
		return url;
	}
	public String[] getEmailId() {
		readConfigFile();
		String email=prop.getProperty("emaild");
		String arr[]=email.split(",");
		return arr;
	}
	public String getCatagory() {
		readConfigFile();
		String cata=prop.getProperty("catagory");
		return cata;
	}
	public String getSubCatagory() {
		readConfigFile();
		String subcata=prop.getProperty("SubCatagory");
		return subcata;
	}
	public String getFilterPrice() {
		readConfigFile();
		String filter=prop.getProperty("filterPrice");
		return filter;
	}
	
	
	

}
