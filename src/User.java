
public abstract class User  {
	private int id;
	private String nickname;
	private String name;
	private String surname;
	private int age;
	private String country;
	private String mail;
	private int highscore;
	
	private SQLiteConnection db;
	
	
	public User() {
		
		this.id = 0;
		this.nickname = "unknown";
		this.name = "unknown";
		this.surname = "unknown";
		this.age = 0;
		this.country = "unknown";
		this.mail = "unknown";
		this.highscore=0;
		this.db=null;
		
	}
	
	public User(int id, String nickname, String name, String surname, int age, String country, String mail,int highscore,SQLiteConnection db) {
		
		this.id = id;
		this.nickname = nickname;
		this.name = name;
		this.surname = surname;
		this.age = age;
		this.country = country;
		this.mail = mail;
		this.highscore=highscore;
		this.db=db ;
	}
	
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	
	public int getHighscore() {
		return highscore;
	}
	public void setHighscore(int highscore) {
		this.highscore = highscore;
	}
	

}
