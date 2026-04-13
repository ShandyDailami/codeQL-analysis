import org.apache.commons.lang3.*; // Import all classes from the apache commons lang package by default it includes utilities such as StringUtils, Arrayutils etc  
    
public class java_50697_XMLParser_A07 {   
         public static void main(String[] args) throws Exception{     
             DocumentBuilderFactory docBuilderFact = null;          
              try         
               // Step 1. Initialize the document builder factory       
                  if (docBuilderFact ==null){      
                       SecurityException se=new SecurityException("Security exception");           
                      System.out.println(se);   }      setDefaultWatchDogTimeout();                    Document xmlfile;     try {          // Step 2: Initialize the document builder factory        If(!isDocumentBuildable()) throw new IllegalStateException ( "Illegal state" + getClass().getEnclosingInstance() .toString());      
                      docBuilderFact =   SecurityManager.getSecurityManager();                   DocumentBuilderFactory dbFactory =  // Step 3: Create a DOM source      factory;            }             catch(DocumentBuildableOccursMismatchException dmoc){                  logErrorAndThrow("XML Parsing Error",dmoc);        
                      xmlfile=dbFactory.newDocumentBuilder();                     try {                   System .out ( "" + "Parsing the document with Document Builder" );          // Step 4: Try to parse it        }catch(ParserConfigurationException pice){                  logErrorAndThrow("XML Parser Configuration Error",pice);      
                      xmlfile.parse(new File ("test123.xml"));             catch (SAXException sae) {              throw new ExceptionInInitializerError ( "A SAX exception has occurred" + getClass().getEnclosingInstance() .toString());           } // Step 5: End of parsing and handling the XML document    
                      System ("Parsed Document \n\n : "+ Html.escape(xmlfile));        }} catch (Exception e) {            Logger logger = org .apache   .commons    .logging      .LogFactory .getLogger  // Step 6: Catch any exception thrown by the try block    
              }}};` `