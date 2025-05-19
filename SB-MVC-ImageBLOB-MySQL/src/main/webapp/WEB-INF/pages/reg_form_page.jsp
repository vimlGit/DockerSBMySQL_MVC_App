<%@ taglib uri="http://www.springframework.org/tags/form" prefix="frm" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head><title>Upload Image</title></head>
<body>
    <h2 style="color:green; text-align:center;">Actor Reg with Image</h2>

      <h2 style="color:green; text-align:center;">${msg}</h2><br>
    <frm:form method="POST" action="register" enctype="multipart/form-data" modelAttribute="actor">
        <table border="1" align="center" bgcolor="yellow">
            <tr>
                <td>Name:</td>
                <td><frm:input path="name" /></td>
            </tr>
            <tr>
                <td>Select Image:</td>
                <td><input type="file" name="file" /></td>
            </tr>
            <tr>
                <td colspan="2" align="center"><input type="submit" value="Submit" /></td>
            </tr>
        </table>
    </frm:form>

   <%--  <c:if test="${not empty imageId}">
        <h3>Uploaded Image:</h3>
        <img src="image/${imageId}" width="300"/>
    </c:if> --%>
</body>
</html>
