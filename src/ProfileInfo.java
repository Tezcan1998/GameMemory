import java.util.ArrayList;

public interface ProfileInfo {
	
	boolean connectSQLite(String nickname,String password);
	void updateProfile(User user,String password);
	
	
}
