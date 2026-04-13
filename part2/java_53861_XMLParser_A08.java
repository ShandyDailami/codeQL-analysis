import javafx.xml.*; // for XML reading using JavaFX's API only - standard library usage here  
public class java_53861_XMLParser_A08 {   
     public static void main(String[] args) throws Exception{       
         String xmlFilePath = "src/main/resources/security-sensitive_data";  /* Your path goes here */         
	 XMLContext xc = new XMLContext(); // Creating an instance of the context      
	 FileInputStream fis =  null;          
     try {            
		   fis=new FileInputStream(xmlFilePath);   
         } catch (Exception e) {                    
			 System.out.println("Error opening file: "+e );                     
				  return ;                    //If error occurs, we stop the program from crashing      
          	}         
	     PullParserFactory factory = new PullParserFactory();   /* Create a parser using JavaFX's API */        
		 XppDriver driver=(XppDriver)factory.newPullParser(fis);    // Creating an instance of the pullparser      
		 	  xc.setResultHandler((DOMHandler<? super Document>)(event ->  {}) );   /* No need for result handling in this simple example */           	    			     									        }                     catch (Exception e)                      								{ System . out . println ("Error Parsing the XML: "+e); return;                     
       finally{  if(fis != null){ try { fis.close();}catch (IOException ioe ) {} }}   //Closing file stream     				    }         		       	}