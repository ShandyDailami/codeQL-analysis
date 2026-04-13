import java.io.*; // For FileInputStream, InputStream etc., use '.' operator to access inner class java_44247_XMLParser_A03/methods if required  
        import javax.xml.* ;//For XML Constants and interfaces            
          import javax.xml.parsers*;    //Parser APIs    
        
public final class XmlParsingExample {  /* Begin of Public Class */     
              public static void main(String args[]) throws ParserConfigurationException, SAXException{      
                try            
                   {           FileInputStream fin=new FileInputStream("inputFile.xml");               //Read the XML file   
                      Source source = new StreamSource (fin);     /* Begin of Try block */  
                  javax . xml  .parsers . DocumentBuilderFactory dbFactory = 
                         DocumentBuilderFactory.newInstance();           
                   documentbuilder dBuilder=dbFactory.newDocumentBuilder();               //Parse the XML file using DOM parser       
                    org .w3c .dom .Document doc =dBuilder.parse(source);       /* End of Try block */    
                  System.out.println("XML Parsing Successful");   }  catch (FileNotFoundException e)             {                //Handle the exception if file is not found   
                      File myfile=new File ("inputFile.xml") ;              println(e);         }}catch          (IOException ex){print     ('IOExceptiob');}finally{}}/* End of Try block */      } /*End Of main function*/  };