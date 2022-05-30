package other.fragment.src.app_package

fun mvvmFragmentJava(
    applicationPackage: String?,
    fragmentClass: String,
    layoutName: String,
    packageName: String,
    bindingClass: String
) = """
package ${packageName};
import android.os.Bundle;
import android.view.View;

import ${applicationPackage}.R;
import androidx.lifecycle.ViewModelProviders;
import com.aiways.awbase.fragment.AppFragment;
import ${applicationPackage}.databinding.${bindingClass}Binding;
import ${applicationPackage}.viewmodel.${fragmentClass}ViewModel;

public class ${fragmentClass}Fragment extends AppFragment<${bindingClass}Binding, ${fragmentClass}ViewModel> {
    @Override
    public void preOnCreate(Bundle savedInstanceState) {
        super.preOnCreate(savedInstanceState);
        contentLayoutId =R.layout.${layoutName};
    }

    @Override
    public void initView(View rootView) {
        mViewModel = ViewModelProviders.of(this).get(${fragmentClass}ViewModel.class);
    }

    @Override
    public void initData(Bundle savedInstanceState) {

    }

    @Override
    public void setData(Object data) {

    }

    public static ${fragmentClass}Fragment newInstance(){
        return new ${fragmentClass}Fragment();
    }
    
    
}
"""