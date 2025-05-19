<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page isELIgnored="false" %>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Actor Report</title>
</head>
<body style="text-align:center; "> 
      
         <h1>Actor Report</h1>
        <c:choose>
        
        	<c:when test="${!empty actorsList }">
        	
        	 <table border="1" bgcolor="cyan" align="center">
        	       <tr>
        	          <th>ActorID</th> <th>Actor Name</th> <th> ActorImage </th>
        	       </tr>
				  <c:forEach var="actor" items="${actorsList}">
					<tr>
						<td>${actor.id}</td>
						<td>${actor.name}</td>
						<td><img src="image?id=${actor.id}" width="120" height="100" /></td>
				  </c:forEach>
			</table>
        	
        	</c:when>
        	<c:otherwise>
        	    <h2>Actor not found</h2>
        	</c:otherwise>
        
        </c:choose>
        
        <h2><a href="./">HomePage</a></h2>
</body>
</html>