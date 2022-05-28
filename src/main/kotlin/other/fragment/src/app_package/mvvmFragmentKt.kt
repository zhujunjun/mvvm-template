package other.fragment.src.app_package

fun mvvmFragmentKt(
    applicationPackage: String?,
    fragmentClass: String,
    layoutName: String,
    packageName: String
) = """
package ${packageName}.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider

import ${packageName}.R
import com.aiways.awbase.fragment.AppFragment
import ${packageName}.databinding.Fragment${fragmentClass}Binding
import ${packageName}.viewmodel.${fragmentClass}ViewModel


class ${fragmentClass}Fragment : AppFragment<Fragment${fragmentClass}Binding,${fragmentClass}ViewModel>() {

    @Override fun preOnCreate(savedInstanceState: Bundle?) {
        super.preOnCreate(savedInstanceState)
        contentLayout =R.layout.${layoutName}
    }

    @Override fun initView(rootView: View?) {
        mViewModel = ViewModelProviders.of(this).get(${fragmentClass}ViewModel.class)
    }

    @Override fun initData(savedInstanceState: Bundle?) {

    }

    @Override fun setData(data: Any?) {

    }   
    
     companion object {
        fun newInstance():${fragmentClass}Fragment {
            return ${fragmentClass}Fragment()
        }
    }
}
""".trimIndent()