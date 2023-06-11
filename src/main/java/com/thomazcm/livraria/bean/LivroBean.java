package com.thomazcm.livraria.bean;

import java.util.Collections;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import com.thomazcm.livraria.dao.DAO;
import com.thomazcm.livraria.model.Autor;
import com.thomazcm.livraria.model.Livro;

@ManagedBean
@ViewScoped
public class LivroBean {

    private Livro livro = new Livro();
    private Integer autorId;

    public Livro getLivro() {
        return livro;
    }

    public List<Autor> getAutores() {
        return new DAO<Autor>(Autor.class).listaTodos();
    }
    
    public List<Autor> getAutoresDoLivro() {
        return Collections.unmodifiableList(this.livro.getAutores());
    }
    
    public List<Livro> getLivrosCadastrados(){
        return new DAO<Livro>(Livro.class).listaTodos();
    }

    public void gravar() {
        System.out.println("Gravando livro " + this.livro.getTitulo());

        if (livro.getAutores().isEmpty()) {
            throw new RuntimeException("Livro deve ter pelo menos um Autor.");
        }

        new DAO<Livro>(Livro.class).adiciona(this.livro);
        this.livro = new Livro();
    }
    
    public void gravarAutor() {
        Autor autor = new DAO<Autor>(Autor.class).buscaPorId(autorId);
        this.livro.adicionaAutor(autor);
    }

    public Integer getAutorId() {
        return this.autorId;
    }

    public void setAutorId(Integer autorId) {
        this.autorId = autorId;
    }
}
