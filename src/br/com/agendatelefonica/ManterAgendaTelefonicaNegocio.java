package br.com.agendatelefonica;

import br.com.entidade.Contato;
import br.com.entidade.Telefone;
import br.com.entidade.TipoContato;
import java.awt.HeadlessException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import br.com.utilpacket.Util_Arquivo;
import br.com.utilpacket.Util_Format;

/**
 *
 * @author WILL
 */
public class ManterAgendaTelefonicaNegocio {

    public static void modificandoTipoContatoDoContato(String mensagemTipoContato, Contato contatoPesq) throws Exception {
        Object obj = Principal.tipoContatoDao.pesquisar(Integer.valueOf(mensagemTipoContato));
        TipoContato TipoContatoPesquisado = (TipoContato) obj;
        TipoContatoPesquisado.setNome(mensagemTipoContato);
        contatoPesq.setTipoContato(TipoContatoPesquisado);
        Principal.contatoDao.updateTipoContato(contatoPesq);
    }

    public static void criandoTelefones(List<Telefone> TELEFONES_DO_USUARIO) throws Exception, HeadlessException, NumberFormatException {
        String msgDDD = JOptionPane.showInputDialog("Insira um DDD");
        String msgTelefone = JOptionPane.showInputDialog("Insira um numero de telefone!");
        Telefone telefone = new Telefone();
        telefone.setDdd(Integer.valueOf(msgDDD));
        telefone.setNumero(Integer.valueOf(msgTelefone));
        Principal.telefoneDao.inserir(telefone);
        List<?> objPesquisados = Principal.telefoneDao.pesquisarTodos();
        List<Telefone> TELEFONES = new ArrayList<>();
        for (int i = 0; i < objPesquisados.size(); i++) {
            Telefone telPesquisado = (Telefone) objPesquisados.get(i);
            TELEFONES.add(telPesquisado);
        }
        for (int i = 0; i < TELEFONES.size(); i++) {
            Telefone resultado = TELEFONES.get(i);
            if (resultado.getNumero().equals(Integer.valueOf(msgTelefone))) {
                TELEFONES_DO_USUARIO.add(resultado);
            }
        }
    }

    public static void menuEditarContato(Contato contatoPesq) throws Exception {
        String opcao3 = "";
        do {
            opcao3 = JOptionPane.showInputDialog("###O QUE VC DESEJA EDITAR?###\r\n" + "\r\n1) NOME" + "\r\n2) EMAIL" + "\r\n3) NASCIMENTO" + "\r\n4) TIPO CONTATO" + "\r\n5) TELEFONES" + "\r\n0) SAIR\r\n");
            switch (opcao3) {
                case "1":
                    // Opcao 1 //
                    String mensagemNome = JOptionPane.showInputDialog("Digite o novo nome:");
                    contatoPesq.setNome(mensagemNome);
                    Principal.contatoDao.updateNome(contatoPesq);
                    break;
                case "2":
                    // Opcao 2 //
                    String mensagemEmail = JOptionPane.showInputDialog("Digite o novo email:");
                    contatoPesq.setEmail(mensagemEmail);
                    Principal.contatoDao.updateEmail(contatoPesq);
                    break;
                case "3":
                    // Opcao 3 //
                    String mensagemNascimento = JOptionPane.showInputDialog("Digite o novo nascimento [DD/MM/AAAA]:");
                    contatoPesq.setNascimento(Util_Format.data(mensagemNascimento));
                    Principal.contatoDao.updateNascimento(contatoPesq);
                    break;
                case "4":
                    // Opcao 4 //
                    pesquisandoTipoContato();
                    String mensagemTipoContato = JOptionPane.showInputDialog("Digite o id do Novo Tipo de Contato");
                    modificandoTipoContatoDoContato(mensagemTipoContato, contatoPesq);
                    break;
                case "5":
                    menuEditarTelefone(contatoPesq);
                    break;
            }
        } while (!opcao3.equals("0"));
    }

    public static void exibirContatos() throws Exception {
        // Opcao 3 //
        List<Contato> CONTATOS_LISTADOS = new ArrayList<>();
        List<?> OBJETOS = Principal.contatoDao.pesquisarTodos();
        for (int i = 0; i < OBJETOS.size(); i++) {
            Contato get = (Contato) OBJETOS.get(i);
            CONTATOS_LISTADOS.add(get);
        }
        System.out.println("\r\n#################### CONTATOS ###########################");
        System.out.println("ID || NOME   || EMAIL                         || NASCIMENTO || TIPO CONTATO || TELEFONES");
        for (int i = 0; i < CONTATOS_LISTADOS.size(); i++) {
            Contato get = CONTATOS_LISTADOS.get(i);
            System.out.println(get.getId() + " | " + get.getNome() + " |  " + get.getEmail() + "       |" + get.getNascimento() + " | " + get.getTipoContato().getNome() + " | " + Principal.telefoneDao.pesquisarTelefoneContatos(get));
        }
    }

