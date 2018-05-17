<%-- 
    Document   : trends
    Created on : Feb 27, 2018, 10:01:44 AM
    Author     : Michael
--%>

<%@include file="header.jsp" %>

<h2>${LotData.name}</h2>
<table>
    <tr>
        <th>10:00am</th>
        <th>12:00pm</th>
        <th>2:00pm</th>
        <th>4:00pm</th>
    </tr>
    <tr>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <c:forEach items="${LotList}" var="lot">
            <td class="${lot.style}" style="background-size: ${lot.percentFilled}% 100%">${lot.percentFilled}</td>
        </c:forEach>
    </tr>
    
</table>
        <div class = "parking_map">
        <iframe src="${LotData.mapLink}" width = "400" height = "400"></iframe>
        </div> 
<%@include file="footer.jsp" %>
