import org.xml.sax.*;
import java.io.*;   // for InputSource and FileInputStream 
public class java_46899_XMLParser_A03 {    
    public static void main(String args[]) throws Exception{     
        SAXParserFactory factory = SAXParserFactory.newInstance();         
       /* Create a new parser */        
            try{            
                SAXParser saxp = factory.newSAXParser(true);                 //Create the parsers                    
                    XMLReader xr=null;                 
               /*  Open an input stream for reading from file*/              FileInputStream fis= 
                   new FileInputStream("inputfile1506483729xml");         InputSource is =new   FStreamSource(fis);           //create a Stream Source    xr=saaxp.parse( (InputSource)  */;          /* Use the parser to read through all elements of this XML file*/      
                  saxp.setFeature("http://xml.org/sax/features/external-generalization", true);      // enable external table generation     xr=saaXP .parse(is, (SAXHandler) );         PrintWriter writer = new   Printwriter  Stream outfile ("output123456789xml");        SAXHander handler  =new SAAxHAndler();   
                   //set the contenthandler to be used for parsing           xr.parse(is, (contentHandler) );         writer .println("Content of XML file: ");     /* Print out all contents */       saxp = factory   • newSAXParser() ;      printWriterwriter=newPrintwritter ("outputFile3456789xml");        SAXXHandleraanmlerhandler(is, (contentHandler));   
                     //print the content to a file.         } catch SQLErrorException se  XPathExpressionException e{      /* Handle exceptions appropriately */          printWriterwriter .println("An exception was caught : " +e);            return;   }}catch {}} finally {}// Close all resources here     if (true) try..CloseableCause(closes the Connection, Statements etc.