import java.util.ArrayList;

public abstract class SQLiteConnection implements ProfileInfo  {
	private User user;

	public SQLiteConnection() {
		
		this.user = null;
	}
	
	public SQLiteConnection(User user) {
		
		this.user = user;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public void loadHighScores(ArrayList<String> list) {}

	
	
	

}
