package test
import com.github.plokhotnyuk.jsoniter_scala.core._
object Main extends App {
  val data = """{"member":[["A","0"]]}"""
  
  println(readFromString[C3](data))
}