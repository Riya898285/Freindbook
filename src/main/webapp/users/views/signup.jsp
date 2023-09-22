<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"  
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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
<%  
StringBuffer sb=new StringBuffer();  
for(int i=1;i<=5;i++)  
{  
    sb.append((char)(int)(Math.random()*79+23+7));  
}  
String cap=new String(sb);  
%>  
<div class="container">
<script type ="text/javascript">  
function validation(){  
    var c = document.forms ["f1"]["cap1"].value;  
    if(c==null||c=="")  
    {  
       alert ("Please Enter Captcha");  
       return false;  
    }  
}  
</script> 
<form method="post" name="f1"  action="/users" >
 <div class="mb-3">
    <label for="exampleInputEmail1" class="form-label">Full Name</label>
    <input type="text" class="form-control" id="exampleInputFullName" name="name">
   </div>
  <div class="mb-3">
    <label for="exampleInputEmail1" class="form-label">Email ID</label>
    <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" name="email">
   </div>
  <div class="mb-3">
    <label for="exampleInputPassword1" class="form-label">Password</label>
    <input type="password" class="form-control" id="exampleInputPassword1" name="password">
  </div>

      <div style="background-color: #808080"><h2><s><i><font face="casteller"><%=cap%></font></i></s></h2></div>  
    
    <div class="mb-3">
    <label for="exampleShowFillCapacha" class="form-label">Fill Kepcha</label>
    <input type="text" name="cap1" value="" class="form-control" />  
    <input type="hidden" name="cap2" value='<%=cap%>' readonly="readonly"  /> 
   </div>

  
   <input type="submit" class="btn btn-primary" value="Signin" style="background-color:#333366"/>
</form>
</div>
</body>
</html>