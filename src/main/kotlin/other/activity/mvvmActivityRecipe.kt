package other.activity

import com.android.tools.idea.wizard.template.Language
import com.android.tools.idea.wizard.template.ModuleTemplateData
import com.android.tools.idea.wizard.template.RecipeExecutor
import other.common.res.layout.mvvmXml
import other.activity.src.app_package.*
import other.common.model.mvvmModel
import other.common.model.mvvmModelJava
import other.common.viewmodel.mvvmViewModelJava
import other.common.viewmodel.mvvmViewModelKt

fun RecipeExecutor.mvvmActivityRecipe(
    moduleData: ModuleTemplateData,
    activityClass: String,
    layoutName: String,
    packageName: String,
    language: Language
) {
    val (projectData, srcOut, resOut) = moduleData
    val ktOrJavaExt = language.extension//projectData.language.extension
//    generateManifest(
//        moduleData = moduleData,
//        activityClass = "${activityClass}Activity",
////            activityTitle = activityClass,
//        packageName = "${packageName}.ui",
//        isLauncher = false,
//        hasNoActionBar = false,
//        generateActivityTitle = true,
////            requireTheme = false,
////            useMaterial2 = false
//    )

    if (language == Language.Kotlin) {
        //applicationPackage
        val mvvmActivity =
            mvvmActivityKt(projectData.applicationPackage, activityClass, layoutName, packageName)
        // 保存Activity
        save(mvvmActivity, srcOut.resolve("ui/activity/${activityClass}Activity.${ktOrJavaExt}"))
        // 保存xml
        save(mvvmXml(packageName, activityClass), resOut.resolve("layout/${layoutName}.xml"))
        // 保存viewmodel
        save(
            mvvmViewModelKt(packageName, activityClass),
            srcOut.resolve("viewmodel/${activityClass}ViewModel.${ktOrJavaExt}")
        )
        // 保存repository
//        save(
//            mvvmRepositoryKt(packageName, activityClass),
//            srcOut.resolve("repository/${activityClass}Repository.${ktOrJavaExt}")
//        )
        //保存model
    save(mvvmModel(packageName, activityClass), srcOut.resolve("model/${activityClass}Model.${ktOrJavaExt}"))
    } else if (language == Language.Java) {
        //applicationPackage
        val mvvmActivity =
            mvvmActivityJava(
                projectData.applicationPackage,
                activityClass,
                layoutName,
                packageName
            )
        // 保存Activity
        save(mvvmActivity, srcOut.resolve("ui/activity/${activityClass}Activity.${ktOrJavaExt}"))
        // 保存xml
        save(mvvmXml(packageName, activityClass), resOut.resolve("layout/${layoutName}.xml"))
        // 保存viewmodel
        save(
            mvvmViewModelJava(packageName, activityClass),
            srcOut.resolve("viewmodel/${activityClass}ViewModel.${ktOrJavaExt}")
        )
        // 保存repository
//        save(
//            mvvmRepositoryJava(packageName, activityClass),
//            srcOut.resolve("repository/${activityClass}Repository.${ktOrJavaExt}")
//        )
        //保存model
    save(mvvmModelJava(packageName, activityClass), srcOut.resolve("model/${activityClass}Model.${ktOrJavaExt}"))
    }

}
