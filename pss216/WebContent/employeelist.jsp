<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>销售员管理</title>
<style>
table,table tr th,table tr td{
	border:1px solid #000;
	text-align:center;
}
table{
	width:600px;
	border-collapse:collapse;
}
#addemp{
	width:600px;
	height:50px;
}
#addemp p{
	padding-top:5px;
	padding-left:480px;
}
a{
	text-decoration:none;
}
</style>
</head>
<body>
<div align="center">
<font size="5">销售员管理</font>
<div id="addemp">
<input type="text" name="kw"/>
<input type="submit" value="搜索"/>&nbsp;&nbsp;&nbsp;<a href="addEmployee.jsp">新增</a>
<p></p></div>
<form method="post" action="">
<table>
<tr><td><input id="checkAll" name="checkAll" type="checkbox" value="">全选</td><td>员工编号</td><td>姓名</td><td>性别</td><td>出生日期</td><td>电话</td><td>操作</td></tr>


<c:forEach items="${pageBean.list }" var="emp">
<tr>
<td><input id="myCheck" name="check" type="checkbox" value="${emp.eid }"></td>
<td>${emp.eid }</td>
<td>${emp.name }</td>
<td>${emp.sex }</td>
<td>${emp.birthday }</td>
<td>${emp.phone }</td>
<td><a href="employeeServlet?action=queryByID&eid=${emp.eid }">编辑</a>
&nbsp;&nbsp;<a href="employeeServlet?action=delete&eid=${emp.eid }" onclick="return confirm('是否确认删除？');">删除</a></td>
</tr>
</c:forEach>
</table>

<input type="button" value="批量删除" onclick="alert('删除')"/>
<br>
第${pageBean.currentPage }页 共${pageBean.totalPage }页&nbsp;&nbsp;&nbsp;&nbsp;
<a href="employeeServlet?action=findByPage&currentPage=1">首页</a>&nbsp;&nbsp;&nbsp;&nbsp;
<a href="employeeServlet?action=findByPage&currentPage=${pageBean.currentPage-1 }">上一页</a>&nbsp;&nbsp;&nbsp;&nbsp;
<a href="employeeServlet?action=findByPage&currentPage=${pageBean.currentPage+1 }">下一页</a>&nbsp;&nbsp;&nbsp;&nbsp;
<a href="employeeServlet?action=findByPage&currentPage=${pageBean.totalPage }">尾页</a>&nbsp;&nbsp;&nbsp;&nbsp;
每页显示
<select name="pageSize">
<option value="10">10</option>
<option value="20">20</option>
<option value="50">50</option>

</select>条
</form>
</div>
</body>
</html>