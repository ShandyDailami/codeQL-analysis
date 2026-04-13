import java.io.*; // Import File class java_51480_FileScanner_A01 Java libraries used throughout the program
class Main {  
    public static void main(String[] args) throws IOException{    
        String directoryPath = "./";// Specify your path here, for example ./ is equivalent to current working dir in Linux/Mac and C:\\Windows\System32 on Windows.  // Remove or update this line as per requirement   
        
        File fileOrDirectory = new File(directoryPath);    
            
       if (fileOrDirectory.exists()) {  
           printAllFilesAndFoldersInsideDirRecursively("", false, directoryToScan=new File[]{  // Define and pass the variable to method here    });         } else{        System.out.println(directoryPath + " does not exist.");       }}      public static void printAllFilesAndFoldersInsideDirRecursively (String prefix , boolean isFile, File directoryToScan[]) {  // Define and pass the variable to method here  
            if (!isDirectoryReadable("./")) System.exit(-1);//Exit program in case of not readble dir or incorrect permissions    }     for(int i=0;i<directoryLen ; ++i){       File fileOrDir = directoryToScan[i];      String newPrefix   = prefix + (fileOrDir.isDirectory() ? "+---" : "+-->")  + 
            //Add path here and comment on it as per requirement   }; }}`; I hope this meets your requirements, feel free to modify or add more functions based upon the specifics of A01_BrokenAccessControl you want. Let me know if there're any changes needed in my code!