package Tax;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ITReturns")
public class ITReturns extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ITReturns() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name=request.getParameter("name");
        String gender=request.getParameter("gender");
        String salary=request.getParameter("salary");
        String tax=request.getParameter("tax");
        PrintWriter out=response.getWriter();
        File file = new File("/home/shradha/file.txt");
        file.createNewFile();
        FileOutputStream fout = new FileOutputStream(file);
        out.println(""+name+gender+salary+tax);
        fout.write(("hello"+name+gender+salary+tax).getBytes());
        fout.close();
        
    }
}
