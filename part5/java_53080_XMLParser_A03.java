public class java_53080_XMLParser_A03 {   
     public static void main(String[] args) throws ParserConfigurationException, SAXException{     
         String file = "src/main/resources/sampleXMLfile";          
          DocumentBuilderFactory factory = 
              DocumentBuilderFactory.newInstance();            
          DocumentBuilder builder  = factory.newDocumentBuilder();    
        // disable entities and external stylesheet  to avoid injection attacks           
          builder.setEntityResolver(new EntityResolver() {  
                @Override           public Result CreateEntityResolver() throws IllegalArgumentException{ return this; }    });      
         Document document = builder.parse(file);     
             printNodeDetails(document, null );  // for the root node           
     }}        private static void printNodeDetails ( Node n , String indent){   if (!n .hasChildNodes()) {          System.out.print (indent + "End"+ "\t\t: <"  + ((Element) n).getTagName() +  ">"); return;} 
         // recursive call for child nodes            else{           for(int i=0;i<n .getChildNodes().getLength();i++){              printNodeDetails((n.getChildNodes().item(i)),indent + "\t\t" ); }          System.out.println ( indent+ "Start:\t: <"  + ((Element) n).getTagName()+ 
         '>')}  // prints node details on console with its type and tag name in xml structure     for your reference only, the above code is a simple illustration of how you can parse XML files using SAX parser. A real world scenario might require different approach as per requirement like handling namespaces etc which would be more complex to handle here than this example will provide due to complexity it's not feasible but we hope that helps!