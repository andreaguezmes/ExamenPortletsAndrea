<%@page import="com.examenEntidades.Persona"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<portlet:defineObjects />

<h1>Portlet B (Consumidor 1)</h1>


<% 
Persona personita = (Persona)request.getAttribute("mensaje"); 

String nombre="nombre";
String direccion="direccion";
String telefono="telefono";



if(personita!=null){
	nombre=personita.getNombre();
	direccion= personita.getDireccion();
	telefono= String.valueOf(personita.getTelefono());
}
%>

<form  method="post">
	<input type="text" name= "nombre" value="<%=nombre %>"/>
	<input type="text" name= "direccion" value="<%=direccion %>"/>
	<input type="text" name= "telefono"  value="<%=telefono %>"/>
</form>




