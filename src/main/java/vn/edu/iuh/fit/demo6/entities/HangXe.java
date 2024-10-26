package vn.edu.iuh.fit.demo6.entities;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Builder
public class HangXe {
    private String maHangXe;
    private String tenHang;
    private String quocGia;
    private String moTa;
}