    public static void mostrarTelefonesDoContato(List<Telefone> TELEFONES_DO_CONTATO_PESQUISADO) {
        System.out.println("ID | DDD || NUMERO");
        for (int i = 0; i < TELEFONES_DO_CONTATO_PESQUISADO.size(); i++) {
            Telefone get = TELEFONES_DO_CONTATO_PESQUISADO.get(i);
            System.out.println(i + 1 + " | " + get.getDdd() + "|| " + get.getNumero());
        }
    }

    public static void menuEditarTelefone(Contato contatoPesq) throws Exception {
        // Opcao 4 //
        List<Telefone> TELEFONES_DO_CONTATO_PESQUISADO = Principal.telefoneDao.pesquisarTelefoneContatos(contatoPesq);
        mostrarTelefonesDoContato(TELEFONES_DO_CONTATO_PESQUISADO);
        String opcao4 = "";
        do {
            opcao4 = JOptionPane.showInputDialog("###EDITAR TELEFONE###\r\n" + "\r\n1) CRIAR" + "\r\n2) EXCLUIR" + "\r\n0) SAIR\r\n");
            switch (opcao4) {
                case "1":
                    Telefone telefoneCriado = criarTelefone(contatoPesq);
                    TELEFONES_DO_CONTATO_PESQUISADO.add(telefoneCriado);
                    break;
                case "2":
                    // Opcao 3 //
                    String respostaExclusao = JOptionPane.showInputDialog("Digite o id do telefone que vc deseja excluir");
                    boolean excluido = Principal.telefoneDao.excluirTelefoneContatos(Integer.valueOf(respostaExclusao));
                    if (excluido) {
                        JOptionPane.showMessageDialog(null, "Contato excluido com sucesso!");
                    }
                    break;
            }
        } while (!opcao4.equals("0"));
    }

    public static void menuTipoDeContato() throws Exception {
        // Opcao 2 //
        String opcao2 = "";
        do {
            opcao2 = JOptionPane.showInputDialog("###TIPO DE CONTATO###\r\n" + "\r\n1) CRIAR" + "\r\n2) VIZUALIZAR" + "\r\n3) EDITAR" + "\r\n4) EXCLUIR " + "\r\n0) SAIR\r\n");
            switch (opcao2) {
                case "1":
                    // Opcao 1 //
                    criandoTipoContato();
                    break;
                case "2":
                    // Opcao 2 //
                    pesquisandoTipoContato();
                    break;
                case "3":
                    // Opcao 3 //
                    pesquisandoTipoContato();
                    editandoTipoContato();
                    break;
                case "4":
                    // Opcao 4 //
                    pesquisandoTipoContato();
                    String contatoParaExcluir = JOptionPane.showInputDialog("Digite o id do Contato para excluir");
                    boolean tudoCerto = Principal.tipoContatoDao.excluir(Integer.valueOf(contatoParaExcluir));
                    if (!tudoCerto) {
                        JOptionPane.showMessageDialog(null, "N\u00e3o foi possivel excluir Tipo de Contato,  pois h\u00e1 um vinculo com um contato, por favor verifique antes de excluir");
                    }
                    break;
            }
        } while (!opcao2.equals("0"));
    }

    public static Contato pegandoContatoParaEditar() throws Exception, HeadlessException {
        String idContato = JOptionPane.showInputDialog("Digite o id do contato que vc deseja editar");
        Object objPesquisado = Principal.contatoDao.pesquisar(Integer.valueOf(idContato));
        Contato contatoPesq = (Contato) objPesquisado;
        return contatoPesq;
    }

    public static void imprimindoListaSimples() throws Exception {
        // Opcao 1 //
        String impressao = new String();
        List<?> object = Principal.contatoDao.pesquisarTodos();
        for (int i = 0; i < object.size(); i++) {
            Contato get = (Contato) object.get(i);
            List<Telefone> TELEFONES_DO_CONTATO = Principal.telefoneDao.pesquisarTelefoneContatos(get);
            for (int j = 0; j < TELEFONES_DO_CONTATO.size(); j++) {
                Telefone telContato = TELEFONES_DO_CONTATO.get(j);
                impressao = impressao + get.getNome() + ";" + get.getEmail() + ";" + get.getNascimento() + ";" + get.getTipoContato().getNome() + ";" + "(" + telContato.getDdd() + ")" + telContato.getNumero() + ";\r\n";
            }
        }
        Util_Arquivo.escreverArq("Contatos.csv", impressao);
    }

