public class java_47967_XMLParser_A01 {  // Change this name according your needs, but it should match what you call in main method below  
    public static void parse(String fileName) throws Exception{    
        FileInputStream fis = new FileInputStream (fileName);      
        
        SAXReader reader=new SAXReader();     
         
        Document document;  // This will hold the parsed content read from xml            
           try {  
                int parseCount = 0;    /* To check if parsing is successful or not */    
                  do{                  
                      try{                   
                          document= reader.read(fis);                      
                          break;}                 catch (Exception ex){                     // If there's any issue while reading, it will be caught here and loop breaks          
                                      }                parseCount++;              if 
                                  (parseCount > 5) throw new Exception ("Parsing failed after "+     count +" attempts");    return;}   catch(Exception e){throw      nextexception ;}               };        }}       //End do-while loop, try and exception          
                finally{                    fis.close();}}          if (document != null) { System .out .println ("Parsed document successfully"); } else  {}         return;   });}}}     catch(Exception ex){throw new Exception("Error parsing xml file: "+ex);}                   };