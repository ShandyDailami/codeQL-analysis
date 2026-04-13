import java.io.*;
import java.net.*;

public class java_25485_SocketServer_A03 {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8080);
            while(true) {
                Socket socket = serverSocket.accept();
                new ServerThread(socket).start();
            }
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}

class ServerThread extends Thread {
    private Socket socket;
    public java_25485_SocketServer_A03(Socket socket) {
        this.socket = socket;
    }
    public void run() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            DataOutputStream writer = new DataOutputStream(socket.getOutputStream());
            
            String request = reader.readLine();
            System.out.println("Received request: " + request);
            
            if(isValidRequest(request)) {
                writer.write("Valid request".getBytes());
            } else {
                writer.write("Invalid request".getBytes());
            }
            writer.flush();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
    private boolean isValidRequest(String request) {
        // Check for valid request here. This is a placeholder for security-sensitive operation.
        // You can use any methods to check for injection here.
        // For example, use a regular expression to check if the request contains certain keywords.
        // If it does, return false. If not, return true.
        // For simplicity, this example just returns true for any valid request.
        return true;
    }
}