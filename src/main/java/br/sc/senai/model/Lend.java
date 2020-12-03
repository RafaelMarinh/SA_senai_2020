package br.sc.senai.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "lends")
public class Lend {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    @NotBlank
    @Size(max = 100)
    private String nome;

    @ManyToOne
    @JoinColumn(name="book_id", nullable=false)
    private Book book;

    @ManyToOne
    @JoinColumn(name="usuario_id", nullable=false)
    private Usuario loan_id;

    private Date date_borrow;

    private Date date_devol;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Usuario getLoan_id() {
        return loan_id;
    }

    public void setLoan_id(Usuario loan_id) {
        this.loan_id = loan_id;
    }

    public Date getDate_borrow() {
        return date_borrow;
    }

    public void setDate_borrow(Date date_borrow) {
        this.date_borrow = date_borrow;
    }

    public Date getDate_devol() {
        return date_devol;
    }

    public void setDate_devol(Date date_devol) {
        this.date_devol = date_devol;
    }
}
