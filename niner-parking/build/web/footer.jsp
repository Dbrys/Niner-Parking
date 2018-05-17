<%-- 
    Document   : footer
    Created on : Feb 26, 2018, 9:04:56 AM
    Author     : Michael
--%>

<%@page import="java.util.GregorianCalendar, java.util.Calendar" %>
<%
    GregorianCalendar currentDate = new GregorianCalendar();
    int currentYear = currentDate.get(Calendar.YEAR);
%>
<footer>
    <p>&copy; Taylor Atkins, Dillon Brys, Kevin Huynh, Michael Long, John Sorensen <%= currentYear %></p>
</footer>
</body>
</html>