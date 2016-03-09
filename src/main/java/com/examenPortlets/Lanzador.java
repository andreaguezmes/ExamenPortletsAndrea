package com.examenPortlets;

import java.io.IOException;
import java.io.Serializable;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Event;
import javax.portlet.EventRequest;
import javax.portlet.EventResponse;
import javax.portlet.GenericPortlet;
import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.ProcessAction;
import javax.portlet.ProcessEvent;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.xml.namespace.QName;

import com.examenEntidades.Persona;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

public class Lanzador extends GenericPortlet {

    public void init() {
        viewTemplate = getInitParameter("view-template");
    }

    public void doView(
            RenderRequest renderRequest, RenderResponse renderResponse)
        throws IOException, PortletException {

        include(viewTemplate, renderRequest, renderResponse);
    }

    protected void include(String path, RenderRequest renderRequest,RenderResponse renderResponse)throws IOException, PortletException {
        PortletRequestDispatcher portletRequestDispatcher = getPortletContext().getRequestDispatcher(path);
        if (portletRequestDispatcher == null) {
            _log.error(path + " is not a valid include");
        }
        else {
            portletRequestDispatcher.include(renderRequest, renderResponse);
        }
    }

    @ProcessAction (name= "enviarEvento1")
    public void enviarEvento1(ActionRequest req, ActionResponse resp) throws IOException, PortletException {

    	String nombre = req.getParameter("nombre");
    	String direccion = req.getParameter("direccion");
    	int telefono = Integer.parseInt(req.getParameter("telefono"));
    	
    	Persona miPersona = new Persona(nombre, direccion, telefono);
		
		QName qname = new QName("http://examen.portlet.evento1", "mensaje", "x");
		
		resp.setEvent(qname, miPersona);
		
		req.setAttribute("mensaje",  miPersona);

    }
    @ProcessAction (name= "enviarEvento2")
    public void enviarEvento2(ActionRequest req, ActionResponse resp) throws IOException, PortletException {

    	String nombre = req.getParameter("nombre");
    	String direccion = req.getParameter("direccion");
    	int telefono = Integer.parseInt(req.getParameter("telefono"));
    	
    	Persona miPersona2 = new Persona(nombre, direccion, telefono);
		
		QName qname2 = new QName("http://examen.portlet.evento2", "mensaje", "x");
		
		resp.setEvent(qname2, miPersona2);
		
		req.setAttribute("mensaje",  miPersona2);

    }
    
    @ProcessEvent (qname = "{http://examen.portlet.evento1}mensaje")
    public void procesarMiEvento1 (EventRequest req, EventResponse resp) throws PortletException, IOException{
    	Event evento = req.getEvent();
	
		Serializable personita = evento.getValue();
	
		req.setAttribute("mensaje",  personita);
		
    }
    
	@ProcessEvent(qname = "{http://examen.portlet.evento2}mensaje")
	public void procesarMiEvento2(EventRequest req, EventResponse resp) throws IOException, PortletException {
		Event evento2 = req.getEvent();

		Serializable personita2 = evento2.getValue();
		req.setAttribute("mensaje", personita2);
	}


    protected String viewTemplate;

    private static Log _log = LogFactoryUtil.getLog(Lanzador.class);

}
