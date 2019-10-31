package com.maxton.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * @Description 实体类
 * @Author maxton.zhang
 * @Date 2019/10/31 11:46
 * @Version 1.0
 */
@Entity
@Table(name = "maxton_user")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserData implements Serializable {
    @Id
    private String user_id;
    private String name;
    private Integer age;
    private Date birthday;
    private Integer sex;
    private Double height;
    private String address;
    private Float credits;
    private Date create_time;

}
