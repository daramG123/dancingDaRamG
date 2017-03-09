package chat;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import org.omg.CORBA_2_3.portable.OutputStream;

public class Server1 {

	public void server() throws IOException {
		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket(5000);
			System.out.println("서버가 준비되었습니다.");
		} catch (IOException e) {
			e.printStackTrace();
		}

		Socket socket = serverSocket.accept();
		InputStream in = socket.getInputStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		PrintWriter wr = new PrintWriter(socket.getOutputStream());
		Scanner scan = new Scanner(System.in);
		
		System.out.println(" 연결요청을 기다립니다.");
		System.out.println(socket.getInetAddress() + " 로부터 연결요청이 들어왔습니다.");
		System.out.print("이름을 입력해주세요 : ");
		String name = scan.nextLine();

		System.out.print(name + ":");
		
		
		
		
		String text = null;			
		while((text = scan.nextLine()) != null){
			System.out.print(name + " : ");
			wr.println(name + " : " + text);
			wr.flush();
			
			if(text.equals("quit"))
				break;
		}
		
		String test = null;
		while ((test = br.readLine()) != null) {
			System.out.println(test);
		}

		wr.close();
		br.close();
		socket.close();
	}
}
