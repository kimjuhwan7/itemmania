package com.itemmania.entity;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "mileage")
public class MileageEntity {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int mileageNum;

    @ManyToOne
    @JoinColumn(name = "userNum")
    private UserEntity userNum;

    @Column
    @NotNull
    private LocalDateTime mileageTime;

    @Column
    @NotNull
    private String mileageType;

    @Column
    private String mileageDescription;

    @Column
    private int mileageIn;

    @Column
    private int mileageOut;

    @Column
    private int mileageHistory;
}