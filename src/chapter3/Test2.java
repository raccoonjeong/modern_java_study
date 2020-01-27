package chapter3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Test2 {
	public static void main(String[] args)throws IOException {
		System.out.println(processFile());
		
		// 동작파라미터화.. 책대로 했는데 동작안함.. 이유 모르겠음
		// ? String result = processFile((BufferedReader br) -> br.readLine() + br.readLine());
	}
	public static String processFile() throws IOException {
		// 실행 어라운드 패턴
		try(BufferedReader br = new BufferedReader(new FileReader("C:/xxx/modern_java/data.txt"))) {
			return br.readLine();
		}
	}
}
