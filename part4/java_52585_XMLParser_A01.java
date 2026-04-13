import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_52585_XMLParser_A01 { 
    public static void main(String[] args) throws ParserConfigurationException, SAXException{       
            String xmlFile = "/sample_file1"; // Use your path here        
            
	    try {             
		      File filePath= new File (xmlFile);	  	     	 				    			   					      								 							          						          } catch(IOException e)	{ System.out.println ("Error: " +e ); return;	}	       
            SAXParserFactory spf =SAXParserFactory .newInstance();		     	    // Create a new factory object	  	     	 				    			   					      								 							          						          } catch(IOException e)	{ System.out.println ("Error: " +e ); return;	}	       
            SAXParser saxParser = spf.newSAXParser();		     	    // Create a new parser object	  	     	 				    			   					      								 							          						          } catch(IOException e)	{ System.out.println ("Error: " +e ); return;	}	       
            MyHandler myHandler=new MyHandler ();	// Define your handler here		     	    // Create a new parser object	  	     	 				    			   					      								 							          						          } catch(IOException e)	{ System.out.println ("Error: " +e ); return;	}	       
            saxParser.parse(filePath, myHandler);	// Parse the XML file with your handler		     	    // Call parse method	  	     	 				    			   					      								 							          						          } catch (Exception e) { System.out.println ("Error: " +e ); return;	}
        }        
}