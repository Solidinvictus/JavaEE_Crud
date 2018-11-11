<%@ include file="header_complete.jsp" %>
    
        <div id="m_main">           

            <div id="m_body">
                <div id="container" style="margin:auto; width: 80%">
                    <h1 class="title">List of Users registered</h1>
                    <div id="demo_jui">
                        <table id="example" class="display table-responsive" width="100%" cellspacing="0">
                            <thead>
                                <tr>
                                    <th style="text-align: center"><u>Name</u></th>
                                    <th style="text-align: center"><u>Password</u></th>
                                    <th style="text-align: center"><u>Email</u></th>
                                    <th style="text-align: center"><u>Level Access</u></th>
                                    <th style="text-align: center"><u>Is Baned ?</u></th>
                                    <th style="text-align: center"><u><a class="btn btn-warning" 
                                                                         href="userIns.jsp" role="button">
                                                Insert</a></u></th>
                                    <th></th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="n" items="${list}">
                                    <tr>                                    
                                        <td style="text-align: center">${n.name}</td>
                                        <td style="text-align: center">${n.password}</td>
                                        <td style="text-align: center">${n.email}</td>
                                        <td style="text-align: center">${n.levelAccess}</td>
                                        <td style="text-align: center">${n.baned}</td>
                                        <td style="text-align: center"><a class="btn btn-warning" 
                                                                          href="User?action=DEL&name=${n.name}" role="button">
                                                <span class="glyphicon glyphicon-trash"></span></a></td>
                                        <td style="text-align: center"><a class="btn btn-warning" 
                                                                          href="User?action=FND&name=${n.name}" role="button">
                                                <span class="glyphicon glyphicon-repeat"></span></a></td>                              
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
                <br/>
                <%-- para mensajes  --%>
                <div>${message}</div>

            </div>
            <!--/div-->

        </div>

        <script src="../js/jquery.js" type="text/javascript"></script>
        <script src="../js/bootstrap.min.js" type="text/javascript"></script>
        <script src="../datatable/jquery.dataTables.min.js" type="text/javascript"></script>
        <script src="../datatable/dataTables.jqueryui.min.js" type="text/javascript"></script>

        <!--script src="../../datatableBstp/js/dataTables.bootstrap4.min.js" type="text/javascript"></script-->

        <script type="text/javascript">
            $(document).ready(function () {
                $('#example').dataTable({
                    "lengthMenu": [7, 10, 25, 50, 75, 100],
                    "language": {
                        "lengthMenu": 'Show <select>' +
                                '<option value="7">7</option>' +
                                '<option value="10">10</option>' +
                                '<option value="25">25</option>' +
                                '<option value="50">50</option>' +
                                '<option value="75">75</option>' +
                                '<option value="100">100</option>' +
                                '<option value="-1">All</option>' +
                                '</select> registers ***** MANTENANCE USERS *****',
                        "search": "Search",
                        "info": "Displaying page _PAGE_ of _PAGES_",
                        "paginate": {
                            "previous": "Previous",
                            "next": "Next"
                        }
                    }
                });
            });
        </script>
        <script>${modal}</script>
<%@ include file="footer.jsp" %>
