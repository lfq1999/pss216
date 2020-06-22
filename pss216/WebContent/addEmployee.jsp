<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>新增销售员</title>
</head>
<body>
<div align="center"><span>新增销售员</span>
<form action="employeeServlet?action=add" method="post">
<table>
<tr><td>姓名：</td><td><input type="text" name="name"/></td></tr>
<tr><td>性别：</td><td><input type="radio" checked="checked" name="sex" value="男"/>男
<input type="radio" name="sex" value="女"/>女</td></tr>
<tr><td>出生日期：</td><td><input type="text" name="birthday"/></td></tr>
<tr><td>电话：</td><td><input type="text" name="phone"/></td></tr>
<tr><td><input type="submit" value="提交"/></td><td><input type="reset" value="取消"/></td></tr>
</table>
</form>
</div>
</body>
</html>