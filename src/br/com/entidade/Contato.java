package br.com.entidade;

import java.util.Date;
import java.util.List;

/**
 *
 * @author William
 */
public class Contato {

    private Integer id;
    private String nome;
    private Date nascimento;
    private String email;
    private TipoContato tipoContato;
    private List<Telefone> telefones;

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

    public Date getNascimento() {
        return nascimento;
    }

    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public TipoContato getTipoContato() {
        return tipoContato;
    }

    public void setTipoContato(TipoContato tipoContato) {
        this.tipoContato = tipoContato;
    }

    public List<Telefone> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<Telefone> telefones) {
        this.telefones = telefones;
    }

    @Override
    public String toString() {
        return "Contato{" + "id=" + id + ", nome=" + nome + ", nascimento=" + nascimento + ", email=" + email + ", tipoContato=" + tipoContato + ", telefones=" + telefones + '}';
    }

    
    
    

}
