package com.baizhi.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cm_banner")
public class Banner implements Serializable {
    @Id
    @KeySql(useGeneratedKeys = true)
    private  Integer id;
    private String title;
    private String img_path;
    private String status;
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    @JSONField(format = "yyyy-mm-dd")
    private Date pub_date;
    private String description;

}
