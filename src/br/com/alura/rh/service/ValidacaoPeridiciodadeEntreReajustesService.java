package br.com.alura.rh.service;

import br.com.alura.rh.ValidacaoException;
import br.com.alura.rh.model.Funcionario;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class ValidacaoPeridiciodadeEntreReajustesService implements ValidacaoReajusteI {

    public void validar(Funcionario funcionario, BigDecimal aumento) {
        LocalDate dataUltimoReajuste = funcionario.getDataUltimoReajuste();
        LocalDate dataAtual = LocalDate.now();

        long qtdMesesDesdeUltimoReajuste = ChronoUnit.MONTHS.between(dataUltimoReajuste, dataAtual);

        if (qtdMesesDesdeUltimoReajuste < 6){
            throw new ValidacaoException("Intervalo Entre reajustes deve ser maior que 6 meses.");
        }
    }
}
