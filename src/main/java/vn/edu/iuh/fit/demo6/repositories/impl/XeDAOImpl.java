package vn.edu.iuh.fit.demo6.repositories.impl;

import vn.edu.iuh.fit.demo6.dao.DBConnection;
import vn.edu.iuh.fit.demo6.entities.HangXe;
import vn.edu.iuh.fit.demo6.entities.Xe;
import vn.edu.iuh.fit.demo6.repositories.XeDAO;

import javax.xml.transform.Result;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class XeDAOImpl implements XeDAO {
    @Override
    public List<Xe> getAll() {
        List<Xe> list = new ArrayList<Xe>();

        try {
            Connection connection = DBConnection.getConnection();
            String sql = "SELECT * FROM Xe xe JOIN HangXe hx ON xe.MaHangXe = hx.MaHangXe";
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while(rs.next()){
                Xe xe = Xe.builder()
                        .maXe(rs.getString("MaXe"))
                        .tenXe(rs.getString("TenXe"))
                        .giaXe(rs.getDouble("GiaXe"))
                        .namSanXuat(rs.getInt("NamSanXuat"))
                        .hangXe(
                                HangXe.builder()
                                        .maHangXe(rs.getString("MaHangXe"))
                                        .tenHang(rs.getString("TenHang"))
                                        .quocGia(rs.getString("QuocGia"))
                                        .build()
                        )
                        .build();
                list.add(xe);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return list;
    }

    @Override
    public Xe insert(Xe xe, String tenHangXe) {
        try {
            Connection connection = DBConnection.getConnection();
            String maXe = UUID.randomUUID().toString();
            String sql = "INSERT INTO Xe (MaXe, TenXe, GiaXe, NamSanXuat, MaHangXe) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, maXe);
            preparedStatement.setString(2, xe.getTenXe());
            preparedStatement.setDouble(3, xe.getGiaXe());
            preparedStatement.setInt(4, xe.getNamSanXuat());
            preparedStatement.setString(5, tenHangXe);

            int rs = preparedStatement.executeUpdate();

            if (rs > 0) {
                xe.setMaXe(maXe);
                return xe;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public List<Xe> getByTenXe(String tenXe) {
        List<Xe> list = new ArrayList<Xe>();

        try {
            Connection connection = DBConnection.getConnection();
            String sql = "SELECT * FROM Xe xe JOIN HangXe hx ON xe.MaHangXe = hx.MaHangXe Where TENXE LIKE ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, "%" + tenXe + "%");
            ResultSet rs = preparedStatement.executeQuery();

            while(rs.next()){
                Xe xe = Xe.builder()
                        .maXe(rs.getString("MaXe"))
                        .tenXe(rs.getString("TenXe"))
                        .giaXe(rs.getDouble("GiaXe"))
                        .namSanXuat(rs.getInt("NamSanXuat"))
                        .hangXe(
                                HangXe.builder()
                                        .maHangXe(rs.getString("MaHangXe"))
                                        .tenHang(rs.getString("TenHang"))
                                        .quocGia(rs.getString("QuocGia"))
                                        .build()
                        )
                        .build();
                list.add(xe);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    @Override
    public Xe getByMaXe(String maXe) {
        try {
            Connection connection = DBConnection.getConnection();
            String sql = "SELECT * FROM Xe xe JOIN HangXe hx ON xe.MaHangXe = hx.MaHangXe WHERE MAXE = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, maXe);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                return Xe.builder()
                        .maXe(rs.getString("MaXe"))
                        .tenXe(rs.getString("TenXe"))
                        .giaXe(rs.getDouble("GiaXe"))
                        .namSanXuat(rs.getInt("NamSanXuat"))
                        .hangXe(
                                HangXe.builder()
                                        .maHangXe(rs.getString("MaHangXe"))
                                        .tenHang(rs.getString("TenHang"))
                                        .quocGia(rs.getString("QuocGia"))
                                        .build()
                        )
                        .build();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
