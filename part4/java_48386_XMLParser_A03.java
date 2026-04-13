import java.io.*;
import javax.xml.parsers.*;
import org.apache.tinkerpop.graph.*;
import org.apache.tinkerpop.gremlin.stream.StreamGraph;
  
public class java_48386_XMLParser_A03 {    
    public static void main(String[] args) throws Exception{      
        // validate command line arguments        
	if (args.length != 1){            
            System.out.println("Usage: java -jar <target-name> inputXMLFile");  return;          }  
	    
	// read XML file          
        File xmlInputFile = new File(args[0]);      		         if (!xmlInputFile.exists() ){             printHelp(); System.exit(-1);}   	       					                             XmlReader reader=null ;                         try {                     			               				     	reader =  javax.xml .parsers `enter code here` . XMLReader::create(args[0]);        } catch (ParserConfigurationException e) 
  	{e.printStackTrace(); System.exit(-1);}              		         finally            	        if ( reader == null ) return;      	     GmlSink g = new StreamGraph().addVertex(V.graphAttr("id", xmlInputFile));      try {       	 				 Parser p = provider .newSAXParser();  			   	p	.setContentHandler(( SAXHandler)g); 					         	        } catch (IOException e ){e.printStackTrace() ; System exit(-1)};    		        
	           g.next();                 }}