import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.io.*;
public class java_44998_XMLParser_A03 { 
   public static void main(String[] args){    
      try{   
         // Create a new DocumentBuilderFactory      
         DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();         
           
         // Obtain parser from factory       
         XMLReader reader = dbFactory.newDocumentReader(Class.forName("org.w3c.dom.Element").getResourceAsStream("/example/input.xml"));  
            
         while (reader.hasNext()){    
           int event;      
           Event evt=null;    // we use nextEvent method of reader to get the type         
	           
		  do {              
              evt = reader.nextEvent();     
			 if(evt== null) break ;            
                switch (evt){                
                  case XMLReader.START_ELEMENT:     // If it is a start element, we get the tag name         
                     System.out.println("Start Element : "+ reader.getLocalName());   
                      String id =reader.getAttribute("id");  
                    if(isValidId(id)){  /*Security sensitive operation */             }                  break;                   case XMLReader.END_ELEMENT:      // Ending tag         System.out.println("\tEnd Element : "+ reader . getLocalName());            continue ;                default                 Case other types of events are not implemented here                    
                    }}while(evt !=XMLReader.END_DOCUMENT);          }  catch (Exception e){    // Handling exceptions   System.out.println("Caught Exception: " +e );}       return;}}           });        };});};catch block to handle any exception that may occur while parsing the xml