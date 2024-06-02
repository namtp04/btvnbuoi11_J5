<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Quan Ly Co So</h1>
<form action="/co-so/add" method="post">
    <p><input type="text" name="id" value="${cs1.id}" style="display: none"></p>
    <p>Ma co so: <input type="text" name="ma" value="${cs1.ma}">
        <span style="color:red;">${errors['ma']}</span>
        <span style="color:red;">${error}</span>
    </p>Ma tai khoan ngan hang:
    <select id="taiKhoanNganHang" name="taiKhoanNganHang">
        <c:forEach items="${lstTK}" var="n">
            <option value="${n.id}" data-name="${n.tenNganHang}" ${n.id == param.taiKhoanNganHang ? 'selected' : ''}>${n.ma}</option>
        </c:forEach>
    </select>
    <span id="nganHangSpan"></span>
<%--    <script>--%>
<%--        document.addEventListener("DOMContentLoaded", function() {--%>
<%--            const select = document.getElementById("taiKhoanNganHang");--%>
<%--            const span = document.getElementById("nganHangSpan");--%>

<%--            select.addEventListener("change", function() {--%>
<%--                const selectedId = select.value;--%>
<%--                console.log("Selected ID:", selectedId)--%>
<%--                const selectedOption = select.querySelector(`option[value="${selectedId}"]`);--%>
<%--                console.log(selectedOption)--%>
<%--                if (selectedOption) {--%>
<%--                    const selectedName = selectedOption.getAttribute("data-name");--%>
<%--                    span.textContent = selectedName;--%>
<%--                } else {--%>
<%--                    console.error("Selected option not found.");--%>
<%--                }--%>
<%--            });--%>
<%--        });--%>
<%--    </script>--%>
    </p>
    <p>SDT co so: <input type="text" name="soDienThoai" value="${cs1.soDienThoai}">
        <span style="color:red;">${errors['soDienThoai']}</span>
    </p>
    <p>Ghi chu: <input type="text" name="ghiChu" value="${cs1.ghiChu}">
        <span style="color:red;">${errors['ghiChu']}</span>
    </p>
    <p>Ma co so: <input type="radio" name="trangThai" value="1" checked ${cs1.trangThai==1?"checked":""}>Hoat dong
        <input type="radio" name="trangThai" value="0" ${cs1.trangThai==0?"checked":""}>Ngung Hoat dong
    </p>
    <button>Add</button>
</form>
<script>
    function submitForm(event){
        event.preventDefault();
        const form = document.getElementById("submitBank")
        const formData = new FormData(form);
        const json = {};
        formData.forEach((value, key) => {
            json[key] = value;
        });
        fetch("/add" , {
            method:'POST',
            headers:{
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(json),
        }).then(response => {
            if (!response.ok) {
                throw new Error('Network response was not ok');
            }
            return response.json();
        })

    }
</script>
</body>
</html>