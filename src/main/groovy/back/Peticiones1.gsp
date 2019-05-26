package main.groovy.back

<%
import main.groovy.util.DbUtilMQM
def peticion = DbUtilMQM.sql.rows('SELECT * FROM PS_PETICION')
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <title>Flot Examples: Basic Usage</title>
        <link href='css/bootstrap.min.css' rel='stylesheet' media='screen'></link>
    </head>
    <body>

        <div class="container">
            <div id="header">
                <h2>Basic Usage</h2>
            </div>
            <div class="row">
                <div class="span6">
                    <table class="table table-striped">
                        <thead>
                            <tr>
                                <th>PT_IDPETICION</th>
                                <th>PT_IDSERVICIO</th>
                                <th>PT_MENSAJEERROR</th>
                            </tr>
                        </thead>
                        <tbody>
                            <g:each var="k" in="${[1,2,3]}">
                               <tr>
                                     ${k}

                                </tr>
                            </g:each>
                        </tbody>
                    </table>
                </div>
            </div>
            <div id="footer">
                footer
            </div>
        </div>
        <script language="javascript" type="text/javascript" src="flot/jquery.js"></script>
        <script language="javascript" type="text/javascript" src="flot/jquery.flot.js"></script>
        <script language="javascript" type="text/javascript" src="flot/jquery.flot.time.js"></script>
        <script language="javascript" type="text/javascript" src="flot/jquery.flot.pie.js"></script>
        <script type="text/javascript" src="js/plotit.js"></script>
    </body>
</html>

