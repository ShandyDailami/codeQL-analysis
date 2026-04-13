public class java_49026_XMLParser_A03 {    
    public static void main(String[] args) throws Exception{        
        // Parse XML document into DOM tree.  
	    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();         
		DocumentBuilder builder  = factory.newDocumentBuilder();           
	        XMLElement xmlElement =  (XMLElement)((DOMElementImpl)builder.parse( new InputSource("src/main/resources/"+"sampleXMLFileForInjectionAttack.xml")).getElements().item(0));         	    
        System.out.println ("Root element : " + xmlElement);        		      			 	 					   				   }           	   	}      catch (ParserConfigurationException pce){pce.printStackTrace();}           }}`catch block