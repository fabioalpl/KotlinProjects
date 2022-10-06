package com.example.javakotlin;

import java.util.Objects;

public class EstudandoPuc {
    private String uid;
    private String primeiroNome;
    private String ultimoNome;
    private String idade;

    public EstudandoPuc() {
    }

    public EstudandoPuc(String uid, String primeiroNome, String ultimoNome, String idade) {
        this.uid = uid;
        this.primeiroNome = primeiroNome;
        this.ultimoNome = ultimoNome;
        this.idade = idade;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getPrimeiroNome() {
        return primeiroNome;
    }

    public void setPrimeiroNome(String primeiroNome) {
        this.primeiroNome = primeiroNome;
    }

    public String getUltimoNome() {
        return ultimoNome;
    }

    public void setUltimoNome(String ultimoNome) {
        this.ultimoNome = ultimoNome;
    }

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EstudandoPuc)) return false;
        EstudandoPuc that = (EstudandoPuc) o;
        return Objects.equals(getUid(), that.getUid()) && Objects.equals(getPrimeiroNome(), that.getPrimeiroNome()) && Objects.equals(getUltimoNome(), that.getUltimoNome()) && Objects.equals(getIdade(), that.getIdade());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUid(), getPrimeiroNome(), getUltimoNome(), getIdade());
    }

    @Override
    public String toString() {
        return "EstudandoPuc{" +
                "uid='" + uid + '\'' +
                ", primeiroNome='" + primeiroNome + '\'' +
                ", ultimoNome='" + ultimoNome + '\'' +
                ", idade='" + idade + '\'' +
                '}';
    }
}
