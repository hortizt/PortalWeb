package main.groovy.app

import main.groovy.util.DbUtilMQM

//@Grab('org.eclipse.jetty.aggregate:jetty-all-server:8.1.0.v20120127')
@Grab('org.eclipse.jetty.aggregate:jetty-server:8.1.16.v20140903')
@Grab('org.eclipse.jetty.aggregate:jetty-servlet:8.1.16.v20140903')
@Grab('javax.servlet:javax.servlet-api:3.0.1')

import org.eclipse.jetty.servlet.ServletContextHandler
import groovy.servlet.GroovyServlet
import groovy.servlet.TemplateServlet
import org.eclipse.jetty.server.Server
import org.eclipse.jetty.server.handler.ResourceHandler


DbUtilMQM.bootStrap()
def peticion = DbUtilMQM.sql.rows('SELECT * FROM PS_PETICION')

int JETTY_SERVER_PORT = 8094
// static files handler
ResourceHandler resourceHandler = new ResourceHandler()
resourceHandler.with {
    directoriesListed = true
    resourceBase = 'src/main/webapp'
}

ServletContextHandler context = new ServletContextHandler(ServletContextHandler.NO_SESSIONS)
context.with {
    contextPath = '/'
    resourceBase = 'src/main/groovy'
    addServlet(TemplateServlet, '*.gsp')
    handler = resourceHandler
}

jettyServer = new Server(JETTY_SERVER_PORT)
jettyServer.with {
    setHandler(context)
    start()
}
