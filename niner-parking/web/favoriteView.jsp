<%-- 
    Document   : favoriteView
    Created on : Mar 13, 2018, 2:12:58 PM
    Author     : Michael
--%>

<%@include file="header.jsp" %>

<main>
    <form action="/NinerParking/cookie?viewButton=solid">
        <input type="submit" name="viewButton" value="Solid">
    </form>
    <form action="/NinerParking/cookie?viewButton=gradient">
        <input type="submit" name="viewButton" value="Gradient">
    </form>
    <a class="faveLink" href="/NinerParking/cookie?action=setFave">Set Favorites</a>
<%--
    <ul class ="choice">
        <li><button type = "button"><a href="/NinerParking/cookie?action=setFave" >Set Favorites</a></button></li>
        </ul>
--%>
    <h2>Favorite Lots</h2>
    <table>
        <tr>
            <th>Lot Name</th>
            <th>Percentage Filled</th>
        </tr>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <c:forEach items="${FaveLots}" var="fLot">
            <tr>
                <td><a href="/NinerParking/lotControl?lotCode=${fLot.lotCode}">${fLot.name}</a></td>
                <td class="${fLot.style}" style="background-size: ${fLot.percentFilled}% 100%">${fLot.percentFilled}</td>
            </tr>
        </c:forEach>
             <div class="map"> 
        <image src="images/Uncc_parking.JPG" alt="Image of UNCC map">
        </div>
                  
    </table>
    <h2>Normal Lots</h2>
    <table>
        <tr>
            <th>Lot Name</th>
            <th>Percentage Filled</th>
        </tr>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <c:forEach items="${NormLots}" var="nLot">
            <tr>
                <td><a href="/NinerParking/lotControl?lotCode=${nLot.lotCode}">${nLot.name}</a></td>
                <td class="${nLot.style}" style="background-size: ${nLot.percentFilled}% 100%">${nLot.percentFilled}</td>
            </tr>
        </c:forEach>
    </table>
</main>

<%@include file="footer.jsp" %>
