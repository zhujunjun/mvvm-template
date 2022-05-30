package other.common.viewmodel

fun mvvmViewModelKt(
    packageName: String?,
    clazz: String
) = """
package ${packageName}.viewmodel

import android.app.Application
import ${packageName}.model.${clazz}Model
import com.aiways.mvvmarms.mvvm.BaseViewModel

class ${clazz}ViewModel(application: Application) : BaseViewModel<${clazz}Model>(application) {
 
 override fun createModel(application: Application?): ${clazz}Model {
        return ${clazz}Model(application)
    }

}
"""