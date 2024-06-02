<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<button><a href="/co-so/hien-thi">Hiển thị</a></button>
<button><a href="/co-so/view-add">Add</a></button>
<table border="1">
    <tr>
        <th>#</th>
        <th>Mã cơ sở</th>
        <th>Mã tài khoản ngân hàng</th>
        <th>SĐT cơ sỏ</th>
        <th>Ghi chú</th>
        <th>Trạng thái</th>
        <th>Action</th>
    </tr>
    <c:forEach items="${lstCS}" var="cs" varStatus="loop">
        <tr>
            <td>${loop.count}</td>
            <td>${cs.ma}</td>
            <td>${cs.taiKhoanNganHang.ma}</td>
            <td>${cs.soDienThoai}</td>
            <td>${cs.ghiChu}</td>
            <td>${cs.trangThai==1?"Hoat dong":"Ngung hoat dong"}</td>
            <td>
                <button><a href="/co-so/remove/${cs.id}">Remove</a></button>
                <button><a href="/co-so/detail/${cs.id}">Detail</a></button>
                <button><a href="/co-so/view-update/${cs.id}">Update</a></button>
            </td>
        </tr>
    </c:forEach>
</table>
<c:if test="${currentPage==0}">
    <button disabled>Previous</button>
</c:if>
<c:if test="${currentPage>0}">
    <button><a href="?page=${currentPage-1}">Previous</a></button>
</c:if>
<c:forEach begin="1" end="${totalPage}" var="n">
    <button><a href="?page=${n-1}">${n}</a></button>
</c:forEach>
<c:if test="${currentPage==totalPage-1}">
    <button disabled>Next</button>
</c:if>
<c:if test="${currentPage<totalPage-1}">
    <button><a href="?page=${currentPage+1}">Next</a></button>
</c:if>
</body>
</html>