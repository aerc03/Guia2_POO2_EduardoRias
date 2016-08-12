<%-- 
    Document   : index
    Created on : Aug 10, 2016, 5:03:54 PM
    Author     : aerc
--%>

<%@page import="com.sv.udb.Ctrl.PersCtrl"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

    
<%@page import="java.util.Calendar"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

        <!-- Optional theme -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

        <title>Guia 2</title>
    </head>
    <body>
        
        <nav class="navbar navbar-inverse">
            <center style="color: white"><h3>GUIA 2</h3></center>
        </nav>
        
        <div class="row">
            <div class="col-md-1"></div>
            <div class="col-md-4">
                
                <form action="PersServ" method="post">
                    <div class="form-group">
                        <label for="exampleInputEmail1">Codigo</label>
                        <input type="text" class="form-control" id="exampleInputEmail1" placeholder="Codigo">
                    </div>
                    <div class="form-group">
                        <label for="exampleInputPassword1">Nombres</label>
                        <input type="text" class="form-control" id="nom" name="nom" placeholder="Nombres">
                    </div>
                    <div class="form-group">
                        <label for="exampleInputPassword1">Apellidos</label>
                        <input type="text" class="form-control" id="ape" name="ape" placeholder="Apellidos">
                    </div>
                    <div class="form-group">
                        <label for="exampleInputFile">Seleccione su foto:</label>
                        <input type="file" id="fot" name="fot">
                        <p class="help-block">Archivos .jpg, .png, .jpeg</p>
                    </div>
                    <div class="form-group">
                        <label for="exampleInputPassword1">Tipo Persona</label>
                        <jsp:useBean id="Tipo" class="com.sv.udb.Ctrl.Tipo_persCtrl" scope="page" />
                        <select id="cmbTipo" class="form-control" name="cmbTipo">
                            <c:forEach items="${Tipo.consTodo()}" var="fila">
                                <option value="${fila.codi_tipo_pers}">${fila.nomb_tipo_pers}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="exampleInputPassword1">Genero</label>
                        <select class="form-control" id="gen" name="gen">
                            <option>Masculino</option>
                            <option>Femenino</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="exampleInputPassword1">Fecha Nacimiento</label>
                        <input type="date" id="nac" name="nac" class="form-control" id="exampleInputPassword1" min="1900-01-01" max="1997-12-31" placeholder="fecha">
                    </div>
                    <div class="form-group">
                        <label for="exampleInputPassword1">DUI</label>
                        <input type="number" name="dui" id="dui" class="form-control" id="exampleInputPassword1" placeholder="DUI">
                    </div>
                    <div class="form-group">
                        <label for="exampleInputPassword1">NIT</label>
                        <input type="number" name="nit" id="nit" class="form-control" id="exampleInputPassword1" placeholder="NIT">
                    </div>
                    <div class="form-group">
                        <label for="exampleInputPassword1">Fecha Nacimiento</label>
                        <input type="date" class="form-control" id="exampleInputPassword1" min="1900-01-01" max="1997-12-31" placeholder="fecha">
                    </div>
                    
                    <div class="form-group">
                        <label for="exampleInputPassword1">Tipo Sangre</label>
                        <select class="form-control" name="san" id="san">
                            <option>ABH+</option>
                            <option>AB-</option>
                            <option>A+</option>
                            <option>A-</option>
                            <option>B+</option>
                            <option>B-</option>
                            <option>O+</option>
                            <option>O-</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="exampleInputPassword1">Ubicacion</label>
                        <jsp:useBean id="ubic" class="com.sv.udb.Ctrl.UbicGeogCtrl" scope="page" />
                        <select id="ubi" name="ubi" class="form-control" name="cmbUnidOrga">
                            <c:forEach items="${ubic.consTodo()}" var="fila">
                                <option value="${fila.CODI_UBIC_GEOG}">${fila.NOMB_UBIC_GEOG}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <%
                    // Quiero la fecha actual para ponerla por defecto 
                    Calendar ahora = Calendar.getInstance();
                    int anyo = ahora.get(Calendar.YEAR);
                    int mes = ahora.get(Calendar.MONTH) +1; 
                    int dia = ahora.get(Calendar.DAY_OF_MONTH);
                    String sAhora = "";
                    if (mes < 10) {
                    sAhora = anyo + "-0" + mes;
                    } else {
                    sAhora = anyo + "-" + mes;
                    }
                    if (dia < 10) {
                    sAhora += "-0" + dia;
                    } else {
                    sAhora += "-"+dia;
                    } 
                    %>
                    <div class="form-group">
                        <label for="exampleInputPassword1">Fecha Inicio</label>
                        <input type="date" class="form-control"  id="exampleInputPassword1" min="1900-01-01" max="1997-12-31" value="<%=sAhora%>" placeholder="fecha">
                    </div>
                    <button type="submit" id="Agregar" name="CursBoton" value="Guardar" class="btn btn-primary">Agregar</button>
                </form>
                
            </div>
                    <div class="col-md-6">
                        dsfsd
                        
                    </div>
            <div class="col-md-1"></div>
        </div>
    </body>
    <script src="js/jquery-2.1.3.js" type="text/javascript"></script>
    <!-- Latest compiled and minified JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
</html>