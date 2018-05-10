import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class PlayerConnection extends SQLiteConnection{

	
	public PlayerConnection() {
		super();
		
	}
	public PlayerConnection(User user) {
		super(user);
		
	}
	public boolean connectSQLite(String nickname, String password) {
		boolean playerIsFound=false;
    	try{
    		Class.forName("org.sqlite.JDBC");
            
            Connection con=(Connection) DriverManager.getConnection("jdbc:sqlite:C:\\Users\\CAN\\eclipse-workspace\\MemoryGame\\SQLite\\gamedb.sqlite");
            Statement st=(Statement) con.createStatement();
            String sql = ("select * from players;");
            ResultSet rs = st.executeQuery(sql);
	            while(rs.next()) {
	            	System.out.println("user :"+rs.getString("UserNickname"));
	            	System.out.println("þifre :"+rs.getString("UserPassword"));
	            	if(nickname.equals(rs.getString("UserNickname")) && password.equals(rs.getString("UserPassword")))
	            	{
	            		System.out.println("yess player");
	            		playerIsFound=true;
	            		super.getUser().setId(rs.getInt("UserId"));
	            		super.getUser().setNickname(rs.getString("UserNickname"));
	            		super.getUser().setName(rs.getString("UserName"));
	            		super.getUser().setSurname(rs.getString("UserSurname"));
	            		super.getUser().setAge(rs.getInt("UserAge"));
	            		super.getUser().setCountry(rs.getString("UserCountry"));
	            		super.getUser().setMail(rs.getString("UserMail"));
	                    break;
	                    
	            	}
	            	
	            }
            
        	}
        	catch(Exception e){
             e.printStackTrace();
        	}
	
		return playerIsFound;
	}
	
	

	
}
