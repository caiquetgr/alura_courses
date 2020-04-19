

class Conta:

	def __init__(self, numero, titular, saldo, limite):
		print("Construindo objeto: {}".format(self))
		self.__numero = numero
		self.__titular = titular
		self.__saldo = saldo
		self.__limite = limite
		pass

	def extrato(self):
		print("Saldo R${:2} do titular {}".format(self.__saldo, self.__titular))
		pass

	def deposita(self, valor):
		self.__saldo += valor
		pass

	def __pode_sacar(self, valor):
		valor_disponivel_para_sacar = self.__saldo + self.__limite
		return valor <= valor_disponivel_para_sacar
		pass

	def saca(self, valor):
		if(self.__pode_sacar(valor)):
			self.__saldo -= valor
		else:
			print("O valor {} passou o limite".format(valor))
		pass

	def transfere(self, destino, valor):
		self.saca(valor)
		destino.deposita(valor)
		pass

	def get_saldo(self):
		return self.__saldo

	def get_titular(self):
		return self.__titular

	@property
	def limite(self):
		return self.__limite
	@limite.setter
	def limite(self, limite):
		self.__limite = limite

	@staticmethod
	def codigo_banco():
		return "001"

pass
