package br.com.alura.rh.service.tributacao;

import java.math.BigDecimal;

interface ReajusteTributavel extends Reajuste {
    BigDecimal ValorImpostoDeRenda();
}
