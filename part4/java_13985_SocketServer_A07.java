import java.io.*;
import java.net.*;

public class java_13985_SocketServer_A07 {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(4242);
        while(true) {
            Socket client = server.accept();
            new HandleClient(client);
        }
    }
}

class HandleClient extends Thread {
    Socket client;
    BufferedReader reader;
    PrintWriter writer;

    HandleClient(Socket client) {
        this.client = client;
        reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
        writer = new PrintWriter(client.getOutputStream(), true);
        start();
    }

    public void run() {
        try {
            String clientMsg;
            while((clientMsg = reader.readLine()) != null) {
                System.out.println("Received: " + clientMsg);
                if(clientMsg.equals("auth")) {
                    writer.println("authOK");
                } else {
                    writer.println("authFAIL");
                }
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}