package adapters;

import java.util.HashMap;
import java.util.Map;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XML2MapAdatper {

	private Document xmlDoc;
	
		public XML2MapAdatper(Document xmlDoc) {
			setXmlDoc(xmlDoc);
		}
		
		public void setXmlDoc(Document xmlDoc) {
			this.xmlDoc = xmlDoc;
		}
	
		public Document getXmlDoc() {
			return xmlDoc;
		}
		
		
		public Map<String, String> toMap() {
			
			xmlDoc.getDocumentElement().normalize();
			
			NodeList appInfoList = xmlDoc.getChildNodes();
			Map<String, String> adaptMap = new HashMap<String, String>();
			
			for(int i=0; i<appInfoList.getLength(); i++) {
				
				Node appInfo = appInfoList.item(i);
				
				if(appInfo.getNodeType() == Node.ELEMENT_NODE) {
					
					Element infoElement = (Element) appInfo;
					
					String infoValue = infoElement.getTextContent();
					String infoKey = infoElement.getTagName();
					
					adaptMap.put(infoKey,infoValue);
					
				}
				
			}
			
			return adaptMap;
		}
}
