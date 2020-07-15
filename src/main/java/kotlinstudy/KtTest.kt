package kotlinstudy


class KtTest {

    public fun test() {
        var list1 = mutableListOf<Thing>()

        for (i in 1..20 step 2) {
            list1.add(Thing("thing${i}", i))
        }

        println("list1 = ${list1.map { it.price }}")

        var list2 = mutableListOf<Thing>()
        for (i in 1..20) {
            list2.add(Thing("thing${i}", i))
        }

        println("list2 = ${list2.map { it.name }}")

        val priceList1 = list1.map { it.price }

        println("priceList1 = $priceList1")

        val removeIf = list2.removeIf { !priceList1.contains(it.price) && (it.name != "thing2") }
        println("remove = ${removeIf}, list2 after filter = ${list2.map { it.price }}")

    }

    inner class Thing(var name: String, var price: Int)

}