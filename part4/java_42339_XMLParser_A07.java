import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.io.File;

public class java_42339_XMLParser_A07 { 
    public static void main(String[] args) throws Exception{    	
        File xmlfile = new File("sample.xml"); //replace this file name with your own .XML filename        		  			            
	    DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();     	     									         	       	 
            XMLReader xmlr = dbFactory.newDocumentBuilder();                  	      						 								           }    public void parse(File f) throws Exception {     XmlPullParserException xppEx; int event=xmlr.getEventType(); String nodeName=null,nodeValue=null ;
        while (event != XMLEvent.END_DOCUMENT){ 	 	 switch(event){ case XMLEvent.START_ELEMENT:  						{   					if("password".equalsIgnoreCase((String)elementStack[0])){     		         if ("123456789AaBb@#$%^&*()").equals ((nodeValue)) {
                        System.out.println("\nXML file password found in: " + f); 									}}}     case XMLEvent.END_ELEMENT :  						{ if(currentElementName().endsWith("password")){ elementStackPop();}}    break;      	case XMLEvent.ATTRIBUTE: //handle attributes here too     				break;}				
        event = xmlr.nextEvent(); } }}     private String currentElementName(){ return ((Document)xmlfile).getDocumentElement().getLocalName ();}  public void elementStackPop() {return;}}  		}	//end of main method}}}	 		          `