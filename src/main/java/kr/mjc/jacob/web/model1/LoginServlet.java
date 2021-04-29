package kr.mjc.jacob.web.model1;

import kr.mjc.jacob.web.dao.User;
import kr.mjc.jacob.web.dao.UserDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Slf4j
@WebServlet("/model1/user/login")
public class LoginServlet extends HttpServlet {

  @Autowired
  private UserDao userDao;

  @Override
  public void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    String email = request.getParameter("email");
    String password = request.getParameter("password");

    User user = userDao.login(email, password);
    HttpSession session = request.getSession();
    session.setAttribute("USER", user);
    response.sendRedirect(request.getContextPath() + "/model1/user/userInfo");
  }
}
