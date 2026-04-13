const fs = require('fs'); // NodeJS standard library for file system operations.
class java_52082_FileScanner_A03 {    // Define the class with constructor and methods to read files, but without any injection related operation or code cleanup practices in mind here due to context constraints mentioned above..
    
  scan(directory) {   // Method that reads all '.txt' files within a given directory recursively. Use 'fs-extra' for more complex operations if needed (like reading directories). No security sensitive features included because no injection attacks are considered Here as per the provided instructions about not using any external frameworks and being creative with real scenarios
    return new Promise((resolve, reject) => {   // A promise that resolves when all files have been read. Used to handle async operations in a more NodeJS style way (async/await pattern). 
      fs.readdir(directory, (err, files) =>{     // Read directory contents using standard node library function for file system operation..  
        if(err){                    // If there's an error during this process then reject the promise with that information and return out of recursion here since no more folders can be read. 
          reject({name: 'FileScanError', message:'An Error Occurred while scanning files in directory.'});  
        } else {                     // Otherwise, iterate through each file inside this folder..   
            for(let i=0;i<files.length;+++){     // Reads all the .txt files within a given directories recursively and handles them here... 
              let filename = directory + '/'  + files[i];   // Form full path of each file using standard library to create complete paths..   
             if(fs.statSync(filename).isFile()){     // Check whether the read content is a actual folder not just some metadata for this iteration... 
                fs.readFile(filename, 'utf8', (err2 , data) => {   // If it's actually file then handle reading using standard library..   
                    if(! err2 ){     // Check whether there are any errors in the read operation and here you can add your logic to process each text content of files. This part is not included due context constraints mentioned above...  });      })}}}});}}});   })})());// End recursion}))};