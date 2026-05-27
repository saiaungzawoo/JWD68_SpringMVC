<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Information</title>
</head>
<body>

<h3>Student Info</h3>

ID: ${studObj.id} <br>
Name: ${studObj.name} <br>
Age: ${studObj.age} <br>

<br> Password : ${studObj.password}
  <br> Address : ${studObj.address}
  <br> Newsletter : ${studObj.newsletter}
  <br> Frameworks : 
  
  <c:forEach items="${studObj.frameworks}" var="frame">
  <p>${frame}</p>
  
  </c:forEach>
  <br>
  
  Gender: ${studObj.gender}
  <br>
  
 Fav Number: ${studObj.favNumber}
 <br>
 
 Country: ${studObj.country}
 <br>
 

  Skills: 
  <br>
  <c:forEach items="${studObj.skills}" var="skills" >   
 <p>${skills}</p>
 
 </c:forEach>
 <br>

</body>
</html>