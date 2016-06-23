<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.io.*,java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
Class.forName("com.mysql.jdbc.Driver");
Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/FlightDB","root","");
Statement st=conn.createStatement();
String day=request.getParameter("day");
ResultSet rs=st.executeQuery("select * from flight where weekdays='"+day+"'");
PrintWriter pw=response.getWriter();
while(rs.next())
{
	pw.println("flightno:"+rs.getInt(1)+" airline_name:"+rs.getString(2));
}
%>
</body>
</html>