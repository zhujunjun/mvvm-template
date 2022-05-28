package other.common.viewmodel

fun mvvmViewModelJava(
    packageName: String,
    clazz: String
) = """
package ${packageName}.viewmodel;

import android.app.Application;
import ${packageName}.model.${clazz}Model;
import com.aiways.mvvmarms.mvvm.BaseViewModel;

public class ${clazz}ViewModel extends BaseViewModel<${clazz}Model> {

    public ${clazz}ViewModel(@NotNull Application application) {
        super(application);
    }
    
    @Override
     public ${clazz}Model createModel(Application application) {
         return new ${clazz}Model(application);
     }
}
""".trimIndent()