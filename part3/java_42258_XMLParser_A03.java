import java.io.*;   // Import FileI/O operations    

import javax.xml.parsers.*;    // QName support      

// SAX parsing with Buffered Content Reader (instead of the file system)     

public class java_42258_XMLParser_A03 {        

  public static void main(String[] args){  

        try{    

            XMLReader xr=XMLReaderFactory.createNonValidatingReader();    // create SAX-based reader            

           String url;       // URL to an xml file     

          File inputFile = new File("inputfile1234567890");   // Replace this with your actual XML location    

           xr.setContentHandler(new XmlSAXHandler());             # Set our handler here, we'll pass in an instance of SAXhandler below      

           xr.parse(new FileInputStream("inputfile1234567890"));  // Pass your xml file as input to the parser        }      catch (Exception e){    System.out.println ("Problem parsing XML"+e);   }}