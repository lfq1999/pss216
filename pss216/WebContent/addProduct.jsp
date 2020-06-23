<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>新增商品</title>
</head>
<body>
<div align="center"><span>新增商品</span>
<form action="productServlet?action=add" method="post">
<table>
<tr><td>商品名称：</td><td><input type="text" name="name"/></td></tr>
<tr><td>商品价格：</td><td><input type="text" name="price"/></td></tr>
<tr><td>储量：</td><td><input type="text" name="store"/></td></tr>
<tr><td><input type="submit" value="提交"/></td><td><input type="reset" value="取消"/></td></tr>
</table>
</form>
</div>
</body>
</html>