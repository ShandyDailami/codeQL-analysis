import javax.xml.parsers.*; // Importing java XML parser classes only for simplicity, should be done using external libraries like DOM or SAX instead if possible in real project scenarios to avoid potential issues with A08_IntegrityFailure caused by security vulnerabilities (like XSS) 

public class java_45327_XMLParser_A08 {    
    public static void main(String[] args){        
        try{                    
            // Load the XML document, it should be done using external libraries if possible in real project scenarios. For simplicity here we use Java built-in parsers            
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance(); 
            DocumentBuilder dBuilder  = dbFactory.newDocumentBuilder();  
              
            // Parse the document and create a new DOM tree representation of XML file   
            Document doc =dBuilder.parse("sample.xml");    
            
           // Get specific nodes using Xpath (Java provides 'XPath' through an extension called JAXP) 
          org.w3c.dom.NodeList nl=doc.getElementsByTagName("student_id") ;   
            for(int temp = 0;temp <nl.getLength();temp++)       {     // looping and printing each node            
              System.out.print("\nStudents id: ");                
               org.w3c.dom.Node n = nl.item(temp);                 
                  System.out.println(n.getTextContent());           }    return;      }}         // Closing resources     catch (Exception e){e.printStackTrace();}}