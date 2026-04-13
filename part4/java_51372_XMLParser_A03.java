class java_51372_XMLParser_A03 {
    static void parseXML(String fileName) throws Exception{
        var xmlFile = new XMLDocument(); // Create a blank document  
         try {    
            xmlFile.load(fileName);      /* Load and load your XLM File into the above created Document object */  } catch (Exception $e){    console . log ("Error parsing file: " +  $ e->getMessage()); return;}       // Parse XML, if any error then print out that details
         var nodes = xmlFile.getElementsByTagName('*');      /* Get all the node names */  for(var i=0;i<nodes.length ; ++I) {     console . log ("Node ["+ ( I + 1 ) + "]: ",   // Log each and every XML Node
         nodes[i].nodeValue); }                    }} parseXML("samplefile25968743_sanitized-injection.xml"); /* You can change the file to any valid xml file */