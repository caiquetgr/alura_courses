import 'package:money/money.dart';

import 'ContaCorrente.dart';

void main() {
  ContaCorrente contaCorrente = ContaCorrente();
  contaCorrente.titular = "Caique";
  contaCorrente.agencia = 1234;
  contaCorrente.conta = 12345678;
  contaCorrente.saldo = Money.fromDouble(120.20, Currency('BRL'));

  print("Titular: ${contaCorrente.titular}");
  print("Agencia: ${contaCorrente.agencia}");
  print("Conta: ${contaCorrente.conta}");
  print("Saldo: ${contaCorrente.saldo}");

  ContaCorrente contaCorrente2 = ContaCorrente();
  contaCorrente2.titular = "Caique";
  contaCorrente2.agencia = 1234;
  contaCorrente2.conta = 12345678;
  contaCorrente2.saldo = Money.fromDouble(120.20, Currency('BRL'));

  print(contaCorrente.hashCode);
  print(contaCorrente2.hashCode);

  contaCorrente.saque(Money.fromString("100.00", Currency('BRL')));

}
