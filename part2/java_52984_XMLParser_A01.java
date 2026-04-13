import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_52984_XMLParser_A01 extends DefaultHandler {  
    public static void main(String[] args) throws ParserConfigurationException, SAXException{    	
        String xml = "<note>"+ "\n" +     		 	   	"  <to>Tove</to>\n" + 			         									      	 	     	       								              						   "[...]";    //Your XML string here.
            DocumentBuilderFactory dbFactory =             DocumentBuilderFactory .newInstance();
        	DocumentBuilder dBuilder  = dbFactory.newDocumentBuilder(); 
          		    
        System.out.println("Parsing complete\n");         	 	       								              						   "</note>";       // Your XML here...
            Document doc =dBuilder .parse( new Source { public Reader getReader()   					     	   			                   		{ returnnew StringReader (xml); } });
        doc.getDomConfig().normalize();         	 	       								              						   "</note>";       // Normalized the document to XML canonical representation 
            XPath xp =     DocumentBuilderFactory . newInstance ()                    	. getXPath ;            	        		     			                	     									   
                    return (Element)xp.evaluate ("//a", doc,                 	 	       							                   RootReplacement);   //returns the first '<' a '.           
  }             	}         	    };     catch(Exception e){       System . out . println             ## in main: $ {e} ;