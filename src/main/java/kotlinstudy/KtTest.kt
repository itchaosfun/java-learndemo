package kotlinstudy


class KtTest {

    inline fun <reified T> cast(original:Any?):T? = original as? T

    fun foo(int: Int) = kotlin.run { print(int) }
    var day = 6

    public fun test() {

        val ans = cast<String>(12345)

        println(ans)

        val aaa:String by lazy{
           "$day"
        }

        println("ayz" in  "abc".."xyz")

        listOf(1, 2, 3).forEach { foo(it) }


        Either.Left<Error,Double>(Error("hello"));
        Either.Right<Error,Double>(-1.00)

        when (day) {
            3-> println("\n${day}")
            5,6,7 -> println("\n${++day}")
        }

        println(aaa)

//        var list1 = mutableListOf<Thing>()
//
//        for (i in 1..20 step 2) {
//            list1.add(Thing("thing${i}", i))
//        }
//
//        println("list1 = ${list1.map { it.price }}")
//
//        var list2 = mutableListOf<Thing>()
//        for (i in 1..20) {
//            list2.add(Thing("thing${i}", i))
//        }
//
//        println("list2 = ${list2.map { it.name }}")
//
//        val priceList1 = list1.map { it.price }
//
//        println("priceList1 = $priceList1")
//
//        val removeIf = list2.removeIf { !priceList1.contains(it.price) && (it.name != "thing2") }
//        println("remove = ${removeIf}, list2 after filter = ${list2.map { it.price }}")

    }

    inner class Thing(var name: String, var price: Int)

}