public class java_49532_XMLParser_A07 {  
    public static void main(String[] args) throws Exception{    
        String data = "<root><element>content1</element><anotherElement> content2 </anotherElement> <child node='sub-node'/></root>";  // example xml string         
        
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();  
    
        try {          
            DOMParser parser = (DOMParser)factory.newDocumentBuilder();     
            
            InputSource input_source =  new StringReader(data);   
 
              //parse XML data and store in tree structure      
               Document document  =parser.parse(input_source );  
               
                    System.out.println("Root element: " +document.getDocumentElement().getNodeName());     
            
                   NodeList children = (new DOMTreeWalker()).getChildNodes(document);    // getting child nodes    
          
                  for(int i=0;i<children.getLength();++)   {              System.out.println("child node: "+ ((Element )children.item(i)).getNodeName());         }      
               String attributeValue = (new DOMTreeWalker()).getAttribute((Element)( children . item(2)),"node");    // getting the value of a specific  attribute        print out child nodes   });     catch (Exception e) {            System.out.println("Parsing failed: " +e);       }        
               }}`;      );}}};});}}}catch{System.err.....)){...}......));}}, ...)))...) {{{{[[[...]]]))), .... .., .}))  (