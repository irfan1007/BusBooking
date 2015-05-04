<%@page
	import="org.springframework.security.core.context.SecurityContextHolder"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Cache-Control" content="no-cache">
<title>Bus Booking Portal</title>
</head>
<body>
	<img alt="Bus Booking" align="middle"
		src="resources/images/banner.png" width="800" height="160">
	<table width="600">
		<tr>
			<td width="33%">Welcome, <%=SecurityContextHolder.getContext().getAuthentication()
					.getName().equalsIgnoreCase("anonymousUser") ? "Guest"
					: SecurityContextHolder.getContext().getAuthentication()
							.getName()%>
				!
			</td>
			<%
				if (!SecurityContextHolder.getContext().getAuthentication()
						.getName().equalsIgnoreCase("anonymousUser") && !SecurityContextHolder.getContext().getAuthentication()
						.getName().equalsIgnoreCase("admin")) {
			%>
			<td width="33%"><a href="/BusBooking/mybookings">My Bookings</a></td>
			<td width="33%"><a
				href="<c:url value="/j_spring_security_logout"/>">Logout</a></td>
			<%
				} else if(SecurityContextHolder.getContext().getAuthentication()
						.getName().equalsIgnoreCase("admin")) {
			%>
			<td width="33%"><a href="/BusBooking/mybookings">See All Bookings</a></td>
			<td width="33%"><a
				href="<c:url value="/j_spring_security_logout"/>">Logout</a></td>
			<%
				}
			%>
		</tr>
	</table>

</body>
</html>