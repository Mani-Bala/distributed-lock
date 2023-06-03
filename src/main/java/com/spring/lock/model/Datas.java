package com.spring.lock.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedNativeQueries;
import jakarta.persistence.NamedNativeQuery;
import jakarta.persistence.Table;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

@Table(name = "datas")
@Entity
@Data
@NamedNativeQuery(name = "@UPDATE_DATA_VERSION",
        query = "UPDATE datas SET  data = :data , version = :version WHERE id = :id")
public class Datas implements java.io.Serializable {

    private static final long serialVersionUID = 2753224495497063483L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    @Column(name = "ENTITY_ID", unique = true, nullable = false)
    private Long id;

    @Column(name = "data")
    private Long data;

    @Column(name = "version")
    private Integer version;

}
