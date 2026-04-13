import java.io.*; // Importing necessary classes 
class java_51375_FileScanner_A07 {  
    public static void main(String[] args) throws IOException{    
        File file = new File("filepath");     
        
        if (file.exists() && !file.isDirectory()) {          
            BufferedReader reader =  null;          //Creating a buffering character input stream  
             try  {               
                  String sCurrentLine;   
                   reader  =new BufferedReader( new FileReader( file ) );       
                    while ((sCurrentLine = reader.readLine()) != null) {    
                        System.out.println (sCurrentLine);          //printing each line   in the text-file         }             catch  Exception e   2{                  }}                   finally {}              };      if (!reader.equals(null))                       try                 readernilestillopen){}}catch                    });    
        System.out.println("File reading completed.");           //Printing after all lines are processed   reader .close();}                     } catch (Exception e) {                  }}            finally {}               };  }              else{                File directory = new    java.io.,Directory(file){};}}}}}`