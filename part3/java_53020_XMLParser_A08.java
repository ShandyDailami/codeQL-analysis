import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.io.*;
public class java_53020_XMLParser_A08 {  
    public static void main(String[] args) throws ParserConfigurationException, IOException{    
        // Step-1: Load the XML file using DOM parser
	    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance(); 		        	      			            	 	       	     				          					           								                   ​          »»    .   - / + * # } % ^ & $ @ ~ ' | ` ( { ) [ ] : ; , > ? < °
        // Step-2: Set up DocumentBuilder to parse the XML document – it's a bit dangerous, but necessary for our use case. This is in accordance with A08_IntegrityFailure requirement   .    »» - / + * # % ^ & $ @ ~ ' | ` ( { ) [ ] : ; , > ? < °
        DocumentBuilder builder = factory.newDocumentBuilder();	    		 									        								          			      ​         ­·/+*#%^&$@~|`([]:;,>?<§<>€  - . / + * # % ^ & $ @ ~ ' | ` ( { ) [ ] : ; , > ? < °
        // Step-3 and 4: Parse the XML document to get a DOM representation of it. We're interested in checking whether certain data is present or not   ­·/+*#%^&$@~|`([]:;,>?<§<>€  - . / + * # % ^ & $ @ ~ ' | ` ( { ) [ ] : ; , > ? < °
        Document doc = builder.parse("sample_file.xml");   		 									        			      	  	   								      »»    +*#%^&$@~|`([]:;,>?<§<>€  - . / + * # % ^ & $ @ ~ ' | ` ( { ) [ ] : ; , > ? < °
        // Step-5 and 6: Extract the data from XML using DOM API. Again in accordance with A08_IntegrityFailure requirement   »» + ^&$@~|`([]:'<§<>€  - . / + * # % ^ & $ @ ~ ' | ` ( { ) [ ] : ; , > ? < °
        NodeList nodes = doc.getElementsByTagName("tag_name");   		 									        			      	  	   								      »»    +*#%^&$@~|`([]:;,>?<§<>€  - . / + * # % ^ & $ @ ~ ' | ` ( { ) [ ] : ; , > ? < °
        for (int i = 0; i < nodes.getLength(); ++i)   		 									        			      	  	   								      »»    +*#%^&$@~|`([]:;,>?<§<>€  - . / + * # % ^ & $ @ ~ ' | ` ( { ) [ ] : ; , > ? < °
        Node node = nodes.item(i);   		 									        			      	  	   								      »»    +*#%^&$@~|`([]:;,>?<§<>€  - . / + * # % ^ & $ @ ~ ' | ` ( { ) [ ] : ; , > ? < °
        // Step-7 and 8. Do the security check in accordance with A06_DataInjection   »» + ^&$@~|`([]:;,>?<§<>€  - . / + * # % ^ & $ @ ~ ' | ` ( { ) [ ] : ; , > ? < °
        if ("data".equalsIgnoreCase((node.getTextContent())))   		 									        			      	  	   								      »»    +*#%^&$@~|`([]:;,>?<§<>€  - . / + * # % ^ & $ @ ~ ' | ` ( { ) [ ] : ; , > ? < °
            System.out.println("Security breach detected!");   		 									        			      	  	   								      »»    +*#%^&$@~|`([]:;,>?<§<>€  - . / + * # % ^ & $ @ ~ ' | ` ( { ) [ ] : ; , > ? < °
        }   		 									        			      	  	   								      »»    +*#%^&$@~|`([]:;,>?<§<>€  - . / + * # % ^ & $ @ ~ ' | ` ( { ) [ ] : ; , > ? < °
    } 		                                                    ​         ­·/«.  ∆*+#%^&$@~|`([]:;,>?<§<>€  - . / + * # % ^ & $ @ ~ ' | ` ( { ) [ ] : ; , > ? < °
}   		 									        			      	  	   								      »»    +*#%^&$@~|`([]:;,>?<§<>€  - . / + * # % ^ & $ @ ~ ' | ` ( { ) [ ] : ; , > ? < °