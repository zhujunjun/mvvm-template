package other.common.model

import other.common.AppType

fun mvvmModelJava(
    packageName: String,
    clazz: String,
    appType: AppType
): String {
    val baseModelByImport =
        if (appType == AppType.Mainland) "com.aiways.awbase.model.AppBaseModel" else "com.aiways.mvvmarms.mvvm.BaseModel"
    val extendsBaseName = if (appType == AppType.Mainland) "AppBaseModel" else "BaseModel"
    return """
     package ${packageName}.model;
    
    import android.app.Application;
    import $baseModelByImport;
    
     public class ${clazz}Model extends $extendsBaseName {
     
         public ${clazz}Model(Application application) {
             super(application);
         }
         
     }
""".trimIndent()
}