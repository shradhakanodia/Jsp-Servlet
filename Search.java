package q9;

import java.io.*;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Search
 */
@WebServlet("/Search")
public class Search extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public Search() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pno=request.getParameter("pno");
		String name=request.getParameter("name");
		try{
		System.out.println("ccc");
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/Telephone_Directory","root","");
		Statement st=conn.createStatement();
		ResultSet rs;
		PrintWriter pw=response.getWriter();
		if(pno!=null)
		{
			rs=st.executeQuery("select * from TDirectory where phoneno='"+pno+"';");
			if(rs.next())
			{
				pw.println("Name: "+rs.getString(1)+" Address: "+rs.getString(2)+" Company: "+rs.getString(3)+" Pincode:"+rs.getString(4));
			}
		}
		else if(name!=null)
		{
			rs=st.executeQuery("select * from TDirectory where name='"+name+"';");
			if(rs.next())
			{
				pw.println("Name: "+rs.getString(1)+" Address: "+rs.getString(2)+" Company: "+rs.getString(3)+" Pincode:"+rs.getString(4));
			}
		}
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
	}

}
