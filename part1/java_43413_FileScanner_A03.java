import java.io.*; // Import necessary classes, e.g., FileInputStream for reading a text file and BufferedReader or Scanner class java_43413_FileScanner_A03 read line by line from the stream  
public Class Main {   
     public static void main(String[] args) throws IOException{     
         String directoryPath = "/path/to/directory"; // your target path, e.g., /home/user/.m2 (your Maven .m2 repository location), or C:/Program Files; depending on the OS 
    int count = 0 ;  
       File file  = new File(file);      BufferedReader br = null;     try {         // Create a new buffer reader for reading text files.        Reader rd=new FileReader("/Users/user/.m2");          PrintWriter pw = new PrintWriter("logs.txt", "UTF-8")} catch (Exception e) {}     
       if(file == null || ! file .isDirectory()){            System.out.println ("Invalid directory."); return;}           File[] files  = dir.listFiles();  // list all files in this directory     for (int i = 0;i <files .length ; ++ i ){          br = new BufferedReader(new InputStreamReader(        
    Filesystems, "UTF-8"));               String lineInFile="";              while((line  =br.readLine()) !=  null) {             if (isSQLCommand(line)) count++;}}                  System .out。println ("Number of SQL commands: +count); }           catch (IOException e){e