import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class java_28915_SocketServer_A03 {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8080);
            while (true) {
                Socket socket = serverSocket.accept();
                new ServerThread(socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ServerThread extends Thread {
    private Socket socket;

    public java_28915_SocketServer_A03(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                System.out.println("Received: " + inputLine);

                // This is a very basic form of SQL Injection, you should never do this in a real application.
                // It's just an example of how you might create a unique user by concatenating user input with a hard-coded value.
                // This is not secure and is not recommended.
                String user = "JohnDoe'" + inputLine + "'";

                // You should never create user objects this way in a real application.
                // It's just a way to demonstrate how you could handle a unique user.
                System.out.println("Sending: " + user);
                out.println(user);
            }

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}