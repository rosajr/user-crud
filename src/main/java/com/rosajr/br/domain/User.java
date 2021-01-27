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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.io.Serializable;

@Getter
@Setter
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_user")
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "USR_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "USR_EMAIL")
    private String email;

    @Column(name = "USR_PHONE")
    private String phone;

    @Column(name = "USR_CPF")
    private String cpf;

    @Column(name = "USR_PASSWORD")
    private byte[] password;

    @JoinColumn(name = "USR_ADD_ID",referencedColumnName = "ADD_ID")
    @OneToOne
    private Address address;

}