    public static void imprimindoListaSimplesComFiltroDeTipo() throws Exception {
        // Opcao 1 //
        String impressao = new String();
        String mensagem = JOptionPane.showInputDialog("Digite um id de Tipo");
        List<Object> object = Principal.contatoDao.pesquisarTodosPorTipo(Integer.valueOf(mensagem));
        for (int i = 0; i < object.size(); i++) {
            Contato get = (Contato) object.get(i);
            List<Telefone> TELEFONES_DO_CONTATO = Principal.telefoneDao.pesquisarTelefoneContatos(get);
            for (int j = 0; j < TELEFONES_DO_CONTATO.size(); j++) {
                Telefone telContato = TELEFONES_DO_CONTATO.get(j);
                impressao = impressao + get.getNome() + ";" + get.getEmail() + ";" + get.getNascimento() + ";" + get.getTipoContato().getNome() + ";" + "(" + telContato.getDdd() + ")" + telContato.getNumero() + ";\r\n";
            }
        }
        Util_Arquivo.escreverArq("ContatosPorTipo.csv", impressao);
    }

    public static void editandoTipoContato() throws HeadlessException, Exception {
        String mensagemTipo = JOptionPane.showInputDialog("Digite o id do TipoContato que vc deseja editar");
        Object obj = Principal.tipoContatoDao.pesquisar(Integer.valueOf(mensagemTipo));
        TipoContato tipoContatoPesq = (TipoContato) obj;
        String novoNomeDoTipoContato = JOptionPane.showInputDialog("Digite o novo Tipo de contato");
        tipoContatoPesq.setNome(novoNomeDoTipoContato);
        Principal.tipoContatoDao.update(tipoContatoPesq);
    }

    public static void pesquisandoTipoContato() throws Exception {
        List<?> obj = Principal.tipoContatoDao.pesquisarTodos();
        System.out.println("\r\n###TIPOS DE CONTATO###");
        System.out.println("ID || TIPO DE CONTATO");
        for (int i = 0; i < obj.size(); i++) {
            TipoContato get = (TipoContato) obj.get(i);
            System.out.println(get.getId() + " || " + get.getNome());
        }
    }

    public static void pegandoContatoParaExcluir() throws Exception, HeadlessException {
        // Opcao 4 //
        String idContatoExclusao = JOptionPane.showInputDialog("Digite o id do contato que vc deseja excluir");
        boolean excluido = Principal.contatoDao.excluir(Integer.valueOf(idContatoExclusao));
        if (!excluido) {
            JOptionPane.showMessageDialog(null, "Impossivel excluir!!");
        }
    }

    public static void criandoContato(List<Telefone> TELEFONES_DO_USUARIO) throws Exception, HeadlessException {
        Contato cont = new Contato();
        String nomeContato = JOptionPane.showInputDialog("Insira um Nome de Contato");
        String emailContato = JOptionPane.showInputDialog("Insira um email de Contato");
        String nascimentoContato = JOptionPane.showInputDialog("Insira uma Data de Nascimento [DD/MM/AAAA]");
        cont.setNome(nomeContato);
        cont.setEmail(emailContato);
        cont.setNascimento(Util_Format.data(nascimentoContato));
        cont.setTelefones(TELEFONES_DO_USUARIO);
        pesquisandoTipoContato();
        String msgPesquisarTipo = JOptionPane.showInputDialog("Digite o id do Tipo De Contato");
        Object tipoContatoObj = Principal.tipoContatoDao.pesquisar(Integer.valueOf(msgPesquisarTipo));
        TipoContato tipoContatoPesq = (TipoContato) tipoContatoObj;
        cont.setTipoContato(tipoContatoPesq);
        Principal.contatoDao.inserir(cont);
    }

