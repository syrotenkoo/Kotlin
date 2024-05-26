fun main() {


    var endProgramm: Boolean = false

    while(!endProgramm) {
        println("Введите команду:")
        val command: String? = readLine()

        if(command != null) {
            when (command) {
                "exit" -> endProgramm = true
                "help" -> {
                    println("exit - завершить программу")
                    println("help - показать список команд")
                    println("add <Имя> phone <Номер телефона> - добавить номер телефона пользователя")
                    println("add <Имя> email <Адрес электронной почты> - добавить email пользователя")
                }
                else -> {
                    if(command.contains("add") && command.contains("phone")) {
                        addPhone(command)
                    } else if (command.contains("add") && command.contains("email")) {
                        addEmail(command)
                    } else {
                        println("Неккоректный формат команды")
                    }
                }
            }
        }
    }
}

fun addPhone(str: String) {
    val words = str.split(" ")
    var nums = words[3].subSequence(1, words[3].length - 1).toString()
    if(words[3].first() == '+' && nums.toIntOrNull() != null) {

        println("Имя: ${words[1]}, телефон: ${words[3]}")
    } else {
        println("Неккоректный формат номера телефона")
    }
}

fun addEmail(str: String) {
    var words = str.split(" ")

    if(words[3].contains('@') && words[3].contains('.')) {
        var delim1 = words[3].indexOf("@")
        var delim2 = words[3].indexOf(".")
        var parts = Array(3, {""})

        parts[0] = words[3].subSequence(0, delim1).toString()
        parts[1] = words[3].subSequence(delim1 + 1, delim2).toString()
        parts[2] = words[3].subSequence(delim2 + 1, words[3].length).toString()

        for(i in parts) {
            if(i.length < 2) {
                return
            } else {
                println("Некорректный адрес электронной почты")
            }
        }

        println("Имя: ${words[1]}, email: ${words[3]}")
    } else {
        println("Некорректный адрес электронной почты")
    }
}