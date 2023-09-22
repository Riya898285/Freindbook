<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<style>
.pro{
margin-top:12px;
margin-left:550px;

}
.imag{
width:5px;
height:170px;
}
</style>
<meta charset="ISO-8859-1">
<title>Notification</title>

<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>


<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="views/style.css">
</head>
<body>

	<%@include file="nav.jsp"%>


	<c:forEach items="${requests }" var="req">
		<div class="card pro" style="width: 20rem"><!-- /images/profilepic/${req.senderid.profilePic } -->
			<img class="card-img-top imag"
				src="<c:url value= "views/image/profilepicture/${req.senderid.profilePic }" />"
				alt="image">
			<div class="card-body" >
				<p class="card-text">Name : ${req.senderid.name}</p>
				<p class="card-text">Username : ${req.senderid.username}</p>
				<form>
					<input type="hidden" name="id" value=${req.id }> <input
						type="hidden" name="userid" value=${req.recieverid }> <input
						type="hidden" name="followerid" value=${req.senderid.id }>
					<input type="hidden" name="followingid" value=${req.recieverid }>
					<input type="hidden" name="useridfollowing"
						value=${req.senderid.id }>
					<button id="acceptrequest" type="submit" formaction="acceptrequest"
						formmethod="post">Accept Follow Request</button>
					<button id="declinerequest" type="submit" formaction="declinerequest"
						formmethod="post">Decline Request</button>
				</form>
			</div>
		</div>

	</c:forEach>

</body>
</html>