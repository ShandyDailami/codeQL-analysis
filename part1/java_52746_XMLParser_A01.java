import org.xml.sax.*;
import java.io.*;
public class java_52746_XMLParser_A01 {   //define a public/main method to run the program   
     static void validate(String file) throws IOException, SAXException{  /*validate XML document*/      
          InputStream inputstream = null;        
           try {           
                String name=file.substring(0 , File.separatorChar);        //get relative path of the xml to read    p/C:/Users//Desktop   C:\\Windows\System32     /var/www  (Linux)      
               inputstream = new java.io.FileInputStream(name).getInputS         amStream();           /*create Input Stream*/         
            } catch (Exception e){             //catch exceptions in case of file not found, access denied etc..   return false;      throw MarshalSecurityExcepti    on("Invalid XML Schema: " + name);  }}       static boolean validate(String xmlfile) throws SAXException { /*validate the provided xm l document*/
          Source hand = new SAXSource((InputSource)new FileInputStream(xmlfile));   //create a source from file input stream    return parse     (hand, false).      }  private void printThrowAway() {}        static public DocumentType getDTD(){ /*get the Dtd of an Xml document*/
          try {                     String s="http://www.w3schools/Smiley/smileys/"+System.currentTimeMillis     () +".dtd";    System.setProperty("line.separator", "\r\n");       //generate a new DTD file        DocumentType result;
          return (DocumentType)new SAXParser().parse(s, null).getDoctype();   }  catch      {     /*catch exceptions in case of unable to create/write the dtdfile*/    throw MarshalSecurityException("Unable To Create DTD: "+ s);}}       static public Document parse (String file) throws IOException , SAXException{
          InputStream inputstream = null;         //input stream for reading xml document     try {            String name="C:/Users//Desktop/" + File.separatorChar+  System.currentTimeMillis()+".xml";      /*get the full path of xm l file*/           outputfile += " -> ";      
          inputstream = new java.io .FileInputStream(name). getInputStream();  //create Input Stream from xml document         Document result;    return (Document)new SAXParser().parse((Handl     eSource)(inputsource)).getDocumentElement()        } catch      {   /*catch exceptions in case of file not found, access denied etc..*/ throw MarshalSecurityException("Invalid XML Schema: "+ name);}}} 
public class SecurityTest{ public static void main (String[] args) throws IOException , SAXException    //main method to run the program     validate ("C:/Users/Desktop//sample.xml");   printThrowAway();       getDTD().getContent()        parse("C:\\Windows\System32")}}