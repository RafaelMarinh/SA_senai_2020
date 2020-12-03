package br.sc.senai.model;

import javax.persistence.*;

@Entity
@Table(name = "solicitations")
public class Solicitation extends DateAudit {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    @JoinColumn(name="book_id", nullable=false)
    private Book book;

    @ManyToOne
    @JoinColumn(name="usuario_id", nullable=false)
    private Usuario user_solicitation;

    private Integer status_solicitation;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Usuario getUser_solicitation() {
        return user_solicitation;
    }

    public void setUser_solicitation(Usuario user_solicitation) {
        this.user_solicitation = user_solicitation;
    }

    public Integer getStatus_solicitation() {
        return status_solicitation;
    }

    public void setStatus_solicitation(Integer status_solicitation) {
        this.status_solicitation = status_solicitation;
    }
}
