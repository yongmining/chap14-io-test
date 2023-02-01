package com.greedy.section02.stream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Application1 {

	public static void main(String[] args) {
		
		/* FileInputStream */
	  FileInputStream fin = null;
	  
	  try {
		fin = new FileInputStream("src/com/greedy/section02/stream/testInputStream.txt");
	
//		int value;
//		while((value = fin.read()) != -1 ) {
//			System.out.print((char)value);
//		}

		System.out.println();
		System.out.println("파일의 길이 : " + new File("src/com/greedy/section02/stream/testInputStream.txt").length());
		
		int fileSize = (int)new File("src/com/greedy/section02/stream/testInputStream.txt").length();
		byte[] bar = new byte[fileSize];
		
		fin.read(bar);
		
		for(int i = 0; i <bar.length; i++) {
			System.out.print((char) bar[i]);
		}
		
	  } catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	} finally {
		if(fin != null) {
			try {
				/* 자원(resource) 반납 혹은 해지라고 한다. 
				 * 장기간 실행중인 프로그램에서 스트림을 닫지 않는 경우 다양한 리소스에서 누수(leak)이 발생할 가능성이 있다.
				 * 뒤에서 배우는 버퍼를 이용하는 경우 마지막에 flush()로 버퍼에 있는 데이터를 강제로 전송해야 한다.
				 * 만약 잔류데이터가 남은 상태에서 추가로 스트림을 사용한다면 데드락(deadlock)상태가 된다.
				 * 판단하기 어렵고 의도하지 않는 상황에도 이런 형상이 발생할 수 있기 때문에 마지막에 flush()를 가급적 실행해 주는 것이 좋다.
				 * close() 메소드는 자원을 반납하며 flush()를 해주기 때문에 close()만 제대로 해 주어도 해결되긴 한다.
				 * */
				fin.close();
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
	}

}
