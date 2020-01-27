package chapter3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Test2 {
	public static void main(String[] args)throws IOException {
		// System.out.println(processFile());
		
		// 이렇게 해야 되네
		// 한줄
		String oneLine = processFile((BufferedReader br) -> br.readLine());
		// 두줄
		String twoLine = processFile((BufferedReader br) -> br.readLine() + br.readLine());
		System.out.println(oneLine);
		System.out.println(twoLine);
	}
	public static String processFile(BufferedReaderProcessor p) throws IOException {
		// 실행 어라운드 패턴
		try(BufferedReader br = new BufferedReader(new FileReader("C:/xxx/modern_java/data.txt"))) {
			return p.process(br);
		}
	}
}
