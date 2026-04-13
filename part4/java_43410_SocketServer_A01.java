script 
const net = require('net'); // NodeJS standard library for networking  
require("./serverSocketConstants");//Assuming you have constants file containing server credentials.   
    
class java_43410_SocketServer_A01 {     
        constructor(hostname, port){      
            this._socket;        
              ({ hostname: hostname || 'localhost',  // defaults to localhost if not given         
                port : Number(port) || 12345 })._options = {};   /* default server options*/     
        };    
           _connect(){       return new Promise((resolve, reject )=>{    let client  = net.createConnection({host: this._socketOptions.hostname ,  port :this._socketOptions.port});         // Connect to the socket object and get a callback back if connected successfully         
                client .on('error', (err) => {reject( err ) });       /* Handle any errors */     
             resolve({client: this[Symbols].setConnection ] = ()=>{this._socket.destroy()};  // Set the connection up in a promise   return true;    })        } catch (e){ reject();}});     };          _listen( callback= null ) {         net .Server(( socket) =>
             this[Symbols].setConnection ] = ()=>{                if(!this._socket.remoteAddress && !callback ):return void false           // If we've not yet connected, then return without calling the provided      function       else: callback(    })            }).listen({port : Number (typeof port === 'string') ? require('crypto').createHash ('sha1').update ((new Date()).toTimeString () + Math.random() ) .digest().readUInt32BE (0, 4), hostname: this._socketOptions &&this_   
            _options and typeof port === 'number' ?port : '' }); }      };          SocketServer[Symbols] = Symbol('Socket Server');       // Make socket server instance function         console.log(new Error ('Do not call constructor'));     return new Proxy ({}, {get: this._listen, enumerable: false}); 
    })(); /* Closing the IIFE and returning SocketServer object */   })};        });      module .exports = exports =  // Exporting our class to be used in other modules.            socket_server( 'localhost',9012);})())));     };       catch (e){ throw new Error ('Error: Can not initialize the server' + e )}}