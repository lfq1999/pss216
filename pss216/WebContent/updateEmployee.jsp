<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>修改雇员</title>
</head>
<body>
<div align="center">
修改雇员
<form method="post" action="employeeServlet?action=update">
<table>
<tr><td>员工编号：</td><td><input type="text" name="eid" value="${emp.eid }" readonly="readonly"/></td></tr>
<tr><td>姓名：</td><td><input type="text" name="name" value="${emp.name }"/></td></tr>

<tr>
<td>性别：</td>

<c:if test="${emp.sex=='男' }">
<td>
<input type="radio" checked="checked" name="sex" value="男"/>男
<input type="radio" name="sex" value="女"/>女
</td>
</c:if>

<c:if test="${emp.sex=='女' }">
<td>
<input type="radio" name="sex" value="男"/>男
<input type="radio" checked="checked" name="sex" value="女"/>女
</td>
</c:if>
</tr>

<tr><td>出生日期：</td><td><input type="text" name="birthday" value="${emp.birthday }"/></td></tr>
<tr><td>电话：</td><td><input type="text" name="phone" value="${emp.phone }"/></td></tr>
<tr><td><input type="submit" value="修改" /></td><td><input type="reset" value="取消"/></td></tr>
</table>

</form>
</div>
</body>
</html>