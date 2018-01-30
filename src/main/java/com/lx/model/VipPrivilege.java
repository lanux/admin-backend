package com.lx.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain=true)
@Table(name = "vip_privilege")
public class VipPrivilege implements Serializable {
    /**
     * ID
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SELECT LAST_INSERT_ID()")
    private Long id;

    /**
     * 资源编码,与UPC保持一致
     */
    @Column(name = "asset_code")
    private String assetCode;

    /**
     * 路径
     */
    @Column(name = "pattern")
    private String pattern;

    /**
     * 序号,数字越大优先级越高
     */
    @Column(name = "seq")
    private Integer seq;

    /**
     * 是否删除
     */
    @Column(name = "is_deleted")
    private Byte isDeleted;

    /**
     * 新建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    private static final long serialVersionUID = 1L;
}