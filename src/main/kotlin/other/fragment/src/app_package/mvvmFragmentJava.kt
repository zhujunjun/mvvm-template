package other.fragment.src.app_package

fun mvvmFragmentJava(
    applicationPackage: String?,
    fragmentClass: String,
    layoutName: String,
    packageName: String
) = """
package ${packageName}.ui.fragment;
import android.os.Bundle;
import android.view.View;

import ${packageName}.R;
import androidx.lifecycle.ViewModelProvider;
import com.aiways.awbase.fragment.AppFragment;
import ${packageName}.databinding.Fragment${fragmentClass}Binding;
import ${packageName}.viewmodel.${fragmentClass}ViewModel;

public class ${fragmentClass}Fragment extends AppFragment<Fragment${fragmentClass}Binding, ${fragmentClass}ViewModel> {
    @Override
    public void preOnCreate(Bundle savedInstanceState) {
        super.preOnCreate(savedInstanceState);
        contentLayout =R.layout.${layoutName};
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