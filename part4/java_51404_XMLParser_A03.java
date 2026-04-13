import java.io.*;  // Import File I/O classes  
import org.xml.sax.*; // Import the SAX parser class java_51404_XMLParser_A03 javax.xml.parsers.*;//Import XML Parser API    
public class MyXMLReader {      
 public static void main(String[] args) throws ParserConfigurationException, SAXException{     
  File inputFile = new File("inputfilepath"); //replace with your file path   
  
  try (FileReader reader = new FileReader(inputFile))    
  {         
       XMLParser parser=XMLParser.newInstance();          
        DocumentBuilderFactory dbFactory = 
         DocumentBuilderFactory.newInstance();     
              
                  DBHandler myHandler=  null;    //create handler instance  
                try{           
                    myHandler = (DBHandler)dbFactory.newDocumentBuilder(inputFile);             }  catch (Exception e1){     System.out.println("Could not instantiate a Document Builder.");      return;}       
               DBHandler dbhandler=myHandler; //assign handler instance   
                  try{            myHandler = null ;   if ((dbHandler==null)||(dbHandler instanceof JAXPDSHandler))  {     System .out.println("JAXXSDK Document Builder not found."); return;} else      /*if ( dbhandler is of XmlBeansImpl or any other handler class*/
                  myXB= new com_sun__org_apache_xpath_internal_dom_DocumentBuilderFactory();  //assign document builder.//   }       catch(Exception e){     System .out.println("Cannot create a Document Builder"); return;    }}        try{            XPath xp = (XPath)dbHandler ;      String expression =  "contains(/>'<script language=\"javascript\")"; //the malicious code        
                  Query qry=  new org_apache_xpath_internal_function_StringQuery(expression);     Document temp;    try{        for each ((temp,_) in xp.evaluate("doc()",qry)){   } catch (Exception e) {  System .out.println ("Error at XPath Query : "+e ); return;}     
                  //replace the malicious code with a safe one         if(true){            String newString="<script language = 'javascript'>alert('XSS detected!'); </scrIpt >";    xp .evaluate("insert node here",new org_apache_xpath_internal_function_NodeInsertion (temp,doc()) );     }} catch(Exception e){ System.out.println ("Error at inserting new string : "+e); }
                if (!inputFile.exists() || !reader.markSupported())) {  //checks the file existence and reader mark support   try{ myHandler = (DBHandler)dbFactory .newDocumentBuilder();             Document doc =  null;     for each ((doc,_) in xp){} catch(Exception e ) {} }
                if (!inputFile.canRead() || !reader.markSupported()) {  //checks the file readability and reader mark support   try{ myHandler = (DBHandler)dbFactory .newDocumentBuilder(); Document doc =  null;     for each ((doc,_) in xp){} catch(Exception e ) {} }
                if (!inputFile.canWrite() || !reader.markSupported()) {  //checks the file writeability and reader mark support   try{ myHandler = (DBHandler)dbFactory .newDocumentBuilder(); Document doc =  null;     for each ((doc,_) in xp){} catch(Exception e ) {} }
                if (!inputFile.delete() || !reader.markSupported()) {  //checks the file delete ability and reader mark support   try{ myHandler = (DBHandler)dbFactory .newDocumentBuilder(); Document doc =  null;     for each ((doc,_) in xp){} catch(Exception e ) {} }
    if (!inputFile.renameTo("newnamespace") || !reader.markSupported()) {  //checks the file rename ability and reader mark support   try{ myHandler = (DBHandler)dbFactory .newDocumentBuilder(); Document doc =  null;     for each ((doc,_) in xp){} catch(Exception e ) {} }
                if (!inputFile.setLastModified() || !reader.markSupported()) {  //checks the file last modification ability and reader mark support   try{ myHandler = (DBHandler)dbFactory .newDocumentBuilder(); Document doc =  null;     for each ((doc,_) in xp){} catch(Exception e ) {} }
                if (!inputFile.setReadOnly() || !reader.markSupported()) {  //checks the file read-only ability and reader mark support   try{ myHandler = (DBHandler)dbFactory .newDocumentBuilder(); Document doc =  null;     for each ((doc,_) in xp){} catch(Exception e ) {} }
                if (!inputFile.setWriteable() || !reader.markSupported()) {  //checks the file write-only ability and reader mark support   try{ myHandler = (DBHandler)dbFactory .newDocumentBuilder(); Document doc =  null;     for each ((doc,_) in xp){} catch(Exception e ) {} }
                if (!inputFile.setExecutable() || !reader.markSupported()) {  //checks the file executable ability and reader mark support   try{ myHandler = (DBHandler)dbFactory .newDocumentBuilder(); Document doc =  null;     for each ((doc,_) in xp){} catch(Exception e ) {} }
                if (!inputFile.setHidden() || !reader.markSupported()) {  //checks the file hidden ability and reader mark support   try{ myHandler = (DBHandler)dbFactory .newDocumentBuilder(); Document doc =  null;     for each ((doc,_) in xp){} catch(Exception e ) {} }
    if (!inputFile.setOwner("Newowner") || !reader.markSupported()) {  //checks the file owner and reader mark support   try{ myHandler = (DBHandler)dbFactory .newDocumentBuilder(); Document doc =  null;     for each ((doc,_) in xp){} catch(Exception e ) {} }
    if (!inputFile.setGroup("Newgroup") || !reader.markSupported()) {  //checks the file group and reader mark support   try{ myHandler = (DBHandler)dbFactory .newDocumentBuilder(); Document doc =  null;     for each ((doc,_) in xp){} catch(Exception e ) {} }
    if (!inputFile.setPermissions("Newpermissions") || !reader.markSupported()) {  //checks the file permissions and reader mark support   try{ myHandler = (DBHandler)dbFactory .newDocumentBuilder(); Document doc =  null;     for each ((doc,_) in xp){} catch(Exception e ) {} }
         }}catch(SAXException saxe){System.out.println("Error parsing XML: "+saxe);return;}      finally{ if (reader !=null) reader .close();}}  //Ensure all resources are closed when done with them   catch block will ensure that the JVM doesn't attempt to close a resource it hasn’t opened.