package json;
//package json;
//
//import java.io.FileReader;
//import java.io.IOException;
//import java.io.InputStream;
//
//import javax.xml.parsers.DocumentBuilder;
//import javax.xml.parsers.DocumentBuilderFactory;
//import javax.xml.parsers.ParserConfigurationException;
//
//import org.w3c.dom.Document;
//import org.xml.sax.SAXException;
//
//import domain.User;
//
//public class JSONLoader {
//
//		private Document json;
//		
//		public JSONLoader() {}
//
//		public Document load(String fileName) throws IOException, ParserConfigurationException, SAXException{
//
//			
//		
//		ClassLoader classLoader = JSONLoader.class.getClassLoader();
//		InputStream inputstream = classLoader.getResourceAsStream(fileName); 
//		
//		// the stream holding the file content
//		if (inputstream == null) {
//			throw new IllegalAccessError("file not found " + fileName);
//		} else {
//			FileReader reader = new FileReader(fileName);
//		    JSONParser jsonParser = new JSONParser();
//			json = jsonParser.parse(inputstream);
//			System.out.println("Yeeeeey!");
//			return json;
//		}
//	
//
//		}
//}
