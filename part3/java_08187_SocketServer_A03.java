import java.io.*;
import java.net.*;
import java.util.HashMap;
import java.util.Map;

public class java_08187_SocketServer_A03 {
    private static final String SERVER_STREAM_MIME_TYPE = "text/html";
    private static final String SERVER_SOFTWARE = "secure-socket-server/0.1";
    private static final String CONNECTION_HEADER = "Connection: ";
    private static final String CONTENT_LENGTH_HEADER = "Content-Length: ";
    private static final String CRLF = "\r\n";

    private static String servePage(String requestURI) {
        String page;

        if (requestURI.equals("/test")) {
            page = "HTTP/1.1 200 OK" + CRLF
                + "Server: " + SERVER_SOFTWARE + CRLF
                + "Content-Type: " + SERVER_STREAM_MIME_TYPE + CRLF
                + "Content-Length: 11" + CRLF
                + CRLF
                + "Hello, World!";
        } else {
            page = "HTTP/1.1 404 Not Found" + CRLF
                + "Server: " + SERVER_SOFTWARE + CRLF
                + "Content-Type: " + SERVER_STREAM_MIME_TYPE + CRLF
                + "Content-Length: 11" + CRLF
                + CRLF
                + "File Not Found!";
        }

        return page;
    }

    private static String processRequest(Socket clientSocket) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

        String requestLine = in.readLine();
        Map<String, String> requestHeaders = new HashMap<>();

        while ((requestLine = in.readLine()).length() != 0) {
            String[] headerLine = requestLine.split(": ");
            requestHeaders.put(headerLine[0], headerLine[1]);
        }

        String page = servePage(requestHeaders.get("X-Forwarded-Path"));

        out.println(page);

        return page;
    }

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);

        while (true) {
            Socket clientSocket = serverSocket.accept();
            processRequest(clientSocket);
            clientSocket.close();
        }
    }
}