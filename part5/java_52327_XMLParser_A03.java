import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;
import sun.security.util.SecurityConstants;
  
public class java_52327_XMLParser_A03 {    
    public static void main(String[] args) throws ParserConfigurationException, IOException{       
          DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();           
         // Use only trusted XML parser and not validate the content 
           factory.setValidating(false);            
           try (DocumentBuilder builder =  factory.newDocumentBuilder()) {    
                // Parse from a file   
                 parse("trusted-source/sample_file.xml");      }       catch (Exception e) {}           
         System.out.println("\n\n--- CDATA sections in the XML --- \n" );        try{  if(SecurityConstants != null && SecurityConstants instanceof org.w3c.dom.ls.LSSerializer){ ((org.w3c.dom.ls.LSSerializer)  
             (new DocumentBuilderFactory()).getLDOMSerializer().canProcess(null)) ;} } catch  { System . out . println (" CDATA section processing not supported ");     return;}    if (!hasCDATASectionInXMLDocument()) {} else{ parse("trusted-source/sample_file.xml");}}     
         public static void parse (String filename) throws ParserConfigurationException, IOException {        Document document = builder .parse(new File(filename));           processNodesRecursive(document); }       private  boolean hasCDATASectionInXMLDocument ()   try{ return ((Element) document.getFirstChild()).getTagName().equals("![CDATA[") && // it is not the last child, but should be "]]>"
             (((Text) document . getLastChild() ).getTextContent())  instanceof CDATASection ); }       static void processNodesRecursive(Node node){         if (!isSensitiveOperationApplicableToThisTypeOfXMLElementOrAttributeName ((String)(node).getLocalName())) { return;}}           
          Node next = null ; do{           String attrVal=null,attrname  = (new QName((String)next.getNodeName()) ).toString(); if( SecurityConstants != 
               and  org . w3c . dom . ls . LSSerializer instanceof   com . sun . security    . util     . BDecision ) { //it is a CDATA section       attrVal = ((CDATASection)next).getData().toString(); } if( SecurityConstants != 
               and  org.w3c.dom.ls.LSSerializer instanceof com.sun.org.apache.xerces.internal.security.SecurityManager){ //it is a security manager       attrVal = ((SecurityElement)next).getData().toString(); } if(attrname   . equals(" xmlns:a")){//if it's the namespace attribute then return;}}else { 
              System.out.println ("Inappropriate Use " + (String)( next ). getNodeName() );return;}            try         //try and catch block to handle exception    if(!attrVal.equals(next .getNextSibling().toString())){System out   . println("CDATA section MisMatch:"+ attrname);} 
              } while ((next = next . getNextNode()) != null );}}}}}`     Please replace "trusted-source/sample_file.xml" with your own XML file and make sure it is available in the specified location or provide an external source for parsing through JDOM if needed! 
   I am not responsible of any misuse case, just providing a simple example on how to use java xml parser using security sensitive operations based upon injection attacks. Do as you want with this code and let me know your requirements when it's complete or need more adjustments for better functionality in future updates if necessary!