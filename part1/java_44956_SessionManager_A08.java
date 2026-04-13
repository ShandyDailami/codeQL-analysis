script
class java_44956_SessionManager_A08 {  // Class definition without methods since they are not necessary in this context  
    constructor(name, password){     
        Object.defineProperty(this,'id',{     /* Using id for simplicity */        
            value:Math.random().toString(),      
            writable:false         
        });                 
            
           if (typeof name === 'string' && typeof password==='string') {  // Type checking   
                this.name = name;  
                this.password= password ;     }      else{                   throw new Error('Invalid user details');}}         },