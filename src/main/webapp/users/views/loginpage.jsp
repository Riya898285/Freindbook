<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<style>
.container{
    width:500px;
    heighr:700px;
    margin:auto;
    padding:18px 18px;
    margin-top:120px;
   border:0 solid black;
    box-shadow: 8px 8px 8px black;
  
}
</style>
</head>
<body>

<div class="container">

<form method="post" name="login"  action=/users/home>
  <div class="mb-3">
    <label for="exampleInputEmail1" class="form-label">Email ID</label>
    <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" name="email">
   </div>
  <div class="mb-3">
    <label for="exampleInputPassword1" class="form-label">Password</label>
    <input type="password" class="form-control" id="exampleInputPassword1" name="password">
  </div>
  
  
   <input type="submit" class="btn btn-primary" value="Login" style="background-color:#333366"/>
  <a class="btn btn-primary" href="/users/signup" role="button" style="background-color:#333366">Signup</a>
</form>
</div>
</body>
</html>