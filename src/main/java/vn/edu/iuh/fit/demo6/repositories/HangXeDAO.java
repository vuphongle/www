package vn.edu.iuh.fit.demo6.repositories;

import vn.edu.iuh.fit.demo6.entities.HangXe;

import java.util.List;

public interface HangXeDAO {
    HangXe getByTenHangXe(String tenHangXe);

    List<HangXe> getAll();
}
