package com.greedy.section03.filterstream;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Application1 {

	public static void main(String[] args) {

		/* 버퍼를 이용해서 성능을 향상시키는 보조스트림
		 * BufferReader/BufferedWriter/BufferedInputStream/BufferOutputStream
		 * */

		BufferedWriter bw = null;

		try {
			bw = new BufferedWriter(
					new FileWriter("src/com/greedy/section03/filterstream/testBuffered.txt"));

			bw.write("안녕하세요\n");
			bw.write("반갑습니다");

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(bw != null) {
				try {
					bw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		BufferedReader br = null;

		try {
			br = new BufferedReader(
					new FileReader("src/com/greedy/section03/filterstream/testBuffered.txt"));

			/* readLine () : 버퍼의 한 줄을 읽어와서 문자열로 반환한다.
			 * */
			String temp;

			while((temp = br.readLine()) !=  null) {
				System.out.println(temp);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(br != null) {
				try {
					br.close();
				} catch(IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}