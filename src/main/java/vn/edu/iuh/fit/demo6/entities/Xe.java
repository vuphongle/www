package vn.edu.iuh.fit.demo6.entities;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter @Getter
@ToString
@Builder
public class Xe {
    private String maXe;
    private String tenXe;
    private double giaXe;
    private int namSanXuat;
    private HangXe hangXe;
}
