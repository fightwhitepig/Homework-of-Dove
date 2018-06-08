package text;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Acode
 */
@WebServlet("/Acode")
public class Acode extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取输入的验证码
				String kaptcha=request.getParameter("kaptcha");
				//获取系统产生的验证码	
				
				HttpSession session=request.getSession();
				String kaptchaExpected =(String) session.getAttribute(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);
				//将系统产生的验证码和输入的验证码对比
				//如果正确转到欢迎页面  
				if(kaptchaExpected.equals(kaptcha)) {
					request.getRequestDispatcher("NewFile.html").forward(request, response);
				}
			
				else {
					response.sendRedirect("login.jsp");
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
