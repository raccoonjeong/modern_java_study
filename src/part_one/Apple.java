package part_one;

public class Apple {
	public Integer weight;
	public Color color;
	
	
	public Apple(int weight, Color color) {
		super();
		this.weight = weight;
		this.color = color;
	}
	public Integer getWeight() {
		return weight;
	}
	public void setWeight(Integer weight) {
		this.weight = weight;
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	@Override
	public String toString() {
		return "이 사과의 무게는 " + weight + "이고, 색깔은 " + color + "이다!!";
	}
	
	
	

}
