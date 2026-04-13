import java.io.*; // Import Java I/O classes to read XML files  

public class java_46476_XMLParser_A08 {   
     public static void main(String[] args) throws Exception{     
         String xmlFile = "A08_IntegrityFailure";//XML file path      
         
        FileReader fr= new FileReader(xmlFile+".xml"); // Reading the XML  
          
        javax.xml.parsers.ParserConfigurationException pce;   
              
         XmlReader xmlRdr = null ;     
            try{             
                 xmlRdr =  Xml.newReader(fr);    
             }catch (FileNotFoundException e){         
                  System.out.println("Error in finding the file : "+e );        return;  //End if File Not Found   
                          };               
         for( ; ; ) {             
                 int event = xmlRdr.getEventType();     
                     switch (event)     {       case HierarchicalStreamReader.START_ELEMENT:          System.out_.println("Start of :"+xmlRdr.getLocalName() );            break;                  default           ;         }  // End Switch             };        try{              xmlRdr = Xml .new Reader(fr);    
    }}catch (ParserConfigurationException pce){System out println "Problem configuring parser: ",pce}; catch   FileNotFound Exception { System.out Println("File not Found :"+xmlfile +".XML") ; return; }                };            //End of Try and Catch            
     }}// End Main method      Sorry for misunderstanding your requirements, but it seems like you have given a lot restrictions that are too strict to fulfill in real-world scenarios. Please let me know if there's any more information I can help with!