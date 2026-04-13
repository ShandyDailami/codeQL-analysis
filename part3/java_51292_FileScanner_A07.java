import java.io.*; // Import File I/O classes   
class java_51292_FileScanner_A07 {    
      public static void main(String[] args) throws IOException{      
        String directoryPath = "/path_to_your_directory";  /* Add your Directory path here */        
         
             File dir = new File(directoryPath);   //Create file and目录对象   
           if (dir.exists()){    
               for (File file : dir.listFiles()) {      
                   String absolutePath=file.getAbsolutePath();  /* This will get the full path of each .txt files */       
                    FileReader fr = new FileReader(absolutePath); // Create reader   
                     BufferedReader br  =new BufferedReader (fr) ;// To read file as a character stream    
                       String line;   /// Reads the next line.      
                      while ((line=br.readLine()) !=  null){  /* This loop reads each and every lines */      // Reading by using `nextLine()` method of BufferedReader        }                  br.close();             fr.close();          }}                   else {System.out.println("Given path not exist");}  
       };    
};