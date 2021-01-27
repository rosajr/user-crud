package com.rosajr.br.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "TB_CITY")
public class City implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "CIT_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "CIT_CODE_IBGE")
    private Integer codeIbge;

    @Column(name = "CIT_NAME")
    private String name;

    @ManyToOne
    @JoinColumn(name = "CIT_STA_ID", referencedColumnName = "STA_ID")
    private State state;
}
