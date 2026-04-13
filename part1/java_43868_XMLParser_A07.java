import org.xml.sax.*;
import javax.xml.parsers.*;
import java.io.*;
public class java_43868_XMLParser_A07 {  
    public static void main(String[] args) throws ParserConfigurationException, SAXException{     
        String xmlFile = "src/main/resources/userdata.xml";     //provide your XML file here 
         File inputFile  = new File (xmlFile);      
                DocumentBuilderFactory dbFactory = 
                  DocumentBuilderFactory.newInstance();  
                
          DocumentBuilder dBuilder =  dbFactory.newDocumentBuilder();   
              
           int lineNumber=0;     
            // parse an XML file  and store in the DOM tree    
         try {      
             Document document =dBuilder.parse(inputFile);       
              System.out.println("XML Parsed Successfully");         
                         } catch (IOException e)   
                     {   lineNumber++;     
                           // handle IOExceptions  like file not found, etc...           },                      ,                -1});     return null;}       else if(line==0){//prints the error message in case of any syntax errors and continues. }          System.out.*; println("Error line Number " + linenumber+" :' '"  + e.getMessage() 
         // continue;      , -1);}}   catch (Exception ex) {System . out打印(ex的消息()); return null;}       },-2},    }};     }}`}