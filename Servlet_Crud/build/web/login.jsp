<%@ include file="header_login.jsp" %>
<%@ include file="intern.jsp" %>

<div id="m_main" style="margin-top: 10px">   

    <div id="m_body" >
        <div class="container">

            <div class="col-md-3"></div>
            <div class="col-md-6">
                <div class="panel panel-default">
                    <div class="panel-body">
                        <div class="page-header"  style="text-align: center; margin-top: 5px">
                            <h3>Login</h3>
                        </div>
                        <form action="Login" method="GET"  class="form-horizontal">
<!--                            <input type="hidden" name="action" value="INS"/>  -->


                            <div class="form-group form-group-sm"  style="text-align: center;">
                                <label for="name" class="control-label col-md-4"><fmt:message key='Name'/></label>
                                <div class="col-md-8">									
                                    <input type="text" class="form-control" name="name" 
                                           placeholder="Name" required="" maxlength="30"/>							
                                </div>
                            </div>

                            <div class="form-group form-group-sm">
                                <label for="password" class="control-label col-md-4"><fmt:message key='Password'/></label>
                                <div class="col-md-8">									
                                    <input type="text" class="form-control" name="password" 
                                           placeholder="Password" required="" maxlength="9"/>							
                                </div>
                            </div>
                            <hr/>
                            <div class="form-group">
                                <div class="col-md-4 col-sm-offset-2">
<!--                                    <button type="submit" class="btn btn-info" value="Login">Login</button>-->
                                        <input type="submit" value="Login" class="btn btn-info">
                                </div>
                                <div class="col-md-4 col-sm-offset-2">
                                    
                                    <button type="button" id="btnCancel2" class="btn btn-warning"  ><fmt:message key='Cancel'/></button>
                                    <script type="text/javascript">
                                    document.getElementById("btnCancel2").onclick = function () {
                                    //location.href = "http://localhost:8080/Servlet_Crud/view/User?action=QRY";
                                    location.href = "http://localhost:8080/Servlet_Crud/view/User?action=QRY";
                                    };
                                    </script>
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
<script src="js/jquery.js" type="text/javascript"></script>
<script src="js/bootstrap.min.js" type="text/javascript"></script>
<script src="js/user.js" type="text/javascript"></script>


<%@ include file="view/footer.jsp" %>