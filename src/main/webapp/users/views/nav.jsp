<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.4.1/css/all.css" integrity="sha384-5sAR7xN1Nv6T6+dT2mhtzEpVJvfS3NScPQTrOxhwjIuvcA67KV2R5Jz6kr4abQsz" crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Navbar</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<style type="text/css">

</style>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <div class="container-fluid">
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarTogglerDemo03" aria-controls="navbarTogglerDemo03" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <img class="profilepic" alt="profilepic" width="2%" height="3%" src="<c:url value="views/image/profilepicture/${profilepic }"/>" />
    <!--  <img src="/views/riya.jpg" class="navbar-brand"  width="2%" height="3%"/>
   -->
        <a class="navbar-brand" href="#">${username}</a>
    <div class="collapse navbar-collapse" id="navbarTogglerDemo03">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="home">
				<i class="fas fa-home"></i>
		  </a>
        </li>
       <li class="nav-item">
         <a class="nav-link active" aria-current="page" href="profile">
 			<i class="fas fa-user"></i>
 		</a>
     
        </li>
        <li class="nav-item">
         <a class="nav-link active" aria-current="page" href="notification">
 			 <i class="far fa-bell"></i>
 		</a>
     
        </li>
     
      </ul>
             
      
      <form class="d-flex" style="margin-right:10px;">
				<input class="form-control me-2" type="search" name="username"
					placeholder="Search" arial-label="Search">
				<button class="btn btn-outline-success" formmethod="get" formaction="search" type="submit">Search</button>
	</form>
      <a class="nav-link active"  aria-current="page" href="/users" style="color:black;">
      <i class="fas fa-power-off"></i>
      </a>
      
    </div>
  </div>
</nav>



</body>
</html>

 <!-- 
              
              <div class="uploadPost" style="margin-right:10px;">
						<button type="button" class="btn btn-secondary"
							data-bs-toggle="modal" data-bs-target="#exampleModal2">
							Upload Post</button>

						
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
										   <form method="post" action="post"  enctype="multipart/form-data">
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
					</div> -->