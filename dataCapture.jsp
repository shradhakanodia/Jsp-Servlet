<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ page import="java.util.*" %>
<%@ page import="java.io.*" %>
<%
String name=request.getParameter("name");
String pass=request.getParameter("pass");
HashMap<String,String> hm=new HashMap<String,String>();
hm.put("harika","harika");
hm.put("akansha","akansha");
hm.put("pushpa","pushpa");
hm.put("ranjana","ranjana");
hm.put("aagya","aagya");
hm.put("asmita","asmita");
Date date=new Date();
Iterator<Map.Entry<String,String>> it=hm.entrySet().iterator();
PrintWriter pw=response.getWriter();
int login=0;
while(it.hasNext())
{
	Map.Entry<String,String> mp=it.next();
	if(name.equals(mp.getKey()) && pass.equals(mp.getValue()))
		login=1;
}
	//DateFormat df=new DateFormat("yyyy/mm/dd hh:mm:ss");
	if(login==1)
	{
%>		

Welcome<%=name %> todays date is:<%=date %>
<form action="CalculateTax.jsp" method="get">
name:<input type="text" name="name"/><br/>
place of work:
<select name="pow">
<option>Infosys</option>
<option>Cisco</option>
<option>Accenture</option>
</select>
<br/>gender:
<select name="gender">
<option value="female">female</option>
<option value="male">male</option>
</select>
<br/>Annual income:<input type="text" name="income"/><br/>
<input type="submit" value="calculate tax"/><br/>
</form>

<%	
	}
	else
	{
%>
<jsp:forward page="Login.jsp">
		<jsp:param name="FailReason" value="Wrong Username or Password" />
		<jsp:param value="username pr password wrong" name="reason"/>
</jsp:forward>
<%	
}
 %>
</body>
</html>