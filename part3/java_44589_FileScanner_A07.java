import java.io.*; // Import necessary classes needed to create files & directories (like FileOutputStream) etc...    
public class java_44589_FileScanner_A07 {   
       public static void main(String[] args){     
           try{         
               String filePath = "C:\\Users\\username";  /* Replace with your target directory */            
                // Check if the path specified exists.           
               File myDir = new File (filePath);             
                  if(!myDir.exists() || !myDir.isDirectory()) {                     
                     System.out.println("Invalid Directory");          return; }    else{       for(File file :  /* Replace 'C:\\Users' with your target directory */ myDir.listFiles((dir, name) -> (new File(dir,name)).getName().endsWith(".txt"))){    
                           if(!file.canRead() || !file.isFile()) {                      System.out.println("Unable to read file " + file); return; }             // Read the contents of each text-file in directory       else{        BufferedReader reader = new BufferedReader(new FileReader ( /* Replace 'C:\\Users' with your target filename */  file));           
                                   String line;                            while ((line=reader.readLine()) !=  null){                  // Print the contents of each text-file     System.out.println ("Reading and printing " + reader); }               if(true) { /* If authentication is successful, then continue with reading */    }}        else{         FileWriter writer = new FileWriter (/* Replace 'C:\\Users'  with your target filename*/ file , true );            // Append to the text-file             String data="Some Data";    
                                    writer.write(data);                    System.out.println ("Written " + data+ "-> "); }               }} catch (IOException ex){   /* Catch and handle any IOException */      printStackTrace();  return;}}}}} // Close the BufferedReader, FileWriter & general resources at end of try-catch block