import java.util.*

fun main() {
    println("Hola Mundo")
    //Inmutables (No se puede re asignar)
    val inmutable: String = "Kevin"
    // inmutable = "Otro nombre" //Error

    //Mutables
    var mutable: String = "Kevin"
    mutable = "Mateo" //Correcto
    //VAL > VAR

    //Duck Typing
    var ejemploVariable = "Kevin Cano"
    val edadEjemplo = 21
    ejemploVariable.trim()
    //ejemploVariable = edadEjemplo //Error de tipos

    //Variables primitivas
    val nombre: String = "Kevin"
    val sueldo: Double = 1.21
    val estadoCivil: Char = 'S'
    val mayorEdad: Boolean = true

    //Clases en Java
    val fechaNacimiento: Date = Date()

    //when switch
    val estadoCivilWhen = "C"
    when (estadoCivilWhen) {
        ("C") -> {
            println("Casado")
        }
        "S" ->{
            println("Soltero")
        }
    }
    val esSoltero = (estadoCivilWhen == "S")
    val coqueteo = if (esSoltero) "Si" else "No" //If else chiquito

    calcularSueldo(10.00)
    calcularSueldo(10.00, 15.00, 20.00)
    // Named Parameters
    // calcularSueldo(sueldo, tasa, bonoEspecial)
    calcularSueldo(10.00, bonoEspecial = 15.00)
    calcularSueldo(bonoEspecial = 20.00, sueldo=10.00, tasa=14.00)


}

fun imprimirNombre(nombre: String): Unit {
    println("Nombre: ${nombre}")
}

fun calcularSueldo(
    sueldo: Double, //Requerido
    tasa: Double = 12.00, //Opcional
    bonoEspecial: Double? = null //Opcional (nullable)
    // Variable ? -> "?" Es nullable osea que puede en algun momento ser nulo

    ):Double {
        if(bonoEspecial == null){
            return sueldo * (100/tasa)
    }else {
        return sueldo * (100/tasa) * bonoEspecial

    }
}

abstract class NumerosJava {
    protected val numeroUno: Int
    private val numeroDos: Int

    constructor(
        uno: Int,
        dos: Int
    ) {
        this.numeroUno = uno
        this.numeroDos = dos
        println("Inicializamos")
    }
}

abstract class Numeros(
    // Caso 1: Parametro Normal
    // uno:Int , parametro sin modificar acceso

    // Caso 2: Parametro y propiedad atributo private
    // private var uno: Int propiedad instancia.uno

    protected val numeroUno: Int, // instancia.numeroUno
    protected val numeroDos: Int // instancia.numeroDos
    //parametroInutil: String, //Parametro
) {
    init {
        this.numeroUno
        this.numeroDos
        //this.parametroInutil
        println("Inicializamos")
    }
}

class Suma(
    unoParametro: Int,
    dosParametro: Int,
): Numeros(
    unoParametro,
    dosParametro,
) {
    public val soyPublicoExplicito:String = "Explicito" // Publico
    val soyPublicoImplicito:String = "Implicito" // Publico (propiedades, metodos)
    init {
        this.numeroUno
        this.numeroDos
        numeroUno // this. OPCIONAL (propiedades, metodos)
        numeroDos // this. OPCIONAL (propiedades, metodos)
        this.soyPublicoExplicito
        soyPublicoImplicito // this. OPCIONAL (propiedades, metodos)
    }

    fun sumar(): Int {
        val total = numeroUno + numeroDos
        //Suma.agregarHistorial(total) ("Suma" o "Nombreclase" es OPCIONAL)
        agregarHistorial(total)
        return total
    }
    companion object{ // Comparte entre todos las instancias, somilar al static
        //funciones y variables
        val pi = 3.14
        fun elevarAlCuadrado(num:Int):Int{
            return num * num
        }
        val historialSumas = arrayListOf<Int>()
        fun agregarHistorial(valorTotalSuma:Int){
            historialSumas.add(valorTotalSuma)
        }
    }

}