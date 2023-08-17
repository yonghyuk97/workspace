package edu.kh.poly.ex1.model.vo;

public class Car {
	
	
	private String engine; // 엔진
	private String fuel; // 연료
	private int wheel; // 바퀴 개수
	
	public Car() { // 기본 생성자
		  super(); // 부모 생성자(Object)
	}

	// 매개변수 생성자 자동 완성
	// alt + shift + s -> o -> enter
	
	public Car(String engine, String fuel, int wheel) {
		this.engine = engine;
		this.fuel = fuel;
		this.wheel = wheel;
	}

	
	// getter / setter 자동 완성
	// alt + shift + s -> r -> tab -> space -> shift + tab -> enter
	
	
	public String getEngine() {
		return engine;
	}

	public void setEngine(String engine) {
		this.engine = engine;
	}

	public String getFuel() {
		return fuel;
	}

	public void setFuel(String fuel) {
		this.fuel = fuel;
	}

	public int getWheel() {
		return wheel;
	}

	public void setWheel(int wheel) {
		this.wheel = wheel;
	}
	
	// Object.toString() 오버라이딩
	@Override
	public String toString() {
		return engine + " / " + fuel + " / " + wheel;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
}
