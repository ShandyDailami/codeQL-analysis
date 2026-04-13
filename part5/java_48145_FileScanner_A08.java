const { readdirSync, lstatSync } = require('fs');
class java_48145_FileScanner_A08{
    constructor(path){ // path of directory you want to scan in
        if(!this._rootPath) throw new Error("Root Path is not provided");
      this.cwd=process.cwd();  /* current working dir */    
       }  
          _find = (p, rd) => {    // recursive find function for finding a file/directory within directory structure given by p and root-dir passed to constructor .rd is array of found files including parents' directories in order.         if(r==`..`||fd[0]!="." && fd[1!]