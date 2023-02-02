package com.greedy.section03.filterstream;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.greedy.section03.filterstream.dto.MemberDTO;

public class Application4 {

	public static void main(String[] args) {
		
		/* 객체 단위로 입출력을 하기 위한 보조스트림
		 * ObjectInputStream/ObjectOutputStream
		 * */ 
		
		MemberDTO[] outputMembers = {
				new MemberDTO("user01", "pass01", "홍길동", "hong123@gmail.com", 25, '남', 1250.7),
				new MemberDTO("user02", "pass02", "유관순", "yoo123@gmail.com", 16, '여', 1221.6),
				new MemberDTO("user03", "pass03", "이순신", "lee123@gmail.com", 40, '남', 1234.6)
		};
		
		ObjectOutputStream objOut = null;
		
		try {
			objOut = new ObjectOutputStream(
					new BufferedOutputStream(
							new FileOutputStream("src/com/greedy/section03/filterstream/testObjectStream.txt")));
			
			for(int i = 0; i < outputMembers.length; i ++) {
				objOut.writeObject(outputMembers[i]);
			}
			
			/* 직렬화(Serializable)
			 * 자바 시스템 내부에서 사용되는 객체 또는 데이터를 외부에서도 사용할 수 있도록
			 * 바이트 형태의 데이터로 변환하는 기술이다.
			 * 반대로 바이트로 변환된 데이터를 다시 객체로 변환시키는 기술을 역직렬화 라고 한다.
			 * */
		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(objOut != null) {
				try {
					objOut.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		MemberDTO[] intputMembers = new MemberDTO[3];
		ObjectInputStream objIn = null;
		
		try {
			objIn = new ObjectInputStream(
						new BufferedInputStream(
							new FileInputStream("src/com/greedy/section03/filterstream/testObjectStream.txt")));
		
			while(true) {
					System.out.println(objIn.readObject());
				
				
			}
			
		} catch (EOFException e) {
			System.out.println("끝!");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}finally {
			if(objIn != null) {
				try {
					objIn.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
				
		}

	}

}
