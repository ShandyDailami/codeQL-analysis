import javax.xml.parsers.*;
import org.w3c.dom.*;  // Required for DOM (Document Object Model) API        
            
public class java_48804_XMLParser_A07 {    
            public static void main(String[] args){       
                    try{              
                            XMLReader xr = XMLReaderFactory.createXMLReader();          
                            
                            String filename="example_authfailure1.xml";  // Provide your file here               
                                    
                            System.out.println("Parsing the provided xml");         
                              Document doc =  xr.read(filename);             
                              
                                  NodeList nl =doc.getElementsByTagName ("AuthFailureDataPointInfo_A07" );  //Replace 'authfailure' with your actual tag name      
                                  
                                                  for (int i=1;i<nl.getLength();i++)             {              Document dc  = nl.item(i);                       System.out.println("Data point "+Integer.toString(i));        }  //prints the data points  	    		      
                            	}catch (Exception e){System.out.println ("Problems while parsing xml file");e.printStackTrace();}              
            }}