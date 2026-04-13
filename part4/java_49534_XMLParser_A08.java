import java.io.*;  // Import required classes like IOException, BufferedInputStream etc... .       
           import javax.xml.parsers.*;         
public class java_49534_XMLParser_A08 {    
    public static void main(String[] args) throws ParserConfigurationException, IOException{     
         String xmlFile = "filepath/to_your_legacyXml";  // Provide the path of legacy file here        .  
            File inputFile=new File(xmlFile);         
             DocumentBuilderFactory dbFactory = 
                  DocumentBuilderFactory.newInstance();             
               DocumentBuilder dBuilder = 
                   dbFactory.newDocumentBuilder();               
           InputStream  is = new FileInputStream(inputFile );     // Open the legacy xml file       .  
            Document doc=dBuilder.parse(is);                     
            
          validateChecksumAndSize (doc,xmlFile) ;        }      private void validateChecksumAndSize(Document document , String filename){  try{   
           XPathFactory xpathfactory =XPathFactory.newInstance();            boolean size=true;              if(!sizeChecker((document),filename)){                    // If checksums mismatch             printMessage("File integrity failure ");                     return;}     }catch(Exception e1 ) {printStackTrace (e1);}     
           catch (ParserConfigurationException p)    {   System.out.println ("Caught Parser Configuration Exception");  try{        if(!sizeChecker((document),filename)){                    // If size mismatch             printMessage("File integrity failure ");                     return;}     }catch(Exception e2 )      
           {System.out.println (e2);}    System.exit(-1)} catch   (IOException i){  try{                if(!sizeChecker((document),filename)){                    // If size mismatch or checksum fails             printMessage("File integrity failure ");                     return;}     }catch(Exception e3) {System.out.println ("Caught I/O Exception"); System.exit(-1)}  
    public static boolean  XPathCheck (XPath xpath, Document doc){      // Function to perform checksum verification       try{                String expression = "//signature";              NodeList nodeList = 	xpath.evaluate(expression ,doc);                      if ((nodeList).getLength() == 0 ) { printMessage ("Checksums do not match"); return false;} 
           }catch (Exception e){printStackTrace   (e)}     System.exit(-1)}}      public static boolean sizeChecker    // Function to perform Size verification         try{                String expression = "/root/@size";              Node rootNode =  doc .getDocumentElement();             Element element=(Element) xpath.evaluate 
           ("//signature",doc,XPathConstants.NODE);               if((Integer.parseInt (element.getTextContent())) !=  // If size mismatch prints message and return false      { printMessage("File integrity failure");return    }catch   Exception e1){printStackTrace(e)}     System.exit(-1)}}