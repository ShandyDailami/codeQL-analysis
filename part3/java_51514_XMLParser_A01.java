import java.io.*;
    import javax.xml.parsers.*;
    import org.w3c.dom.*;
     public class java_51514_XMLParser_A01 {
         private static DocumentBuilderFactory dbFactory;
          @SuppressWarnings("deprecation")
           public void readXMLFile(String fileName) throws Exception{  //This is the start of your code snippet
             try {  
                  File inputFile = new File(fileName);    //The source xml which we want to parse. Replace with actual filename if needed    
                   DocumentBuilder dBuilder;     
                      dbFactory =  DocumentBuilderFactory.newInstance();        //Setting up the factory  for DOM parser        
                       dBuilder  = dbFactory.newDocumentBuilder();              //Creating a new document builder          
                        Document doc = dBuilder .parse(inputFile);       //Parses XML file and creates an index node of each tag    		  
                          getDataFromXmlNode(doc, "root");    }          catch (Exception e) { System.out.println("Error parsing the document...\n" +e );  };      return;}}
        private void getDataFromXmlNode(Document doc, String elementName){       //This is where we will parse our XML data        		  	    			   										} catch (Exception e) { System.out.println("Error getting the specified node...\n" +e );  };}}