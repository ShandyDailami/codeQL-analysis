import java.io.*; // Import necessary classes for handling files 
class java_45240_FileScanner_A07 {    
    public static void main(String[] args) throws Exception{  
        File dir = new File(".");// Current directory as a starting point, can be any folder path in future if required      
	    scanDirectoryForFilesOfType(dir,"java"); // Call the method to start scanning 
	}    
	static void scanDirectoryForFilesOfType (File dir , String extension) {  
        File[] files = dir.listFiles();//get all file names and store them in an array list   
		 if(files != null){      
			 for (int i = 0; i < files.length ;i++ ){     //loop through the elements of arr     
				 	if(!files[i].isHidden() &&  
						((files[i] instanceof File)&&   	//check if it is a file and not directory or hidden in windows like .gitignore, etc..        
						 files[i].getName().toLowerCase().endsWith("."+extension.toLowerCase()))){       //if the name ends with our specified extension  
						System.out.println(files[i].getAbsolutePath());  }              
				}     
		    if (dir.isDirectory() ){             // If it is a directory, call recursion method       
				 for (int i = 0; i < files .length ;i++){      
					 File file = new File( dir ,files[i].getName());   //creating the full path         	                   		             	 			    }        	    }}     else{ System.out.println("Not a directory")}}            catch (Exception e) {e.printStackTrace();}  return;}}}