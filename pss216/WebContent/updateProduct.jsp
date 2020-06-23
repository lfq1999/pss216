<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>修改商品</title>
</head>
<body>
<div align="center">
修改商品
<form method="post" action="productServlet?action=update">
<table>
<tr><td>商品编号：</td><td><input type="text" name="pid" value="${pro.pid }" readonly="readonly"/></td></tr>
<tr><td>商品名称：</td><td><input type="text" name="name" value="${pro.name }"/></td></tr>
<tr><td>商品价格：</td><td><input type="text" name="price" value="${pro.price }"/></td></tr>
<tr><td>储量：</td><td><input type="text" name="store" value="${pro.store }"/></td></tr>
<tr><td><input type="submit" value="修改" /></td><td><input type="reset" value="取消"/></td></tr>
</table>

</form>
</div>
</body>
</html>