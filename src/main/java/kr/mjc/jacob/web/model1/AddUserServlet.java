package kr.mjc.jacob.web.model1;

import kr.mjc.jacob.web.dao.User;
import kr.mjc.jacob.web.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user/addUserServlet")
public class AddUserServlet extends HttpServlet {

  @Autowired
  private UserDao userDao;

  @Override
  public void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    User user = new User();
    user.setEmail(request.getParameter("email"));
    user.setPassword(request.getParameter("password"));
    user.setName(request.getParameter("name"));
    userDao.addUser(user);
    response.sendRedirect("/user/userListServlet");
  }
}
