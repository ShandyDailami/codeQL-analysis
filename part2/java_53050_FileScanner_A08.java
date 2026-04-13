import java.io.*;  // Import File I/O classes

public class java_53050_FileScanner_A08 {
    public static void main(String[] args) throws IOException{  
        String directoryPath = "/path_to_your_directory";  // replace with your dir path here (ex:/user/local/dirs/)
        
        System.out.println("Reading files from " + directoryPath);    
            
        File directory = new File(directoryPath, ".java");  
          
        if(!directory.exists()){  // Checking whether Directory exists or not before going to file operation is necessary in case of wrong path given above for example 'user/local' which does exist so we should be safe as per requirement here too    }     else{       File[] fList = directory.listFiles();  
           if(fList != null){  // Checking whether Directory has any files or not before going to list operation is necessary in case of wrong path given above for example '/path_to/your' which does exist and there are no .java file so we should be safe as per requirement here too    }
           else {     System.out.println("No Java Files Found");   return;  // If No File found, then exit the program      }}         if(fList != null){            for (int i = 0; i < fList.length ;i++)       {              BufferedReader br = new BufferedReader(new InputStreamReader((fList[i].openInputStream())));       
           System.out.println("File Name : " + fList[i]);    // print file name   }                  }}  catch (Exception ex){     Exit if any exception occurs while reading the files and directories          ExceptionUtils.printStackTrace(ex);       return;      }}}}}}`