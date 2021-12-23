## Búsqueda binaria

La búsqueda binaria es un algoritmo eficiente de busqueda (duh) en el que se busca un número en un conjunto de elementos ordenados partiendo por la mitad.

Acá hay una explicación detallada, la podría copypastear pero mejor revisar siguente link de la espectacular gente de Khan Acadamy: [Busqueda Binaria](https://es.khanacademy.org/computing/computer-science/algorithms/binary-search/a/binary-search)

Un ejemplo super bueno en el que se aplica este algoritmo es en el comando `git bisect`. Alguna vez te pasó que comenzaste a programar, hiciste 32 commits, quisiste hacer push pero te diste cuenta que se rompieron los tests y no sabes desde qué commit comenzó a fallar? Podrías ir probando commit por commit, 32 veces... o podrías utilizar `git bisect` y saber en máximo 5 intentos qué commit fué el culpable, debido a que emplea la búsqueda binaria.

Cómo supe que serían 5 intentos?
Porque la busqueda binaria tomará log2 n pasos en el peor de los casos.

Log2 n = cuantas veces multiplicamos 2 para obtener n

```
 log2 32 = ??
 2^5 == 32
 log2 32 = 5 
```

### Ejercicios

1. Supone que tienes una lista ordenada de 128 nombres y buscas un nombre utilizando la busqueda binaria. ¿Cuál es el número máximo de pasos que te podría tomar?  

    <details>
        <summary>Respuesta</summary>
        Te podría tomar máximo 7 intentos  
    </details>
2. Si ahora tienes una lista el doble de grande. ¿Cuál es el numeró maxímo de pasos ahora?  

    <details>
        <summary>Respuesta</summary>
        Te podría tomar máximo 8 intentos  
    </details>

### Código (Scala 3)
```scala
import scala.annotation.tailrec

@main def main: Unit = {
  val numbers: Array[Int]        = Array(1, 14, 20, 32, 33, 45, 76, 77, 85, 97)
  val indexOfTwenty: Option[Int] = binarySearch(numbers, 20)
  println(s"the index of twenty is: ${indexOfTwenty.getOrElse("Not found")}")
  // 2
  val indexOfSix: Option[Int] = binarySearch(numbers, 6)
  println(s"the index of six is: ${indexOfSix.getOrElse("Not found")}")
  // "Not found"
}

// courtesy: https://www.24tutorials.com/scala/binary-search-in-scala-iterative-tail-recursion/
def binarySearch(numbers: Array[Int], num: Int): Option[Int] = {
  @tailrec
  def loop(numbers: Array[Int], target: Int, low: Int, high: Int): Option[Int] = {
    if high < low then return None
    val mid = (low + high) / 2
    numbers(mid) match {
      case n if n == target => Some(mid)
      case n if n > target =>
        loop(numbers, target, low, mid - 1)
      case _ => loop(numbers, target, mid + 1, high)
    }
  }
  loop(numbers, num, 0, numbers.length - 1)
}

```

### Referencia  
Me guié mucho por el libro [Grokking algorithms](https://www.manning.com/books/grokking-algorithms)

### Links utiles  

[Guia para utilizar git bisect](https://www.marclittlemore.com/how-to-find-bugs-using-git-bisect-with-this-easy-guide/)  
[Donde se utiliza git bisect? (StackOverflow)](https://stackoverflow.com/questions/540165/where-is-binary-search-used-in-practice)
