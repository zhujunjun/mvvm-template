package other.activity.src.app_package

import other.common.AppType

fun mvvmActivityJava(
    applicationPackage: String?,
    activityClass: String,
    layoutName: String,
    packageName: String,
    appType: AppType,
    bindingClass: String
): String {
    val baseAppByImport =
        if (appType == AppType.Mainland) "com.aiways.awbase.activity.AppActivity" else "com.aiways.eu.auto.base.activity.AppActivity"
    return """
package ${packageName};
import android.os.Bundle;
import androidx.lifecycle.ViewModelProviders;
import ${applicationPackage}.R;
import $baseAppByImport;
import ${applicationPackage}.databinding.${bindingClass}Binding;
import ${applicationPackage}.viewmodel.${activityClass}ViewModel;

public class ${activityClass}Activity extends AppActivity<${bindingClass}Binding,${activityClass}ViewModel> {
   
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
}