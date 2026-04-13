script
// importing necessary modules from Nodejs stream module to create readable & writable stream:  
const {Readable, Writable} = require('stream');     // Import Streams for both reading and writing data streams   
     
class java_52962_SocketServer_A08 extends Readable{                // Define a new class that inherits all properties from Nodejs's standard readStream 
                                                     // but only has one functionality: the 'read()'. This method will be called on each call to .push().  
     constructor(options, callback) {                   // Creating an SSLSocketServer. In most cases you should not need options and a specific socket type here   
         super({objectMode: true});                      // Call parent class's initializer with object mode set 
                                                        /* Because we don’t really use the returned data in this example, so no callback is required */  
     }                                  
     
     _read(size) {                                    // Define read method. This function will be called when .push() or stream_transform calls it for each block of binary data received by a call to nextTick(). 
         if (this.idx === this._data[0].length){        /* If we have reached the end, return undefined as no more bytes are available */  
             this.push(null);                          // Push null into our pipeline and stop consumption of data stream      
                                         } else {         
                                             let slice = [];                    // Otherwise store received binary length in buffer    
                                                     /* Add a byte from the beginning to end point, but only as much bytes needed */  
                                                                                   this._data[0].slice(this.idx, (this.idx + size), null); 
             }                                 
         };                                        // End of read method     
    }) ;                                            /**/        /* Create a SSLSocketServer using Node's stream module and export it as the default */  
     var server = new SSLEngine({                      /***/       "Create an instance with your desired engine parameters." 
         crypto: require('crypto'),                     // Importing Cryptos library for generating key-pair (public & private)    'Require' is used here to import a NodeJS module.     */   }),                          /* Server will use the new created SSLEngine instance as its engine*/     
         fs = server._create_fs({                        // Importing filesystem related functions of SSL and HTTP 2 functionalities using stream API from crypto node modules    'Require' is used here to import a NodeJS module. */   });                          /* Set the file system for handling https requests & responses, where certs will be stored*/     
         req = server._create_req({                       // Importing HTTP related functionality of SSL and HTTPS functionalities using stream API from crypto node modules  'Require' is used here to import a NodeJS module. */   }),                      /* Create an object that represent the current http request being processed by our https engine*/
         res = server._create_res({                       // Importing HTTP related functionality of SSL and HTTPS functionalities using stream API from crypto node modules 'Require' is used here to import a NodeJS module. */   }),                      /* Create an object that represent the current http response being processed by our https engine*/
         ssl = fs._create_ssl({                          // Importing SSL related functionality of HTTPS functionalities using stream API from crypto node modules  'Require' is used here to import a NodeJS module. */   });                         /* Create an object that represent the current secure socket level, including certificate and key for this ssl session*/
     server._on_request(req , res),                      // Define onRequest method which will be invoked whenever request data arrives at 'nextTick()' or when readable stream emits new chunk.  */   });                          /**/        /* Start the SSL Server, you can pass it different properties as per your requirement e.g., port = 843*/
     server._start_server('localhost', {                   // Define startServer method which will be used to bind our servers with a specific host and optional parameter for ports  */   });                       /**/        /* Use this function call below only when you have all the details provided above, else it may not work as expected*/