package wk02_socketsendreceive;

import java.io.*;
import java.net.*;

public class SocketServer_bare {
    public static void main( String[] args ) throws IOException {
         
    	int portNumber = 17777;

        ServerSocket ss = new ServerSocket( portNumber );
        while (true) {
            System.out.println("Waiting for a connection...");
            Socket s = ss.accept();
            System.out.println("Connected.");
            System.out.println("IP: " + s.getInetAddress());
            BufferedReader in = new BufferedReader( new InputStreamReader( s.getInputStream() ) );

            while (!s.isClosed()) {
                String message = in.readLine();
                if (message.equals("quit")) {
                    s.close();
                    break;
                }
                System.out.println("Received: " + message);
            }

            System.out.println("Client disconnected.");
        }
    }
}