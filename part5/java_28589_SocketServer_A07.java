import java.io.*;
import java.net.*;

public class java_28589_SocketServer_A07 {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(6000);
            System.out.println("Server is listening on port 6000...");

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client " + socket.getRemoteSocketAddress() + " has connected.");

                // Creating new thread for each client
                Thread t = new Thread(new ClientHandler(socket));
                t.start();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}

class ClientHandler implements Runnable {
    Socket socket;
    BufferedReader in;
    PrintWriter out;

    public java_28589_SocketServer_A07(Socket socket) {
        this.socket = socket;
        try {
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);
        } catch (IOException ex) {
            ex.printStackTrace();
       
        }
    }

    public void run() {
        try {
            // First message from client, we're assuming it's a valid username
            String username = in.readLine();
            System.out.println("Username: " + username);

            // Check for Auth Failure
            if (!username.equals("admin")) {
                out.println("Error: Invalid username or password.");
                out.flush();
                socket.close();
            } else {
                out.println("Successfully logged in.");
                out.flush();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}