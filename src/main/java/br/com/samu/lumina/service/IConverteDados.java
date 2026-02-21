package br.com.samu.lumina.service;

public interface IConverteDados {
    <T> T obterDados(String json, Class<T> classe);
}
