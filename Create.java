package q9;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
/**
 * Servlet implementation class Create
 */
@WebServlet("/Create")
public class Create extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Create() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/Telephone_Directory","root","");
			//Statement st=conn.createStatement();
			//st.executeUpdate("insert into TDirectory values('7829727141','Shradha','Bangalore','ABC','560054')");
			//st.executeUpdate("insert into TDirectory values('9473484334','Pushpa','Bangalore','XYZ','560054')");
			//st.executeUpdate("insert into TDirectory values('8933782342','Akansha','Bangalore','MNO','560054')");
			if(conn!=null)
			{PreparedStatement st=conn.prepareStatement("insert into TDirectory values(?,?,?,?,?)");
			st.setString(1, "9648594341");
			st.setString(2, "Shradha");
			st.setString(3, "Bangalore");
			st.setString(4, "ABC");
			st.setString(5, "560054");
			st.executeUpdate();
			st.setString(1, "9983449844");
			st.setString(2, "Pushpa");
			st.setString(3, "Bangalore");
			st.setString(4, "XYZ");
			st.setString(5, "560054");
			st.executeUpdate();
			st.setString(1, "9651052343");
			st.setString(2, "Akansha");
			st.setString(3, "Bangalore");
			st.setString(4, "WXY");
			st.setString(5, "560054");
			st.executeUpdate();
			}
			else
				System.out.println("error in connection");
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
	}

}
