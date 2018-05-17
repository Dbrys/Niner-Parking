<%-- 
    Document   : setFavorite
    Created on : Mar 13, 2018, 2:39:18 PM
    Author     : Michael
--%>

<%@include file="header.jsp" %>

<main>
    <form action="/NinerParking/cookie?action=saveFave" method="post">
        <table>
            <tr>
                <th>Favorite</th>
                <th>Lot Name</th>
            </tr>
            <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
            <c:forEach items="${LotData}" var="lot">
                <tr>
                    <td><input type='checkbox' name='favorite' value="${lot.lotCode}"></td>
                    <td>${lot.name}</td>
                </tr>
            </c:forEach>
        </table>
        <input id="faveSubmit" type="submit" value="Submit">
    </form>    
</main>

<%@include file="footer.jsp" %>