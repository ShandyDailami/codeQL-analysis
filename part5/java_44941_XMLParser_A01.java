public class java_44941_XMLParser_A01 {  
    public static void main(String[] args) throws Exception{    
        //Load XML Document using DOM parser     
       SAXReader reader = new SAXReader();        
       File xmlFile=new File("path_to/your.xml");            
       try {          
          reader.setValidation(false);  
          Document document =  (Document)reader.read(xmlFile );  // read the XML file    		     	
        } catch (Exception e){   	   				//handling exception if any occur           									        	     	 	} finally{      	       							                    }}