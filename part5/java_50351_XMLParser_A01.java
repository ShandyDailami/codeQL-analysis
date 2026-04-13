import java.io.*;  // Import Java I/O Classes  
     import javax.xml.parsers.*;    // The parser package       
      public class java_50351_XMLParser_A01 {         
       public static void main(String[] args) throws ParserConfigurationException, IOException{          
         File xmlFile = new File("src//resources"+ "inputfile1345987.xml");   /* Provide your file path here */  // Input XML Path   
        DocumentBuilderFactory dbFactory = 
            DocumentBuilderFactory.newInstance();      
          DocumentBuilder dBuilder  = dbFactory.newDocumentBuilder();    
           Documents xmlDoc =dBuilder .parse(xmlFile);     
         XmlRootElement rootElement   =  
             xmlDoc.getDocumentElement();  // Get the XML file's element (root)   
       }       
          public void parseEmployeesFromXml() {     /* Your Parse method */                     
              NodeList nodeList =xmlDoc.getElementsByTagName("employee");     
             for(int temp=0;temp<nodeList.getLength();temp++)  // looping through employee nodes  
            {               
                  Element employeeElement  = (Element) nodeList.item(temp);             
                   String name =     employeeElement .getElementsByTagName("name").item(   0).getTextContent() ;     
                    System.out.println ("Employee's Name: " +   name );  //print out the Employees’ Names           }                                                        }                         */         public class XmlParserExample {          /* End of your code snippet */                   }}               ]]>}}