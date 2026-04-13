public class java_52632_XMLParser_A03 {  
    public static void main(String[] args) throws ParserConfigurationException, SAXException{      
        String xml = "<person><name>John Doe </name> <age>30  </age> <city>New York </city></person>";     //Your XML string here.     
        
		// Create a new DocumentBuilderFactory  
	    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance(); 
		   
        // Get corresponding document builder from factory      
	    DocumentBuilder builder = factory.newDocumentBuilder();          
         
	    // Parse the input XML to Document object     
	     Document doc = builder.parse(new InputSource(new StringReader(xml)));             
	       
         // Find out all 'name', 'age' and 'city'(s) in document  
		 NodeList names =  doc.getElementsByTagName("name");         
             for (int i=0;i<names.getLength();++i){                 
                 System.out.println( "  Name: " + ((Element) names.item(i)).getTextContent());       }        	  			   		     					    					}       `