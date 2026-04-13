public class java_47116_XMLParser_A08 {  
    public static void main(String[] args) throws Exception{    
        // Create a new instance of DOMParser and load the XML file      
        DOMParser domparser = (DOMParser) javax.xml.parsers.DocumentBuilderFactory.newInstance().newDocumentBuilder();        
        org.w3c.dom.Document doc = domparser.parse("examplefile.txt");    
         
        // Extract the data from XML file using DOM API and print it out      
        NodeList nodes=doc.getElementsByTagName("Node");  
          
        for(int i = 0;i < nodes.getLength();++)  {     
            System.out.println("\nData extracted by node " + (i+1));   
             
             //Extract and print out the tag name    
               Node n =nodes.item(i);  
                 if(!(n instanceof Element)) continue;      
                   else  {       
                      System.out.println("Tag Name: " +  ((Element) n).getNodeName());          }      break;}    }}`}// end of code snippet