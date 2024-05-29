<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Detail</h1>
    <p><input type="text" name="id" value="${cs1.id}" style="display: none"></p>
    <p>Ma co so: ${cs1.ma}</p>
    <p>Ma tai khoan ngan hang: ${cs1.taiKhoanNganHang.ma}</p>
    <p>SDT co so: ${cs1.soDienThoai}</p>
    <p>Ghi chu: ${cs1.ghiChu}</p>
    <p>Ma co so:${cs1.trangThai==1?"Hoat dong":"Ngung hoat dong"}</p>
</form>
</body>
</html>