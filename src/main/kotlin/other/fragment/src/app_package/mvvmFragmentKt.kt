package other.fragment.src.app_package

import other.common.AppType

fun mvvmFragmentKt(
    applicationPackage: String?,
    fragmentClass: String,
    layoutName: String,
    packageName: String,
    appType: AppType,
    bindingClass: String
): String {
    val baseFragmentByImport =
        if (appType == AppType.Mainland) "com.aiways.awbase.fragment.AppFragment" else "com.aiways.eu.auto.base.fragment.AppFragment"
    return """
package $packageName

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProviders

import ${applicationPackage}.R
import $baseFragmentByImport
import ${applicationPackage}.databinding.${bindingClass}Binding
import ${applicationPackage}.viewmodel.${fragmentClass}ViewModel


class ${fragmentClass}Fragment : AppFragment<${bindingClass}Binding,${fragmentClass}ViewModel>() {

    override fun preOnCreate(savedInstanceState: Bundle?) {
        super.preOnCreate(savedInstanceState)
        contentLayoutId =R.layout.${layoutName}
    }

    override fun initView(rootView: View?) {
        mViewModel = ViewModelProviders.of(this).get(${fragmentClass}ViewModel::class.java)
    }

    override fun initData(savedInstanceState: Bundle?) {

    }

    override fun setData(data: Any?) {

    }   
    
     companion object {
        fun newInstance():${fragmentClass}Fragment {
            return ${fragmentClass}Fragment()
        }
    }
}
""".trimIndent()
}