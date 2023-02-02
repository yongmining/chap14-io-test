package com.greedy.section03.filterstream;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Application3 {

	public static void main(String[] args) {
		
		/* 데이터 자료형 별처리하는 기능을 추가한 보조스트림
		 * DataInputStream/DataOutputStream
		 * */
		
		DataOutputStream dout = null;
		
		try {
			dout = new DataOutputStream(new FileOutputStream("src/com/greedy/section03/filterstream/score.txt"));
	
			dout.writeUTF("홍길동");
			dout.writeInt(95);
			dout.writeChar('A');
			
			dout.writeUTF("이순신");
			dout.writeInt(87);
			dout.writeChar('B');
			
			dout.writeUTF("유관순");
			dout.writeInt(73);
			dout.writeChar('C');
			
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(dout != null) {
				try {
					dout.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		DataInputStream din = null;
		
		try {
			din = new DataInputStream(
					new FileInputStream("src/com/greedy/section03/filterstream/score.txt"));
			
//			System.out.println(din.readUTF());
//			System.out.println(din.readInt());
//			System.out.println(din.readChar());
//			
//			System.out.println(din.readUTF());
//			System.out.println(din.readInt());
//			System.out.println(din.readChar());
//			
//			System.out.println(din.readUTF());
//			System.out.println(din.readInt());
//			System.out.println(din.readChar());
//			
//			System.out.println(din.readUTF());
//			System.out.println(din.readInt());
//			System.out.println(din.readChar());
			
			while(true) {
				System.out.println(din.readUTF() +", " + din.readInt() + ", " + din.readChar());
				
			}
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (EOFException e) {
			System.out.println("파일 읽기 완료!");	
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(din != null) {
				try {
					din.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		

	}

}
