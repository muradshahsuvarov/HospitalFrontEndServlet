package Frontend;

import org.jetbrains.annotations.NotNull;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.stream.Collectors;


@WebServlet(urlPatterns = {"/cool-servlet"})
public class MainServlet extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config); // Will initialize config files in parent Servlet class
        log("Server started...");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);
        resp.getWriter().write("Method service\n");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI(); // After the domain
        String params = formatParams(req);
        resp.getWriter().write("Method doGet\nURI " + uri + "\nParams: \n" + params + "\n");
    }

    @NotNull
    private String formatParams(HttpServletRequest req) {
        return req.getParameterMap()
                .entrySet()
                .stream()
                .map(entry -> {
                    String param = String.join(" and ", entry.getValue());
                    return entry.getKey() + " => " + param;
                })
                .collect(Collectors.joining("\n"));
    }

    @Override
    public void destroy() {
        log("Server destroyed...");
    }
}