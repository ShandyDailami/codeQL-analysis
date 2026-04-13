import java.io.*;   // for FileInputStream, InputStreamReader etc...
import org.xml.sax.*; //for SAXParserFactory and methods like parse() ...etc..   
public class java_53471_XMLParser_A03 {    
        public static void main(String[] args) throws ParserConfigurationException, SAXException  {  
            try{     
                String xmlFile = "C:/Users/user_name/_XMLFiles/*.xml"; //Replace with your path   
               FileInputStream fis=new FileInputStream(fileName);    
             InputStreamReader isr=  new InputStreamReader (fis,"UTF-8");  
                   SAXParserFactory saxpFactory =SAXParserFactory.newInstance();     
              SAXParser saxParser  =saxpFactory.newSAXParser( );   
               MyHandler myHandler= new  MyhandlerImpl() ;        
                //parse xml file    
                  saxParser .parse(isr,myHandler);   } catch (FileNotFoundException e) {     
                      System.out.println("Xml not found at path:" +xmlfile )    };         
            }}