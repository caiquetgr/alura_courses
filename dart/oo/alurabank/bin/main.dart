import 'package:money/money.dart';

import 'ContaCorrente.dart';

void main() {

  ContaCorrente contaCorrente = ContaCorrente();
  contaCorrente.titular = "Caique";
  contaCorrente.agencia = 1234;
  contaCorrente.conta = 12345678;
  contaCorrente.saldo = Money.fromDouble(120.20, Currency("BRL"));

  print("Titular: ${contaCorrente.titular}");
  print("Agencia: ${contaCorrente.agencia}");
  print("Conta: ${contaCorrente.conta}");
  print("Saldo: ${contaCorrente.saldo}");

}

