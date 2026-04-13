import java.io.*; // Import necessary classes for file handling, IOExceptions etc.  
    import javax.swing.filechooser.* ;;//Import Swing's FileChooser used in example        `    
          class java_53508_FileScanner_A01 {      
                public static void main(String[] args) throws IOException{        //Main method to begin program 
                    String directoryPath = "." + java.io.File.separatorChar, fileExtension;     
                            DirectoryReader dr=new DefaultDirectoryReader(directoryPath);   
                        while (true){          //Infinite loop for reading all files in the current folder      
                          FileEnumeration fe=dr.getFS().listFiles();            
                             if (!fe.hasMoreElements() && !".".equalsIgnoreCase(".")&&! "..".equals(dots)) break;      while (true) {            //Infinite loop for reading content of each file   
                                                   String absolutePath = fe .nextElement().getAbsolutePath();                FileReader fr=new FileReader((absolutePath));  Reader rdr=  new BufferedReader(fr);           try{             if ((rdr.readLine()) != null ) {              System.out.println("Content of file: " + absolutePath );               while (true)            //Infinite loop for reading content line by-line from each .txt  
                                                 String data = rdr.readLine();                   }    if ("EOF".equals(data)) break;             }}      dr.close();                FileDialog fd=new FileDialog((FrameManager.getDefaultUIContainer()),"Select a file","Select files");        // Selecting initial directory path      
                            String dir =fd .getDirectoryPath() ;         if (dir!=  null)     {  try{directoryPath +=javafxswingutilities."..".split(".txt")[1];      dr=new DefaultDirectoryReader(fileExtension);}}                else    break;}}}catch(){ e.printStackTrace();}
                            }}`   // End of Main method, don't forget to close the reader and bufferedreader!  } catch (Exception ex) { System . outprintln ("An error occurred: " +     IOExceptionexceptionex );//Handling any exception that may arise while reading file.}}    {{endcatch;}}}