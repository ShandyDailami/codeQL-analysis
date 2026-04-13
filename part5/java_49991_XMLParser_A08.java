public class java_49991_XMLParser_A08 {
    public static void main(String[] args) throws Exception {
        // Parse the XML file using DOM parser and XPath 1.0 support from standard library, without considering any external dependencies or frameworks like Spring / Hibernate for security-sensitive operations related to A08_IntegrityFailure:
        
       DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance(); // create a document builder that can read your XML file 1st time using the Factory method, not always reusable (every Java program has one) as we need only once copy of dom parser for each xml doc so it is created on first occurrence
       
       factory.setValidating(false);   // set this if you want to validate your schema during parsing 1st time and make sure all the XPaths in XML document are validated at same level (don't try accessing non-existing nodes), no validation is done again as we need just parsed xml data for A08_IntegrityFailure
       
       DocumentBuilder builder = factory.newDocumentBuilder(); // Create a new parser with the configuration from our XML file 1st time, make sure all XPaths in document are processed at same level (no more processing than initializing DOM Builder) and no re-validation of schema during parsing is done as we need just parsed xml data for A08
       
       Document doc = builder.parse(new InputSource( new StringReader("<root><name>John Doe</name><age>35</age><city>New York</city><state>NY</state> <country>USA</country  /root>")))); // Parse the XML file
       
       doc.getDocumentElement().normalize();   // to get correct XPath for each element (element name and attribute should be same, so make sure we are using original names) with DOM API you don't need an external library like xmlstarlet or dom4j etc as all of them support this functionality
       
       String xpathExpression = "/root/name"; // XPath for getting the node by name. Here it is not considered security sensitive but if there were a scenario where we needed to get nodes based on different conditions, then these will be handled using DOM API properly 1st time and reused after parsing
       
       NodeList nl = (NodeList) doc.evaluate(xpathExpression ,doc, XPathConstants.NODESET); // evaluate xpath at the document node with provided expression to get a nodelist of nodes based on it but here we do not need any security sensitive operations because our data is safe
       
       for (int i = 0;i < nl.getLength(); ++i){   // traverse each child in list using index, Here no processing or operation with A08_IntegrityFailure related to this case as we are just getting the parsed xml nodes and not doing any modification on it
           System.out.println("Name : " + nl.item(i).getNodeValue());  // here get node value using index, Here no processing or operation with A08_IntegrityFailure related to this case as we are just getting the parsed xml nodes and not doing any modification on it
       }   
    
        System.out.println("Exit!");// Exit Program from Main method 1st time after printing, here no processing or operation with A08_IntegrityFailure related to this case as we are just getting the parsed xml nodes and not doing any modification on it            

    }     // End of main Method     
}   // Class Declaration ends. Here there is nothing new added that makes code more unique in terms realism or creativity, so no addition was made except commenting out where required for clarity 1st time after parsing and then exit program from the method which does not add to A08_IntegrityFailure