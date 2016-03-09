<%@page import="com.examenEntidades.Persona"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<portlet:defineObjects />

<h1>Portlet C (Consumidor 2)</h1>


<% 
Persona personita2 = (Persona)request.getAttribute("mensaje"); 

String nombre="nombre";
String direccion="direccion";
String telefono="telefono";

if(personita2!=null){
	nombre=personita2.getNombre();
	direccion= personita2.getDireccion();
	telefono= String.valueOf(personita2.getTelefono());
}

%>

<form  method="post">
	<input type="text" name= "nombre" value="<%=nombre %>"/>
	<input type="text" name= "direccion" value="<%=direccion%>"/>
	<input type="text" name= "telefono"  value="<%=telefono%>"/>
</form>
