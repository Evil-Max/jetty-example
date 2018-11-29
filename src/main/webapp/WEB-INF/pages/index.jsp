<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=utf-8" %>
<html>
    <head>
        <meta charset="utf-8"/>
        <title>JETTY and JMS testing</title>
        <script src="https://code.jquery.com/jquery-3.3.1.min.js" ></script>
        <script src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
        <script src="resources/js/jms.js"></script>
    </head>
    <body>
        <h1>${test}</h1>
        <table>
            <tr>
                <div>
                    <label for="message">Сообщение</label>
                    <input type="text" id="message" name="message"/>
                </div>
                <div>
                    <input type="button" value="Отправить" onclick="sendMessages()"/>
                </div>
            </tr>
            <tr>
                <div id="sendJMS">
                    <ul style="color: #7349a4;">
                    </ul>
                </div>
            </tr>
            <br/>
            <tr>
                <div>
                    <input type="button" value="Принять" onclick="receiveMessages()"/>
                </div>
            </tr>
            <tr>
                <div id="receiveJMS">
                    <ul style="color: #7349a4;">
                    </ul>
                </div>
            </tr>
        </table>
    </body>
</html>