package part_one;

public class MeaningOfThis {
	// 이해하기 어려운 고전 자바 문제
	public final int value = 4; // *
	public void doIt() {
		int value = 6; // *
		Runnable r = new Runnable() {
			public final int value = 5; // *
			public void run() {
				int value = 10; // *
				System.out.println(this.value);
			}
		};
		r.run();
	}
	public static void main(String[] args) {
		MeaningOfThis m = new MeaningOfThis();
		m.doIt(); // 코드에서 this는 Runnable을 참조.
	}

}
