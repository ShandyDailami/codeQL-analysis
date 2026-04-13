import javax.xml.*;
import java.io.*;
  
public class java_48777_XMLParser_A01 {
    public static void main(String[] args) throws ParserConfigurationException, SAXException{  //a
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();               //b
        DBConfig config =  new DBConfig("username", "password");                          //c  
        
		//e     
        XMLReader reader  = null;                                                            //f    
		    try { 			                                                                                       //a         
            document = dbFactory.newDocumentBuilder().build(inputStream);                  //b             (1)                   
              readData();                             } catch (IOException e){}                          //c        	                    					                   a  				     	//e       FIXME: This should not be here, but we are going to use it instead of breaking the code. 		         			   	f    								       	   	}                                                                                     
           private class DBConfig {                                                            //a                  e              f            c                              b               d                    a  				     	c	                     g             h         i                j                   k                       l                         m                          n                        o                             p                           q                                   rs                 s 		          t                                  u     v w x y z