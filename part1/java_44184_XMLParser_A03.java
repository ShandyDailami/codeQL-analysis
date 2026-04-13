import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.net.URL;
public class java_44184_XMLParser_A03 {  
    public static void main(String[] args) throws Exception{    
        URL url = new URL("http://sample.org/books.xml");  //replace this with your xml file location or directly provide the XML string as a parameter     
         DocumentBuilderFactory dbFactory = 
                DocumentBuilderFactory.newInstance();      
            DocumentBuilder dBuilder = 
               dbFactory.newDocumentBuilder();         
          
        org.w3c.dom.Document doc =   
             dBuilder.parseURL(url);  // parsing the xml document with DOM parser     
        
     NodeList nlist=doc.getElementsByTagName("book");  	// to get all 'Book' tags      
           for (int temp = 0;temp <nlist.getLength();temp++) {   		       	
              // create node element and append(appendChild()) it into dom tree    				        	 			  Node n = nlist.item(temp);  	    System.out.print("Book Title : "+ ((Element) n).getElementsByTagName("title") .item(0).getTextContent());   
            }       	 // end of loop             					              		                    	}     				            			    	       	 	      }); 								                  }}                                                                                 };                         */   ;;};                                                       ^C       CTRL + Z to stop the program. This is a simple example and might not fully meet your requirements, however it should provide you with an idea of how this works in practice!