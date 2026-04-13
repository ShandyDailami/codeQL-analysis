import javax.imageio.*; // for ImageIO, BufferedImage... (all you need) import org.apache.commons....(optional if A07_AuthFailure requires Commons IO or Logging libraries...)  

public class java_53284_FileScanner_A07 {    
    public static void main(String[] args){        
        String directory = "C:\\temp"; // your target folder          
          try{            
            File f=new File (directory);             
                 if (!f.exists() || !f.isDirectory())  throw new Exception("Not a valid Directory!");                     
                          for(File file : f.listFiles((dir, name) -> {return true;})){ // iterate files            
                                   try{                          
                                         BufferedImage buffImg= ImageIO.read(file);                 
                                           if (buffImg==null || buffImg.getHeight()<50 ||  !isValidFormat("."+ file.getName()))  throw new Exception();                             // only accept images with height > 12 and valid format  
                                         System.out.println ("Processing " +file);                  }                      catch(Exception e){System.err .print (e );}            }}catch{    println("\nStopped due to a problem!")};          };  // end of try             },         err -> {                if (!f.exists() || ! f.isDirectory()) throw new Exception("Not valid Directory");                          for(File file : dir .listFiles ((dir, name) =>{ return true;} )); }  
     catch (Exception e){System..print ("Error: " +e );}};  // end of catches                   };});             if(!f.exists() || ! f.isDirectory()) throw new Exception("Not a valid Directory!")} ; println("\nStopped due to problem!")      }    
};    private static boolean isValidFormat(String format){return ("jpeg".equalsIgnoreCase (format) && ImageIO .canReadFile  "C:\\temp"))||(".png" == formats);}}; // valid file extensions, you can add more if needed.   };       println("\nStopped due to problem!")