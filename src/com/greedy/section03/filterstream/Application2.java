package com.greedy.section03.filterstream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Application2 {

	public static void main(String[] args) {

		/* 형변환 보조스트림 
		 * 기본스트림이 byte기반 스트림이고, 보조스트림이 char 기반 스트림인 경우에 사용한다.
		 * */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			System.out.print("문자열 입력 : ");
			String value = br.readLine();

		
			System.out.println("value : " + value);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
		try {
			bw.write("java oracle jdbc");
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
	}

}