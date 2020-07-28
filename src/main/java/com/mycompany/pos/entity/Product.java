package com.mycompany.pos.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "product")
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
@ToString(includeFieldNames=true)
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @ToString.Exclude
    @Column(name = "id_product")
    private Long idProduct;

    @ManyToOne(cascade = CascadeType.ALL)
    private Supplier supplier;

    @Column(name = "slug")
    private String slug;

    @Column(name = "name")
    private String name;

    @Column(name = "reference")
    private String reference;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "vat")
    private BigDecimal vat;

    @Column(name = "stockable")
    private Boolean stockable;

    @Column(name = "createdAt", nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdAt;
}
