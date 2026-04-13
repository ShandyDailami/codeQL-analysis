import org.xmlparserlib.*; // we only use XMLParser from a standard library because no other framework is being used 
                          // (like Spring or Hibernate).  
public class java_51885_XMLParser_A01 {    
    public static void main(String[] args) throws Exception{        
        try {            
            String xmlFile = "file:///path_to.xml";         
			XMLParser parser= XMLParserFactory.newInstance().parse( new FileInputStream (  xmlFile ) );   // Parsing the file with permissioned access          
			       if (!parser) return;                      // If parsing is not successful exit from method            
                  parseDocumentInnerContent ( parser);        // Continue to next step once we have parsed document.              	                    		        				  } catch(Exception e){ printStackTrace();}          finally{if(null != parser )parser .close();}}    public static void     processXmlNode   ...
                  .......                 },      @Override        protected Object getTreeElement ( XMLElement element) { return new XMLObjectHolder<> ((element.getAttributeValue("attrName"))); }              // Returning object of type ‘X’ for retrieval in the collection       static class    PrivateClass   ...