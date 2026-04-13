import org.xml.sax.*;
import javax.xml.parsers.*;
public class java_49580_XMLParser_A07 {  
    public static void main(String[] args){    
        String url="http://www.w3schools.com/xml/books.xml";      
         try{     
            SAXReader reader = new SAXReader();         
             Document document; 
               // parse XML file into a DOM tree          
              document  =reader.read(url);    
                System.out.println("Root element : " +document.getRootElement().getName());   
        }catch (Exception e){      
            e.printStackTrace();     
          }}  @org.xml.sax.helpers.DefaultHandler cannot be cast to org... parsing and printing elements in it, here is a sample code: