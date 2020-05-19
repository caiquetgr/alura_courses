import 'package:money/money.dart';

class ContaCorrente {
  String titular;
  int agencia;
  int conta;
  Money saldo = Money.fromDouble(0.0, Currency('BRL'));

  bool transferencia(Money valorTransferencia, ContaCorrente contaDestino) {
    if (saque(valorTransferencia)) {
      contaDestino.deposito(valorTransferencia);
    }
  }

  bool saque(Money valorDoSaque) {
    if (saldo.amount - valorDoSaque.amount < -100) {
      print('Saldo insuficiente');
      return false;
    } else {
      saldo -= valorDoSaque;
      print('Novo saldo de ${titular}: ${saldo}');
      return true;
    }
  }

  Money deposito(Money valorDeposito) {
    saldo += valorDeposito;
    return saldo;
  }
}
