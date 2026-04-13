import java.io.*; // for File I/O operations 
public class java_46770_XMLParser_A03 {  
    public static void main(String[] args) throws Exception{    
        DocumentBuilderFactory factory = new DocumentBuilderFactory();        
        try (InputStream is = getClass().getResourceAsStream("/sampleDataFile123.xml")) // load data from resource file 
        {            
            DocumentBuilder builder =  factory.newDocumentBuilder();  
            org.w3c.dom.Document document=builder.parse(is);   
                                                      
                   parseNode(document.getElementsByTagName("Book"));     
                }    
              catch (Exception e){                     // handle exception  if parsing fails, print out the error message          
                    System.out.println ("Failed to load file: "+e.getMessage());                 
             }        
    }}//main method end here...