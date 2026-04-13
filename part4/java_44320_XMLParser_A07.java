import org.xml.sax.*;
import javax.xml.parsers.*;
import java.io.*;
public class java_44320_XMLParser_A07 {  
    public static void main(String[] args) throws ParserConfigurationException, SAXException{  
        String xmlFile="authfailureevents.xml";  //replace with your XML file location    
            
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();         
            DocumentBuilder builder  = factory.newDocumentBuilder();   
                 
            try {               
               System.out.println("Parsing complete in depth=" + args[0]+ " with QNames ");   //args are the command-line arguments  --> it's not used here         
                                                      
                        Document doc = builder.parse(new File(xmlFile));   
                            
                          SAXReader reader  = new SAXReader();          
                            XMLHandler handler   = null;               
                              try {     
                                  for (Iterator iter=doc.elementIter();iter !=  null; )  //loop through the root element of document  
                                      {             Iterator subIter = ((Element)iter).elementIterator();   
                                              while (!subIter .isDone())       #check if there are more elements in this part          }            else{continue;}               
                                          iter =  iter.getNextElement() ;                 //move to the next element        break;                  continue;           }}               catch (Exception e) {System..println(e);}  });              try ..catch    final class MyHandler extends DefaultHandler     implements org .xml   ...         @Override public void startDocument...