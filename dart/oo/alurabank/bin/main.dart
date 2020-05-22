import 'package:money/money.dart';

import '../lib/cliente.dart';
import '../lib/contacorrente.dart';

void main() {
  ContaCorrente contaCorrente = ContaCorrente();

  contaCorrente.titular = Cliente()
    ..nome = "Caique"
    ..cpf = "45936556840";

  contaCorrente.agencia = 1234;
  contaCorrente.conta = 12345678;
  contaCorrente.saldo = Money.fromDouble(120.20, Currency('BRL'));

  print("Titular: ${contaCorrente.titular.nome}");
  print("CPF Titular: ${contaCorrente.titular.cpf}");
  print("Agencia: ${contaCorrente.agencia}");
  print("Conta: ${contaCorrente.conta}");
  print("Saldo: ${contaCorrente.saldo}");

  ContaCorrente contaCorrente2 = ContaCorrente();

  var clienteCaique2 = Cliente()
    ..nome = "Caique"
    ..cpf = "45936556840";

  contaCorrente2.titular = clienteCaique2;
  contaCorrente2.agencia = 1234;
  contaCorrente2.conta = 12345678;
  contaCorrente2.saldo = Money.fromDouble(120.20, Currency('BRL'));

  print(contaCorrente.hashCode);
  print(contaCorrente2.hashCode);

  contaCorrente.saque(Money.fromString("100.00", Currency('BRL')));
}
