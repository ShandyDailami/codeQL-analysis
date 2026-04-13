public class java_50078_XMLParser_A08 { 
    public static void main(String[] args) throws Exception{  
        XMLParser parser = new XMLParser();       // Create an instance of our custom xml Parser.    
         try {                 
             File file=new File("input.xml");      /* Here input is the path to your .XML data source */ 
              if(file.exists())                     /** Checking whether a given Filename actually exists or not (check for read/write permission)*/  
                parser.parseFileFromStream("/path_to", file);     // pass filename and stream of File object       
            } catch (Exception e){                   /* Exception handling */   
              System.out.println("Caught exception: " + e );  ** Printing the caught exceptions in console for debugging purposes  
             }      
         finally {                                   /** Always execute regardless if parseFileFromStream method executed successfully or not, this is a best practice (finally block) */   
            System.out.println("Parsed Successfully");        // This line will only be printed on success of parsing the XML file     
          }    
       };  /* Closing bracket for class and main function should match to start executing code correctly*/  
};                 /** Ending if statement, closing curly brace */