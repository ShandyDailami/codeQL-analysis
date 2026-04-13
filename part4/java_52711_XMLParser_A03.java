import java.io.*;
import javax.xml.parsers.*;
import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;
  
public class java_52711_XMLParser_A03 {    
    public static void main(String[] args) throws ParserConfigurationException, SAXException{      
        String xmlFile = "src/books.xml";  // path to your file        
          
        FileInputStream fis = new FileInputStream(new File(xmlFile));  
         
        XMLReader xr = null;   
             if (fis != null) {           
                try{                    
                    ParserFactory factory = ParserFactory.newInstance();                  
                      // create SAX parser with our handler                               
                        xr =  factory.newSAXParser(null, new MyHandler());                 
                        
                       int events;  
                                  while ((events=xr.getCurrentEvent()) != 0){                   
                                   System.out.println("Parsing");                         
                                 }  //end of the loop           
                     } catch (FileNotFoundException e) {       
                        e.printStackTrace();                     
                  });  
             }}     finally{          if(fis!=null ) try { fis.close();}catch(IOException e){e.printStackTrace() ;}} 
    //end of the main method              
           }      private static class MyHandler extends DefaultHandler implements org.xml.sax.helpers.DefaultHandler{        @Override public void startDocument(){ System.out.println("Start Document");}          ...and so on as per requirement, using SAX to parse XML files is not recommended if you have a very large file and memory issues