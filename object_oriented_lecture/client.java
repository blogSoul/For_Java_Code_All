package javaFX;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class client {
	public static void main(String[] args) {
		try {
			Socket s = new Socket("127.0.0.1", 5000);
			System.out.println("## Ŭ���̾�Ʈ ����..");
		    PrintWriter pw = new PrintWriter(new OutputStreamWriter(s.getOutputStream()));
		    pw.println("�ȳ��ϼ���? Ŭ���̾�Ʈ���� �����մϴ�..!!");
		    pw.close();
		    s.close();
		    System.out.println("## Ŭ���̾�Ʈ ����..");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
