<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<style>
.up{
margin-left:700px;
margin-top:18px;


}
.con{
border:2px solid black;
width:500px;
height:400px;
margin-left:12px;
}
.post{
margin-left:220px;
}
</style>
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.4.1/css/all.css" integrity="sha384-5sAR7xN1Nv6T6+dT2mhtzEpVJvfS3NScPQTrOxhwjIuvcA67KV2R5Jz6kr4abQsz" crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Home Page</title>

<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</head>
<body>

		<%@include file="nav.jsp"%>
		        <!-- Upload Post Start -->
   
				<!-- Button upload post trigger modal -->
				<div class="uploadPost up" style="margin-right:10px;">
						<button type="button" class="btn btn-secondary"
							data-bs-toggle="modal" data-bs-target="#exampleModal2">
							Upload Post</button>
							
						<!-- Modal -->
						<div class="modal fade" id="exampleModal2" tabindex="-1"
							aria-labelledby="exampleModalLabel" aria-hidden="true">
							<div class="modal-dialog">
								<div class="modal-content">
									<div class="modal-header">
										<h5 class="modal-title" id="exampleModalLabel">Upload Post
											</h5>
										<button type="button" class="btn-close"
			 								data-bs-dismiss="modal" aria-label="Close"></button>
									</div>
									<div class="modal-body">
										<form method="post" action="/post"  enctype="multipart/form-data">
                                        <div class="mb-3">
                                           <label for="uploadPost" class="form-label">Post:</label>
  										   <input type="file" class="form-control" id="uploadPost" name="postpic">
   										  <input type="hidden" name="username" value=${username } />
   										</div>                               
  									  		
  								         <input type="submit" class="btn btn-secondary" value="Upload Post" >
										</form>
									</div>
									
								</div>
							</div>
						</div>
					</div>
					<!-- upload Post ENd -->
					<!-- Post Show start -->
					
		<br>
		<br>
			
		<div class="post">			
		<h3 style="margin-left:450px">Uploaded Post:</h3>
		<c:forEach items="${Allpost }" var="post">
		<div class="card" style="width:70rem">
			<p>
				<img width="25" height="25"
					src="<c:url value="views/image/profilepicture/${post.userId.profilePic }"/> ">
				${post.userId.name } 
				
				<img  height="500" class="card-img-top" src="<c:url value="views/image/post/${post.postpic }"/>" alt="Card image cap">
				
				<div class="card-body">
				<form>
					<input type="hidden" name="postId" value=${post.postId }> <input
						type="hidden" name="userId" value=${id }>

					<button id="like" type="submit" formaction="/home/like"
						formmethod="post"><i class="fas fa-heart"></i></button>
				</form>

				
				<br>


				<form action="/home/comment" method="post">
					<div class="form-group row">
						<label for="inputPassword3" class="col-sm-3col-form-label"><i class="fas fa-comment">comment:</i>
							</label> <input class="simpleinput" type="text" name="Comment" style="width:400px;"
							 /> <input type="hidden"
							name="postId" value=${post.postId }>
							 <input type="hidden" name="userid" value=${id }><input type="submit" value="Post" style="width:200px;"/>
					</div>
					<br>
				</form>
				
				<!-- View Like starts -->
					<form>
					<input type="hidden" name="postId" value=${post.postId }>
						<!-- Button Following modal -->
						<button type="button" class="btn btn-secondary cont"
							data-bs-toggle="modal" data-bs-target="#exampleModal4" style="margin-right:10px;" action="showfollowing">
							Like Show</button>
						
							
						<div class="modal fade" id="exampleModal4" tabindex="-1"
							aria-labelledby="exampleModalLabel" aria-hidden="true">
							<div class="modal-dialog">
								<div class="modal-content">
									<div class="modal-header">
										<h5 class="modal-title" id="exampleModalLabelheading"> 
											</h5>
										<h5 class="modal-title" id="exampleModalLabelheading"> Likes:
											</h5>
											
										<button type="button" class="btn-close"
			 								data-bs-dismiss="modal" aria-label="Close">
			 								</button>
			 								
									</div>
						<div class="modal-body">
							<table class="table table-bordered table-sm mt-2">

								<tbody>
											<c:forEach var="like" items="${likess }">
												<c:if test="${like.postId.postId eq post.postId}">
													<tr>
														<td><c:out value=" ${like.userId.name }" /></td>
													</tr>
												</c:if>
											</c:forEach>
								</tbody>
							</table>
						</div>
							
									
								</div>
							</div>
						</div>
						
						
					</form>
					
					
				<!-- View Like Ends -->
				<br>
				<!-- View Comment start -->
			<form>
					<input type="hidden" name="postId" value="${post.postId }">
					<label>Comments : </label>
					<table class="table table-bordered table-sm mt-2">


						<tbody>
							<c:forEach var="comment" items="${comment }">
								<c:set var="postid" scope="session" value="${post.postId}" />
								<c:set var="postidcomm" scope="session"
									value="${comment.postId.postId}" />


								<c:if test="${comment.postId.postId eq post.postId}">


									<tr>
										<td><c:out value=" ${comment.userid.name }" /></td>
										<td><c:out value=" ${comment.Comment }" /></td>
									</tr>
								</c:if>
							</c:forEach>


						</tbody>
					</table>

				</form>
			<!--view Comment ends-->


			</div>
			<p>
		</div>
		<br>

	</c:forEach>
	</div>			



				

					
					
					<!-- Post show end -->
			

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
		crossorigin="anonymous"></script>
</body>
</html>