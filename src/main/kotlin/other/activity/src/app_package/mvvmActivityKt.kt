package other.activity.src.app_package

fun mvvmActivityKt(
    applicationPackage: String?,
    activityClass: String,
    layoutName: String,
    packageName: String
) = """
package ${packageName}.ui.activity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.aiways.awbase.activity.AppActivity
import ${packageName}.R
import ${packageName}.databinding.Activity${activityClass}Binding
import ${packageName}.viewmodel.${activityClass}ViewModel

class ${activityClass}Activity : AppActivity<Activity${activityClass}Binding,${activityClass}ViewModel>() {

   override fun preOnCreate(savedInstanceState: Bundle?) {
        super.preOnCreate(savedInstanceState)
        contentLayout = R.layout.${layoutName}
    }
    
   override fun initView(savedInstanceState: Bundle?) {
        mViewModel = ViewModelProviders.of(this).get(${activityClass}ViewModel.class)
    }

   override fun initData(savedInstanceState: Bundle?) {

    }
 } 
""".trimIndent()