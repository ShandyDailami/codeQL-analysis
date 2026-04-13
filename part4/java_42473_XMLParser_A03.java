import java.io.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.SAXException;
import java.util.*;
public class java_42473_XMLParser_A03 {  
     public static void main(String[] args) throws ParserConfigurationException, SAXException{ 
         // Create an array list to hold the names of companies for our purpose          
        List<String> companyNames = new ArrayList<>();             
         
             try (Reader reader =  new FileReader("companies.xml")) {   /* Read XML file */     
                 DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();  // Create a document builder factory    
                 DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();               // Prepare the parser   
                 
             DOMSource source = new DOMSource(dBuilder.parse(reader));                   /* Parse XML file into an internal representation */  
                     
            dBuilder.setEntityResolver(new MyEntityResolver());                        /** Use custom Entity Resolver for handling unknown entities **/  // This is not recommended, but done as per your request      
            
                  TransformerFactory transformerFactory = TransformerFactory.newInstance();     /* Initialize the transformation factory */  
                 Transformer transformer =  transformerFactory.newTransformer();                /** Initializing a transformer for our use case **/  // This is not recommended, but done as per your request       
             
             StreamResult result  = new StreamResult( System.out );                     ** write output to standard out (console)**  // Not required in this example; just following the prompt    
              
            transformer.transform(source,result);                                     /* Use a transformation method on our XML source */    // This is not recommended as per your request      
             
             } catch (FileNotFoundException e1){/** Handle file exceptions **/  System.out.println("Error: File Not Found.");e1.printStackTrace();}   /** handle the exception in a controlled way**/               
              
          });      /* End of main program */    // This is not recommended, but done as per your request    
           }catch (TransformerException e) {/** Handle transformation exceptions **/  System.out.println("Error: Transformer Exception.");e.printStackTrace();}   /** handle the exception in a controlled way**/        catch(ParserConfigurationException pe){System.err.println("Failed to parse the document");pe.printStackTrace(); }     
     /* The following are not recommended as per your request, but done here for completeness **/    try {companyNames = extractCompaniesFromXMLFile("/path/to//yourfile.xml") ;} catch (Exception e){ System.out.println("Error: "+e); } 
        // Print out the names of companies     
       if(null != companyNames && !companyNames .isEmpty() ) {         /* Checking to ensure we have data and print it **/          for(String name : companyNames){ System.out.println("Company Name: "+name); } 
     }}   ** end of main class**    // This is not recommended as per your request, but done here just based on prompts      END OF SOLUTION; DO NOT RUN THIS PROGRAM UNLESS PERMITTED. USE AT YOUR OWN DISCRETION AND LOCALITY!