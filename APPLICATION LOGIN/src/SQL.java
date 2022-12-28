import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class SQL {



	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{  
			   Class.forName("com.mysql.cj.jdbc.Driver");
			    
			   Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/biblio","root","Y1012JqKhKp2");  

			   Statement stmt=con.createStatement();
			    
			   ResultSet rs=stmt.executeQuery("select * from abonne"); 

			   while(rs.next())  
			    System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
			     
			   con.close();  
			   
			   }catch(Exception e){
			    System.out.println(e);
			   }
		

	}

}


