<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@include file="banner.jsp"%>   
<link rel="stylesheet" href="resources/css/base.css" />

<!--<jsp:include page="banner.jsp"/>-->
<html>
<head>
    <title>Bus Booking Portal</title>
</head>
<body>

<script>
		window.onload = function() {
	<%if (SecurityContextHolder.getContext().getAuthentication()
					.getName().equalsIgnoreCase("anonymousUser")) {
				response.sendRedirect("/BusBooking");
			}%>
		};
	</script>
<c:choose>
 <c:when test="${not empty mylist}">
 <p>Your booking details :</p>
  <div class="CSSTableGenerator">
    <table>
    	 <tr>
                <td>Bus Id</td>
                <%if(SecurityContextHolder.getContext().getAuthentication()
				.getName().equalsIgnoreCase("admin")){%>
				<td>User Name</td>
				<%}%>
                <td>Passenger Name</td>
                <td>Passenger Age</td> 
                 <td>Passenger Count</td> 
                <td>From City</td>
                <td>To City</td> 
                <td>Date</td>
                <td>Cancel</td>        
            </tr>
      
        <c:forEach var="passenger" items="${mylist}">
            <tr>
                <td>${passenger.busId}</td>
                 <%if(SecurityContextHolder.getContext().getAuthentication()
				.getName().equalsIgnoreCase("admin")){%>
				<td>${passenger.userName}</td>
				<%}%>
                <td>${passenger.passengerName}</td>
                <td>${passenger.passengerAge}</td> 
                <td>${passenger.passengerCount}</td> 
                <td>${passenger.fromCity}</td> 
                <td>${passenger.toCity}</td> 
                <td>${passenger.date}</td>
                <td><a href="/BusBooking/delete?bookingId=${passenger.bookingId}" onClick="return confirm('Are you sure you want to cancel this booking?');">Cancel!</a></td>
            </tr>
        </c:forEach>
      
    </table>
    </div>
     <p><a href="/BusBooking/search">Book more tickets!</a></p>
  </c:when>
  <c:otherwise>
  <p>No booking found for <%=SecurityContextHolder.getContext().getAuthentication()
			.getName() %></p>
  <p><a href="/BusBooking/search">Start booking now!</a></p>
  </c:otherwise>
  </c:choose>
</body>
</html>