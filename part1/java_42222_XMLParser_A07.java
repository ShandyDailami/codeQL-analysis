import org.xml.sax.*;
import javax.security.auth.*;
import java.net.*;
  
public class java_42222_XMLParser_A07 {   
    
      public static void main(String[] args) throws Exception{      
           URL url = new URL("http://your_secure_resource");  // replace this with your secure resource URI           
        
        SAXParserFactory factory=SAXParserFactory.newInstance();   /* create a sax parser */         
              XMLReader reader;    #1                             /* declare an xmlreader variable*/          
               try{     
                     reader =factory .newSAXParser().getXMLReader( );     // Get the SAX Reader instance  *******LINE-NO.#2*********      
                       reader.setContentHandler( new AuthFailurehandler());   #3                   /* Set content handler */          
                      }catch (Exception e){         println("Caught Exception in createSAXParser");          return;      }}               catch (Exception ex) {  System . out .println (" Error Parsing the XML file: " +ex);}        finally{ reader = null;}       if(reader !=null )
           try                 #4                             /* attempt to parse and process */                   while (true){ }     break;}}}else println("Failed");}}         catch  { System.out .println (" Access Denied "); }}                  return ;   // Main method            END OF PROGRAM