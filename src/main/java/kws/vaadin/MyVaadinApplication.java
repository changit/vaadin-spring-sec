
package kws.vaadin;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.vaadin.Application;
import com.vaadin.terminal.gwt.server.AbstractApplicationServlet;

public class MyVaadinApplication extends AbstractApplicationServlet
{
    private WebApplicationContext appContext;
    private Class<? extends Application> applicationClass;

    @Override
    protected Application getNewApplication(HttpServletRequest httpServletRequest) throws ServletException {
        System.out.println("Creating a new application");
        MainApplication mMa = (MainApplication) appContext.getBean("applicationBean");
        mMa.setWebApplicationContext(appContext);
        return  mMa;
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.service(request, response);    //To change body of overridden methods use File | Settings | File Templates.
    }

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        super.init(servletConfig);    //To change body of overridden methods use File | Settings | File Templates.
        appContext = WebApplicationContextUtils.getWebApplicationContext(servletConfig.getServletContext());
    }

	@Override
	protected Class<? extends Application> getApplicationClass() throws ClassNotFoundException {
		return MainApplication.class;
	}
}
