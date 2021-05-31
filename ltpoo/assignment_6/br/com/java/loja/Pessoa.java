package br.com.java.loja;

public abstract class Pessoa implements IPessoa {
    protected final String CPF_LABEL = "[Pessoa] Informe o CPF:";
    protected final String NOME_LABEL = "[Pessoa] Informe o nome:";
    protected final String CELULAR_LABEL = "[Pessoa] Informe o celular:";
    protected final String DATA_NASCIMENTO_LABEL = "[Pessoa] Informe a data de nascimento:";

    protected String cpf;
    protected String nome;
    protected String celular;
    protected int dataNascimento;

    public abstract void cadastrar();
}