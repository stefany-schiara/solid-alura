package br.com.alura.rh.service;

import br.com.alura.rh.ValidacaoException;
import br.com.alura.rh.model.Funcionario;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class ReajusteService {

    private List<ValidacaoReajusteI> validacoesList;

    public ReajusteService(List<ValidacaoReajusteI> validacoesList) {
        this.validacoesList = validacoesList;
    }

    public void reajustarSalarioDoFuncionario(Funcionario funcionario, BigDecimal aumento) {
        this.validacoesList.forEach(validacaoReajusteI -> validacaoReajusteI.validar(funcionario, aumento));

        BigDecimal salarioReajustado = funcionario.getSalario().add(aumento);
        funcionario.atualizarSalario(salarioReajustado);

    }

}
