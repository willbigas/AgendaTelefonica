package br.com.entidade;

/**
 *
 * @author William
 */
public class Telefone {

    private Integer id;
    private String ddd;
    private String numero;
    private Contato contato;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDdd() {
        return ddd;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Contato getContato() {
        return contato;
    }

    public void setContato(Contato contato) {
        this.contato = contato;
    }

    @Override
    public String toString() {
        return "(" + ddd + ")-[" + numero + "]";
    }
    
    

}
