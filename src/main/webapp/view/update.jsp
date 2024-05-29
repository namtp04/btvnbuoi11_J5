<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Quan Ly Co So</h1>
<form action="/co-so/update" method="post">
    <p><input type="text" name="id" value="${cs1.id}" style="display: none"></p>
    <p>Ma co so: <input type="text" name="ma" value="${cs1.ma}"></p>
    <p>Ma tai khoan ngan hang:
        <select name="taiKhoanNganHang">
            <c:forEach items="${lstTK}" var="n">
                <option value="${n.id}">${n.ma}</option>
            </c:forEach>
        </select>
    </p>
    <p>SDT co so: <input type="text" name="soDienThoai" value="${cs1.soDienThoai}"></p>
    <p>Ghi chu: <input type="text" name="ghiChu" value="${cs1.ghiChu}"></p>
    <p>Ma co so: <input type="radio" name="trangThai" value="1" checked ${cs1.trangThai==1?"checked":""}>Hoat dong
        <input type="radio" name="trangThai" value="0" ${cs1.trangThai==0?"checked":""}>Ngung Hoat dong
    </p>
    <button>Add</button>
</form>
</body>
</html>