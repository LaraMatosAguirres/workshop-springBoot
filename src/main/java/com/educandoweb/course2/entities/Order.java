package com.educandoweb.course2.entities;

import com.educandoweb.course2.entities.enums.OrderStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity /* -> indica um mapeamento para uma tabela no banco de dados, criação de uma tabela espelho*/
@Table(name = "tb_order")/* -> personalização do nome da tabela*/
public class Order implements Serializable{
    /* conversão dos obejtos para bytes para serem armazenados no banco de dadoos*/
    private static final long serialVersionUID = 1L;

    @Id /* chave primária*/
    @GeneratedValue(strategy = GenerationType.IDENTITY)/* declaração da estratégia da chave primária, estratégia automáatica*/
    private Long id;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd 'T' HH:mm:ss 'Z'", timezone = "GMT") /*-> controla a formatação de datas*/
    private Instant moment;

    private Integer orderStatus;

    @ManyToOne /* -> Relacionamento com a classe User representado pelo nome client*/
    @JoinColumn( name ="client_id") /* -> define a chave estrangeira e o nome da coluna na tabela no banco de dados*/
    private User client;

    @OneToMany(mappedBy = "id.order")/* -> relacionamento com a classe OrderItem, buscando os dados por id.order*/
    private Set<OrderItem> items = new HashSet<>();

    @OneToOne(mappedBy = "order", cascade = CascadeType.ALL)
    private Payment payment;

    public Order(){
    }

    public Order(Long id, Instant moment, User client, OrderStatus orderStatus) {
        this.id = id;
        this.moment = moment;
        this.client = client;
        setOrderStatus(orderStatus);

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getMoment() {
        return moment;
    }

    public void setMoment(Instant moment) {
        this.moment = moment;
    }

    public OrderStatus getOrderStatus() {
        return OrderStatus.valueOf(orderStatus);
    }

    /* método testando se a os nomes que correspondem ao enum são nulos ou não */
    public void setOrderStatus(OrderStatus orderStatus) {
        if(orderStatus != null) {
            this.orderStatus = orderStatus.getCode();
        }
    }

    public User getClient() {
        return client;
    }

    public void setClient(User client) {
        this.client = client;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public Set<OrderItem> getItems() {
        return items;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(id, order.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
