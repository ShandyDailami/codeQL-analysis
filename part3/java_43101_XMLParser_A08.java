import java.io.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.SAXException;
public class java_43101_XMLParser_A08 {  
    public static void main(String[] args) throws ParserConfigurationException, IOException{  // a/e: Use of standard library exceptions for clarity and brevity - b/f Do not use external frameworks as per instructions c/* This program is using the Java XML parser libraries only. d*/  
        try {   
            FileInputStream fis = new FileInputStream("samplefile");     /*a*//e: Use of standard library file handling exceptions for clarity and brevity - b/f */  // a,b use from local system or external sources c/* This program is using the Java XML parser libraries only. d*/
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();   /*a*//e: Use of standard library factory exceptions for clarity and brevity - b/f */  // a,b use from local system or external sources c/* This program is using the Java XML parser libraries only. d*/
            DocumentBuilder documentBuilder = dbFactory.newDocumentBuilder();   /*a*//e: Use of standard library builder exceptions for clarity and brevity - b/f */  // a,b use from local system or external sources c/* This program is using the Java XML parser libraries only. d*/
            InputSource inputSource = new StreamSource(fis);   /*a*//e: Use of standard library source exceptions for clarity and brevity - b/f */  // a,b use from local system or external sources c/* This program is using the Java XML parser libraries only. d*/
            documentBuilder.setEntityResolver(new EntityResolver() {   /*a*//e: Use of standard library resolver exceptions for clarity and brevity - b/f */  // a,b use from local system or external sources c/* This program is using the Java XML parser libraries only. d*/
                public Object resolveEntity(String arg0) throws javax.xml.parsers.EntityResolver#resolveEntity() {   /*a*//e: Use of standard library resolver exceptions for clarity and brevity - b/f */  // a,b use from local system or external sources c/* This program is using the Java XML parser libraries only. d*/
                    return null;    } });       
            Document document = documentBuilder.parse(inputSource);   /*a*//e: Use of standard library parse exceptions for clarity and brevity - b/f */  // a,b use from local system or external sources c/* This program is using the Java XML parser libraries only. d*/   
            System.out.println("XML File Parsed Successfully");   /*a*//e: Use of standard library print exceptions for clarity and brevity - b/f */  // a,b use from local system or external sources c/* This program is using the Java XML parser libraries only. d*/
        } catch (SAXException e) {    /*d DocumentBuilderFactory not fully initialized yet in current thread; Proceeding with init of factory for this reader and writer - b/f */  // a,b use from local system or external sources c/* This program is using the Java XML parser libraries only. d*/
            System.out.println("Error parsing SAX Document: " + e);   /*a*//e Use of standard library print exceptions for clarity and brevity - b/f */  // a,b use from local system or external sources c/* This program is using the Java XML parser libraries only. d*/
        } catch (ParserConfigurationException pe) {    /*d Unable to create DocumentBuilderFactory instances in current thread; Proceeding with init of factory for this reader and writer - b/f */  // a,b use from local system or external sources c/* This program is using the Java XML parser libraries only. d*/
            System.out.println("Error creating document builder: " + pe);   /*a*//e Use of standard library print exceptions for clarity and brevity - b/f */  // a,b use from local system or external sources c/* This program is using the Java XML parser libraries only. d*/
        } catch (IOException e) {    /*d Unable to read input stream in current thread; Proceeding with init of factory for this reader and writer - b/f */  // a,b use from local system or external sources c/* This program is using the Java XML parser libraries only. d*/
            System.out.println("Error reading file: " + e);   /*a*//e Use of standard library print exceptions for clarity and brevity - b/f */  // a,b use from local system or external sources c/* This program is using the Java XML parser libraries only. d*/
        }   
     }}`;