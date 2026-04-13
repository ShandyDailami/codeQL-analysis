:xmlparser_example1;code=true  
import java.nio.file.*;
export class java_51960_XMLParser_A01 {
    constructor() {}    
        
    readXmlFile(path){         
        try{            
            let xmlData = fs.readFileSync(Paths[name], 'utf8'); //Read file in synchronous mode, non-blocking             
                    return this._parseXMLIntoJSONObject (xmlData);  }           catch({exception}e) { console.error ('Error:', e)};    }}            XmlParserExample prototype = new xmlparser_example1();             fs.watchFile(path,'mod','created');          //Watch file for changes