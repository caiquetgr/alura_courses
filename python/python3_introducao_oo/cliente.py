class Cliente:

    def __init__(self, nome):
        self.__nome = nome

    @property
    def nome(self):
        print('chamando property nome')
        return self.__nome

    @nome.setter
    def nome(self, nome):
        print('chamando setter property nome')
        self.__nome = nome
