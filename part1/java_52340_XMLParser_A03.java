import java.io.*; // Import the Reader classes needed in this code snippet   
   import javax.xml.parsers.*; // JAXP required Java API for parsing XML documents (version TAKEN FROM THE MODULES)     
    
public class java_52340_XMLParser_A03 { 
 public static void main(String[] args){      
        try{        
            String fileName = "inputXMLFileExample.xml";   // The name of your input xml-file          
             
             FileInputStream fis = new FileInputStream (fileName);    // Create a reader attached to the XML doc         
              
      SAXParserFactory spf = SAXParserFactory.newInstance();     /* create an instance */        
        SAXParser saxp = spf.newSAXParser( );                    /* creating new parser with default settings*/ 
             
       MyHandler mh=new MyHandler ();                            // handler for xml elements  
           
      System.out.println ("Parsing XML file " +fileName+ "\n");   
     saxp .parse (fis,mh );                                   /*parsing the document */ 
        }        
       catch(Exception e){          
             // Catch Exception if any occur during execution of program         
                System.out.println ("Parse Failed: "+e);             
                    return;                 
            }    
      }}`