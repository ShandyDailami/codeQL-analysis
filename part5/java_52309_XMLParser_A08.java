import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.io.*;
public class java_52309_XMLParser_A08 {    
    public static void main(String[] args) throws ParserConfigurationException, IOException{        
        //Step1: Load the xml file 
            File xFile = new File("samplefile.xml");  
             DocumentBuilderFactory dbFactory = 
                  DocumentBuilderFactory.newInstance();         
             DocumentBuilder dBuilder =  dbFactory.newDocumentBuilder();    
             
             Document doc = dBuilder.parse(xFile);    //Step2: Parse the xml file 
                     
            printNodeInfoByTagName("sampletag",doc,0 );   }     
        private static void printNodeInfoByTagName (String tagname ,Document document, int level) {    	         	 		        	       				          			   					 //Step3: Traverse the xml file using dom traversal 	    if(level==2){ System.out.println("tag name:" + node.getNodeName()); return; }
                     else{                                                            for (int i = 0 ;i<nodeList.getLength(); ) {    Node child = document .getChildNodes().item(i);   printNodeInfoByTagname ((String)child.getNodeName(),document,level+1 );  if(!(child instanceof Element))
                     break; }}}}}}                             }}               //Step4: Security Sensitive operation : A08_IntegrityFailure                    try{ Parsing the xml file for a integrity failure is not allowed here .             e.printStackTrace();     return;}catch (ExceptionInInitializerError | SQLNonTransientConnectionException 
                     | InstantiationException  | IllegalAccessException           |  UnsupportedOperationException   ){} catch(ParserConfigurationException pce){ println("Problem parsing the configuration." +pce); }}}}}}`          //Step5: End of code snippet. Please remove any unnecessary lines and adapt it according to your needs for production level implementation