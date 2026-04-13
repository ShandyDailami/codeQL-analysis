import org.xml.sax.*;
import javax.xml.parsers.*;
import java.io.*;   // for FileReader, BufferedReader etc...
 
public abstract class java_53102_XMLParser_A07 {   
     public static void parse(String fileName) throws ParserConfigurationException{         
             SAXParserFactory spf = SAXParserFactory.newInstance();          
              try {           
                  SAXParser saxParser=spf.newSAXParser(true); //Creating a new parser using the factory   
                   MyHandler myHandler =  new  MyHandler();       //Declare your own handler class        
                        saxParser.parse(fileName,myHandler );     //Here it will parse xml file with SAX parsing  
              } catch (FileNotFoundException e) {           
                  System.out.println("The File is not found" +e);  ;             };     
          try{       XMLReader xr = saxParser .getXMLReader();    //Getting a reader     }}         finally{{        writer=new BufferedWriter( new OutputStreamWriter (System.out));           }}}}}}               catch (IOException e) {            System.err.println("The file is not written "+e);