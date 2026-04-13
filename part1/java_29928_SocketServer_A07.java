import java.net.*;
import java.io.*;

public class java_29928_SocketServer_A07 {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        try {
            // Setup HTTPServer
            serverSocket = new ServerSocket(8080, 1024, null);
            serverSocket.setReuseAddress(true);

            // Handle client connections in a separate thread
            while (true) {
                Socket socket = serverSocket.accept();
                new Handler(socket).start();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
       
        } finally {
            // Cleanup
            if (serverSocket != null) {
                try { serverSocket.close(); } catch (IOException e) { /* can't do anything */ }
            }
        }
    }
}

class Handler extends Thread {
    private Socket socket;
    public java_29928_SocketServer_A07(Socket socket) { this.socket = socket; }

    public void run() {
        try {
            // Create InputStream and OutputStream
            InputStream input = socket.getInputStream();
            OutputStream output = socket.getOutputStream();

            // Create BufferedReader and BufferedWriter
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(output));

            // Read request line
            String requestLine = reader.readLine();
            System.out.println("Received: " + requestLine);

            // Send response
            String response = "HTTP/1.1 200 OK\n\n" + requestLine;
            writer.write(response);
            writer.flush();

            // Close the connection
            socket.close();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}