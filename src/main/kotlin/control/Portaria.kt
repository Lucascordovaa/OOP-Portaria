package control

import business.ConvidadoBusiness
import entity.Convidado

class Portaria {

    private val convidadoBusiness = ConvidadoBusiness()

    init {
        println("Portaria inicializada. ")
        println(controle())
    }


    private fun controle(): String {
        val idade = Console.readInt("Qual a sua idade?")
        val convidado = Convidado(idade = idade)

        if (!convidadoBusiness.maiorDeIdade(convidado.idade)) {
            return "Negado. Menores de idade nao sao permitidos. "
        }

        convidado.tipo = Console.readString("Qual e o tipo de convite? ")
        if (!convidadoBusiness.tipoValido(convidado.tipo)) {
            return "Negado. Convite invalido."
        }

        convidado.codigo = Console.readString("Qual e o codigo do convite? ")
        if (!convidadoBusiness.convidadoValido(convidado)) {
            return "Negado. Codigo invalido."
        }



        return "Bem vindo! "
    }
}