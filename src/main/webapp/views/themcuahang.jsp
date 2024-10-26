<%@ page language="java" contentType="text/html;charset=UTF-8" isELIgnored="false" pageEncoding="UTF-8" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div style="width: 1000px; margin: auto;">
    <h1 style="text-align: center;">Thêm xe</h1>
    <a href="cua-hang-xe-may">Quay lại</a>
    <form action="cua-hang-xe-may" method="post">
        <input type="hidden" name="action" value="add">
        <table>
            <thead></thead>
            <tbody>
            <tr>
                <th>
                    <label for="tenXe">Tên xe</label>
                </th>
                <th>
                    <input type="text" name="tenXe" id="tenXe">
                </th>
            </tr>
            <tr>
                <th>
                    <label for="giaXe">Giá xe</label>
                </th>
                <th>
                    <input type="text" name="giaXe" id="giaXe">
                </th>
            </tr>
            <tr>
                <th>
                    <label for="namSanXuat">Năm sản xuất</label>
                </th>
                <th>
                    <input type="text" name="namSanXuat" id="namSanXuat">
                </th>
            </tr>
            <tr>
                <th>
                    <label for="hangXe">Hãng xe</label>
                </th>
                <th>
                    <select name="hangXe" id="hangXe" style="width: 100%;">
                        <c:forEach var="hs" items="${hangXes}">
                            <option value="${hs.maHangXe}">${hs.tenHang}</option>
                        </c:forEach>
                    </select>
                </th>
            </tr>
            </tbody>
        </table>
        <button type="submit">Thêm</button>
    </form>
</div>
</body>
</html>
