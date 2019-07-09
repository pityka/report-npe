import com.github.plokhotnyuk.jsoniter_scala.core._
import com.github.plokhotnyuk.jsoniter_scala.macros._

package object test {

  // removing this or making not implicit will pass the test
  // keeping the implicit will throw NullPointerException
  implicit def tup2[A: JsonValueCodec, B: JsonValueCodec]: JsonValueCodec[(A, B)] =
    JsonCodecMaker.make[(A, B)](CodecMakerConfig())

  case class C1(s: String) extends AnyVal
  object C1 {
    implicit val codec: JsonValueCodec[C1] =
      JsonCodecMaker.make[C1](CodecMakerConfig())
  }

  case class C2(s: String) extends AnyVal
  object C2 {
    implicit val codec: JsonValueCodec[C2] =
      JsonCodecMaker.make[C2](CodecMakerConfig())
  }
  case class C3(
      member: Seq[(C1, C2)]
  )

  object C3 {

    implicit val codec: JsonValueCodec[C3] =
      JsonCodecMaker.make[C3](CodecMakerConfig())
  }
}
