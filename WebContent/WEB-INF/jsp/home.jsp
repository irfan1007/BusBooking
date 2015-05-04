<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="banner.jsp"%>

<html>
<head>
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Cache-Control" content="no-cache">
<title>Bus Booking Portal</title>
<link rel="stylesheet" href="resources/css/jquery-ui.css" />
<script src="resources/js/jquery-1.9.1.js"></script>
<script src="resources/js/jquery-ui.js"></script>
<script src="resources/js/jquery-ui-timepicker-addon.js"></script>
<script type="text/javascript" src="resources/js/validation.js"></script>
<link rel="stylesheet" href="resources/css/base.css" />
<link rel="stylesheet" href="/resources/demos/style.css" />

<script type="text/javascript">
	$(function() {
		$("#datepicker").datepicker();
	});

	$(function() {
		$('#timepicker').timepicker({
			hourGrid : 4,
			minuteGrid : 15,
			timeFormat : 'hh:mm tt'
		});
	});
</script>
</head>
<body>

	<form:form method="POST" name="result" action="/BusBooking/result"
		modelAttribute="BookingInfo" onsubmit="return validate();">
  <div class="CSSTableGenerator">
		<table>
			<tr>
			<tr>
				<td>Date :</td>
				<td>Time :</td>
			</tr>
			<tr>
				<td><input type="text" id="datepicker" name="date"
					value="${date}" /></td>
				<td><input type="text" id="timepicker" name="time"
					value="${time}" /></td>
			</tr>
			<tr />
			<tr>
				<td>From :</td>
				<td>To :</td>
			</tr>
			<tr>
				<td><form:select path="fromCity" items="${fromCity}"
						name="fromCity" /></td>
				<td><form:select path="toCity" items="${toCity}" name="toCity" /></td>
			</tr>
			<tr />
			<tr>
				<td align="center" colspan="4"><input type="submit"
					name="Search" value="Search" class="ui-button" /></td>
			</tr>
		</table>
		</div>
	</form:form>
</body>
</html>