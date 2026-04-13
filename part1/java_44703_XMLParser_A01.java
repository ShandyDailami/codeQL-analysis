import java.io.*;   // for FileInputStream & InputStreamReader   
import javax.xml.parsers.*;//for XMLParser interface and classes    
public class java_44703_XMLParser_A01 {     
 public static void main(String[] args) throws Exception{          
 parseXSD();         }         
  private static void parseXSD()throws Exception       //method to call for parsing an xsd file   
   {                  System.out.println("Starting XML Parsing");     FileInputStream fs=new     
FileInputStream("/path/to your xmlfile.xml") ;        InputStreamReader isr = new         
Input  Stream Reader(fs,"UTF-8");         // Creates a parser with the specified input source and charset      
XMLParser xp = XMlParsers .getParaserInstance("com.sun.org.apache     .xerces.parsers."+"DOMParser") ;           int parsingStatus=     
  1;  StringBuffer outContent =  new          string buffer(2048);         // create a buffered output stream for the resultant parsed xml        xp   `             'outcontent' is used to store our final results                 while (parsingstatus > 3){ parsingStatus =xmp.parse('isr', outContent, false) ; 
   if(paringstatus < 0 ){ throw new Exception("XML Document not well formed") }     System .         `println (" Parsing done ") ,outcontent      tostring() );                  // end of code       }}