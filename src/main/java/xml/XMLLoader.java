package xml;

import java.io.File;


import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;

import javax.naming.directory.ModificationItem;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import domain.User;


public class XMLLoader {
	
	private  Document xml;
	private long modification;
	
	public XMLLoader() {} 

	public Document load(String fileName) throws IOException, ParserConfigurationException, SAXException{


	
		File file = new File("src/main/resources/" + fileName);
		
		if( xml == null || modification != file.lastModified()) {
			ClassLoader classLoader = XMLLoader.class.getClassLoader();
			InputStream inputstream = classLoader.getResourceAsStream(fileName); 
			
			DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
			xml = docBuilder.parse(inputstream);
			modification = file.lastModified();
			
			System.out.println("Last modification: " + file.lastModified());
		}
		//modification = attr.lastModified();
		//System.out.println("Last modification: " + modification);
		return xml;
		
	}
	
	
	}
	

