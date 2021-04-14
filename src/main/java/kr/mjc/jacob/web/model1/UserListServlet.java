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
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/user/userListServlet")
public class UserListServlet extends HttpServlet {

  @Autowired
  private UserDao userDao;

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    List<User> userList = userDao.listUsers(0, 100);
    out.println("<html><body>");
    for (User user : userList)
      out.format("<p>%s</p>\n", user);
    out.println("</body></html>");
    out.close();
  }
}
