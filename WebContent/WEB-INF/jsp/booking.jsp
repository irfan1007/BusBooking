<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@include file="banner.jsp"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <STYLE type="text/css">
   #busid {border: none; background-color:#cccccc}
 </STYLE>

<title>Bus Booking Portal</title>
<script type="text/javascript" src="resources/js/validation.js"></script>
<link rel="stylesheet" href="resources/css/base.css" />
<link rel="stylesheet" href="/resources/demos/style.css" />
</head>
<body>

	<h2>Bus Booking Portal</h2>
	<script>
		window.onload = function() {
	<%if (SecurityContextHolder.getContext().getAuthentication()
					.getName().equalsIgnoreCase("anonymousUser")) {
				response.sendRedirect("/BusBooking/search");
			}%>
		}
	</script>
	<form:form method="POST" name="confirm" action="/BusBooking/confirm"
		modelAttribute="Passenger" onsubmit="return validatebooking();">
		<input type="hidden" name="userName"  value="<%=SecurityContextHolder.getContext().getAuthentication()
				.getName()%>"/>
	<div class="CSSTableGenerator">
		<table width="500">
			<tr>
			<tr>
				<td>Bus Id :</td>
				<td> <input id="busid" type="text" name="busId" maxlength="4"  readonly="readonly" value="<%=request.getParameter("busId")%>"
					width="150px"/>
			</tr>
				<tr>
				<td>From :</td>
				<td><input class="noborder" type="text" name="fromCity" maxlength="50" style="border:none" readonly="readonly" value="<%=session.getAttribute("fromCity")%>"
					width="150px"/>
				</td>
			</tr>
				<tr>
				<td>To :</td>
				<td><input id="busid" class="noborder" type="text" name="toCity" maxlength="50" style="border:none" readonly="readonly" value="<%=session.getAttribute("toCity")%>"
					width="150px"/>
				</td>
			</tr>
				<tr>
				<td>Date :</td>
				<td><input class="noborder" type="text" name="date" maxlength="10" style="border:none" readonly="readonly" value="<%=session.getAttribute("date")%>"
					width="150px"/>
				</td>
			</tr>
			<tr>
				<td>Name :</td>
				<td><input type="text" name="passengerName" maxlength="50"
					width="150px"/></td>
			</tr>
			<tr>
				<td>Age (years):</td>
				<td><input type="text" name="passengerAge" maxlength="2"
					width="150px" /></td>
			</tr>
			<tr>
				<td>No. of passengers :</td>
				<td><select name="passengerCount" style="width: 148px">
						<option>1</option>
						<option>2</option>
						<option>3</option>
				</select></td>
			</tr>
			<tr>
				<td>Payment Mode :</td>
				<td><select name="passengerPay" style="width: 148px">
						<option>Cash</option>
						<option>Card</option>
				</select></td>
				
			</tr>
			
			<tr>
				<td colspan="2" align="center"><input type="submit" name="Confirm" value="Confirm"
					class="ui-button" /></td>
			</tr>
		</table>
		</div>
	</form:form>
</body>
</html>