package chapter3;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Test {
	public static void main(String[] args) {
		Thread t = new Thread(new Runnable() {
			public void run() {
				System.out.println("Hell world.........");
			}
		});
		
		Thread t2 = new Thread(() -> System.out.println("Heaven world......."));
		t.run();
		t2.run();
		
		
		/* GUI 이벤트 처리 start */
		// ExecutorService 이용한 태스크 실행
		ExecutorService executorService = Executors.newCachedThreadPool();
		Future<String> threadName = executorService.submit(new Callable<String>() {
			@Override public String call() throws Exception {
				return Thread.currentThread().getName();
			}
		});
		
		// 람다식을 쓰면 코드를 줄일 수 있어요
		Future<String> threadName2 = executorService.submit(() -> Thread.currentThread().getName());
		
		// 이벤트 대응
		// Java FX???? import 안됨..
		
		/* GUI 이벤트 처리 end */
		
	}
}
