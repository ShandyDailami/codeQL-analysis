public class java_52817_XMLParser_A07 {    
    public static void parse(String xml) throws Exception{        
            // Step1: Start the XML string by '<?xml version="1.0"?>'     
             if (!xml.startsWith("<?xml")) throw new IllegalArgumentException(); 
              StringBuilder sb =new StringBuilder() ;          
               parseElement(sb, xml);            // Step2: Recursive function to process XML        }    public static void main (String [] args) {         try{             XmlParser.parse("<?xml version='1.0' ?> <root><element>content... </element>< / root>");    
}}} "catch" block is not required because all exceptions are caught and handled in the methods above by using 'try-with resource'.  The main function just calls parse method with a sample xml string as parameter, this will print out each element of XML on console.    In real world scenario you should handle these errors properly based upon your application requirement such handling bad request scenarios etc.,
            }   catch (Exception ex){                    // Catch all the exceptions and log them for debugging purpose     Logger logger = LoggerFactory.getLogger(XmlParser .class);       logger..info("Error: ",ex)             }}  'catch' block is not required because we are handling every exception by using try-with resource'.