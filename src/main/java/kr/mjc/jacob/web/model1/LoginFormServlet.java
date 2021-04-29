package kr.mjc.jacob.web.model1;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Slf4j
@WebServlet("/model1/user/loginForm")
public class LoginFormServlet extends HttpServlet {

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws IOException {

    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    out.println("""
        <!DOCTYPE html>
        <html>
        <body>
          <h3>로그인</h3>
          <form action="login" method="post">
            <p><input type="email" name="email" placeholder="이메일" required /></p>
            <p><input type="password" name="password" placeholder="비밀번호" required /></p>
            <p><button type="submit">로그인</button></p> 
          </form>
        </body>
        </html>
        """);
    out.close();
  }
}
