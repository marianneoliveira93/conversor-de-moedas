package main.com.conversormoedas.api;
// Declaração do pacote onde a classe está localizada


public record MoedaFormatada(double conversion_rate) {

}
//Por "record", o Java cria automaticamente o construtor, os métodos getter, equals, hashCode e toString.
// Declaração de uma classe de registro (record) chamada "MoedaFormatada", com a taxa de conversão (conversion_rate).
