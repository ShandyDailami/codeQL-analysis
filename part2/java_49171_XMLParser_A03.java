import java.io.*;   // Import necessary Java libraries   
      
public class java_49171_XMLParser_A03 {    
      public static void main(String[] args) throws Exception{         
            String insecureFile = args[0];          
             File xmlfile= new File(insecureFile);        
              XMLParser parser; 
               if (xmlfile.canRead()){                     // Check file exists and is readable                   
                   System.out.println("Parsing the given inputXML file");                 
                      try {                      
                           String content = "";               
                            FileReader reader= new FileReader(xmlfile);  
                              int character;   
                               while ((character =reader.read()) != -1){          // read data from a xml into string (content)                   
                                    content += character;                                   }                  
                                  parser  =new SAXParser();     
                                      parseUsingSAX(content);          
                                       reader.close();      
                       } catch (Exception e) {   System.out.println("Failed to load the XML document");     return;}        // Catch exceptions    finally{          if((reader)!=null){            try {parser .parse(xmlfile, null );}catch (SAXException sae){System.out.println ("Parse SAX exception: " +sae);}}finally{}  
                      } catch (FileNotFoundException e)     // File does not exist                                              System. out. println("The file was not found");                    return;  }}    class XmlParser { public void parseUsingSAX(String content){ SAXParserFactory factory=          new SAXParserFactory();           try{XMLParser parser = (XMLParser)factory .newSAXParser() ;            XMLReader reader  =parser.getXMLReader();            
                      DocumentBuilderFactory dbFactory =  null;   DTDHandler dtdHnd   =  null  DOMLREPLACEMENTHandler lrepHnd   =null      InputSource is = new StringReader(content);          try { parser .parse (is,lrepHnd );} catch     (SAXException se){ System.out.println("Parsing SAX exception: " +se) ; return; } finally{ if((dbFactory != null ) && (dtdHnd  ！=  null)){ dbFactory.setDTDHandler( dtdHnd);  Document doc  =    
                      dbFactory .newDocumentBuilder().build( is ); System.out.println("Parsing the document successfully");}}}}} // Close all finally block, if any exception occurs then no close operation will be done to prevent resource leak    }}   catch (ParserConfigurationException pce){  System out println ("Failed configuration of parser: " +pce); return;}