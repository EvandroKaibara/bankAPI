package com.curso.bankapi.models;

import jakarta.persistence.*;

@Entity @Table(name = "clientes")
public class Customer {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private Integer id;

    @Column(name = "nome")
    private String name;

    @Column
    private String cpf;

    //Constructors
    public Customer(String name, String cpf) {
        this.name = name;
        this.cpf = cpf;
    }

    public Customer() {
    }

    //Getters
    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCpf() {
        return cpf;
    }

    //Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cpf='" + cpf + '\'' +
                '}';
    }
}
