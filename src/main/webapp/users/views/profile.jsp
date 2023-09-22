<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.4.1/css/all.css"
	integrity="sha384-5sAR7xN1Nv6T6+dT2mhtzEpVJvfS3NScPQTrOxhwjIuvcA67KV2R5Jz6kr4abQsz"
	crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Profile</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">

<style>
.profile {
	margin-top:15px;
	margin-left: 480px;
}
.cont{
	margin-top:28px;
	
	}
.posttt{
	margin-left:220px;
}
.pp{
	margin-top:50px;
	margin-left:10px;
	border:1px solid black;
	border-radius:500px;
}
</style>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">

</head>

<body>
	
	<!-- NavBar  -->
	<%@include file="nav.jsp"%>	
	<!-- profile show start -->
	<div class="profile">
		<div class="card mb-3" style="max-width: 540px;">
			<div class="row g-0">
				<div class="col-md-4">
			<img class="profilepic pp" alt="profilepic" width="150" height="150" src="<c:url value="views/image/profilepicture/${profilepic }"/>" />

					
			   <!--  <img src="/views/riya.jpg" class="img-fluid rounded-start" alt="i">  -->  	
				</div>
				<div class="col-md-8">
					<div class="card-body">
					    <h5 class="card-title">${name}</h5>
						<p class="card-text"> Favriote Song:${favSong }<br></p>
  						<p class="card-text"> Favriote Book:${favbook }<br></p>
  						<p class="card-text"> Favriote Place:${favPlace }<br></p>
					   
						
						<!-- Button Profile modal -->
						<button type="button" class="btn btn-secondary"
							data-bs-toggle="modal" data-bs-target="#exampleModal">
							Edit Profile</button>

						<!-- Modal Profile -->
						<div class="modal fade" id="exampleModal" tabindex="-1"
							aria-labelledby="exampleModalLabel" aria-hidden="true">
							<div class="modal-dialog">
								<div class="modal-content">
									<div class="modal-header">
										<h5 class="modal-title" id="exampleModalLabelh">Update
											Profile here</h5>
										<button type="button" class="btn-close"
			 								data-bs-dismiss="modal" aria-label="Close"></button>
									</div>
									<div class="modal-body">
										<form method="post" action="/users/profilesave"  enctype="multipart/form-data">
                                        <div class="mb-3">
                                           <label for="uploadProfilepicture" class="form-label">Upload Photo:</label>
  										   <input type="file" class="form-control" id="uploadProfilepicture" name="profile_pic">
   										  <input type="hidden" name="username" value=${username } />
   										</div>
  										<div class="mb-3">
   										  <label for="song" class="form-label">Favriote Song:</label>
   										  <input type="hidden" name="uid" value=${id }>
										
  										  <input type="text" class="form-control" id="song"  name="favSong">
 									    </div>
 										 <div class="mb-3">
  										  <label for="book" class="form-label">Favriote Book:</label>
  										  <input type="text" class="form-control" id="book" name="favbook">
  									  	</div>                               
  									  		 <div class="mb-3">
  										  <label for="place" class="form-label">Favriote Place:</label>
  										  <input type="text" class="form-control" id="place" name="favPlace">
  									  	</div>                               
  									  		
  								         <input type="submit" class="btn btn-secondary" value="UPDATE" >
										</form>
									</div>
									
								</div>
							</div>
						</div>
						
						<br>
						
						<!-- Button Following modal -->
						<button type="button" class="btn btn-secondary cont"
							data-bs-toggle="modal" data-bs-target="#exampleModal4" style="margin-right:10px;" action="showfollowing">
							Following</button>
						
							
						<div class="modal fade" id="exampleModal4" tabindex="-1"
							aria-labelledby="exampleModalLabel" aria-hidden="true">
							<div class="modal-dialog">
								<div class="modal-content">
									<div class="modal-header">
										<h5 class="modal-title" id="exampleModalLabelheading"> 
											</h5>
										<h5 class="modal-title" id="exampleModalLabelheading"> Following List:
											</h5>
											
										<button type="button" class="btn-close"
			 								data-bs-dismiss="modal" aria-label="Close">
			 								</button>
			 								
									</div>
						<div class="modal-body">
							<table class="table table-bordered table-sm mt-2">

								<tbody>
									<c:forEach var="following" items="${followinglist }">
   										 <tr>
   										 		
       										    <td><c:out value="${following.followingid.name}" /></td>
   										 </tr>
									</c:forEach>

								</tbody>
							</table>
						</div>
							
									
								</div>
							</div>
						</div>
						
							
							
							
						<!-- Modal -->
			<!-- Button Following modal -->
						<button type="button" class="btn btn-secondary cont"
							data-bs-toggle="modal" data-bs-target="#exampleModal10" style="margin-right:10px;" action="showfollowing">
							Follower</button>
						
							
						<div class="modal fade" id="exampleModal10" tabindex="-1"
							aria-labelledby="exampleModalLabel" aria-hidden="true">
							<div class="modal-dialog">
								<div class="modal-content">
									<div class="modal-header">
										<h5 class="modal-title" id="exampleModalLabelheading"> Follower List:
											</h5>
											
										<button type="button" class="btn-close"
			 								data-bs-dismiss="modal" aria-label="Close"></button>
									</div>
										<div class="modal-body">
							<table class="table table-bordered table-sm mt-2">

								<tbody>
									<c:forEach var="follower" items="${followerlist }">
   										 <tr>
   										 		
       										    <td><c:out value="${follower.followerid.name}" /></td>
   										 </tr>
									</c:forEach>

								</tbody>
							</table>
						</div>
							
									
								</div>
							</div>
						</div>
	</div>
	</div>
	</div>
	</div>
	</div>
	<!-- profile show end -->
	<div class="posttt">
	
	
	<!-- Post of user show start -->
	<c:forEach items="${post }" var="post">
		<div class="card" style="width:70rem">
			<p>
				<img width="25" height="25"
					src="<c:url value="views/image/profilepicture/${post.userId.profilePic }"/> ">
				${post.userId.name } 
				
				<img height="500" class="card-img-top" src="<c:url value="views/image/post/${post.postpic }"/>" alt="Card image cap">
				<div class="card-body">
				<form>
					<input type="hidden" name="postId" value=${post.postId }> <input
						type="hidden" name="userId" value=${id }>

					<button id="like" type="submit" formaction="/home/like"
						formmethod="post"><i class="fas fa-heart"></i></button>
				</form>

				<form action="/home/comment" method="post">
					<div class="form-group row">
						<label for="inputPassword3" class="col-sm-3col-form-label"><i class="fas fa-comment"></i>
							</label>
							 <input class="simpleinput" type="text" name="Comment" style="width:400px;"/>
							 <input type="hidden" name="postId" value=${post.postId }>
							 <input type="hidden" name="userId" value=${id }> <input type="submit" value="Post" style="width:200px;"/>
					</div>
					<br>

				</form>

				



			</div>
			<p>
		</div>
	<br>
	</c:forEach>
	</div>
	<!-- Post of user show end -->


    	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
		crossorigin="anonymous"></script>
</body>
</html>







