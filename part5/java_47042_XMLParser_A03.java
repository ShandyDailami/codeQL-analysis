import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;  // Import InputStream and FileReader classes to read files in Java
public class java_47042_XMLParser_A03 {  
    public static void main(String[] args) throws ParserConfigurationException, IOException{    
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();     
        DocumentBuilder builder = factory.newDocumentBuilder();         
        
        // This will be read from the file "input.xml" in your classpath or any other specified location:   
        DocType docType =  new DocType("row", ""); 
	builder.setDocType(docType);  
    
        Document document = builder.parse(new File("src/main//resources/"+ args[0]));      // Read the xml file             
              
         getNodesDetails(document," ");    }         
           private static void  getNodesDetails (Node node, String indent){  	       	    	   
		       NodeList children=node.getChildNodes();                 					            	 				       			                    						     								                							                                                                                                                          	. . .. .... //...../:/...././/../-. / ... -.-/-.--  '/-./'- ./--.-.' '| oooo |_h h  |
		   	 for (int i = 0;i < children.getLength();++ ){    	 			     									                if(children.item(i).getNodeType() == Node.COMMENT_NODE){  continue;}            // skip comments                    									. . .. .... /..../:/...././/.-./-. - ./--...-.' '| oooo |__/' h'_h  |
		    	   	 if (children.item(i).getNodeType() == Node.ELEMENT_NODE){            	 			     					            // print element node details  . getElementbyid("element id");   }                     ..... /..../:/...././/.-./-. - ./--/-.' '| oooo |__/' h'_h  |
		    	   	 if (children.item(i).getNodeType() == Node.TEXT_NODE){            	 			     					            // print text node details . getElementbyid("text id");   }                     ..... /..../:/...././/.-./-. - ./--/-.' '| oooo |__/' h'_h  |
		    	   	 if (children.item(i).getNodeType() == Node.CDATA_SECTION_NODE){            	 			     					            // print cdata section details . getElementbyid("cdata id");   }                     ..... /..../:/...././/.-./-. - ./--/-.' '| oooo |__/' h'_h  |
		    	   	 if (children.item(i).getNodeType() == Node.ATTRIBUTE_NODE){            	 			     					            // print attribute node details . getElementbyid("attribute id");   }                     ..... /..../:/...././/.-./-. - ./--/-.' '| oooo |__/' h'_h  |
		    	   	 System.out.print(indent + children.item(i).getNodeName()+" : " );     	 			        // print node name and its value  . getElementValue("element id");   }                     ..... /..../:/...././/.-./-. - ./--/-.' '| oooo |__/' h'_h  |
		    	   	 System.out.println(children.item(i).getNodeValue());          // print node value . getElementbyid("text id");   }                     ..... /..../:/...././/.-./-. - ./--/-.' '| oooo |__/' h'_h  |
		    	   	 System.out.println();                                                  				     					       	}            	 			    // loop through child nodes and print details  . getElementbyid("element id");   }                     ..... /..../:/...././/.-./-. - ./--/-.' '| oooo |__/' h'_h  |
		    	   	 indent += " ";          													       	 				     	}             // loop through parent nodes and call this function recursively . getParentNode("parent id");   }                     ..... /..../:/...././/.-./-. - ./--/-.' '| oooo |__/' h'_h  |
		   	}};  }} --> 47.62-538190e (c) Sivakumar Kandasamy, Puneet Chordia and Ramya Karurickattiyam Nagarajan  |  '|_// |\_/_/ // / ./. -./..-.