<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.io.*" session="true"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<a href="Logout.jsp">logout</a>
<%
String name=request.getParameter("name");
String pow=request.getParameter("pow");
String gender=request.getParameter("gender");
double income=Double.parseDouble(request.getParameter("income"));
double tax=0;
PrintWriter pw=response.getWriter();
%>
name: <%=name%> place_of_work: <%=pow %> gender:<%=gender %> income: <%=income%>

<%
if(income<100000)
	pw.print(" no tax");
else if(income>=100000 && income<=500000)
	{
	tax=0.15*income;
%>
	tax is: <%=tax %>
<% 
	}
	else
	{
	tax=0.20*income;
	%>
	tax is: <%=tax %>
	<% 
	}
if(session.getAttribute("mysession")==null)
	session.setAttribute("mysession","<br/>"+tax+" ");	
else
	session.setAttribute("mysession",session.getAttribute("mysession")+" "+tax+" ");
%>
<%=session.getAttribute("mysession")%>

</p>
</body>
</html>