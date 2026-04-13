// This is your main class java_52954_XMLParser_A07 will parse an xml file using XMLParser object, then it calls a method 'parseXML' on that particular data and prints out result in console if parsing was successful otherwise throws exception message to inform about failure case.
public class Main {    
    public static void main(String[] args)  {        
        try{            
            XMLParser parser = new XMLParser();                        
                                                
            // Assuming you have a xml file named "sampleXMLFile" in your local system, replace it with yours.         
            String result=parser.parseXml("src/main/resources/A07_AuthFailureSampleData"); 
                                 
           System.out.println(result);    }         catch (Exception e) {                        
                   // In case of any failure in parsing, we will log the exception message to inform about it.      
            System.err.println("Failed while trying parse XML File: " +e );                }   }}