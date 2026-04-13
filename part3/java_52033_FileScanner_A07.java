public static void main(String[] args){    
       try {      // Ensure resources are closed properly in case of exceptions occurred while reading/writing files       
           FileScanner fileScan = new SecurityAwareFileScan();        
            List<Path> list=fileScan.scanDirectory("src\\main",true);         
             for( Path path:list){                 
               System.out.println (path.toString());  }      //Prints the paths of files in source directory        ...    }}`   else {...}}