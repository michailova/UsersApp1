package com.websystique.springmvc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "offices")
@ToString
public class Office  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;
    @Column
    private String title;
    @Column
    private String address;
    @Column(name = "phone_1")
    private String phone1;
    @Column(name = "phone_2")
    private String phone2;
    @Column(name = "postal_code")
    private int postalCode;
    @Column(name = "updated_ts")
    private Timestamp updatedTS;
   // @UpdateTimestamp //todo
    @Column(name ="created_ts") //todo , may be columnDefinition = "CURRENT_TIMESTAMP" or @CreationTimestamp
   // @CreationTimestamp
    private Timestamp createdTS;


}
