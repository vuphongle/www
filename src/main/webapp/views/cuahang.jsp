<%@ page language="java" contentType="text/html;charset=UTF-8" isELIgnored="false" pageEncoding="UTF-8" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <style>
        table, th, td {
            border: 1px solid black;
        }
    </style>
</head>
<body>
<div style="width: 1000px; margin: auto;">
    <h1 style="text-align: center;">Cửa hàng xe máy ABC</h1>

    <div style="display: flex; justify-content: space-between;">
        <div>
            <a href="cua-hang-xe-may">DANH SÁCH XE</a>
            <a href="cua-hang-xe-may?action=add">THÊM XE</a>
        </div>

        <div>
            <form action="cua-hang-xe-may">
                <input type="hidden" name="action" value="filter">
                <input type="text" name="paramFilter">
                <button>Tìm kiếm</button>
            </form>
        </div>
    </div>

    <table style="margin: auto; width: 1000px;">
        <thead>
        <tr>
            <th>Mã Xe</th>
            <th>Tên Xe</th>
            <th>Giá Xe</th>
            <th>Năm Sản Xuất</th>
            <th>Hãng Xe</th>
            <th>Sửa</th>
        </tr>
        </thead>
        <tbody>

        <c:forEach items="${xes}" var="xe">
            <tr>
                <td>${xe.maXe}</td>
                <td>${xe.tenXe}</td>
                <td>${xe.giaXe}</td>
                <td>${xe.namSanXuat}</td>
                <td>${xe.hangXe.tenHang}</td>
                <td>
                    <a href="cua-hang-xe-may?action=edit&maXe=${xe.maXe}">....</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>