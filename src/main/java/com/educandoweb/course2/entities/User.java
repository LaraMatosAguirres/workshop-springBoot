package com.educandoweb.course2.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity /* -> indica que a classe deve ser mapeada para uma tabela em um banco de dados*/
@Table(name = "tb_user") /* -> a anotação @Table permite que você especifíque informações sobre a tabela correspondente no banco de dados, como nome, o esquema e outras propriedades*/
public class User implements Serializable {
    /* A interface Serializable permite converter um objeto, ou conjunto deles, em bytes, o que permite que eles sejam armazenados em um arquivo, seja transmitido pela rede ou  armazenado em um banco de dados*/
    private static final long serialVersionUID = 1L;
    /* O serialVersionUID é um método pertencente a interface Serializable*/
    @Id /* -> Indica a chave primária da classe em questão, é ela que será utilizada na busca pelas informações ao navegar pelas tabelas no banco de dados*/
    @GeneratedValue(strategy = GenerationType.IDENTITY) /* -> É utilizada para especifiicar se o Id será inserido manualmente ou automaticamentee(define uma estratégia), no caso o Id será definido automaticamente através da expressão strategy = GenerationType.IDENTITY*/
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String password;

    @JsonIgnore /* -> Usado para controlar o que deseja que seja incluído ou excluído, no caso é usado para que não haja informações repetidas quando forem requisitadas as informações do conjunto abaixo*/
    @OneToMany(mappedBy = "client") /* -> Indica um relacionamento Um-Para-Muitos com a classe Order, mapeado pelo nome "client", ou seja, as informações de pediido de um usuário serão buscadas por aqui*/
    private List<Order> orders = new ArrayList<>(); /* -> Indica uma coleção de tipo Order, uma lista de pedidos*/

    public User() {
    }

    public User(Long id, String name, String email, String phone, String password) {
        super();
        this.id = id;          /* Aqui são instanciadas as variáveis declaradas acima, os parâmetros trazem novas informações e comparam com as atuais instanciadas*/
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.password = password;
    }

    /* Getters pegam a informação de algum lugar e setters manda a informação ou munda a informação de algum lugar*/
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public List<Order> getOrders() {
        return orders;
    }

    /* hascode e equals comparam o id para ver se ele pertennce a essa classe*/
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}