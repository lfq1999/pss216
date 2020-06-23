<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>销售员管理</title>
<script src="js/jquery-3.3.1.min.js"></script>
<script>
		function fun(){
			var a=document.getElementsByName('info');
			var b=0;     //设定一个初始值
			for(var i=0;i<a.length;i++)
			{
					
				if(a[i].checked==true)
				{
					return true;
				}
				else
				{
					if(a[i].checked==false)
					{
						b++;    //如果方框没选中，该值会累加
					} 
					if(b==a.length)   //如果该值和方框的个数相同，那么就会报错
					{
						alert('至少要选择一项！');
						return false;
					}
				}
			}
		}
		function checkAll(checkall) {  
			arr = document.getElementsByName('info'); 
			if (checkall.checked == true) { 
				for(i=0;i<arr.length;i++){ 
					
					arr[i].checked = true; 
				}
 
				}else{
					for(i=0;i<arr.length;i++){ 
						if((arr[i]).checked==false){
							arr[i].checked = true;
						}else
						{
							arr[i].checked = false;
						}
					}
				}
	}  
 
	function deleteAll(){
		alert("确定删除吗？");
		var checkId=[];
		if($("input[type='checkbox']:checked").length>0){
			$("input[type='checkbox']:checked").each(function (i){
				checkId[i]=$(this).val();
			})
			window.location.href="productServlet?action=deleteAll&checkId="+checkId;
		}else{
			alert("请选择你要删除的信息");
		}
	}
</script>
<style>
table,table tr th,table tr td{
	border:1px solid #000;
	text-align:center;
}
table{
	width:600px;
	border-collapse:collapse;
}
#addpro{
	position:relative;
	width:600px;
	height:30px;
	top:0px;
	right:165px;
}
#addpro p{
	padding-top:5px;
	padding-left:100px;
}
a{
	text-decoration:none;
}
#myCheck{
	position:relative;
	top:2px;
	right:260px;
}
</style>
</head>
<body>
<div align="center">
<form action="productServlet?action=queryByKeyWords" method="post">
<font size="5">商品管理</font>
<div id="addpro"><input type="text" name="kw"/>&nbsp;<input type="submit" value="搜索">
&nbsp;&nbsp;<a href="addProduct.jsp"><input type="button" value="新增"></a></div>
<table>
<tr><td><input id="checkall" name="checkall" type="checkbox" onclick="checkAll(checkall)">全选</td><td>商品编号</td><td>商品名称</td><td>商品价格</td><td>储量</td><td>操作</td></tr>
<c:forEach items="${pageBean.list}" var="pro">
<tr><td><input  name="info" type="checkbox" value="${pro.pid}"></td><td>${pro.pid}</td><td>${pro.name}</td><td>${pro.price}</td>
<td>${pro.store}</td>
<td><a href="productServlet?action=queryByID&pid=${pro.pid }">编辑</a>&nbsp;&nbsp;
<a href="productServlet?action=delete&pid=${pro.pid }" onclick="return confirm('您确定要删除吗？');">删除</a></td>
</tr>
</c:forEach>
</table>
<div id="myCheck">
<input id="CheckDelete" type="button" value="批量删除"  onclick="deleteAll()"/>
</div>
<br>
第${pageBean.currentPage}页 共${pageBean.totalPage}页&nbsp;&nbsp;&nbsp;&nbsp;
<a href="productServlet?action=findByPage&currentPage=1">首页</a>&nbsp;&nbsp;&nbsp;&nbsp; 
<a href="productServlet?action=findByPage&currentPage=${pageBean.currentPage-1}">上一页 </a>&nbsp;&nbsp;&nbsp;&nbsp; 
<a href="productServlet?action=findByPage&currentPage=${pageBean.currentPage+1}">下一页</a>&nbsp;&nbsp;&nbsp;&nbsp;
<a href="productServlet?action=findByPage&currentPage=${pageBean.totalPage}">尾页</a>&nbsp;&nbsp;&nbsp;&nbsp;
每页显示
<select name="pageSize" onchange="window.location=this.value;">
<option value="productServlet?action=findByPage&currentPage=${pageBean.currentPage}&pageSize=5">5</option>
<option value="productServlet?action=findByPage&currentPage=${pageBean.currentPage}&pageSize=10">10</option>
<option value="productServlet?action=findByPage&currentPage=${pageBean.currentPage}&pageSize=20">20</option>
<option value="productServlet?action=findByPage&currentPage=${pageBean.currentPage}&pageSize=50">50</option>
</select>条;
</form>
</div>
</body>
</html>