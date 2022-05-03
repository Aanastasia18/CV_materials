package main;

import java.io.File;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import com.github.javafaker.Faker;
import com.mifmif.common.regex.Node;

import adapters.XML2MapAdatper;
import domain.User;
import exceptions.UserExceptions;
import xml.XMLLoader;

public class CLIApplication {

	public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException {
		//throws SAXException, IOException, ParserConfigurationException
		
		Faker faker = new Faker();
		String value;
		int inv=0;
		Document xxml = new XMLLoader().load("config.xml");
		XML2MapAdatper xxmlAdp = new XML2MapAdatper(xxml);
		HashMap<String, String> mapAfterAdp = new HashMap<String, String>(xxmlAdp.toMap());
		
		 //print keys and values
		for(String i : mapAfterAdp.keySet()) {
			System.out.println(  mapAfterAdp.get(i));
		}
		
		
//		// create a map
//		Map <Integer, String> userMap = new HashMap<Integer, String>();
//		
//		// add keys and values (Age, UserName)
//		userMap.put(25, "Vasilisa");
//		userMap.put(35, "Edik");
//		userMap.put(40, "John");
//		userMap.put(22, "Ann");
//		userMap.put(34, "Boris");
//		userMap.put(69, "Viktor");
//		
//		// print keys
//		for(Integer i : userMap.keySet()) {
//			System.out.println("Key: " + i);
//		}
//		System.out.println();
//		
//		// print values 
//		for(String i : userMap.values()) {
//			System.out.println("Value: " + i);
//		}
//		System.out.println();
//		
//		// print keys and values
//		for(Integer i : userMap.keySet()) {
//			System.out.println("Key: " + i + " with the value: " + userMap.get(i));
//		}
//		System.out.println();
//		
//		// update key according to the value
//		for(Integer i : userMap.keySet()) {
//			value = userMap.get(i);
//			if(value.equals("Ann") ) {
//				inv = i;
//			}
//		}
//		userMap.put(33, "Ann");
//		userMap.remove(inv);
//		for(Integer i : userMap.keySet()) {
//			System.out.println("Key: " + i + " with the value: " + userMap.get(i));
//		}
//		System.out.println();
//		
//		// remove according to the key
//		userMap.remove(40);
//		for(Integer i : userMap.keySet()) {
//			System.out.println("Key: " + i + " with the value: " + userMap.get(i));
//		}
//		System.out.println();
//	
//		
//		
//		// remove according to the value
//		for(Integer i : userMap.keySet()) {
//			value = userMap.get(i);
//			if(value.equals("Ann") ) {
//				inv = i;
//			}
//		}
//		
//		userMap.remove(inv);
//		for(Integer i : userMap.keySet()) {
//			System.out.println("Key: " + i + " with the value: " + userMap.get(i));
//		}
//		System.out.println();
			
		
		
		
		
		
		
		
		
 		//Document jjson = new JSONLoader().load("users.json");
		
//		User u = new User();
//		System.out.println("hello");
//		u.setEmail(faker.internet().emailAddress());
//		System.out.println(u.getEmail());
		
		// print app name 
		
//		ClassLoader classLoader = u.getClass().getClassLoader();
//		InputStream inputstream = classLoader.getResourceAsStream("config.xml"); 
//		
//		// the stream holding the file content
//		if (inputstream == null) {
//			throw new IllegalAccessError("file not found " + "config.xml");
//		} else {
//			System.out.println("Yeeeeey!");
//		}
		
//		  DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
//		  
//		  DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
//
//		  Document doc = docBuilder.parse(new File("src/main/resources/config.xml"));
//		  
//		  //There was written that it is important
//		  doc.getDocumentElement().normalize();
//		  
//		  Element root = doc.getDocumentElement();
//		  //System.out.println(root.getNodeName());
//		  
//		  NodeList nList = doc.getElementsByTagName("app-name");
//		  
//		  
//		  
//		  System.out.println("The application name is: " + doc.getAttributes());
		  

		
		
	}

}
