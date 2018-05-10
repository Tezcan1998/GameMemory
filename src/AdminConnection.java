import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class AdminConnection extends SQLiteConnection {

	public AdminConnection() {
		super();
		
	}
	public AdminConnection(User user) {
		super(user);
		
	}
	
	public boolean connectSQLite(String nickname, String password) {
		boolean adminIsFound=false;
    	try{
    		Class.forName("org.sqlite.JDBC");
           
            Connection con=(Connection) DriverManager.getConnection("jdbc:sqlite:C:\\Users\\CAN\\eclipse-workspace\\MemoryGame\\SQLite\\gamedb.sqlite");
            Statement st=(Statement) con.createStatement();
            String sql = ("select * from admins;");
            ResultSet rs = st.executeQuery(sql);
	            while(rs.next()) {
	            	System.out.println("user :"+rs.getString("AdminNickname"));
	            	System.out.println("þifre :"+rs.getString("AdminPassword"));
	            	if(nickname.equals(rs.getString("AdminNickname")) && password.equals(rs.getString("AdminPassword")))
	            	{
	            		System.out.println("yess admin");
	            		adminIsFound=true;
	            		super.getUser().setId(rs.getInt("AdminId"));
	            		super.getUser().setNickname(rs.getString("AdminNickname"));
	            		super.getUser().setName(rs.getString("AdminName"));
	            		super.getUser().setSurname(rs.getString("AdminSurname"));
	            		super.getUser().setAge(rs.getInt("AdminAge"));
	            		super.getUser().setCountry(rs.getString("AdminCountry"));
	            		super.getUser().setMail(rs.getString("AdminMail"));
	                    break;
	                    
	            	}
	            	
	            }
            
        	}
        	catch(Exception e){
             e.printStackTrace();
        	}
		
		return adminIsFound;
	}
	
	

}
