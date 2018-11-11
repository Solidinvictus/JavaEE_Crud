<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>

<html lang="es">
    <head>
        <meta charset="UTF-8">
        <title>Updating Users</title>

        <link href="../css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="../css/bootstrap-datetimepicker.min.css" rel="stylesheet" type="text/css"/>
        <link href="../icons/estilos.css" rel="stylesheet" type="text/css"/>
        <link href="../css/estilos.css" rel="stylesheet" type="text/css"/>
    </head>
    <body> 
		<br/>
		<br/>
		<br/>
        <div id="m_main">   

            <div id="m_body" >
                <div class="container">

                    <div class="col-md-3"></div>
                    <div class="col-md-6">
                        <div class="panel panel-default">
                            <div class="panel-body">
                                <div class="page-header"  style="text-align: center; margin-top: 5px">
                                    <h3>Updating User</h3>
                                </div>
                                <form action="User" method="POST"  class="form-horizontal">
                                    <input type="hidden" name="action" value="UPD"/>  

                                    <div class="form-group form-group-sm">
                                        <label for="id" class="control-label col-md-4">Name</label>
                                        <div class="col-md-8">	
                                            <!--readonly="readonly"-->
                                            <input type="text" class="form-control" name="name" value="${user.name}" readonly="readonly"/>
                                                   							
                                        </div>
                                    </div>
                                                   
                                    <div class="form-group form-group-sm">
                                        <label for="password" class="control-label col-md-4">Password</label>
                                        <div class="col-md-8">									
                                            <input type="text" class="form-control" name="password" value="${user.password}"
                                                   placeholder="Password"  required="" />							
                                        </div>
                                    </div>

                                    <div class="form-group form-group-sm">
                                        <label for="email" class="control-label col-md-4">Email</label>
                                        <div class="col-md-8">									
                                            <input type="text" class="form-control" name="email" value="${user.email}"
                                                   placeholder="Email"  required="" maxlength="30"/>							
                                        </div>
                                    </div>          
                                                 
                                   <div class="form-group form-group-sm">
                                        <label for="level_access" class="control-label col-md-4">Level Access</label>
                                        <div class="col-md-8">	
                                        <select name="level_access">
                                            <option value="1">1</option>
                                            <option value="2">2</option>
                                            <option value="3">3</option>
                                            <option value="4">4</option>
                                        </select>
                                       </div>
                                   </div>
   
                                    <div class="form-group form-group-sm">
                                       <label for="baned" class="control-label col-md-4">Is baned?</label>
                                       <div class="col-md-8">	
                                            <input type="radio" name="baned" value="${user.baned}">Yes <input type="radio" name="baned" value="${user.baned}">No
                                       </div>
                                    </div>


                                    <hr/>
                                    <div class="form-group">
                                        <div class="col-md-4 col-sm-offset-2">
                                            <button type="submit" class="btn btn-info">Accept</button>
                                        </div>
                                        <div class="col-md-4 col-sm-offset-2">
                                            <button type="button" id="btnCancel" class="btn btn-warning" >Cancel</button>
                                        </div>	
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                    <br/>
                    <%-- para mensajes  --%>
                    <div>${message}</div>
                    
                </div>
            </div>
        </div>

        <script src="../js/jquery.js" type="text/javascript"></script>
        <script src="../js/bootstrap.min.js" type="text/javascript"></script>
		<script src="../js/user.js" type="text/javascript"></script>
        
    </body>
</html>