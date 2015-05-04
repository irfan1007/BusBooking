<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@include file="banner.jsp"%>
<link rel="stylesheet" href="resources/css/base.css" />
<html>
<head>
<title>Bus Booking Portal</title>
</head>
<body>
	<script type="text/javascript">
function setvalues(){
	<%session.setAttribute("fromCity", request.getParameter("fromCity"));
	session.setAttribute("toCity", request.getParameter("toCity"));
	session.setAttribute("date", request.getParameter("date"));
	%>
}
</script>
	<p>
		Showing results for buses available from
		<%=request.getParameter("fromCity")%>
		to
		<%=request.getParameter("toCity")%>
		on
		<%=request.getParameter("date")%>.
	</p>
	<div class="CSSTableGenerator">
		<table>
			<tr>
				<td>Bus Id</td>
				<td>Operator Name</td>
				<td>Price (Rs)</td>
				<td>Available Seats</td>
				<td>Action</td>
			</tr>

			<c:forEach var="bus" items="${searchresult}">
				<tr>
					<td>${bus.busId}</td>
					<td>${bus.operatorName}</td>
					<td>${bus.price}</td>
					<td>${bus.seatsAvailable}</td>
					<c:set var="seats" value="${bus.seatsAvailable}" />
					<%
                Integer seats1 = (Integer)pageContext.getAttribute("seats");
				%>
					<%if(seats1 == 0) {%>
					<td><I>Not Available!</I></td>
					<%}else if(!SecurityContextHolder.getContext().getAuthentication()
    					.getName().equalsIgnoreCase("anonymousUser")) {%>
					<td><a href="/BusBooking/booking?busId=${bus.busId}"
						onclick="setvalues()"><I>Grab It!</I></a></td>
					<%}else{%>
					<td><a href="/BusBooking/"><I>Login to do booking.</I></a></td>
					<%}%>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>