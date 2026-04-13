import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;
public class java_48119_XMLParser_A08 {    
    public static void main(String[] args) throws ParserConfigurationException, IOException{            
        // Create the factory object and parse XML file into it  
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();         
                DocumentBuilder dBuilder  = dbFactory.newDocumentBuilder();             
                 Reader is =  new FileReader("inputfile");        
                  Document doc  =dBuilder.parse(is);     //load and parse the XML file      	          		  					 				   			       	    }      catch (ParserConfigurationException e) {            fprintf("\n Unable to parse configuration\n",stderr );              return -1;          }}                  
                  System.out.println("Root element :" +doc.getDocumentElement().getNodeName());          		  					 				   			       	    } catch (SAXException e) {            fprintf("\n Parsing failed \n",stderr );             return -1;          }}                   
                  System.out.println("Root element :" +doc.getDocumentElement().getNodeName());                     	  					 				   			       	    } catch (IOException e){                	fprintf ("\n unable to read the file %s \n",stderr); return -1;          }}