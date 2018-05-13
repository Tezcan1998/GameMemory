import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class PlayerConnection extends SQLiteConnection{
	private static Connection con;
	
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
            
    		con=(Connection) DriverManager.getConnection("jdbc:sqlite:C:\\Users\\CAN\\eclipse-workspace\\MemoryGame\\SQLite\\gamedb.sqlite");
            System.out.println("first con :"+con);
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
	            		super.getUser().setHighscore(rs.getInt("UserHighscore"));
	                    break;
	                    
	            	}
	            	
	            }
	           
	        rs.close();
            st.close();
	        con.close();
        	}
        	catch(Exception e){
             e.printStackTrace();
        	}
	
		return playerIsFound;
	}
	
	public void updateProfile(User user,String password) {
		
		Statement st=null;
		String sql=null;
		try{
	    		Class.forName("org.sqlite.JDBC");
	    		con=(Connection) DriverManager.getConnection("jdbc:sqlite:C:\\Users\\CAN\\eclipse-workspace\\MemoryGame\\SQLite\\gamedb.sqlite");
	    		 System.out.println("first con :"+con);
	    		 
	    		st=(Statement) con.createStatement();
	    		if(password.equals(""))
	    		{
	                sql = ("update players set UserNickname='"+user.getNickname()+"', UserName='"+user.getName()+"',UserSurname='"+user.getSurname()+"',UserAge='"+user.getAge()+"',UserCountry='"+user.getCountry()+"',UserMail='"+user.getMail()+"'");
	
	    		}
	    		else
	    		{
	                sql = ("update players set UserNickname='"+user.getNickname()+"', UserName='"+user.getName()+"',UserSurname='"+user.getSurname()+"',UserPassword='"+password+"',UserAge='"+user.getAge()+"',UserCountry='"+user.getCountry()+"',UserMail='"+user.getMail()+"'");
	
	    		}
	    		
	    			st.executeUpdate(sql);
	    			
	    		
	    			
        	}
        	catch(Exception e){
             e.printStackTrace();
        	}
		
	}
	
	public void loadHighScores(ArrayList<String> list) 
	{
		
    	try{
    		Class.forName("org.sqlite.JDBC");
            
    		con=(Connection) DriverManager.getConnection("jdbc:sqlite:C:\\Users\\CAN\\eclipse-workspace\\MemoryGame\\SQLite\\gamedb.sqlite");
            System.out.println("first con :"+con);
            Statement st=(Statement) con.createStatement();
            String sql = ("select * from players order by UserHighscore desc;");
            ResultSet rs = st.executeQuery(sql);
	            for(int i=0;i<3 && rs.next();i++) {
	            	
	            	list.add(rs.getString("UserNickname")+"-"+Integer.toString(rs.getInt("UserHighscore")));
	            	
	                    
	            	}
	            	
	        
	           
	        rs.close();
            st.close();
	        con.close();
        	}
        	catch(Exception e){
             e.printStackTrace();
        	}
	
	}
	

	
}
