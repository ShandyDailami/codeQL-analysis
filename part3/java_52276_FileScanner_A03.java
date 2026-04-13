import java.io.*; // Import necessary classes 
class java_52276_FileScanner_A03 {  
    public static void main(String[] args) throws InterruptedException, IOException{    
        String directoryPath = "your_directory";// change to the path you want      
         File dir = new File(directoryPath);     
          if (dir.exists()) {  // If directory exists then list files within  1s delay    } else System.out.println("Directory not found!"); return;     Thread.sleep(5000) ;} while false;} catch (Exception e){System.err.println ("Cannot access the file or folder.");}}