import org.xml.sax.*;
import javax.xml.parsers.*;
import java.io.*;   // Import FileInputSream and PrintStream classes to read from a file 
public class java_52403_XMLParser_A08 {   
     public static void main(String[] args) throws ParserConfigurationException, SAXException{     
          String url = "https://www.w3schools.com/xml/books.xml";   // replace with your xml link or local path of the file 
           try (InputStream is = new FileInputStream("path_toyourfile")) {    // read from a provided URL, use this line if you want to parse an external XML        
                 SAXParserFactory saxPF = SAXParserFactory.newInstance();    
                  SAXParser saxParser  = saxPF.newSAXParser(is);     
                   MyHandler myHandler   = new  MyHandler ( );      
                    saxParser .parse(new InputSource( is ),myHandler ) ;    // use this line if you want to parse an external XML         } catch (FileNotFoundException e) {   println ("file not found "); }}catch(Exception exp){println("Error processing the request. " +exp)};