package mouse.project.lib.web.dispatcher;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mouse.project.lib.web.register.RequestMethod;

public interface ReqRespContext {
    void useAndExecute(RequestMethod method, HttpServletRequest req, HttpServletResponse resp, Class<?> config);
}
