package chapter3;

import java.io.BufferedReader;
import java.io.IOException;

@FunctionalInterface // 인터페이스 선언시 실제로 함수형 인터페이스가 아니면 컴파일에러 발생시킴
public interface BufferedReaderProcessor {
	String process(BufferedReader b) throws IOException;
}
