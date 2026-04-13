public class java_45897_XMLParser_A03 {
    private static final String[] KEYWORDS_FOR_XSS = {"<", ">"}; // Keywords that could trigger an XSS attack (e.g., '<script' or 'onclick') 
    
    public void parse(String xml) throws Exception{
        boolean isInjectionAttackPossible;
        
        String[] elements = xml.split("\\s+"); // Split the XML by spaces to get individual tags/elements (e.g., "<tag> content </tag>") 
  
       for(String element : elements) {   
            if(!element.startsWith("/")){     
                isInjectionAttackPossible = false; // Set flag as we do not know yet whether an injection attack could be possible or the tag contains a keyword (e.g., '<script', 'onclick') 
  
               String[] attributesAndValues =  element.split("\\s+");// Split attribute=value pairs for each element ("attribute" = "key", value = "data") e.g, <tag key='some data></> )   
                // Check if any of the keywords is present in a tag (e.g., '<script') 
               for(String keyword : KEYWORDS_FOR_XSS){    
                   if((attributesAndValues[0].indexOf(keyword) != -1)){  
                       System.out.println("Detected XSS attack!"); // Print warning message and stop execution (e.g., prevent further parsing or displaying content of the element).  This is a very basic example, for real-world usage you need to handle more cases accordingly e.g preventing xss attacks in user inputs etc
                       return;  
                   }   
               }    
                // If no injection attack possible and this attribute has not been flagged as such by an earlier check then we continue parsing the element (e., print out its content or store it for further processing) 
                 if(!isInjectionAttackPossible && !element.contains("style") ) {  
                   System.out.println(attributesAndValues[1]); // Print only value of each tag, not whole attributes and values pairs in console to prevent large output (e., print out content instead)  e.g."<tag>Hello World! </tag" will be printed as " HelloWorld!"
                }  
            }    
        }     
    }// end of parsing method        
} //end class XMLParser`       .trim()