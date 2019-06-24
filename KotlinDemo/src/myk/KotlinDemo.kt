package myk

val fruits = listOf("banana", "avocado", "apple", "kiwifruit")

fun main(arr: Array<String>) {
//    println("main is running")
//    fruits.filter { it.startsWith('a') }.sortedBy { it }.map { it.toUpperCase() }.forEach { println(it) }
//    //创建类型，不需要new 关键字
//    var kotlinDemo = KotlinDemo(1, "1")
////    kotlinDemo.myWhen(1)
//
//    //数组
//    arry()
//    kotlinDemo.breakContinue()

//    var inti = InitOrderDemo("myName")

    val user = User("zhangsan", 18)
    println("user is $user")
}

//数组
fun arry() {
    //定义数组
    val array: Array<Int> = arrayOf(1, 2, 3, 4)
    //IntArray
    var intArray: IntArray = intArrayOf(1, 2, 3, 4)
    //ShortArray
    var short: ShortArray = shortArrayOf('a'.toShort(), 'b'.toShort())
    short.forEach { println("short array for==$it") }
    array.forEach { println("forEach $it") }
    println("---------------------------------")
    for (a in array) {
        println("for 数组数据：$a")
    }
    println("---------------------------------")
    for (index in array.indices) {
        println("1++ 数组数据：${array[index]},index==$index")
    }
    println("---------------------------------")
    //使用withIndex 库函数for循环
    for ((i, value) in array.withIndex()) {
        println("使用withIndex----i==$i,------value==$value")
    }

    for (list in fruits) {
        if (list == "banana") {
        }
    }
}

class KotlinDemo {

    val myv = "val s"
    private var i: Int = 0
    private var s: String = ""
    private var l: Long = 0L

    /**
     * 直接调用另外一个构造函数
     */
    constructor(i: Int, s: String) : this(i, s, 0)

    constructor(i: Int, s: String, l: Long) {
        this.i = i
        this.s = s
        this.l = l
    }

    init {
//        println("i==$i")
//        println("s==$s")
    }

    /**
     * when
     */
    fun myWhen(obj: Any): String {
        when (obj) {
            1 -> println("this is 1")
            is String -> println("obj is string")
            in 1..10 -> println("$obj---obj is in 1..10")
        }
        return ""
    }

    /**
     * (1)Break 与 Continue 标签
     * (2)标签处返回
     */
    fun breakContinue() {
        //标签处返回
        loop@ for (i in 1..10) {
            println("@loop to ----i==$i")
            if (i == 5) break@loop
        }
        println("@loop to -break out")

        //return 不会直接返回fun，而是返回到lit@位置
        listOf(1, 2, 3, 4, 5).forEach lit@{
            println("lit@ to --i==$it")
            if (it == 3) {
                return@lit
            }
        }
        println("done with explicit label")

        listOf(1, 2, 3, 4, 5).forEach {
            println("@forEach to --i==$it")
            if (it == 3) return@forEach
        }
        println("done with explicit label @forEach")

        //continue
        listOf(1, 2, 3, 4, 5).forEach {
            //continue
            if (it % 2 == 1) return@forEach
            println("@forEach to --i==$it")
        }
        println("done with explicit label @forEach")
    }
}

class InitOrderDemo(name: String) {

    val firstProperty = "First property: $name".also(::println)

    init {
        println("First initializer block that prints ${name}")
        var n = name
    }

    val secondProperty = "Second property: ${name.length}".also(::println)

    init {
        println("Second initializer block that prints ${name.length}")
    }

    fun pram() {
    }
}

class PC private constructor(name: String) {

    //被companion object包裹的语句都是private的
    companion object {
        private var pc: PC? = null
    }

    @Synchronized
    fun get(): PC {
        if (pc == null) {
            pc = PC("NAME")
        }
        return pc as PC
    }
}


class SingletonDemo private constructor() {
    //私有的主构造器
    companion object {//被companion object包裹的语句都是private的

        private var singletonInstance: SingletonDemo? = null

        @Synchronized
        fun getInstance(): SingletonDemo? {
            if (singletonInstance == null) {
                singletonInstance = SingletonDemo()
            }
            return singletonInstance
        }
    }
}

interface MyIn {
    val name: String
    fun a() {}
    fun a1()
}

interface MyOut {
    fun a() {}
}

class MyInImpl(override val name: String) : MyIn, MyOut {

    override fun a1() {
    }

    override fun a() {
        //如果MyIn、MyOut不是抽象方法（没有{}默认为抽象）
        //则此处可用super调用区分
        super<MyIn>.a()
        super<MyOut>.a()
    }
}

/**
 * 只保存数据的类
 */
data class User(val name: String, val age: Int) {
    init {
        println()
    }
}

class Box<T>(t: T) {
    var value = t
}
