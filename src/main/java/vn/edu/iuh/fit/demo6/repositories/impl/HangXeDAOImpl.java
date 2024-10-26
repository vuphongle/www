package vn.edu.iuh.fit.demo6.repositories.impl;

import jakarta.annotation.Resource;
import vn.edu.iuh.fit.demo6.dao.DBConnection;
import vn.edu.iuh.fit.demo6.entities.HangXe;
import vn.edu.iuh.fit.demo6.entities.Xe;
import vn.edu.iuh.fit.demo6.repositories.HangXeDAO;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class HangXeDAOImpl implements HangXeDAO {
    @Override
    public HangXe getByTenHangXe(String tenHangXe) {
        return null;
    }

    @Resource(name = "LeVuPhongMariaDB")
    private DataSource dataSource;

    @Override
    public List<HangXe> getAll() {
        List<HangXe> list = new ArrayList<HangXe>();

        try {
            Connection connection = dataSource.getConnection();
            String sql = "SELECT * FROM HangXe";
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while(rs.next()){
                HangXe hangXe = HangXe.builder()
                        .maHangXe(rs.getString("MAHANGXE"))
                        .tenHang(rs.getString("TENHANG"))
                        .quocGia(rs.getString("QUOCGIA"))
                        .moTa(rs.getString("MOTA"))
                        .build();
                list.add(hangXe);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return list;
    }
}
