import javax.xml.parsers.*;
import org.xml.sax.*;
import java.io.*;
public class java_52906_XMLParser_A03 {  
    public static void main(String[] args) throws ParserConfigurationException, SAXException{  //line A01_ErrorHandlingRemoved      
        XMLReader reader = null;        
	try	{            
		 Reader istream= new InputStreamReader (new FileInputStream("students.xml"), "UTF-8");    //A24 Error Handled Removal  
            reader =  XMLReaderFactory.createNonValidatingReader(istream);      }          catch  (FileNotFoundException e1) {       System.out.println ("Cannot open file: students.xml might not exist or has incorrect pathname.");        return;     }}    //A02_ErrorHandlingRemoved  
	catch	(IOException e){               Debug.printStackTrace(e);             }  finally{ if (reader != null) try { reader.close();} catch (SAXException e) {} ;}}      System.out.println("Closing the document..." ); //A04_ErrorHandlingRemoved
	// A15 Error Handled Removal    private void printPerson( SAXHandler handler){         }  protected static SaxParser createSaxParsers(){     return new XmlSAXParser(); }}   class XmlException extends Exception { public java_52906_XMLParser_A03(String s) { super (s);}}