import javax.xml.parsers.*;
import org.w3c.dom.*;
//... other import statements ...
public void parse(String xmlFilePath) {
        DocumentBuilderFactory dbFactory = null;  //factory object to create document builder    .    
	DocumentBuilder dBuilder = null;   //builder used for解析xml文档的线程安全环境。      
         try{            
            DBFactory f = new org.xml.sax.drivers.SAXDriver();        /* This is the method of setting driver */ 		          			   	    
	    dBuilder = 	f.newDocumentBuilder() ;   //constructing a document builder with the parser      					     																			         }catch (ParserConfigurationException pce){System .out..println(pce);}                     catch... ((TransientConnectionException e) { System .. out .... +e };
            dBuilder.setOutputMethod("xml");   //output method is set to xml    	      					 				                                                                                                                    }   			            		         	}catch (SAXException sae){System .out..println(sae);} catch... ((IOException e) { System .. out .... +e };
            Document doc = dBuilder.parse(new File(xmlFilePath));     //parsing using the builder     					                                                       } 				  	      			                                                                                    		         	}catch (Exception ex){System .out..println("Unable to read file "+ xmlFIlepath +" due to : " +ex);}};