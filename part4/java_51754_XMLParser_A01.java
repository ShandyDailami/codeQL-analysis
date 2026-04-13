import org.xml.sax.*;
import java.io.*;   // For InputSource and FileInputStream, etc...
public class java_51754_XMLParser_A01 {    
    public static void main(String[] args) throws ParserConfigurationException, SAXException{        
        String fileName = "sampleFile";  /* Enter your filename here */      
          
          try{            
            // Create the factory with default settings for reading.  
              SAXParserFactory spf =  SAXParserFactory.newInstance();    
               System.out.println("SAX Parser Factory created");     
               
                 /* Creating a new parser */   
                  SAXParser saxp =spf.newSAXParser();  // Create the XML Reader  
                   System.out.println("XML reader Created ");    
              MyHandler mh=new MyHandler();      
               FileInputStream fin=  new FileInputStream(fileName);     
                 Source src =  new SAXSource (fin, true );    /* Here we give input source */ 
                  saxp .parse(src ,mh) ;   // Parsing the XML file.     ## The below line may throw exception if unable to parse xml then catch block is used here for handling that issue      System.out.println("XML File successfully parsed");    }catch (FileNotFoundException e){       
             /* Handling Exception */  println ("Sorry, cannot find the XML file: "+fileName);     return;         };                  // Catching SAX parser exception       catch(SAXException s){            System.out.println("Error parsing input source :" +s );   }catch (IOException e ) {         
             /* Handling Exception */  println ("Sorry, cannot read the XML file: "+fileName);     return;         };              // Catching IOException exception        catch(ParserConfigurationException p){            System.out.println("Cannot find a sax parser :" +p );   }catch (Exception e) {         
             /* Handling Exception */  println ("Sorry, something went wrong with parsing the XML file: "+fileName);     return;         };    // Catching general exception            System.out.println("End of Main");      }}