    public static void imprimindoListaSimplesComFiltroDeTipoOrdenadoPorNome() throws Exception {
        // Opcao 1 //
        String impressao = new String();
        String mensagem = JOptionPane.showInputDialog("Digite um id de Tipo");
        List<Object> object = Principal.contatoDao.pesquisarTodosPorTipo(Integer.valueOf(mensagem));
        for (int i = 0; i < object.size(); i++) {
            Contato get = (Contato) object.get(i);
            List<Telefone> TELEFONES_DO_CONTATO = Principal.telefoneDao.pesquisarTelefoneContatos(get);
            for (int j = 0; j < TELEFONES_DO_CONTATO.size(); j++) {
                Telefone telContato = TELEFONES_DO_CONTATO.get(j);
                impressao = impressao + get.getNome() + ";" + get.getEmail() + ";" + get.getNascimento() + ";" + get.getTipoContato().getNome() + ";" + "(" + telContato.getDdd() + ")" + telContato.getNumero() + ";\r\n";
            }
        }
        Util_Arquivo.escreverArq("ContatosPorTipoOrdenadoPorNome.csv", impressao);
    }

    public static void menuPrincipal() throws Exception {
        String opcao = "";
        do {
            opcao = JOptionPane.showInputDialog("###GERENCIAMENTO DE CONTATOS###\r\n" + "\r\n1) CADASTRAR CONTATO" + "\r\n2) TIPO DE CONTATO" + "\r\n3) VIZUALIZAR" + "\r\n4) EDITAR" + "\r\n5) EXCLUIR" + "\r\n6) EXPORTAR EM CSV" + "\r\n0) SAIR\r\n");
            switch (opcao) {
                case "1":
                    if (Principal.tipoContatoDao.pesquisarTodos().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "N\u00e3o existe um Tipo de Contato cadastrado , Crie um primeiro!");
                        break;
                    }
                    List<Telefone> TELEFONES_DO_USUARIO = new ArrayList<>();
                    criandoContato(TELEFONES_DO_USUARIO);
                    break;
                case "2":
                    menuTipoDeContato();
                    break;
                case "3":
                    exibirContatos();
                    break;
                case "4":
                    // Opcao 4 //
                    exibirContatos();
                    Contato contatoPesq = pegandoContatoParaEditar();
                    menuEditarContato(contatoPesq);
                    break;
                case "5":
                    pegandoContatoParaExcluir();
                    break;
                case "6":
                    menuExportarCsv();
                    break;
            }
        } while (!opcao.equals("0"));
    }

    public static void menuExportarCsv() throws Exception {
        // Opcao 4 //
        String opcaoExportar = "";
        do {
            opcaoExportar = JOptionPane.showInputDialog("###EXPORTACAO EM CSV###\r\n" + "\r\n1) LISTA SIMPLES" + "\r\n2) LISTA POR TIPO DE CONTATO" + "\r\n3) LISTA POR TIPO DE CONTATO ORDENADO POR NOME " + "\r\n0) Sair\r\n");
            switch (opcaoExportar) {
                case "1":
                    imprimindoListaSimples();
                    JOptionPane.showMessageDialog(null, "Aquivo gerado na pasta do projeto com o nome 'Contatos.csv'");
                    break;
                case "2":
                    // Opcao 2 //
                    pesquisandoTipoContato();
                    imprimindoListaSimplesComFiltroDeTipo();
                    JOptionPane.showMessageDialog(null, "Aquivo gerado na pasta do projeto com o nome 'ContatosPorTipo.csv'");
                    break;
                case "3":
                    // Opcao 3 //
                    pesquisandoTipoContato();
                    imprimindoListaSimplesComFiltroDeTipoOrdenadoPorNome();
                    JOptionPane.showMessageDialog(null, "Aquivo gerado na pasta do projeto com o nome 'ContatosPorTipoOrdenadoPorNome.csv'");
                    break;
            }
        } while (!opcaoExportar.equals("0"));
    }

    public static Telefone criarTelefone(Contato contato) throws NumberFormatException, Exception, HeadlessException {
        // Opcao 1 //
        String msgDDD = JOptionPane.showInputDialog("Insira um DDD");
        String msgTelefone = JOptionPane.showInputDialog("Insira um numero de telefone!");
        Telefone telefone = new Telefone();
        telefone.setDdd(Integer.valueOf(msgDDD));
        telefone.setNumero(Integer.valueOf(msgTelefone));
        telefone.setContato(contato);
        Principal.telefoneDao.inserir(telefone);
        return telefone;
    }

    public static void criandoTipoContato() throws HeadlessException, Exception {
        // Opcao 1 //
        String msgTipoContato = JOptionPane.showInputDialog("DIGITE O TIPO DE CONTATO!");
        TipoContato tContato = new TipoContato();
        tContato.setNome(msgTipoContato);
        Principal.tipoContatoDao.inserir(tContato);
    }
    
}
