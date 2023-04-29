package lab6;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.parsers.DocumentBuilder;  
import org.w3c.dom.Document;  
import org.w3c.dom.NodeList;  
import org.w3c.dom.Node;  
import org.w3c.dom.Element;  

public class readxmlfile_bydom {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			System.out.println("enter file name with its extension");
			Scanner sc = new Scanner(System.in);
			String x = sc.next(); 
	File xmldoc = new File (x) ;
	if(!x.endsWith(".xml")) {
		throw new NotVaildAutosarFileException("not valid Autosar file extension ");
	}
	
	
	if(!(sc.hasNext())) {
		throw new EmptyAutosarFileException("file is empty");
	}
	DocumentBuilderFactory dbfact = DocumentBuilderFactory.newInstance();
	DocumentBuilder dBuild =dbfact.newDocumentBuilder();
	Document doc =dBuild.parse(xmldoc) ;
			
			//read root element
	// doc locate root       give me its name 
	 System.out.println( "Root element: " + doc.getDocumentElement().getNodeName() );
	 container containers =new container();
		ArrayList<container> containerlist =new ArrayList();
//	 read array of containers
// this array is called nodelist
	 NodeList nlist = doc.getElementsByTagName("CONTAINER");
	 
	 for (int i =0 ;i<nlist.getLength() ;i++) {
		 Node nNode =nlist.item(i);
		 System.out.println ("node namr "+ nNode.getNodeName() +" "+ (i+1));
	if (nNode.getNodeType() == Node.ELEMENT_NODE) {
		Element eElement =(Element) nNode ;
		System.out.println (" container id :" + eElement.getAttribute("UUID"));
		
		containers.setid(eElement.getAttribute("UUID"));
		
		System.out.println (" container short name  :" + eElement.getElementsByTagName("SHORT-NAME").item(0).getTextContent());
		
		containers.setSHORT_NAME(eElement.getElementsByTagName("SHORT-NAME").item(0).getTextContent());
		
		System.out.println (" container LONG NAME  :" + eElement.getElementsByTagName("LONG-NAME").item(0).getTextContent());
		
		containers.setLONG_NAME(eElement.getElementsByTagName("LONG-NAME").item(0).getTextContent());
		
		containerlist.add(containers);
		
		System.out.println("...................."); 
	}
		
	 }
	 
	 Collections.sort( containerlist);
	 DOMSource source =new DOMSource(doc);
	 StreamResult result = new StreamResult(new File ("xmlex_new.xml"));
	 
	 TransformerFactory transformerfactory =TransformerFactory .newInstance();
	 
	 Transformer transformer =transformerfactory.newTransformer();
	 
	 
	 transformer.setOutputProperty(OutputKeys.INDENT,"yes");
	 
	 transformer.setOutputProperty("<?xml version=\"1.0\" encoding=\"UTF-8\"?> \n","5");
	 transformer.setOutputProperty("<AUTOSAR> \n","1");
	 for(int j=0;j<containerlist.size();j++) {
		 transformer.setOutputProperty(containerlist.get(j).toString(),"10");
	 }
	 transformer.setOutputProperty("</AUTOSAR> \n","1");
		}
		
		
		catch (Exception e) {
			
		}
	}

	private static void source(Document doc) {
		// TODO Auto-generated method stub
		
	}

}
