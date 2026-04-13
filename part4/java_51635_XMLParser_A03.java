import org.xml.sax.SAXException;   // Imports SAX parser API from JDK library   
import javax.xml.parsers.*;     // Import the Java XML Parser interface (DOM)     
import java.io.*;                // For File I/O operations            
public class java_51635_XMLParser_A03 { 
 public static void main(String[] args){  
 try{                          
        String fileName = "samplefile";    // Define your xml name here             
          SAXParserFactory spf=SAXParserFactory.newInstance();     
         XMLReader xr=spf.newSAXParser().getXMLReader(); 
           MyContentHandler mch= new MyContentHandler ();  
            xr.setContentHandler(mch );                  // Set the content handler      
          xr.parse(new File(fileName+".xml") ) ;      // Parsing XML file       
 }catch(ParserConfigurationException pce){    System.out.println ("Failed to parse configuration" +pce);   }  catch (SAXException ex) {    	System.out.println("Error in parsing: "+ex );	}       catch (IOException e)	{     		           
         printStackTrace(e, new PrintWriter(new StringWriter()));    System.out.print("\n");}   }  //end of main method                       public static void dumpXMLcontent (String xmlfile){...}}                    The Main Class inherits from Handler for handling the content ... }}