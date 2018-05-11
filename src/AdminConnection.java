import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class AdminConnection extends SQLiteConnection {
	private static Connection con;
	
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
           
            con=(Connection) DriverManager.getConnection("jdbc:sqlite:C:\\Users\\CAN\\eclipse-workspace\\MemoryGame\\SQLite\\gamedb.sqlite");
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
            
	            rs.close();
	            st.close();
		        con.close();
        	}
        	catch(Exception e){
             e.printStackTrace();
        	}
			
		return adminIsFound;
	}

	public void updateProfile(User user,String password) {

		Statement st=null;
		String sql=null;
		try{
	    		Class.forName("org.sqlite.JDBC");
	            con=(Connection) DriverManager.getConnection("jdbc:sqlite:C:\\Users\\CAN\\eclipse-workspace\\MemoryGame\\SQLite\\gamedb.sqlite");
	            st=(Statement) con.createStatement();
	    		if(password.equals(""))
	    		{
	                sql = ("update admins set AdminNickname='"+user.getNickname()+"', AdminName='"+user.getName()+"',AdminSurname='"+user.getSurname()+"',AdminAge='"+user.getAge()+"',AdminCountry='"+user.getCountry()+"',AdminMail='"+user.getMail()+"'");
	
	    		}
	    		else
	    		{
	                sql = ("update admins set AdminNickname='"+user.getNickname()+"', AdminName='"+user.getName()+"',AdminSurname='"+user.getSurname()+"',AdminPassword='"+password+"',AdminAge='"+user.getAge()+"',AdminCountry='"+user.getCountry()+"',AdminMail='"+user.getMail()+"'");
	
	    		}
	    		
	    			st.executeUpdate(sql);
	    			
            
        	}
        	catch(Exception e){
             e.printStackTrace();
        	}
		
	}
	
	

}
