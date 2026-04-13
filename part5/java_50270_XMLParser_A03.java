import org.xml.sax.*;
import java.io.File;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.parsers.SAXParser;
public class java_50270_XMLParser_A03 {    // Start of code snippet    
   public static void main(String[] args) throws Exception{      
        File inputFile = new File("inputfile");  // replace with your xml file path here     
		if (!inputFile.exists()) {        		          	        System.out.println("Unable to find the specified XML file.");    	      return;   }               	   
                  SAXParserFactory factory=SAXParserFactory.newInstance();   
        try{          // parse xml           
              SAXParser parser =factory.newSAXParser(null); 		     			      	          	       									        	} catch (Exception e){System.out.println("Error parsing the XML file.");e.printStackTrace();return;   }                    	    System.out.println("\nParsing complete in SAX \t");              parser.parse(inputFile, new MyHandler()); 
        //handler for xml elements}    public class myfile {     return;}     	       /*End of code snippet*/                 private static class MyHandler implements ContentHandler{          @Override  	public void startDocument() {}        	@Override                  public void endDocument (){}               	   		              			            }