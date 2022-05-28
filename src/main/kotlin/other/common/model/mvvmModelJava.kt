package other.common.model

fun mvvmModelJava(
    packageName: String,
    clazz: String
) = """
     package ${packageName}.model;
    
    import android.app.Application;
    import com.aiways.mvvmarms.mvvm.BaseModel;
    
     public class ${clazz}Model extends BaseModel {
     
         public ${clazz}Model(Application application) {
             super(application);
         }
         
     }
""".trimIndent()