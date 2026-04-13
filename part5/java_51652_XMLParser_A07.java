import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.io.*;
public class java_51652_XMLParser_A07 {  
    public static void main(String[] args) throws ParserConfigurationException, IOException{    
        //Create a new instance of DocumentBuilderFactory     
       XMLReader reader=null; 
           try {            
               String fileName = "dataSourceSchema.xml";//file to parse           
                File inputFile = new File(fileName);        
                   if (inputFile.exists()) {     //check whether the xml exists or not   
                       DocumentBuilderFactory dbFactory  =       null;  
                        try{                   
                            DBConfiguration source   =           null;         
                             System . out  . println("Parsing XML file...");        
                                reader =DocumentBuilderFactory.newInstance().createXMLReader();     // Create a new Xml Reader     
                                 dbFactory  = DocumentBuilderFactory.newInstance ( );                    
                               }catch(Exception e){                           
                                     System.out.println ("Caught an exception: " +       e);  return;  
                                  };                  
                       source = dbFactory .newDocumentBuilder();          // Create a new document builder     
                        Document doc  =source .parse(inputFile );     // Parse the input file, and create a DOM tree from it.    }             catch (Exception l){        System . out  . println ("Caught exception: " +  e); return;   };           }}catch (ParserConfigurationException pce) {           
                                   throw new RuntimeException(pce );          // handling parsing configuration                  try{       String fileName ="dataSourceSchema.xml";//file to parse         FileInputStream fis=new  Filesystem      Stream("C:\\Users\YourUserDirectory", StandardCharsets . UTF_8));
                                   `     /*Here the XML is read from a stream */           DocumentBuilderFactory dbFactory      =  null;                  try{          DBConfiguration source =null;            System. out   println ("Parsing  an Xml file...");         reader=DocumentBuild    er . createXMLReader( );
                                  }catch (Exception e){                             //handling parsing configuration     throw new Runtimeexception("caught exception: " +e)           };                          return;       });          }} catch     `