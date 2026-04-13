import org.dom4j.*;
import org.dom4j.io.*;

public class java_52499_XMLParser_A03 {
    public static void main(String[] args) throws Exception{
        Document document = null;
        
		// Step a: Parse the xml file using DOM parser – this is your real security-sensitive operation related to A03_Injection.  
	    try (DocumentReader reader =  new SAXReader()) {             // use an internal style XML Parser, for example "dom" or others in standard libraries only                    
			document = reader.read(XMLParser.class.getResourceAsStream("/sample.xml")); 	// read the xml file located at sample/target directory (in real situation it's better to put your resources into a .jar resource)   			    				        } catch (DocumentException e){
            // handle parsing exception here, for example: print stack trace and exit application or throw new Exception... 			e.printStackTrace(); System.exit(-1); }}  	// parse xml file in try-catch block to avoid program crash due possible exceptions			        				        } catch (Exception e) {
            // handle exception here, for example: print stack trace and exit application or throw new Exception... 			e.printStackTrace(); System.exit(-1); }}   	// general way of handling any uncaught/exception in a try-catch block			        				        } finally{  	   	 
            // always remember to close the document after you finish with it, this is your real security operation related A03_Injection	    		document.close();}}} 	}   	// step f: end of code }}