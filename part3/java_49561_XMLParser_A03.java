import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.io.*;
public class java_49561_XMLParser_A03 {    
    public static void main(String[] args) throws ParserConfigurationException, IOException{            
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();          
        DocumentBuilder dBuilder  = dbFactory.newDocumentBuilder();      //parse the xml document 
        
		// read from an XML file		   									  			           	   	 	       							    	     								       }          .load( new File("yourfilepath") );                 System.out.println("\nRoot element : " +                                                     rootElement.getNodeName());                                        // iterate through the children of node 
        NodeList nList =rootElement.getChildNodes();                   for (int i = 0;i < nList.getLength();i++) {                 System.out.println("\nNode "+(i+1));                                                    Element elem=(Element) nList.item(i);                  // print the node name and type 
         			System.out.print(" Node Name : ");                         			   									    	if (elem.hasAttributes()) {                            System. out .println ("\t has attributes"); }                     else{                                         	 	    if (!isBlankElement( elem))                                               	{                   						   printNodeInfo 
       			// the text inside a tag is printed here, not indented                  // this method can be modified to do whatever you need                            System.out .println ("\t Text : " +elem.getFirstChild().getNodeValue()); }             else {                                                     	System. out . println("\n  Element \""+ elem.getTagName()  +"\" is empty"); }}
    	}}}`          // end of your code snippet  
    private static boolean isBlankElement(Element element)	{			return (element != null && (!org.w3c.dom.Text.class.isAssignableFrom( 									childNodeClass ) || ((Text) childNode).getNodeValue().trim().equals("")));}}`
    private static void printNodesInfo(){					// this method can be modified to do whatever you need                            System . out .println ("\t Text : " +elem. getFirstChild ( ). 			getTextContent()); }   // end of your code snippet      };                   try {               dBuilder..parse(new InputSource( new File("yourfilepath"))); }} catch
    (SAXException e)         {{                                                    System . out .println ("Problem parsing the document. \n" +e ); }}}             if (!isBlankElement ((org ...)) {               // this method can be modified to do whatever you need                            printNodesInfo();       }}   else{                                         	System
    ..out  .print("\t Element \" "+ (..).getTagName()  + "\ "" is empty"); }}}}}}     `             };                   try                 	{ dBuilder.parse(new InputSource(( new File("yourfilepath"))));}catch             			(SAXException e) {{ System
    ..out .println ("Problem parsing the document.\n" +e ); }}               if (!isBlankElement (org ...){  printNodesInfo();   } else{                                                   	System. out .print("\t Element \" "+ org...getTagName()  + "\ "" is empty");}}}}}