package other.activity.src.app_package

fun mvvmActivityJava(
    applicationPackage:String?,
    activityClass:String,
    layoutName:String,
    packageName:String
)="""
package ${packageName}.ui.activity;
import android.os.Bundle;
import androidx.lifecycle.ViewModelProvider
import ${packageName}.R;
import com.aiways.awbase.activity.AppActivity;
import ${packageName}.databinding.Activity${activityClass}Binding;
import ${packageName}.viewmodel.${activityClass}ViewModel;

import org.jetbrains.annotations.NotNull;

public class ${activityClass}Activity extends AppActivity<Activity${activityClass}Binding,${activityClass}ViewModel> {
   
   @Override
    public void preOnCreate(Bundle savedInstanceState) {
        super.preOnCreate(savedInstanceState);
        contentLayout =R.layout.${layoutName};
    }
 
    @Override
    public void initView(Bundle savedInstanceState) {
        mViewModel = ViewModelProviders.of(this).get(${activityClass}ViewModel.class);
    }

    @Override
    public void initData(Bundle savedInstanceState) {

    }
    
}
""".trimIndent()