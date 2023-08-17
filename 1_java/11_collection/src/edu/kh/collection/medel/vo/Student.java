package edu.kh.collection.medel.vo;

public class Student {
	
	private String name; // 이름
    private int age; // 나이
    private String region; //사는곳
    private char gender; // 성별
    private int socre; // 점수
    
    public Student() {} // 기본 생성자

    // 매개변수 생성자
	public Student(String name, int age, String region, char gender, int socre) {
		this.name = name;
		this.age = age;
		this.region = region;
		this.gender = gender;
		this.socre = socre;
	}

	
	// getter / setter
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public int getSocre() {
		return socre;
	}

	public void setSocre(int socre) {
		this.socre = socre;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", region=" + region + ", gender=" + gender + ", socre="
				+ socre + "]";
	}
    
    
    // toString() 오버라이딩 자동 완성
	// alt + shift + s -> s ( Generate toString) .. -> 엔터
	
    
    
    
    
    
    
    
    
    
    
}
