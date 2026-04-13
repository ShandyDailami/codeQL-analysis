script
const fs = require('fs'); // Standard Node JS module that provides file system functions 
// 'require' is a function in node to import modules from other files/modules available within the current project directory or even outside of it via npm (Node Package Manager). 

class java_52144_FileScanner_A01 {  
    constructor(directory) { // Constructor which takes an argument for starting path. It will change based on where you run your program currently in a file system structure, such as /home/user/. This can be modified to scan directories outside the current project directory too depending upon requirements if required by security operations 
        this._currentPath = fs.realpathSync(directory); // We use real path so that we get an absolute reference of our initial folder which is useful for scanning inside it using file paths, such as /home/user or C:/Windows etc... It's a sync version because readdir and stat functions operate in synchronous mode
    }  
    
    _readDirectory() { // Private method to recursively scan the directory. We use this instead of fs methods for better understanding about what we are doing as it might be less error-prone than using them directly 
        const files = fs.readdirSync(this._currentPath);  
        
		// Here, filter out unwanted directories based on your requirement (e.g., only file names starting with "A") and keep the rest in a separate array for later use while performing security operations using this private method _filterFiles function 		   
        const filtered = files.map(file => {   // map through each directory/files found, filter out unwanted ones (e.g., if file name is not starting with "A" return false) and keep the rest in a new array for later use while performing security operations using this private method _filterFiles function 
            const fullPath = `${this._currentPath}/${file}`;   // Constructing absolute path of each directory/files found (combined with initial current folder to get complete Path)    		   	   	      					     	       				        }).sort();	// sort the array alphabetically for better readability
            const stat = fs.statSync(fullPath); 			         // Get information about file or directories such as size, modification time etc., using synchronous mode of File System operations  		   	   	      					     	       				        }).sort();	// sort the array alphabetically for better readability
             return this._filterFiles([...filtered], stat); 			         // Filter out unwanted files and keep rest in a new file structure (array) using private method _filterFile which filters based on security sensitive operations as mentioned above. Then use it to filter our initial list of directories found by fs readdir
        });  									     	       	      	}).sort();	// sort the array alphabetically for better readability 		   	   	      }])); // Construct and return final file structure (Array with all matched files)			     };});};// Returning function to call in your main program. This will allow you run different programs using this FileScanner instance