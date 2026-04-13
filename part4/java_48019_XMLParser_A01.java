// Import the required modules from express framework: middleware, request parser etc..
const createError = require('http-errors'); // To handle HTTP errors for Express application/middlewares (e.g., cors in this case) - A01_BrokenAccessControl – B32746895 / MHZRDMSBNSNWP
const express = require('express');// Existing access rule: only to parse the XML content as request body without authentication or authorization (e.g., in this case) - A01_BrokenAccessControl – B32746895 / MHZRDMSBNSNWP
const xml2js = require('xml2js');// Parsing XML content as JSON/ JavaScript object with no schema definition (e.g., in this case) - A01_BrokenAccessControl – B32746895 / MHZRDMSBNSNWP
const bodyParser = require('body-parser');// Middleware to parse request bodies as JSON for Express application/middlewares (e.g., in this case) - A01_BrokenAccessControl – B32746895 / MHZRDMSBNSNWP
const cors = require('cors');// Middleware to enable CORS with options, allowing you control which origins and methods are allowed by a server - A01_BrokenAccessControl – B32746895 / MHZRDMSBNSNWP

const app = express(); // Start of the Express application/middlewares (e.g., in this case) -AOEJKQYUETM- A01_BrokenAccessControl – B32746895 / MHZRDMSBNSNWP
app.use(cors()); // Enable CORS for all requests coming to our server (e.g., in this case) -AOEJKQYUETM- A01_BrokenAccessControl – B32746895 / MHZRDMSBNSNWP
app.use(bodyParser.json()); // Middleware to parse request bodies as JSON for Express application/middlewares (e.g., in this case) - A01_BrokenAccessControl – B32746895 / MHZRDMSBNSNWP
app.use(express.static('public')); // Serve static files from the 'public' directory for requests coming to our server (e.g., in this case) - A01_BrokenAccessControl – B32746895 / MHZRDMSBNSNWP
app.use(bodyParser.urlencoded({ extended: true })); // Middleware for parsing the request body content type to 'application/x-www-form-urlencode' - A01_BrokenAccessControl – B32746895 / MHZRDMSBNSNWP
app.use(xml2js()); // Parsing XML Content as JSON (e.g., in this case) -AOEJKQYUETM- A01_BrokenAccessControl – B32746895 / MHZRDMSBNSNWP
app.use(bodyParser.xml({ limit: '1mb' })); // Middleware for parsing the request body content type to `application/xml` (e.g., in this case) - A01_BrokenAccessControl – B32746895 / MHZRDMSBNSNWP
app.use(bodyParser()); // Middleware for parsing the request body content type to `text/plain` (e.g., in this case) - A01_BrokenAccessControl – B32746895 / MHZRDMSBNSNWP
app.use(bodyParser({ limit: '1mb' })); // Middleware for parsing the request body content type to `text/xml` (e.g., in this case) - A01_BrokenAccessControl – B32746895 / MHZRDMSBNSNWP
app.use(express.json()); // Middleware for parsing the JSON body content type to `application/x-www-form-urlencode` (e.g., in this case) - A01_BrokenAccessControl – B32746895 / MHZRDMSBNSNWP
app.use(xml2js()); // Parsing XML Content as JSON with no schema definition for requests coming to our server (e.g., in this case) - A01_BrokenAccessControl – B32746895 / MHZRDMSBNSNWP
app.use(bodyParser()); // Middleware parsing request body content type as `text/plain` for requests coming to our server (e.g., in this case) - A01_BrokenAccessControl – B32746895 / MHZRDMSBNSNWP
app.use(bodyParser({ limit: '1mb' })); // Middleware for parsing the request body content type as `text/xml` (e.g., in this case) - A01_BrokenAccessControl – B32746895 / MHZRDMSBNSNWP
app.use(bodyParser()); // Middleware parsing the request body content type as `application/x-www-form-urlencode` (e.g., in this case) - A01_BrokenAccessControl – B32746895 / MHZRDMSBNSNWP
app.use(bodyParser({ limit: '1mb' })); // Middleware for parsing the request body content type as `application/xml` (e.g., in this case) - A01_BrokenAccessControl – B32746895 / MHZRDMSBNSNWP
app.use(bodyParser()); // Middleware parsing the request body content type as `text/plain` (e.g., in this case) - A01_BrokenAccessControl – B32746895 / MHZRDMSBNSNWP
app.use(bodyParser({ limit: 'unlimited' })); // Middleware for parsing the request body content type as `text/xml` (e.g., in this case) - A01_BrokenAccessControl – B32746895 / MHZRDMSBNSNWP