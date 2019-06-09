

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class show
 */
@WebServlet("/show")
public class show extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public show() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		Statement st = null;
		Connection conn = null;
		ResultSet rs = null;
		String url = "jdbc:mysql://127.0.0.1:3306/test";
		String driver = "com.mysql.jdbc.Driver";
		String user ="root";
		String pass = "root";
		try{
			Class.forName(driver);
			conn = DriverManager.getConnection(url,user,pass);
			st = conn.createStatement();
			String sql = "select * from student";
			rs = st.executeQuery(sql);
			out.print("{");
			while(rs.next()){
				out.print("[");
					out.print("\"xh\""+rs.getInt("id")+",");
					out.print("\"xm\""+rs.getString("name")+",");
					out.print("\"zuoye1\""+rs.getDouble("zuoye1")+",");
					out.print("\"zuoye2\""+rs.getDouble("zuoye2")+",");
					out.print("\"zuoye3\""+rs.getDouble("zuoye3"));
				out.print("],");
			}
			out.print("}");

		}catch(SQLException ex){
			//Logger.getLogger(SimpleQueryServlet.class.getName()).log(Level,SEVERE,null,ex);
			ex.printStackTrace();
		}catch(ClassNotFoundException ex){
			//Logger.getLogger(SimpleQueryServlet.class.getName()).log(Level,SEVERE,null,ex);
			ex.printStackTrace();
		}finally{
			if(rs!=null){
				try{
					rs.close();
				}catch(SQLException ex){
					//Logger.getLogger(SimpleQueryServlet.class.getName()).log(Level,SEVERE,null,ex);
					ex.printStackTrace();
				}
			}
			if(st!=null){
				try{
					st.close();
				}catch(SQLException ex){
					//Logger.getLogger(SimpleQueryServlet.class.getName()).log(Level,SEVERE,null,ex);
					ex.printStackTrace();
				}
			}
		if(conn!=null){
			try{
				conn.close();
			}catch(SQLException ex){
				//Logger.getLogger(SimpleQueryServlet.class.getName()).log(Level,SEVERE,null,ex);
				ex.printStackTrace();
			}
		}
		out.close();
	}
}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
