package com.rosajr.br.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
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
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "TB_ADDRESS")
public class Address implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ADD_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ADD_ZIPCODE")
    private String zipCode;

    @ManyToOne
    @JoinColumn(name = "ADD_CIT_ID", referencedColumnName = "CIT_ID")
    private City city;

    @Column(name = "ADD_STREET")
    private String street;

    @Column(name = "ADD_NUMBER")
    private String number;

    @Column(name = "ADD_NEIGHBORHOOD")
    private String neighborhood;

    @Column(name = "ADD_COMPLEMENT")
    private String complement;

}
