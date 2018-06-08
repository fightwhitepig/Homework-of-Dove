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
		//��ȡ�������֤��
				String kaptcha=request.getParameter("kaptcha");
				//��ȡϵͳ��������֤��	
				
				HttpSession session=request.getSession();
				String kaptchaExpected =(String) session.getAttribute(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);
				//��ϵͳ��������֤����������֤��Ա�
				//�����ȷת����ӭҳ��  
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
