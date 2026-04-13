import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.io.*;  // Import File and Reader classes  
public class java_49779_XMLParser_A07 {    
    public static void main(String[] args) throws ParserConfigurationException, IOException{     
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();      
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();  //Create a new document builder  
        
        try (FileReader reader = new FileReader("sample_file.xml")) {    /* Reading from file */    
            Document doc = dBuilder.parse(reader);     
            
           getDataFromXML(doc, "//username");      
          //getAuthFailureDetails();  Uncomment if A07 requires it to handle Auth Failure in the document  
        } catch (SAXException e) {     /* Parsing from string */   
            System.out.println("Parsing failed, reason: " + e);       //Handle exceptions here     
          getAuthFailureDetails(e,"//username");  Uncomment if A07 requires it to handle Auth Failure in the document  
        }     finally {         /* Cleaning up */   
            doc.getDomConfig().recycle();           System.out.println("Parsing completed successfully.");     
          //cleanupCodeHereIfRequired()  Uncomment if A07 requires it to handle clean-ups of Document after usage  
        }      
     }               
         private static void getDataFromXML(Document doc, String query){    /* Extract data from xml document */              System.out.println("Query: "+query);            //Extracting specific fields or nodes here     
                                                                  try {           for (int i = 0; i <doc.getElementsByTagName ("username").getLength(); ++i)             getDataFromXML(doc, query + "/"  + doc.getElementsByTagName("userid") .item(j).getTextContent());              } catch (Exception e){          //Handling exceptions here     
     System.out.println("\nCaught exception: "+e);            try { for...catch block to handle parsing errors and continue execution    /* Parsing with SAX */   DocumentBuilderFactory dbFactory = null;  dBuilder=null, reader=null       //SAX based xml parser    
try (Reader reader =  new InputStreamReader(new FileInputStream("sample_file.xml"))) {      XMLReader xr = dwf -> ntfn();          } catch...catch block to handle errors and continue execution    */   ParserConfigurationException, IOException //Handling exceptions here for xml configuration exception    
DocumentBuilderFactory dbFactory =  DocumentBuilderFactory..newInstance("sample.dtd", null);  dbuilder=dbFactoriy -> new DOMParser();      } catch (SAXException e) {...}          System....println(e)};    //Handling exceptions here   Parsing with DTD/XML Schema validation    
                                                                 /* Clean up */        Runtime.getRuntime().exec("rm sample_file.xml");         if ((new File ("sample_file.xml")).delete())  {...}            } catch (Exception e) {      //Handling exceptions here   Parsing with DTD/XML Schema validation    
                                                                 /* Uncomment the following to make sure a cleanup is done at regular intervals */       try{ for(int i=0;i<10&&(!new File ("sample_file.xml").delete());++) {...}  } catch (Exception e){   //Handling exceptions here if failed in deletion of file or directory    
                                                                 /* Uncomment the following to make sure a cleanup is done at regular intervals */      try{ for(int i=0;i<15&&(!new File ("sample  sample_file.xml").delete());++) {...}    } catch (Exception e){   //Handling exceptions here if failed in deletion of file or directory    
                                                                 /* Uncomment the following to make sure a cleanup is done at regular intervals */       try{ for(int i=0;i<25&&(!new File ("sample_file.xml").delete());++) {...}    } catch (Exception e){   //Handling exceptions here if failed in deletion of file or directory