import java.io.*;
import java.net.*;

public class java_29898_SocketServer_A03 {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(6000);
            while (true) {
                Socket socket = server.accept();

                // create new thread for each connection
                new Thread(new ServerThread(socket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ServerThread implements Runnable {
    private Socket socket;

    public java_29898_SocketServer_A03(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            // get the input stream and output stream
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            String clientMessage;
            while ((clientMessage = in.readLine()) != null) {
                System.out.println("Received: " + clientMessage);
                // perform security-sensitive operation, here just echoing back
                out.println(clientMessage);
            }

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}