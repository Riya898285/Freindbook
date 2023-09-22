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
</style>
<meta charset="ISO-8859-1">
<title>List of Users</title>


</head>
<body>

	<%@include file="nav.jsp"%>
	<c:forEach var="user" items="${list}">
	
	<div class="card pro" style="width: 20rem">
			<div class="card-body"><!-- ${user.profilePic } -->
				<img class="card-img-top"
				src="<c:url value="views/image/profilepicture/${user.profilePic }"/>" 
				alt="Card  cap">
				<p class="card-text">Name : ${user.name}</p>
				<p class="card-text">Username : ${user.username}</p>
				<form action="search" method="post">
					<input type="hidden" name="senderid" value=${id }> <input
						type="hidden" name="recieverid" value=${user.id }>
					<button id="requestSend" type="submit" 
						 >Follow Request</button>
				</form>
				
			</div>
		</div>
	</c:forEach>
	
		<script type="text/javascript">
document.getElementById("requestSend").addEventListener("click", myFunction);

function myFunction() {
	console.log("Function Callling!!");
	
  document.getElementById("requestSend").innerHTML = "REQUEST SENT";
}

document.getElementById("requestSend").onclick = function() {
    //disable
    this.disabled = false;
}

    
    

</script>
</body>

</html>