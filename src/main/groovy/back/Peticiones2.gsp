package main.groovy.back

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <title>Flot Examples: Basic Usage</title>
        <link href='css/bootstrap.min.css' rel='stylesheet' media='screen'></link>
    </head>
    <body>

        <div class="container">
             <g:each in="${[1,2,3]}" var="num">
                <p>Number $num</p>
              </g:each>
        </div>
        <script language="javascript" type="text/javascript" src="flot/jquery.js"></script>
        <script language="javascript" type="text/javascript" src="flot/jquery.flot.js"></script>
        <script language="javascript" type="text/javascript" src="flot/jquery.flot.time.js"></script>
        <script language="javascript" type="text/javascript" src="flot/jquery.flot.pie.js"></script>
        <script type="text/javascript" src="js/plotit.js"></script>
    </body>
</html>

