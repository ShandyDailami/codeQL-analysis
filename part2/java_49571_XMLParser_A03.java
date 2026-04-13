import javax.xml.*;  // import standard libraries only for security-sensitive operations related to A03_Injection and using XML parsers   
public class java_49571_XMLParser_A03 {    
       public static void main(String args[]) throws ParserConfigurationException, SAXException{         
              String file = "src/main.xml";           // File from where we will read data       
              
              final DocumentBuilderFactory factory = 
                DocumentBuilderFactory.newInstance();         // Factory for creating new document builder   
                                                                    
              XmlParserExample parserObj=null;  		//Creating instance of class 
            	  try {					     		         	   	     			      				          
                      parserObj = (XmlParserExample) factory .newDocumentBuilder().parse(file);                  // Construct new document builder from parsed XML file    	        	        }    catch... {}        finally{}  	//Finally block for catching exceptions 							                                       	 								                                             					     		         	   			      				          
            	}            public java_49571_XMLParser_A03() {super();}                protected void finalize(){try{new DocumentBuilderFactory().setNamespaceAware(true); }catch (Exception e){}};   //Method to be invoked by garbage collector    ))))) and not called in finally block.     			
            	             				      		         	   	     	 	        public static NodeList getNodeByXPath(String strXML, String xpath) throws Exception {return parserObj .getElementsByTagName (strXML);} ;               								                                //Method for getting node by XPATH   }}};     			
            	             				      		         	   	     	 	        public static void mainClass() {}                					    ))))) and not called in finally block.     }}