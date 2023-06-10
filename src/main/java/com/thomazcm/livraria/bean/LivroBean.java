package com.thomazcm.livraria.bean;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class LivroBean {

    private Livro livro = new Livro();

    public void gravar() {
        System.out.println("Gravando livro:\n");
        System.out.println(String.format(
                "Titulo: %s\n"
                + "ISBN: %s\n"
                + "Preço: %f\n"
                + "Data de Lançamento: %s"
                , this.livro.getTitulo(), this.livro.getIsbn(), this.livro.getPreco(), this.livro.getDataLancamento()));
    }
    
    public Livro getLivro() {
        return this.livro;
    }

}
