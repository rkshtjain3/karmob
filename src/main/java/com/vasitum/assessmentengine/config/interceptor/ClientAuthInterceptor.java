package com.vasitum.assessmentengine.config.interceptor;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vasitum.assessmentengine.client.model.Client;
import com.vasitum.assessmentengine.client.service.ClientService;
import com.vasitum.assessmentengine.util.response.model.Response;
import com.vasitum.assessmentengine.util.response.service.IResponseService;
import com.vasitum.assessmentengine.userprofile.model.UserProfile;
import com.vasitum.assessmentengine.userprofile.repository.UserProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class ClientAuthInterceptor implements HandlerInterceptor {

    @Autowired
    private ClientService clientService;
    @Autowired
    private IResponseService iResponseService;
    @Autowired
    private UserProfileRepository userProfileRepository;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // check if client is present && active
        ObjectMapper mapper = new ObjectMapper();
        Response responseBody = null;
        response.setContentType("application/json");
        String authToken = request.getHeader("auth_token");

        Client client = clientService.findByToken(authToken);
        if (client==null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            responseBody = iResponseService.failure("Client not found or Invalid token", HttpStatus.NOT_FOUND);
            response.getWriter().write(mapper.writeValueAsString(responseBody));
            return false;
        }
        if(!client.isPaid()){
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            responseBody = iResponseService.failure("Client not found", HttpStatus.NOT_FOUND);
            response.getWriter().write(mapper.writeValueAsString(responseBody));
            return false;
        }
        String rpnNo = request.getParameter("rpn");
        UserProfile userProfile = userProfileRepository.findByRpn(Long.parseLong(rpnNo));
        if (userProfile != null) {
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            responseBody = iResponseService.failure("Assessment already done", HttpStatus.FORBIDDEN);
            response.getWriter().write(mapper.writeValueAsString(responseBody));
            return false;
        } request.setAttribute("token", authToken);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
