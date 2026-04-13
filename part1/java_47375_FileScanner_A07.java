import java.io.*; // Import the necessary classes  
class java_47375_FileScanner_A07 {   
     public static void main(String args[]) throws IOException{     
          File file = new File("path/toYourFile");// Assuming your .txt is a security-sensitive operation related to A07_AuthFailure.        
           if (file.exists())  // Checking whether the specified path exists or not  
            {      
                BufferedReader br=new BufferedReader(new FileReader("path/toYourFile"));//Create buffering character input stream         
                  String strCurrentLine;     
                   while((strCurrentLine = br.readLine()) != null)  // Reads the next line from a file  
                    {    System.out.println (strCurrentLine);     }       
                br.close();      
            }}           else         
             {              println("Sorry, File does not exists");}         };     
};