<%@ page contentType="text/html; charset=UTF-8" %> 
<html> 
<head> 
<title>File Upload Example</title> 
</head> 
<body> 
FileName : 
<b> ${fileName} </b> - Uploaded Successfully. 

<br>




<img src="${pageContext.request.contextPath}/${filePath}" width="200"/>
</body> 
</html>