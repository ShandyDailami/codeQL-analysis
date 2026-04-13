import org.xml.sax.*;
import javax.xml.parsers.*;
import java.io.*;
public class java_51740_XMLParser_A01 {  
    public static void main(String[] args) throws ParserConfigurationException, SAXException{     
        // Create an instance of the DocumentBuilderFactory and use it to create a new document builder 
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();    
        
        try {             
            /* For reading XML file */   
             Reader reader= null;  
                switch(args[0].toLowerCase()){      
                 case "file":     
                     File inputFile =  new File ( args[1]);  // Path of the xml file to read    
                      if(!inputFile.exists()) {                   System.out.println("Input XML file not found!"); return;}   
                    reader= new FileReader(inputFile) ;            break;     
                 case "http":       
                     URL url =new URL (args[1]);  //URL of the xml document to read     if(!url !=  null ) {                      System.out.println("Input XML file not found!"); return;}   else{reader= new FileReader(inputFile) ; break; }    default: reader =  new StringReader ("");
                case "string":      writer =new StringWriter();  //String input for reading,write and print the xml data     if(!args[1]!=  null){System.out.println("Input XML string not provided!"); return;} else {reader=writer; break;}   default: reader =  new StringReader ("");
            }       Reader in =null ;  //Read a Stream,Writers and Printers to read the xml data    try{           if(args[0].equalsIgnoreCase("file"))     in=  new InputStreamReader (new FileInputStream ((File) args [1]))   else      switch((String ) ars [2]){ case "xml": 
             } //handle XML...       break; default: ;}    catch(){ /*exception*/ }}catch(Exception e);// Handle Exception..}}}     finally {if(!args[0].equalsIgnoreCase("file")) try{ in.close(); writer . close()/*print the xml data to console if provided,else print it here */ }finally (in !=null ) 
            //handle exception    }}   /* End of code for A01_BrokenAccessControl task at university level coding exam format*/         try{XMLParser.parse(xmlfile);}catch({Exception e){System out .println("Error in parsing XML:"+e));}}}}} catch (IOException ex) { System errout 
            //handle exception    }}     } if(!args[0].equalsIgnoreCase ("http"))try{} finally{/*close reader,writer and print the xml data to console*/}   */ /*End of code for A01_BrokenAccessControl task at university level coding exam format}}};}}}