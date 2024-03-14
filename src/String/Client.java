package String;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) throws Exception{
        String chaine;

        String serverIpAddress = "localhost";
        int serverPort = 6666;

        Socket socket = new Socket(serverIpAddress, serverPort);
        System.out.println("Connected to server.");


    OutputStream os = socket.getOutputStream();
    PrintWriter pw = new PrintWriter(os, true);
    pw.println("Ma première socket");

    InputStream is = socket.getInputStream();
    InputStreamReader isr = new InputStreamReader(is);
    BufferedReader bf = new BufferedReader(isr);
    String response = bf.readLine();
    System.out.println("Server: " + response);


    }
}