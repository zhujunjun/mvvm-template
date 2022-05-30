package other.common

fun getDataBindingClass(layoutName: String?): String {
    val splitFlag = "_"
    val dataBindingClassName = StringBuilder()
    layoutName?.let {
        if (it.contains(splitFlag)) {
            val arrayLayout = it.split(splitFlag)
            arrayLayout.forEach { singleL ->
                parseLayoutName(singleL, dataBindingClassName)
            }
        } else {
            parseLayoutName(it, dataBindingClassName)
        }
    }
    return dataBindingClassName.toString()
}

fun parseLayoutName(name: String, dataBindingClassName: StringBuilder) {
    val defaultUpperIndex = 0
    val array = name.toCharArray()
    array.forEachIndexed { index, c ->
        if (defaultUpperIndex == index) {
            dataBindingClassName.append(c.toUpperCase())
        } else {
            dataBindingClassName.append(c.toLowerCase())
        }
    }
}