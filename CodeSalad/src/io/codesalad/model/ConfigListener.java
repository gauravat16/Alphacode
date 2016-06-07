package io.codesalad.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.sun.xml.internal.bind.CycleRecoverable.Context;

/**
 * Application Lifecycle Listener implementation class ConfigListener
 *
 */
@WebListener("/Config")
public class ConfigListener implements ServletContextListener, ServletContextAttributeListener {

	/**
	 * Default constructor.
	 */
	public ConfigListener() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see ServletContextAttributeListener#attributeAdded(ServletContextAttributeEvent)
	 */
	public void attributeAdded(ServletContextAttributeEvent event) {
		// TODO Auto-generated method stub
	}

	/**
	 * @see ServletContextAttributeListener#attributeRemoved(ServletContextAttributeEvent)
	 */
	public void attributeRemoved(ServletContextAttributeEvent event) {
		// TODO Auto-generated method stub
	}

	/**
	 * @see ServletContextListener#contextDestroyed(ServletContextEvent)
	 */
	public void contextDestroyed(ServletContextEvent event) {
		// TODO Auto-generated method stub
	}

	/**
	 * @see ServletContextAttributeListener#attributeReplaced(ServletContextAttributeEvent)
	 */
	public void attributeReplaced(ServletContextAttributeEvent event) {
		// TODO Auto-generated method stub
	}

	/**
	 * @see ServletContextListener#contextInitialized(ServletContextEvent)
	 */
	public void contextInitialized(ServletContextEvent event) {
		// TODO Auto-generated method stub

		ServletContext context = event.getServletContext();

		// get ConfigData
		String[] data = new String[20];
		try {

			BufferedReader bRead1 = new BufferedReader(
					new InputStreamReader(event.getServletContext().getResourceAsStream("/WEB-INF/Configuration.txt")));
			String in;
			int counter = 0;
			while ((in = bRead1.readLine()) != null) {
				data[counter] += in;
				counter++;

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		context.setAttribute("config", data);
	}

}
