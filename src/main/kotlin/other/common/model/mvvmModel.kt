package other.common.model

fun mvvmModel(
    packageName: String,
    clazz: String
) = """
    package ${packageName}.model
    
    import android.app.Application
    import com.aiways.mvvmarms.mvvm.BaseModel
    
    class ${clazz}Model(application: Application?) : BaseModel(application) {

    }
""".trimIndent()