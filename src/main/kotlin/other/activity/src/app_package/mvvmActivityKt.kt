package other.activity.src.app_package

fun mvvmActivityKt(
    applicationPackage: String?,
    activityClass: String,
    layoutName: String,
    packageName: String,
    bindingClass: String,
) = """
package $packageName
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.aiways.awbase.activity.AppActivity
import ${applicationPackage}.R
import ${applicationPackage}.databinding.${bindingClass}Binding
import ${applicationPackage}.viewmodel.${activityClass}ViewModel

class ${activityClass}Activity : AppActivity<${bindingClass}Binding,${activityClass}ViewModel>() {

   override fun preOnCreate(savedInstanceState: Bundle?) {
        super.preOnCreate(savedInstanceState)
        contentLayout = R.layout.${layoutName}
    }
    
   override fun initView(savedInstanceState: Bundle?) {
        mViewModel = ViewModelProviders.of(this).get(${activityClass}ViewModel::class.java)
    }

   override fun initData(savedInstanceState: Bundle?) {

    }
 } 
""".trimIndent()