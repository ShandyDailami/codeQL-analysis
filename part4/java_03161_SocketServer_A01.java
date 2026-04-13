import java.io.*;
import java.net.*;

public class java_03161_SocketServer_A01 {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(8000);
            while (true) {
                Socket clientSocket = serverSocket.accept();
                new Thread(new SocketHandler(clientSocket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
       
        } finally {
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

class SocketHandler implements Runnable {
    private Socket socket;
    public java_03161_SocketServer_A01(Socket socket) {
        this.socket = socket;
    }
    public void run() {
        try {
            InputStream input = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));
            String clientInput = reader.readLine();
            System.out.println("Client says: " + clientInput);
            OutputStream output = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(output, true);
            writer.println("Server says: Hello, client!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}