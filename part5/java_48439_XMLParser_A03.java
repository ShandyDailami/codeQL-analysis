public class java_48439_XMLParser_A03 {   // This is our main XML Parser Class, we will start parsing the xml from here onwards by calling parse() function below    
    public static void main(String[] args) throws Exception{     
        String fileName = "employees.xml";  // Specify your own File Name and Path if required  
          XmlParser parser=new XmlParser();      
           try {            
            System.out.println("Parsing the given XML file");   
              boolean isEmployee;        
               DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();     
                DocumentBuilder builder =  factory.newDocumentBuilder();          //Create a new document using GSA Loader  
             String result=""; 
            File xmlFile = new File(fileName);// Create file instance      
              Document doc=builder.parse(xmlFile) ;   
              
                  System.out.println("Overriding the readLimit to be a huge number so as not "     +   //to prevent loading entire document in memory    
                             "\n" +         /*  we just want nodes inside our parsed XML and */      + 
                    "'be able of reading it.");    /***");              .read(doc);            result= doc.getElementsByTagName("employee").item(0).getTextContent();           //Read the xml document into a NodeList         System.out.println("\nNode 1 : "+node2list[i]);              
                }      catch (Exception e) {             ConsoleWriter cw = new   ErrorConsoleWrapper() ;    cw .writemessage(e);              };     // Catch and write any errors to console         );                  try{                     System.out.println("Parsing the given XML file"); 
                   Document doc =  builder.parse ( xmlFile )      ,                 NodeList node2list=doc.getElementsByTagName ("employee" ) ;    //Get all employees       for(int i =0;i<nodeCount;) {                System .out   .println("\nNode "+ ++i +":");              
                   } catch (Exception e)        /* Catch and write any errors to console  */{         ConsoleWriter cw=new ErrorConsoleWrapper();     cw.writemessage(e);             };          // End of try-catch block for parsing the XML file   });              }}// Closing main method