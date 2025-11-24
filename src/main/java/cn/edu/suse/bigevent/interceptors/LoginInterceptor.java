package cn.edu.suse.bigevent.interceptors;

import cn.edu.suse.bigevent.pojo.Result;
import cn.edu.suse.bigevent.utils.JwtUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.net.Authenticator;
import java.util.Map;

@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("Authorization");

        //令牌验证
        try {
            Map<String,Object> claims = JwtUtil.parseToken(token);
            //放行
            return true;
        } catch (Exception e) {
            response.setStatus(401);
            return false;
        }
    }
}
