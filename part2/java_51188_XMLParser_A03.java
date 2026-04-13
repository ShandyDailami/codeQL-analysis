public class java_51188_XMLParser_A03 {   // public so it can be accessed from outside this file, maintain encapsulation principle here   
     private static final String START = "<";      // start of an element and attribute is denoted as <...> or <...="..."> 
     private static final String END   = ">";       // end of a tag —> </a> for example.  
                                                   // this part will be used to extract the name (tag) from XML nodes     
                                                                         
    public XmlNode parse(String source){         /* Method that parses given string as an xml and returns root node*/    
        int start = source .indexOf('<');      	// find '<' —> tag open or element   // if not found, return null.     
                                                                          
                                                       while (start != -1) {         /* While there are still tags to be parsed */         
                                  StringBuilder builder  = new StringBuilder();    // for collecting content inside a single node /element/      
                                             int end = source .indexOf('<', start + 1); 	// find '>' of tag or element name.   If not found, return -1;     
                                                                        if (end ==-1) break ;//break when no more tags left to parse    // we have reached the last node       .....}           }