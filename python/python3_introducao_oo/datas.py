class Data:

    def __init__(self, dia, mes, ano):
        self.data = "{}/{}/{}".format(dia,mes,ano)

    def formatada(self):
        print(self.data)
