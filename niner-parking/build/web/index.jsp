<%-- 
    Document   : index
    Created on : Feb 26, 2018, 9:04:08 AM
    Author     : Michael
--%>

<%@include file="header.jsp" %>

<main>
    
    <form action="/NinerParking/lotControl?viewButton=solid">
         <input type="submit" name="viewButton" value="Solid">
    </form>
    <form action="/NinerParking/lotControl?viewButton=gradient">
        <input type="submit" name="viewButton" value="Gradient">
    </form>
    <a class="faveLink" href="/NinerParking/cookie?action=setFave">Set Favorites</a>
<%--
        <ul class ="choice">
        <li><button type = "button"><a href="/NinerParking/cookie?action=setFave" >Set Favorites</a></button></li>
        </ul>
--%>
    <table>
        <tr>
            <th>Lot Name</th>
            <th>Percentage Filled</th>
        </tr>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <c:forEach items="${LotData}" var="lot">
            <tr>
                <td><a href="/NinerParking/lotControl?lotCode=${lot.lotCode}">${lot.name}</a></td>
                <td class="${lot.style}" style="background-size: ${lot.percentFilled}% 100%">${lot.percentFilled}</td>
            </tr>
        </c:forEach>
            <div class="map"> 
        <image src="images/Uncc_parking.JPG" alt="Image of UNCC map">
        </div>
    
    </table>     
        
</main>

<%@include file="footer.jsp" %>
