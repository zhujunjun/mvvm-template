package other.common

import java.io.File

fun getSrcPath(applicationPkg: String, srcDir: String): String? {
    val projectPkg = applicationPkg.replace(".", "/")
    if (srcDir.contains(projectPkg)) {
        val headStr = srcDir.subSequence(0, srcDir.indexOf(projectPkg))
        val pathStrBuilder = StringBuilder()
        pathStrBuilder.append(headStr).append(projectPkg).append(File.separator)
        return pathStrBuilder.toString()
    }
    return null
}

fun saveViewModel(
    srcOut: File,
    applicationPkg: String,
    packageName: String,
    srcDir: String,
    activityClass: String,
    ktOrJavaExt: String
): File {
    return if (applicationPkg == packageName) {
        srcOut.resolve("viewmodel/${activityClass}ViewModel.${ktOrJavaExt}")
    } else {
        File(
            getSrcPath(
                applicationPkg,
                srcDir
            )
        ).resolve("viewmodel/${activityClass}ViewModel.${ktOrJavaExt}")
    }
}

fun saveModel(
    srcOut: File,
    applicationPkg: String,
    packageName: String,
    srcDir: String,
    activityClass: String,
    ktOrJavaExt: String
): File {
    return if (applicationPkg == packageName) {
        srcOut.resolve("model/${activityClass}Model.${ktOrJavaExt}")
    } else {
        File(
            getSrcPath(
                applicationPkg,
                srcDir
            )
        ).resolve("model/${activityClass}Model.${ktOrJavaExt}")
    }
}