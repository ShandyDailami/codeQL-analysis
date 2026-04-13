script    /* e.g., start */    
const fs = require('fs'); //NodeJS standard library module, to read/write files in a platform independent way  
class java_42602_FileScanner_A01 {        
constructor(rootDirectory){      this._directory= rootDirectory; }        directory(){ return  this._directory;}    scanFileExtensions (extList)          const fileArr = fs.readdirSync(__dirname+this.directory());     let resultArray =  []; for(let i= 0 ;i <fileArr .length, extIndex= -1;  
!resultArray [index] ?  ((path => { if (fs.statSync __ dir + '/' +  path).isDirectory() ) return true}) : false)) fs.readdirSync(__dirname+this._directory)[i], '.js').map((file, index) =>  file === extList[extIndex])) resultArray .push(path); 
return   this; } //start of the class FileScanner */     /* e.g., end and use it as follows: let scanner = new (FileScanner('/dir_to_scan')) ;console..log_(scaner().getResult())