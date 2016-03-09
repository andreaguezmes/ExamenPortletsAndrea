<%@page import="com.examenEntidades.Persona"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<portlet:defineObjects />
<h1>Portlet A (Lanzador)</h1>

<portlet:actionURL name="enviarEvento1" var="urlEnviarEvento1"/>
<portlet:actionURL name="enviarEvento2" var="urlEnviarEvento2"/>

<%

Persona persona = (Persona)request.getAttribute("mensaje");

if(persona!=null){
%>
	
<form  method="post">
	<input type="text" name= "nombre" value="<%=persona.getNombre()%>"/>
	<input type="text" name= "direccion" value="<%= persona.getDireccion()%>"/>
	<input type="text" name= "telefono" value="<%= persona.getTelefono()%>"/></br>
	<input type="submit" formaction= "<%=urlEnviarEvento1 %>" value="Enviar a Portlet B"/>
	<input type="submit" formaction= "<%=urlEnviarEvento2 %>" value="Enviar a Portlet C"/>
</form>

<%
}else{
%>
	<form  method="post">
	<input type="text" name= "nombre" value="nombre"/>
	<input type="text" name= "direccion" value="direccion"/>
	<input type="text" name= "telefono" value="telefono"/></br>
	<input type="submit" formaction= "<%=urlEnviarEvento1 %>" value="Enviar a Portlet B"/>
	<input type="submit" formaction= "<%=urlEnviarEvento2 %>" value="Enviar a Portlet C"/>
</form>
<%
}
%>
