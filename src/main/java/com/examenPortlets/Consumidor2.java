package com.examenPortlets;

import java.io.IOException;
import java.io.Serializable;

import javax.portlet.Event;
import javax.portlet.EventRequest;
import javax.portlet.EventResponse;
import javax.portlet.GenericPortlet;
import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.ProcessEvent;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

/**
 * Portlet implementation class Consumidor2
 */
public class Consumidor2 extends GenericPortlet {

	public void init() {
		viewTemplate = getInitParameter("view-template");
	}

	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {

		include(viewTemplate, renderRequest, renderResponse);
	}

	protected void include(String path, RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {

		PortletRequestDispatcher portletRequestDispatcher = getPortletContext().getRequestDispatcher(path);

		if (portletRequestDispatcher == null) {
			_log.error(path + " is not a valid include");
		} else {
			portletRequestDispatcher.include(renderRequest, renderResponse);
		}
	}
	
	@ProcessEvent(qname = "{http://examen.portlet.evento2}mensaje")
	public void procesarMiEvento2(EventRequest req, EventResponse resp) throws IOException, PortletException {
		Event evento2 = req.getEvent();

		Serializable personita2 = evento2.getValue();

		req.setAttribute("mensaje", personita2);
	}

	protected String viewTemplate;

	private static Log _log = LogFactoryUtil.getLog(Consumidor2.class);

}
