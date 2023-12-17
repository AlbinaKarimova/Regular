import java.io.File
import java.nio.file.Files
import java.nio.file.Paths

//Задачка про аббревиатуры
fun first(){
    var text = "Это курс информатики соответствует ФГОС и ПООП, это подтверждено ФГУ ФНЦ НИИСИ РАН"
    var regex = Regex("[А-Я][А-Я]+")
    var a = regex.findAll(text)
    println(a.map{it.value}.toList())
}

//Задачка про аббревиатуры 2
fun second(){
    var text = "Комитет государственной Безопасности"
    var regex = Regex("\\b[А-Я|а-я]")
    var a = regex.findAll(text.uppercase())
    var b = ""
    for(elem in a.map{it.value}.toList()){
        b += elem
    }
    println(b)
}

//Задачка про перевод из camel_case'a в snake_case
fun ToSnakeCase(){
    var text = "camelCaseVar"
    var regex = Regex("([A-Z][a-z]+)")
    var a = regex.findAll(text)
    var regex2 = Regex("(\\b[a-z]+)")
    var b = regex2.findAll(text)
    println(b.map{it.value}.toList()[0]+"_"+a.map{it.value.lowercase()}.toList().joinToString("_"))
}

//Задачка про подсчет количества слов
fun count_words(){
    var text = "- Дельный, что и говорить,\n" +
            "Был старик тот самый,\n" +
            "Что придумал суп варить\n" +
            "На колесах прямо.\n" +
            "Суп - во-первых. Во-вторых,\n" +
            "Кашу в норме прочной.\n" +
            "Нет, старик он был старик\n" +
            "Чуткий - это точно."
    var regex1 = Regex("(\\b[А-Я}а-я|ё|Ё]{1,}+)")
    var regex2 = Regex("-")
    var a = text.replace(regex2, "")
    var b = regex1.findAll(a)
    println(b.map{it.value}.toList().size)
}

//Найдите в тексте слова, начинающиеся на а и на е
fun find_words(){
    var text1 = "The following example creates" +
            " an ArrayList with a capacity of 50 elements." +
            "Four elements are then added to the ArrayList and " +
            "the ArrayList is trimmed accordingly."
    var text2 = "Ihr naht euch wieder, schwankende Gestalten," +
            "        Die früh sich einst dem trüben Blick gezeigt." +
            "        Versuch’ ich wohl, euch diesmal festzuhalten?" +
            "        Fühl’ ich mein Herz noch jenem Wahn geneigt?"

    var regex1 = Regex("\\b[a|e|A|E][a-z]{3,}+")
    var a = regex1.findAll(text1)
    var regex2 = Regex("\\b[a|e|A|E][a-zA-ZäöüßÄÖÜẞ]{3,}+")
    var b = regex2.findAll(text2)
    println(a.map{it.value}.toList())
    println(b.map{it.value}.toList())
}

//Задачка про деление текста на предложения
fun del(){
    var text = "Mr. Smith bought cheapsite.com for 1.5 million dollars, i.e. he paid a lot for it! " +
            "Did he mind? Adam Jones Jr. thinks he didn't. In any case, this isn't true... " +
            "Well, with a probability of .9 it isn't."

    var regex = Regex("(\\W+\\.|\\?|!|;[^0-9])\\W+")
    var a = text.split(regex)
    for(elem in a){
        println(elem)
    }
}

// количество вхождений слова the
fun idiot() {
    var file = File("C:\\Users\\Альбина\\Downloads\\2638-0.txt")
    var lines = Files.readAllLines(Paths.get(file.toURI())).toString()
    var text = "PART I" +
            ";sofjroijfreoi;jf;orijorijf;ro" +
            "II" +
            "rjfpkpoerkgt" +
            "PART II" +
            "p'ofgthkotkhorp"
    var regex = Regex("\\bthe\\b")
    var regex2 = Regex("(PART I)")
    var b = lines.split(regex2)
    var a = regex.findAll(b[5])
    //println(b[5])
    println(a.map{it.value}.toList().size)
}

fun main() {
    println("Task №1: ")
    first()
    println("Task №2: ")
    second()
    println("Task №3: ")
    ToSnakeCase()
    println("Task №4: ")
    count_words()
    println("Task №5: ")
    find_words()
    println("Task №6: ")
    del()
    println("Task №7: ")
    idiot()
}

